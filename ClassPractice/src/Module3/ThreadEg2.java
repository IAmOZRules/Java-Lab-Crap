package Module3;

public class ThreadEg2 extends Thread{
    // running state
    public void run() {
        System.out.println(getPriority());
        System.out.println(getName() + ": " + getId());
        for (int i=0; i<5; i++) {
            System.out.println("Value of i is: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //..
            }
        }
    }

    public static void main(String[] args) {
        ThreadEg2 t1 = new ThreadEg2();     // new thread
        ThreadEg2 t2 = new ThreadEg2();
        t1.setPriority(1); t2.setPriority(10);
        t1.start(); t2.start();             // runnable mode
    }
}
