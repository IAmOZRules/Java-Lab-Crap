import java.util.Scanner;
public class Duplicate_19BCE2686 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        
        int len = 0;
        int[] arr = new int[n];
        
        System.out.print("Enter the elements in the array: ");
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        for (int i=0; i<n-1; i++)
            if (arr[i] != arr[i+1])
                arr[len++] = arr[i];

        System.out.print("The array with no duplicate elements is: ");
        arr[len++] = arr[n-1];
        for (int i=0; i<len; i++)
            System.out.print(arr[i] + " ");
        
        sc.close();
    }
}
