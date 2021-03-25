package Package1;
import java.util.Scanner;

public class Vacation {
    Scanner sc = new Scanner(System.in);
    String Place;
    String Date;
    String[] Activities;
    public int[] Cost;

    public void getMethod() {
        System.out.print("Enter the Place of the vacation: ");
        Place = sc.next();
        System.out.print("Enter the Date: ");
        Date = sc.next();
        System.out.print("Enter the number of activities: ");
        int n = sc.nextInt();

        Activities = new String[n];
        Cost = new int[n];

        System.out.print("Enter the Name each activity: ");
        for (int i=0; i<n; i++) { Activities[i] = sc.next(); }

        System.out.print("Enter the Cost of each activity [in ₹]: ");
        for (int i=0; i<n; i++) { Cost[i] = sc.nextInt(); }
    }

    public void printMethod() {
        System.out.printf("Vacation Place: %s, Date: %s\n", Place, Date);
        System.out.print("The activities are: ");
        for(int i=0; i<Activities.length-1; i++){
            System.out.printf("%s [₹%d], ", Activities[i], Cost[i]);
        }
        System.out.printf("%s [₹%d]", Activities[Activities.length-1], Cost[Activities.length-1]);
        System.out.println();
    }
}