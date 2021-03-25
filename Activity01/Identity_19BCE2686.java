import java.util.Scanner;
public class Identity_19BCE2686{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the matrix: ");
        int n = sc.nextInt();
        boolean flag = true;
        int[][] matrix = new int[n][n];

        System.out.printf("Enter the matrix of size %dx%d: \n", n, n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        for(int i = 0; i < n; i++){    
            for(int j = 0; j < n; j++){    
              if(i == j && matrix[i][j] != 1){    
                  flag = false;    
                  break;    
              }    
              if(i != j && matrix[i][j] != 0){    
                  flag = false;    
                  break;    
              }    
            }    
        }

        if (flag) {System.out.println("Given matrix is an identity matrix.");}
        else {System.out.println("Given matrix is NOT an identity matrix.");}

        sc.close();
   }
}