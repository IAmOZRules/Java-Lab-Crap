package Module3;

public class ThreadEg1 {
    void meth1(){
        System.out.println("SHIT");
    }
    public static void main(String[] args) {
        ThreadEg1 obj1 = new ThreadEg1();
        ThreadEg1 obj2 = new ThreadEg1();
        obj1.meth1(); obj2.meth1();
    }
}
