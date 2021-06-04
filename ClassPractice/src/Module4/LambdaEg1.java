package Module4;

interface Sample {
    void meth1(int a, int b, int c);
}

public class LambdaEg1 {
    public static void main(String[] args) {
        // this be a lambda expression for abstract method of interface
        Sample ref1 = (a,b,c) -> {
            float avg = (float)((a+b+c)/3);
            System.out.println("Average is: " + avg);
        };
        ref1.meth1(10,20, 30);
    }
}
