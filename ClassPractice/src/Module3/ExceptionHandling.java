package Module3;

public class ExceptionHandling {
    public static void main(String[] args) {
        int num = 10;
        int den = 2;
        try {
            int v = num / den;
            System.out.println("Value of v is: " + v);
            String v1 = "403";
            System.out.println("Length of the string v1 is: "+v1.length());
            int v2 = Integer.parseInt(v1);
            System.out.println("Parsed value of v1 is: "+v2);
            int[] a = new int[3];
            a[2] = 100;
            System.out.println("Length of the array a is: "+a.length);
        }
        // Names self explanatory
        catch (NullPointerException e) {
            System.out.println("ERROR: Cannot find length of NULL String!");
        }
        catch (ArithmeticException e) {
            System.out.println("ERROR: Denominator cannot be Zero!");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: Array Index Out of Bounds!");
        }
        catch (NumberFormatException e) {
            System.out.println("ERROR: String cannot be formatted into a number!");
        }
        catch (Exception e){
            System.out.println("ERROR: " + e);              // Parent reference exception
        }
        int i = 100;
        System.out.println("The value of i is: " + i);
    }
}
