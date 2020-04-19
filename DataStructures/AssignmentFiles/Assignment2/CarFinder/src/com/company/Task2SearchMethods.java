package com.company;

public class Task2SearchMethods {

    public static <T> int linearSearch(T[] data, T target) {
        int i;

        for (i = 0; i < data.length; ++i) {
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1; // if failed
    }

    public static <T extends String> int binarySearch(T[] data, T target) {

        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int i = left + (right - left) / 2;

            if (data[i].equals(target)) {
                return i;
            }

            if (data[i].compareTo(target) < 0) {
                left = i + 1;
            }

            else {
                right = i - 1;
            }
        }

        return -1; // if failed
    }
}
