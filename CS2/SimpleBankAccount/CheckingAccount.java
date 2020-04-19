
/**
 * CheckingAccount class, subclass of SimpleBankAccount
 *
 * @author Soungmin Lee
 * @version 10/19/19
 */
public class CheckingAccount extends SimpleBankAccount {
    
    private int lastCheckNum;

    
    public CheckingAccount(double balance) {
        this.balance = balance;
    }
    
    public boolean processCheck(int checkNum, double amount) {
        
        if (checkNum == lastCheckNum) {
            return false;
        } else if (checkNum != lastCheckNum) {
            balance = balance - amount;
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void print() {
        System.out.println(balance);
        super.print();
    }
    
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
}
