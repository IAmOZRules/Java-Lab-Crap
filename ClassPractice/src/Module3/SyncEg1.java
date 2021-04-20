package Module3;

class ClassA {
    int a;
    synchronized static void meth1(int n) {
        for (int i = 1; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "\t" + i * n);
        }
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        ClassA.meth1(10);
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        ClassA.meth1(4);
    }
}

public class SyncEg1 {
    public static void main(String[] args) {
//        ClassA obj1 = new ClassA();
//        ClassA obj2 = new ClassA();
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start(); t2.start();
    }
}
