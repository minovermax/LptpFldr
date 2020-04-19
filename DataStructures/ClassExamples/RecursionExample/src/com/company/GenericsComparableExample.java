package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class GenericsComparableExample {

    public static void main(String[] args) {
	// write your code here
      //  recuFail(10);
      //  someMethod(new Integer(5));

        Backpack<String> newBackpack = new Backpack<String>();
        newBackpack.brand = "Adidas";
        newBackpack.capacity = 1000;

        Backpack<String> newBackpack1 = new Backpack<String>();
        newBackpack1.brand = "Jordan";
        newBackpack1.capacity = 100;

        Backpack<String> newBackpack2 = new Backpack<String>();
        newBackpack2.brand = "Zappos";
        newBackpack2.capacity = 10;

        Backpack<String> newBackpack3 = new Backpack<String>();
        newBackpack3.brand = "Sperry";
        newBackpack3.capacity = 50;

        ArrayList<Backpack> anArrayList = new ArrayList<Backpack>();

        anArrayList.add(newBackpack);
        anArrayList.add(newBackpack1);
        anArrayList.add(newBackpack2);
        anArrayList.add(newBackpack3);


        System.out.println(anArrayList);

        Collections.sort(anArrayList);

        System.out.println(anArrayList);

        Collections.sort(anArrayList, new BackpackWeightComparator());

        System.out.println(anArrayList);

        /*Backpack<String>[] anArray = new Backpack[4];
        anArray[0] = newBackpack;
        anArray[1] = newBackpack1;
        anArray[2] = newBackpack2;
        anArray[3] = newBackpack3;

        for(Backpack back : anArray){
            System.out.println(back);
        }

        Arrays.sort(anArray);

        System.out.println("After");
        for(Backpack back : anArray){
            System.out.println(back);
        }*/
    }

    public static int  recuFail(int n)
    {
        if(n == 0){
            return 0;
        }

        return 1 + recuFail(n-1);


    }

    public static void someMethod(Object obj){

        String a = "" + (String)obj;
    }
}
