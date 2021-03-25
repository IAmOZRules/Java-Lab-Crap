import java.util.Scanner;
public class Search_19BCE2686 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the elements in the array: ");
        
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter the term to be searched: ");
        int term = sc.nextInt();

        int idx = 0; boolean found = false;
        for (int i=0; i<n; i++)
            if (arr[i] == term){
                found = true;
                idx = i;
            }

        if (found) System.out.printf(term + " found at index " + idx + " in array.");
        else System.out.printf(term + " not found in the array.");

        sc.close();
    }
}