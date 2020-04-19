package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CarFinder {

    // region variables
    ArrayList<Car> carArrayList = new ArrayList<>();
    Car[] carList;
    // endregion

    public static void main(String[] args) {
        System.out.println("Welcome to CarFinder!");

        CarFinder carFinder = new CarFinder();

        // task 1
        boolean userContinue = true;
        Scanner user = new Scanner(System.in);

        while (userContinue) {
            carFinder.carArrayList.clear();

            System.out.println(" ");
            carFinder.readFile();
            carFinder.searchCar();

            System.out.println(" ");
            System.out.print("Enter 'n' if you want to quit: ");
            String userAnswer = user.nextLine();

            if (userAnswer.equals("n")) {
                userContinue = false;
            }
        }

        // task 3
        System.out.println(" ");
        System.out.println("Task 3");
        carFinder.sortByCityMpg();

    }

    // region task 1
    private void readFile() {

        String fileName = "cars.csv";
        File file = new File(fileName);

        try {
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] values = data.split(",");
                carArrayList.add(new Car(values[9], Integer.parseInt(values[0])));
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // converting to array
        carList = new Car[carArrayList.size()];
        carList = carArrayList.toArray(carList);

    }

    private void searchCar() {

        Scanner user = new Scanner(System.in);
        System.out.println("ATTENTION! An index of -1 means that the element does not exist in the array!");
        System.out.print("Enter the Car ID you wish to find: ");
        String userIdInput = user.nextLine();

        System.out.println(" ");    // spacing
        System.out.println(Arrays.toString(carList));   // array check
        long linearStartTime = System.nanoTime();
        System.out.println("\"" + userIdInput + "\"" + " is at index " + SearchMethods.linearSearch(carList, userIdInput) + " of the unsorted array"); // linear search
        long linearEndTIme = System.nanoTime();
        System.out.println("Linear Search Runtime: " + (linearEndTIme - linearStartTime) + " ns");
        System.out.println(" ");    // spacing

        // sorting before binary search
        System.out.println("Sorting the array based on Car ID ... \n");
        selectionSort(carList, new CarIdComparator());

        System.out.println(Arrays.toString(carList));   // array check
        long binaryStartTime = System.nanoTime();
        System.out.println("\"" + userIdInput + "\"" + " is at index " + SearchMethods.binarySearch(carList, userIdInput) + " of the sorted array");
        long binaryEndTime = System.nanoTime();
        System.out.println("Binary Search Runtime: " + (binaryEndTime - binaryStartTime) + " ns");

    }
    // endregion

    // region task 3
    private void sortByCityMpg() {

        System.out.println("Sorting the ArrayList based on City mpg ... \n");
        arrayListSelectionSort(carArrayList, new CarCityMpgComparator());
        System.out.println(carArrayList);
    }
    // endregion

    // region selection sort
    public static void swap(Car[] array, int i, int j){
        Car temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static <T extends Comparator<Car>> void selectionSort(Car[] array, T cmp){

        for(int i = 1; i < array.length; ++i) {

            int min = i - 1;
            for(int j = i - 1; j < array.length; ++j){

                if(cmp.compare( array[j],  array[min] ) < 0){
                    min = j;
                }
            }
            swap(array, i - 1, min);
        }
    }
    // endregion

    // region arrayList selection sort
    public static void arrayListSwap(ArrayList<Car> arrayList, int i, int j){
        Car temp = arrayList.get(j);
        arrayList.set(j, arrayList.get(i));
        arrayList.set(i, temp);
    }

    public static void arrayListSelectionSort(ArrayList<Car> arrayList, Comparator<Car> cmp) {
        for(int i = 1; i < arrayList.size(); ++i) {

            int min = i - 1;
            for(int j = i - 1; j < arrayList.size(); ++j){

                if(cmp.compare( arrayList.get(j),  arrayList.get(min) ) < 0){
                    min = j;
                }
            }
            arrayListSwap(arrayList, i - 1, min);
        }
    }
    // endregion


}
