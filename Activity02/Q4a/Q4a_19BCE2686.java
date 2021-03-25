package Q4a;
import java.util.Scanner;

abstract class Vacation {
    Scanner sc = new Scanner(System.in);
    String Place;
    String Date;
    String[] Activities;
    int[] Cost;

    abstract void getMethod();
    abstract void printMethod();
}

class SummerVacation extends Vacation{
    Scanner sc = new Scanner(System.in);
    String CourseTitle;
    String OnlinePlatform;
    int Duration;

    void getMethod() {
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

    void printMethod() {
        System.out.printf("Vacation Place: %s, Date: %s\n", Place, Date);
        System.out.print("The activities are: ");
        for(int i=0; i<Activities.length-1; i++){
            System.out.printf("%s [₹%d], ", Activities[i], Cost[i]);
        }
        System.out.printf("%s [₹%d]", Activities[Activities.length-1], Cost[Activities.length-1]);
        System.out.println();
    }

    void GetMethod() {
        System.out.print("Enter the Course Title: ");
        CourseTitle = sc.nextLine();
        System.out.print("Enter the Online Platform: ");
        OnlinePlatform = sc.next();
        System.out.print("Enter the Course Duration [in hours]: ");
        Duration = sc.nextInt();
    }

    void PrintMethod() {
        System.out.printf("Course Title: %s [%d hours], on Platform: %s\n", CourseTitle, Duration, OnlinePlatform);
    }

    public static void CalculateCosts(int[] cost) {
        int total = 0;
        for (int paisa : cost) { total += paisa; }
        System.out.println("The total cost of the vacation is : ₹"+total);
    }
}

public class Q4a_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        System.out.println("ENTER DETAILS FOR SummerVacation OBJECT 1 ...");
        System.out.println("-- abstract class Vacation inherited by SummerVacation --");
        System.out.println();
        SummerVacation obj1 = new SummerVacation();
        obj1.getMethod(); System.out.println();
        obj1.printMethod();
        SummerVacation.CalculateCosts(obj1.Cost);

        System.out.println();
        System.out.println("ENTER DETAILS FOR SummerVacation OBJECT 2...");
        SummerVacation obj2 = new SummerVacation();
        obj2.GetMethod(); System.out.println();
        obj2.PrintMethod();
    }
}
