package Help;

import java.util.Scanner;

class ConstException extends Exception
{
    private int c;
    ConstException(int a)
    {
        this.c=a;
    }
    public String toString()
    {
        String s= "ConstantException: Constant value less than 0";
        return s;
    }
}


public class Main {
    public static void main(String[] args) throws ConstException {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the value for a: ");
        int a = sc.nextInt();
        while (a < 0) {
            System.out.println("exception for the value of a");
            try{ throw new ConstException(a);}
            catch (ConstException exp) { System.out.println(exp); }
            System.out.print("enter the value of a again: ");
            a = sc.nextInt();
        }

        System.out.print("enter the value for b: ");
        int b = sc.nextInt();
        while (b < 0) {
            System.out.println("exception for the value of b");
            try{ throw new ConstException(b);}
            catch (ConstException exp) { System.out.println(exp); }
            System.out.print("enter the value of b again: ");
            b = sc.nextInt();
        }

        System.out.print("enter the value for c: ");
        int c = sc.nextInt();
        while (c < 0) {
            System.out.println("exception for the value of c");
            try{ throw new ConstException(c);}
            catch (ConstException exp) { System.out.println(exp); }
            System.out.print("enter the value of c again: ");
            c = sc.nextInt();

        }

        System.out.print("enter the value for d: ");
        int d = sc.nextInt();
        while (d < 0) {
            System.out.println("exception for the value of d");
            try{ throw new ConstException(d);}
            catch (ConstException exp) { System.out.println(exp); }
            System.out.print("enter the value of d again: ");
            d = sc.nextInt();
        }

        System.out.print("enter the value for m: ");
        int m = sc.nextInt();
        while (m < 0) {
            System.out.println("exception for the value of m");
            try{ throw new ConstException(m);}
            catch (ConstException exp) { System.out.println(exp); }
            System.out.print("enter the value of m again: ");
            m = sc.nextInt();
        }

        System.out.print("enter the value for n: ");
        int n = sc.nextInt();
        while (n < 0) {
            System.out.println("exception for the value of n");
            try{ throw new ConstException(n);}
            catch (ConstException e) { System.out.println(e); }
            System.out.print("enter the value of n again: ");
            n = sc.nextInt();
        }

        int x1 = (m * d - b * n) / (a * d - b * c);
        int x2 = (n * a - m * c) / (a * d - b * c);
        System.out.println("The value of x1 is " + x1);
        System.out.println("The value of x2 is " + x2);
    }
}
