
// importing classes needed
import java.util.Scanner;

/**
 * Project 2: Patient Class
 * <p>
 * Class containing the main function to activate the Patient class
 * </p>
 *
 * @author Soungmin Lee
 * @version Sept 5, 2019
 */
public class PatientDriver
{
    /**
     * Instanciates a Patient object with user's inputs and also tests 3 cases
     */
    public static void main(String args[]){
        
        // creating Scanner object
        Scanner UserInput = new Scanner(System.in);
        
        // getting patient's first name
        System.out.print("Please enter the patient's first name: ");
        String userName = UserInput.nextLine();
        assert userName.length() > 0 : "name must be over 1 character";   // checking value
        System.out.println("You entered " + userName);
        
        // getting patient's height
        System.out.print("Please enter the patient's height (in inches): ");
        double userHeight = UserInput.nextDouble();
        assert userHeight > 0 : "negative height value";   // checking value
        System.out.println("You entered " + userHeight);
        
        // getting patient's weight
        System.out.print("Please enter the patient's weight (in pounds): ");
        double userWeight = UserInput.nextDouble();
        assert userWeight > 0 : "negative weight value";   // checking value
        System.out.println("You entered " + userWeight);
        
        
        // object test case 1
        Patient testPatient1 = new Patient("Mary", 68, 165);   // an input of 68 and 165 should
        assert testPatient1.getBMI() == 25.1 : "test 1 failed";   // return a BMI of 25.1
        
        // object test case 2
        Patient testPatient2 = new Patient("Liam", 72.1, 185);   // an input of 72.1 and 185 should
        assert testPatient2.getBMI() == 25.0 : "test 2 failed";   // return a BMI of 25.0
        
        // object test case 3
        Patient testPatient3 = new Patient("Min", 69, 134.5);   // an input of 69 and 134.5 should
        assert testPatient3.getBMI() == 19.9 : "test 3 failed";   // return a BMI of 19.9
        
        
        // creating user's Patient object
        Patient userPatient = new Patient(userName, userHeight, userWeight);
        
        // printing final string
        System.out.println(userPatient.toString());
        
    }   // main(String args[])
    
}
