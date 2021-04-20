package Module3;
import java.io.*;

public class ExceptionHandlingEg2 {
    static void meth1() throws FileNotFoundException {
//        throw new ArithmeticException("BOOM BOOM!");
        FileOutputStream Fout = new FileOutputStream("abc.txt");
    }

    static void meth2() {
        try {
            meth1();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException, nigga!");
        }
    }

    public static void main(String[] args) {
        try {
            ExceptionHandlingEg2 obj = new ExceptionHandlingEg2();
            obj.meth2();
//            meth2();
        }
        catch (Exception e){
            System.out.println("ERROR: " + e);              // Parent reference exception
        }
        int i = 100;
        System.out.println("The value of i is: " + i);
    }
}
