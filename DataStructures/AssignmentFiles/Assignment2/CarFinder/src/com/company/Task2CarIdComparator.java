package com.company;

import java.util.Comparator;

public class Task2CarIdComparator<T extends String> implements Comparator<T> {


    @Override
    public int compare(T t, T t1) {
        if (t.compareTo(t1) > 0) {
            return 1;
        } else if (t.compareTo(t1) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
