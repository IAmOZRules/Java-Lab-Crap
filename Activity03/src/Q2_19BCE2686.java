import java.util.Scanner;

class MarkValidationError extends Exception {
    MarkValidationError(int input) {
        try {
            if (input < 0) {
                throw new Exception("Input less than 0!");
            } else {
                try {
                    if (input > 0 && input < 25) {
                        throw new Exception("Input between 0 and 25!");
                    }
                } catch (Exception e) {
                    System.out.println("\n-------- Exception in Nested-Try Block --------");
                    System.out.println("MarkValidationError: " + e);
                }
            }
        } catch (Exception e) {
            System.out.println("\n-------- Exception in Try Block --------");
            System.out.println("MarkValidationError: " + e);
        } finally {
            System.out.println("\n-------- Finally Block Process ---------");
            System.out.println("The square of the input entered is: " + input*input);
        }
    }
}

public class Q2_19BCE2686 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        System.out.print("Enter any number of choice: ");
        int input = sc.nextInt();
        MarkValidationError obj;
        obj = new MarkValidationError(input);
    }
}
