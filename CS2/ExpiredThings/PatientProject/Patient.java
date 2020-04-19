
// importing classes needed
import java.lang.Math;
import java.text.DecimalFormat;

/**
 * Project 2: Patient Class
 * <p>
 * Class for calculating a patient's BMI and returning a final string
 * </p>
 @author Soungmin Lee
 @version Sept 5, 2019
 */
public class Patient{
    // fields (instance variables)
    private String firstName;   // patient's first name
    private double height;   // patient's height in inches
    private double weight;   // patient's weight in pounds
    private double BMI;   // patient's BMI
    private String finalString;   // the final string that covers everything

    /**
     * Creates a Patient object
     * @param firstName The patient's first name.
     * @param height The patient's height in inches.
     * @param weight The patient's weight in pounds.
     */
    public Patient(String firstName, double height, double weight){   // constructor
        this.firstName = firstName;   // using this keyword to distinguish from parameter
        this.height = height;
        this.weight = weight;
        
        BMI = updateBMI();   // calling updateBMI method to calculate BMI
    }   // Patient(String firstName, double height, double weight)
    
    /**
     * Calculates the patient's BMI (private)
     * @return A double value of the patient's BMI
     */
    private double updateBMI(){   // mutator method
        
        double calcBMI = (703 * weight) / Math.pow(height, 2);   // BMI equation
        
        DecimalFormat upTo1 = new DecimalFormat("#.#");   // setting format to 1 decimal point
        
        calcBMI = Double.valueOf(upTo1.format(calcBMI));   // rouding BMI
        
        return calcBMI;
    }   // updateBMI()

    /**
     * Returns a string containing overall information of the patient
     * @return A string containing the patient's first name, height, weight.
     */
    public String toString(){   // accessor method
        // concatenating string
        finalString = "Patient: " + firstName + " is " + height + " inches tall and weighs " + weight + " pounds " + "(BMI: " + BMI +")";
        return finalString;
    }   // toString()

    /**
     * Returns the patient's BMI
     * @return A double value containing the patient's BMI
     */
    public double getBMI(){   // accessor method
        return BMI;
    }   // getBMI()
}