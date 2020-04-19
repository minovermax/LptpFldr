 
import java.text.NumberFormat;

/**
 * Simple Bank Account, base class for CheckingAccount and SavingsAccount
 *
 * @author Soungmin Lee
 * @version 10/19/119
 */
public abstract class SimpleBankAccount{
    
    // field (instance variable)
    protected double balance;

    /**
     * Constructor for objects of class SimpleBankAccount
     */
    public SimpleBankAccount(){
        balance = 0.0;
    }

    /**
     * Add money to the balance
     *
     * @param  amount the amount to deposit
     * @return void
     */
    public void deposit( double amount ){
        balance += amount;
    }

    /**
     * Remove money from the balance
     *
     * @param  amount the amount to withdraw
     * @return true (success) or false (failure)
     */
    public boolean withdraw( double amount ){
        if( balance - amount >= 0 ){
            balance -= amount;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Get the balance
     *
     * @return the balance
     */
    public double getBalance(){
         return balance;
    }

    /**
     * Display the balance
     */
    public void print( ){
        // display as currency
        System.out.println( NumberFormat.getCurrencyInstance().format( balance ) );
    }
    
    /*
    @Override
    public String toString() {
        String newString = String.valueOf(balance);
        return newString;
    }
    
    
    @Override
    public boolean equals(Object someObject) {
        if (someObject == this) {
            return true;
        } else if (someObject != this) {
            return false;
        } else {
            return false;
        }
    }
    */
}

