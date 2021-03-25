import java.util.Scanner;
public class Transpose_19BCE2686{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the matrix: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        System.out.printf("Enter the matrix of size %dx%d: \n", n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("");
        System.out.println("The transpose matrix is: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", matrix[j][i]);
            }
            System.out.println("");
        }

        sc.close();
   }
}