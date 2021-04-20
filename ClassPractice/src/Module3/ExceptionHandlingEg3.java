package Module3;
import java.io.*;

public class ExceptionHandlingEg3 {
    public static void main(String[] args) {
        int n=10;
        int d=0;
        try {
            System.out.println("Value is: " + n / d);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("AIOB: " + e);
        } finally {
            System.out.println("Connection closed!");
        }
    }
}
