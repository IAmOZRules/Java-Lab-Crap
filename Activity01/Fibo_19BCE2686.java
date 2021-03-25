// Prints out the Fibonacci Sequence
import java.util.Scanner;
public class Fibo_19BCE2686 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = 0, n2 = 1, n3, i;
        System.out.print("Enter the number of terms: ");
        int count = sc.nextInt(); sc.close();
        System.out.print(n1+" "+n2);

        for (i=2; i<count; ++i){
            n3 = n1+n2;
            System.out.print(" "+n3);
            n1 = n2; n2 = n3;
        }
    }
}
