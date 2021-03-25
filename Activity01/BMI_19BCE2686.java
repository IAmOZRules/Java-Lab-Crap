// Calculates the BMI from weight (in kgs) and height (in cms)
import java.util.Scanner;
public class BMI_19BCE2686 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input weight in Kilogram(s): ");
        float weight = sc.nextFloat();
        System.out.print("Input height in Centimeter(s): ");
        float height = sc.nextFloat();
        sc.close();
        height = height/100;
        float BMI = weight / (height * height);
        System.out.println("The BMI is " + BMI + " kg/m2\n");
    }
}
