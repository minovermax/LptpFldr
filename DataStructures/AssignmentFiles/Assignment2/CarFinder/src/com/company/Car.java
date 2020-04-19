package com.company;

public class Car implements Comparable<Car>{

    int height;
    int length;
    int width;
    String driveline;
    String engineType;
    boolean hybrid;
    int numOfForwardGears;
    String transmission;
    int cityMpg;
    String fuelType;
    int highwayMpg;
    String classification;
    String id;
    String make;
    String modelYear;
    int year;
    int horsePower;
    int torque;


    public Car(String id, int cityMpg) {
        this.id = id;
        this.cityMpg = cityMpg;
    }



    @Override
    public int compareTo(Car otherCar) {
        if (cityMpg > otherCar.cityMpg) {
            return 1;
        } else if (cityMpg < otherCar.cityMpg) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", City mpg: " + cityMpg;
    }
}
