package Package1.SubPackage1;
import Package1.*;
import java.util.Scanner;
public class SummerVacation extends Vacation{
    Scanner sc = new Scanner(System.in);
    String CourseTitle;
    String OnlinePlatform;
    int Duration;

    public void GetMethod() {
        System.out.print("Enter the Course Title: ");
        CourseTitle = sc.nextLine();
        System.out.print("Enter the Online Platform: ");
        OnlinePlatform = sc.next();
        System.out.print("Enter the Course Duration [in hours]: ");
        Duration = sc.nextInt();
    }

    public void PrintMethod() {
        System.out.printf("Course Title: %s [%d hours], on Platform: %s\n", CourseTitle, Duration, OnlinePlatform);
    }

    public static void CalculateCosts(int[] cost) {
        int total = 0;
        for (int paisa : cost) { total += paisa; }
        System.out.println("The total cost of the vacation is : ₹"+total);
    }
}