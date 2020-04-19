package com.company;

import java.util.Comparator;

public class CarIdComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        if (car1.id.compareTo(car2.id) > 0) {
            return 1;
        } else if (car1.id.compareTo(car2.id) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
