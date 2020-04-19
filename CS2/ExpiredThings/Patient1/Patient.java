/**
 @author Soungmin Lee
 @version 0.1
 */

import java.lang.Math;

public class Patient{
    String firstName;
    double height;
    double weight;
    double BMI;

    public Patient(String firstName double height double weight){
        this.firstName = firstName;
        this.height = height;
        this.weight = weight;
        BMI = updateBMI();
    }

    private double updateBMI(){
        double calcBMI = Math.round(703 * weight / height ** 2);
        return calcBMI;
    }

    public String toString(){
        finalString = firstName + " is" + height + " inches tall and weighs " + weight + "pounds" + "(BMI: " + BMI +")");
    }

}