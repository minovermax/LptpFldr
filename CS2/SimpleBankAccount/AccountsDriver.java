
/**
 * Write a description of class AccountsDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AccountsDriver{
    final public static double INTEREST_RATE = 0.01;  // 1%

    public static void main( String[] args ){
        CheckingAccount checking = new CheckingAccount(100.0);
        SavingsAccount savings = new SavingsAccount( 1000.0, INTEREST_RATE );

        double monthlyExpenses = 756.34;
        int electricBillCheckNum = 2123;
        double electricBill = 60.34;
        int registationCheckNum = 2124;
        double registration = 50.00;
        double dinnerMoney = 55.32;
        double futureCar = 200.0;

        // checking account transactions
        checking.deposit( monthlyExpenses );
        checking.processCheck( electricBillCheckNum, electricBill );
        checking.withdraw( dinnerMoney );
        checking.processCheck( registationCheckNum, registration );
        System.out.print("Checking account: ");
        displayAccount( checking );

        // savings account transactions
        savings.deposit( futureCar );
        savings.applyInterest( );
        System.out.print("\nSavings account: ");
        displayAccount( savings );
    }
    
    public static void displayAccount(SimpleBankAccount someAccount) {
        someAccount.print();
    }
}
