
/**
 * SavingsAccount class, subclass of SimpleBankAccount
 *
 * @author Soungmin Lee
 * @version 10/19/19
 */
public class SavingsAccount extends SimpleBankAccount {
    
    private double interestRate;
    
    public SavingsAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
        
    }
    
    public void applyInterest() {
        balance = balance + (balance * interestRate);
        
    }
    
    @Override
    public void print() {
        System.out.println(balance);
        super.print();
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

}
