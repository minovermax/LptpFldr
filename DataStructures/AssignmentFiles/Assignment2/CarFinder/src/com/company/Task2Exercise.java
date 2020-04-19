package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task2Exercise {

    String[] carIdList;
    String[] userList;
    int userArraySize;

    public static void main(String[] args) {
        System.out.println("This program only uses Car ID!");

        Task2Exercise carIdFinder = new Task2Exercise();
        Scanner user = new Scanner(System.in);

        boolean userContinue = true;

        while (userContinue) {
            System.out.println(" ");

            carIdFinder.readFile();
            carIdFinder.createArray();
            carIdFinder.searchRandomElement();

            System.out.println(" ");
            System.out.print("Enter 'n' if you want to quit and proceed to Task 3: ");
            String userAnswer = user.nextLine();
            if (userAnswer.equals("n")) {
                userContinue = false;
            }
        }
    }

    private void readFile() {

        String fileName = "cars.csv";
        File file = new File(fileName);
        ArrayList<String> carArrayList = new ArrayList<>();

        try {
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] values = data.split(",");
                carArrayList.add(values[9]);
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // converting to array
        carIdList = new String[carArrayList.size()];
        carIdList = carArrayList.toArray(carIdList);

    }

    public void createArray() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("How many elements do you want in your array? (max 5076): ");
        userArraySize = Integer.parseInt(userInput.nextLine());

        userList = new String[userArraySize];
        Random rand = new Random();

        // creating random numbers
        ArrayList<Integer> randNums = new ArrayList<>();
        for (int i = 0; i < userArraySize; ++i) {
            randNums.add(rand.nextInt(5076));
        }
        Collections.shuffle(randNums);

        for (int i = 0; i < userArraySize; ++i) {
            userList[i] = carIdList[randNums.get(i)];
        }

    }

    public void searchRandomElement() {
        Random rand = new Random();
        String randomElement = userList[rand.nextInt(userArraySize)];
        System.out.println("Your random element is " + "\"" + randomElement + "\"");
        System.out.println(" ");

        System.out.println(Arrays.toString(userList));
        long linearStartTime = System.nanoTime();
        System.out.println("\""+ randomElement + "\" is at index " + Task2SearchMethods.linearSearch(userList, randomElement));
        long linearEndTime = System.nanoTime();
        System.out.println("Linear Search Runtime: " + (linearEndTime - linearStartTime) + " ns");

        System.out.println("\nSorting the array ...\n");
        selectionSort(userList);

        System.out.println(Arrays.toString(userList));
        long binaryStartTime = System.nanoTime();
        System.out.println("\"" + randomElement + "\" is at index " + Task2SearchMethods.binarySearch(userList, randomElement));
        long binaryEndTime = System.nanoTime();
        System.out.println("Binary Search Runtime: " + (binaryEndTime - binaryStartTime) + " ns");
    }

    public static void swap(String[] array, int i, int j){
        String temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void selectionSort(String[] array){

        for(int i = 1; i < array.length; ++i) {

            int min = i - 1;
            for(int j = i - 1; j < array.length; ++j){

                if(array[j].compareTo(array[min]) < 0){
                    min = j;
                }
            }
            swap(array, i - 1, min);
        }
    }
}
