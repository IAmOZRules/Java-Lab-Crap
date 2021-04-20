package Module3;
//wait, notify, notifyAll - non static method - object class
class Bank2{
    int bal;
    Bank2(){
        bal=10000;
    }
    synchronized void debit(int amt){//20000
        if(amt>bal){
            try{
                System.out.println("Bal insufficient");
                wait();
                System.out.println("resuming the task");
            }
            catch(InterruptedException e){
            }
        }
        bal=bal-amt;
        System.out.println("Amt debited");
    }
    synchronized void credit(int amt){//25000
        bal=bal+amt;
        System.out.println("amt credidted successfully");
        System.out.println("bal is "+bal);
        notify();   //notifyAll();
        //t1 t2 t3 t4
    }
}
public class InterruptThreadEg1 {
    public static void main(String args[]){
        //communicate
        //class - dm - meth1[wait], meth2[notifyAll]
        //runnable state - non runnable state
        //bank [10000]- debit[20000]-credit[10000]
        //acc
        //thread 1 - sync meth1
        //thread 2 - sync meth2
        //wait - releases
        //notify
        //notifyAll
        Bank2 BC1=new Bank2();      //bal=10000
        //two ways of creating thread instance
        //anonymous thread
        new Thread(){
            public void run(){
                BC1.debit(80000);
                System.out.println("bal is "+BC1.bal);
            }
        }.start();
        System.out.println("bal is "+BC1.bal);
        new Thread(){
            public void run(){
                BC1.credit(50000);
                System.out.println("bal is "+BC1.bal);
            }
        }.start();
        System.out.println("bal is "+BC1.bal);
    }
}