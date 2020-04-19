package com.company;

import java.util.Comparator;

public class CarCityMpgComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        if (car1.cityMpg > car2.cityMpg) {
            return 1;
        } else if (car1.cityMpg < car2.cityMpg) {
            return -1;
        } else {
            return 0;
        }
    }
}
