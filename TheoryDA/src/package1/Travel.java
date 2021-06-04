package package1;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Travel implements Serializable{
    public String destination;
    public int year;
    public int duration;
    public abstract void getInfo();
    public abstract void printInfo();

    public static void futureTravels() {
        System.out.println("----- ENTER DETAILS FOR FUTURE TRAVEL PLANS -----");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of places you want to visit: ");
        int n = sc.nextInt();
        String[] places = new String[n];
        int[] years = new int[n];

        for (int i=0; i<n; i++) {
            System.out.printf("Enter Destination %d: ", i+1);
            places[i] = sc.next();
            System.out.printf("Enter Year for Destination %d: ", i+1);
            years[i] = sc.nextInt();
            System.out.println();
        }

        System.out.println("----- FUTURE TRAVEL PLANS -----");
        System.out.println("\nNo. | Destination \t| Year");
        for (int i=0; i<n; i++){
            System.out.printf("%d \t| %s \t\t| %d\n", i+1, places[i], years[i]);
        }
        System.out.println();
    }
}