import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is the class for the 'Loan Info" assignment.
 * @author Soungmin Lee
 * @version Sept 29, 2019
*/
public class Main {

    public static void main(String[] args) {
        
        Main newExample = new Main();
        
        System.out.println(newExample.mystery(12, 6));
        
    }
    
    public int mystery(int a, int b) {
	
        if ( b == 0 ){
            return 1;
        }
        if (b%2 == 0) {
            return mystery(a+2, b/2);
        }
        
        return mystery(a+2, b/2) + a;
}
}