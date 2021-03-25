import java.util.Scanner;
public class Reverse_19BCE2686 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements in the array: ");
        
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Reversed array is: ");
        for (int i=n; i>0; i--){
            System.out.print(arr[i-1] + " ");
        }
        sc.close();
    }
}
