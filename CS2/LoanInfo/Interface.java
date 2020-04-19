
/**
 * Write a description of class Interface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Interface
{
    
    public static void main(String[] args){
        Main loan = new Main(10000.0, 0.05, 2);

        System.out.println( loan.getMonthlyPayment() );
        System.out.println( loan.getTotalInterest() );
        System.out.println( loan.getTotalPayments() );
        System.out.println( loan.getAmount( "first", "interest" ) );
        System.out.println( loan.getAmount( "first", "principal" ) );
        System.out.println( loan.getAmount( "first", "balance" ) );
        System.out.println( loan.getAmount( "first", "!@#$%^&*()" ) );
        System.out.println( loan.getAmount( "last", "interest" ) );
        System.out.println( loan.getAmount( "last", "principal" ) );
        System.out.println( loan.getAmount( "last", "balance" ) );
        System.out.println( loan.getAmount( "last", "{}|:<>?" ) );
        System.out.println( loan.getAmount( "{)*(&EPQWR", "interest") );
    
    }
}
