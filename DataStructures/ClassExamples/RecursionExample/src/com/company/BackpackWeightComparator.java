package com.company;

import java.util.Comparator;

public class BackpackWeightComparator implements Comparator<Backpack> {
    @Override
    public int compare(Backpack obj1, Backpack obj2) {

       if(obj1.capacity == obj2.capacity) return 0;

       if(obj1.capacity < obj2.capacity) return -1;

       return 1;
    }
}
