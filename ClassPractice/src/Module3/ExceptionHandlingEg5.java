package Module3;
import java.io.*;

class MarkValidationError extends Exception {
    MarkValidationError() {}
}

public class ExceptionHandlingEg5 {
    static void meth1(int mark) throws MarkValidationError{
        if (mark > 30) {
            throw new MarkValidationError();
        }
        System.out.println(mark);
    }

    public static void main(String[] args) {
        try {
            int[] marks = new int[65];
            marks[0] = 40;
            meth1(marks[0]);
        }
        catch (Exception e){
            System.out.println("ERROR: " + e);              // Parent reference exception
        }
        int i = 100;
        System.out.println("The value of i is: " + i);
    }
}
