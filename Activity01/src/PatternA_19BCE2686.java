import java.util.Scanner;
public class PatternA_19BCE2686{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt(); sc.close();
        
        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                System.out.print("*");
            }
            for (int j=2*n-3-2*i; j>0; j--) {
                System.out.print(" ");
            }

            if (i == n-1){
                for (int j=0; j<i; j++){
                    System.out.print("*");
                }
            }
            else{
                for (int j=0; j<=i; j++){
                    System.out.print("*");
                }
            }
            System.out.println("");
        }

        for (int i=n-1; i>0; i--){
            for (int j=i; j>0; j--){
                System.out.print("*");
            }
            for (int j=1; j<=2*n-1-2*i; j++){
                System.out.print(" ");
            }
            for (int j=i; j>0; j--){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}