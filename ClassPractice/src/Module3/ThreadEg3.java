package Module3;

public class ThreadEg3 implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("Value of i is: " + i);
        }
    }

    public static void main(String[] args) {
        ThreadEg3 obj1 = new ThreadEg3();
        Thread t1 = new Thread(obj1);
        t1.start();
    }
}
