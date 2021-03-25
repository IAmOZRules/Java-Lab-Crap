package Package2;
import Package1.SubPackage1.SummerVacation;

public class Q4c_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686");
        System.out.println("-- Main Method Q4c_19BCE2686 in Package2 --\n");

        System.out.println("-- Vacation in Package1 inherited by SummerVacation in Package1.SubPackage1 --");
        System.out.println("ENTER DETAILS FOR SummerVacation OBJECT 1 ...");
        System.out.println();
        SummerVacation obj1 = new SummerVacation();
        obj1.getMethod(); System.out.println();
        obj1.printMethod();
        SummerVacation.CalculateCosts(obj1.Cost);

        System.out.println();
        System.out.println("-- SummerVacation in Package1.SubPackage1 inherits Vacation in Package1 --");
        System.out.println("ENTER DETAILS FOR SummerVacation OBJECT 2...");
        SummerVacation obj2 = new SummerVacation();
        obj2.GetMethod(); System.out.println();
        obj2.PrintMethod();
    }
}
