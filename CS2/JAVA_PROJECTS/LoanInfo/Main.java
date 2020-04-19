
// import statements
import java.lang.Math;


/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    final double INITIAL_BALANCE;
    final double INTEREST_RATE;
    final double NUMBER_OF_YEARS;
    double J;
    double monthlyPayment;
    
    public Main(double initialBalance, double interestRate, double numberOfYears) {
        INITIAL_BALANCE = initialBalance;
        INTEREST_RATE = interestRate;
        NUMBER_OF_YEARS = numberOfYears;
    
    }
    
    public double getMonthlyPayment() {
        J = INTEREST_RATE / 12.0;
        monthlyPayment = INITIAL_BALANCE * (J + ( J / (Math.pow((1+J), (12.0 * NUMBER_OF_YEARS)) -1)));
        monthlyPayment = (monthlyPayment * 10) / 10.0;
        
        return monthlyPayment;
    }
    
    public double getAmount(String type, String firstOrLast) {
    
    }
    
    public double getTotalInterest() {
    
    }
    
    public double getTotalPayments() {
    
    }
    
    
}
