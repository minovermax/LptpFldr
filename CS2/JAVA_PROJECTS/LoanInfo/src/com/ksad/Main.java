package com.ksad;


// importing necessary packages
import java.lang.Math;

/**
 * This is the class for the 'Loan Info" assignment.
 * @author Soungmin Lee
 * @version Sept 29, 2019
*/
public class Main {

    private final double NUMBER_OF_PERIODS = 12;    // number of payments per year
    private final double INVALID_DOLLAR_AMOUNT = -1.0;  // value that is shown when invalid dollar amount occurs

    private double initialBalance;  // initial balance of the loan
    private double interestRate;    // annual interest rate of the loan
    private double numberOfYears;   // number of years the loan is lasting

    private double monthlyPayment;  // monthly payment of the loan
    private double J;   // monthly interest
    private double totalInterestAmount; // total amount of interest
    private double totalPayment;    // total amount of payment

    private double firstMonthInterest;  // interest of the first month
    private double firstMonthPrincipal; // principal of the first month
    private double firstMonthBalance;   // balance of the first month
    private double lastMonthInterest;   // interest of the last month
    private double lastMonthPrincipal; // principal of the last month
    private double lastMonthBalance;    // balance of the last month

    /**
     * Constructor that creates a Main object and instantiates fields.
     * @param initialBalance The initial balance of the loan.
     * @param interestRate The interest rate of the loan.
     * @param numberOfYears The number of yeas of the loan (the life of the loan).
     */
    public Main(double initialBalance, double interestRate, double numberOfYears) {    // constructor
        this.initialBalance = initialBalance;   // instantiating initial fields with 'this' operator
        this.interestRate = interestRate;
        this.numberOfYears = numberOfYears;

        mutatorMethodPacket();  // running all the methods needed
    }   // Main()

    /**
     * Method that sets the monthly interest rate.
     */
    private void setMonthlyInterestRate() {    // mutator method
        J = interestRate / NUMBER_OF_PERIODS;
    }   // setMonthlyInterestRate()

    /**
     * Method that sets the monthly payment.
     */
    private void setMonthlyPayment() {    // mutator method
        monthlyPayment = Math.round((initialBalance * (J + (J / (Math.pow((1 + J), (NUMBER_OF_PERIODS * numberOfYears)) - 1)))) * 100) / 100.0;
    }   // setMonthlyPayment()

    /**
     * Method that sets the total interest amount.
     */
    private void setTotalInterestAmount() {    // mutator method
        double balanceLeft = initialBalance;    // variable needed to change the left amount of balance
        totalInterestAmount = 0;

        double numberOfMonths = NUMBER_OF_PERIODS * numberOfYears;  // 12 (months) * (number of years)

        for (int i = 0; i <= numberOfMonths; ++i){  // for loop for calculating total interest
            double monthlyInterest = J * balanceLeft;
            double monthlyPrincipal = monthlyPayment - monthlyInterest;

            balanceLeft -= monthlyPrincipal;
            totalInterestAmount += monthlyInterest;
        }

        totalInterestAmount = Math.round(totalInterestAmount * 100) / 100.0;
    }   // setTotalInterestAmount()

    /**
     * Method that sets the total payments.
     */
    private void setTotalPayments() {    // mutator method
        totalPayment = initialBalance + totalInterestAmount;
    }   // setTotalPayments

    /**
     * Method that sets the first month's interest.
     */
    private void setFirstMonthInterest() {
        firstMonthInterest = Math.round((J * initialBalance) * 100) / 100.0;
    }   // setFirstMonthInterest()

    /**
     * Method that sets the first month's principal.
     */
    private void setFirstMonthPrincipal() {
        firstMonthPrincipal = Math.round((monthlyPayment - firstMonthInterest) * 100) / 100.0;
    }   // setFirstMonthPrincipal()

    /**
     * Method that sets the first month's balance.
     */
    private void setFirstMonthBalance() {
        firstMonthBalance = Math.round((initialBalance - firstMonthPrincipal) * 100) / 100.0;
    }   // setFirstMonthBalance()

    /**
     * Method that sets the last month's interest.
     */
    private void setLastMonthInterest() {
        double balanceLeft = initialBalance;
        double monthlyInterest = 0;

        double numberOfMonths = NUMBER_OF_PERIODS * numberOfYears;

        for (int i = 0; i <= (numberOfMonths-1); ++i){  // for loop for calculating interest of the last month (used -1)
            monthlyInterest = J * balanceLeft;
            double monthlyPrincipal = monthlyPayment - monthlyInterest;

            balanceLeft -= monthlyPrincipal;
        }

        lastMonthInterest = Math.round(monthlyInterest * 100) / 100.0;
    }   // setLastMonthInterest()

    /**
     * Method that sets the last month's principal.
     */
    private void setLastMonthPrincipal() {
        double balanceLeft = initialBalance;
        double numberOfMonths = NUMBER_OF_PERIODS * numberOfYears;
        double monthlyPrincipal = 0;

        for (int i = 0; i <= (numberOfMonths-1); ++i){  // for loop for calculating interest of the last month (used -1)
            double monthlyInterest = J * balanceLeft;
            monthlyPrincipal = monthlyPayment - monthlyInterest;

            balanceLeft -= monthlyPrincipal;
        }

        lastMonthPrincipal = Math.round(monthlyPrincipal * 100) / 100.0;
    }   // setLastMonthPrincipal()

    /**
     * Method that sets the last month's balance.
     */
    private void setLastMonthBalance() {
        lastMonthBalance = 0;
    }   // setLastMonthBalance()

    /**
     * Method that sums all the mutator methods up in order to simplify the constructor.
     */
    private void mutatorMethodPacket() {

        setMonthlyInterestRate();
        setMonthlyPayment();
        setTotalInterestAmount();
        setTotalPayments();
        setFirstMonthInterest();
        setFirstMonthPrincipal();
        setFirstMonthBalance();
        setLastMonthInterest();
        setLastMonthPrincipal();
        setLastMonthBalance();
    }   // mutatorMethodPacket()


    // interface

    /**
     * Method that returns the monthly payment.
     * @return The monthly payment of the loan.
     */
    public double getMonthlyPayment() {    // accessor method
        return monthlyPayment;
    }   // getMonthlyPayment()

    /**
     * Method that returns a specific value based on the argument passed. Returns -1 if invalid value.
     * @param whatMonthToFind The month of the value you wish to find ("first", "last").
     * @param whatToFind The value that you wish to find ("interest", "principal", "Balance").
     * @return A specific value based on the argument passed. Returns -1 if argument is invalid.
     */
    public double getAmount(String whatMonthToFind, String whatToFind) {    // accessor method
        switch (whatMonthToFind) {  // switch method for "first" and "last"
            case "first":
                switch (whatToFind) {   // nested switch method for "interest", "principal", "balance"
                    case "interest":
                        return firstMonthInterest;
                    case "principal":
                        return firstMonthPrincipal;
                    case "balance":
                        return firstMonthBalance;
                    default:
                        return INVALID_DOLLAR_AMOUNT;
                }

            case "last":
                switch (whatToFind) {   // nested switch method for "interest", "principal", "balance"
                    case "interest":
                        return lastMonthInterest;
                    case "principal":
                        return lastMonthPrincipal;
                    case "balance":
                        return lastMonthBalance;
                    default:
                        return INVALID_DOLLAR_AMOUNT;
                }

            default:
                return INVALID_DOLLAR_AMOUNT;
        }
    }   // getAmount()

    /**
     * Method that returns the total interest.
     * @return The total interest of the loan.
     */
    public double getTotalInterest() {    // accessor method
        return totalInterestAmount;
    }   // getTotalInterest()

    /**
     * Method that returns the total payments of the loan.
     * @return The total payments of the loan.
     */
    public double getTotalPayments() {    // accessor method
        return totalPayment;
    }   // getTotalPayments()


}   // Main
