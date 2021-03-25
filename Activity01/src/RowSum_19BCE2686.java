import java.util.Scanner;

public class RowSum_19BCE2686{
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

        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                count += matrix[i][j];
            }
            System.out.printf("Count of row %d is: %d\n", i+1, count);
        }

        sc.close();
    }
}