// Prints if a number is prime or not
import java.util.Scanner;
public class Prime_19BCE2686 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int a, b, i, j, flag=0;
        System.out.print("Enter the lower limit: ");
        a = sc.nextInt();
        System.out.print("Enter the upper limit: ");
        b = sc.nextInt(); sc.close();
        System.out.print("Prime Numbers between " + a + " and " + b + " are: ");
        
        for (i = a; i <= b; i++) {
            if (i == 1 || i == 0) continue;
            flag = 1;
 
            for (j = 2; j <= i / 2; ++j)
                if (i % j == 0) {
                    flag = 0; break;
                }

            if (flag == 1) System.out.print(i + " ");
        }
    }
}
