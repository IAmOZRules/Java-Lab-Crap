package Module3;

import static java.lang.Thread.sleep;

class A {
    int num;
    boolean valueSet = false;
    public synchronized void put(int num) {
        while(valueSet){
            try { wait(); }
            catch (InterruptedException ignored) { }
        }
        System.out.println("Put: " + num);
        this.num = num;
        valueSet = true;
        notify();
    }

    public synchronized void get() {
        while(!valueSet) {
            try { wait(); }
            catch (InterruptedException ignored) { }
        }
        System.out.println("Get: " + num);
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable {
    A a;
    public Producer(A a) {
        this.a = a;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    @Override
    public void run() {
        int i=0;
        while(true){
            a.put(i++);
            try { sleep(500); }
            catch (InterruptedException ignored) { }
        }
    }
}

class Consumer implements Runnable {
    A a;
    public Consumer(A a) {
        this.a = a;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    @Override
    public void run() {
        int i=0;
        while(true){
            a.get();
            try { sleep(200); }
            catch (InterruptedException ignored) { }
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        A a = new A();
        new Producer(a); new Consumer(a);
    }
}
