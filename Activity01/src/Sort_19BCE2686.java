import java.util.Scanner;
public class Sort_19BCE2686 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int max = 0;

        int[] arr = new int[n];
        System.out.print("Enter the elements in the array: ");
        
        for (int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        for (int i=0; i<n; i++)
            for (int j=i+1; j<n; j++)
                if (arr[i] > arr[j]){
                    max = arr[i];
                    arr[i] = arr[j];
                    arr[j] = max;
                }

        System.out.print("The sorted array is: ");
        for (int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
        sc.close();
    }
}