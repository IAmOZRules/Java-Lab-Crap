import java.util.Scanner;
public class Sum_19BCE2686{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the matrix A: ");
        int r1 = sc.nextInt(); int c1 = sc.nextInt();
        System.out.print("Enter the size of the matrix B: ");
        int r2 = sc.nextInt(); int c2 = sc.nextInt();
        int[][] A = new int[r1][c1];
        int[][] B = new int[r2][c2];

        if (r1 == r2 && c1 == c2){
            System.out.printf("Enter the matrix A of size %dx%d: \n", r1, c2);
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            
            System.out.println("");
            System.out.printf("Enter the matrix B of size %dx%d: \n", r2, c2);
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    B[i][j] = sc.nextInt();
                }
            }
            
            System.out.println("");
            System.out.println("The sum of A and B is: ");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    System.out.printf("%d ", A[i][j]+B[i][j]);
                }
                System.out.println("");
            }
        }

        else{
            System.out.println("The dimensions of both matrices aren't similar!");
            System.out.println("Addition is not possible!");
        }

        sc.close();
    }
}