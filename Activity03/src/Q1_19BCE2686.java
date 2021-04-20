import java.util.*;

public class Q1_19BCE2686 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        System.out.print("Enter one value from 1,2 or 3: ");
        int choice = sc.nextInt();

        while (choice > 3) {
            System.out.print("Invalid value! Please enter your choice again! : ");
            choice = sc.nextInt();
        }
        try {
            if (choice == 1) {
                throw new ArithmeticException("This is an ArithmeticException for choice = 1!");
            } else if (choice == 2) {
                throw new NullPointerException("This is a NullPointerException for choice = 2!");
            } else if (choice == 3) {
                throw new ArrayIndexOutOfBoundsException("This is a ArrayIndexOutOfBoundsException for choice = 3!");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
