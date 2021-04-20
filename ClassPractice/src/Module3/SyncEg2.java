package Module3;

import static java.lang.Thread.sleep;

class Bank {
    int bal;
    Bank () {
        bal = 10000;
    }

    synchronized int debit(int amt) {
        if (amt < bal){
            bal -= amt;
            System.out.print("Amount debited from balance -> ");
        } else {
            System.out.println("Balance insufficient!");
            try {
                wait(200);     // Doesnt belong to Thread class, but Object class
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return bal;
    }

    synchronized int credit (int amt){
        bal += amt;
        System.out.print("Amount credited to balance -> ");
        notify();
        return bal;
    }
}

public class SyncEg2 {
    public static void main(String[] args) {
        Bank customer = new Bank();

        // Anonymous Thread
        new Thread(() -> {
            int bal = customer.credit(10000);
            System.out.println(bal);
        }).start();
        System.out.println("Balance is: " + customer.bal);


        new Thread(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int bal = customer.debit(20000);
//            System.out.println(bal);
        }).start();
        System.out.println("Balance is: " + customer.bal);

    }
}
