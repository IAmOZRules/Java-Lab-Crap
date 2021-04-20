import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

class makeRoti implements Runnable{
    final LinkedList<Integer> vessel;
    int maxCapacity;
    int noOfRoti;

    makeRoti(LinkedList<Integer> vessel, int maxCapacity, int noOfRoti){
        this.vessel = vessel;
        this.maxCapacity = maxCapacity;
        this.noOfRoti = noOfRoti;
    }
    @Override
    public void run() {
        for(int i = 1; i <= noOfRoti; i++){
            synchronized(vessel) {
                while(vessel.size() >= maxCapacity){
                    System.out.println("VESSEL FULL! WAITING FOR CHILD TO EAT...\n");
                    try { vessel.wait(); }
                    catch (InterruptedException ignored) {}
                }
                System.out.println("Mother is making roti " + i + "...");
                vessel.add(i);
                vessel.notify();
                try { sleep(1000); } catch (InterruptedException ignored) {}
            }
        }
    }
}

class eatRoti implements Runnable{
    final LinkedList<Integer> vessel;
    int noOfRoti;
    eatRoti(LinkedList<Integer> vessel, int noOfRoti){
        this.vessel = vessel;
        this.noOfRoti = noOfRoti;
    }
    @Override
    public void run() {
        for(int i = 1; i <= noOfRoti; i++){
            synchronized(vessel) {
                while(vessel.size() < 1){
                    System.out.println("VESSEL EMPTY! WAITING FOR MORE ROTI...\n");
                    try { vessel.wait(); }
                    catch (InterruptedException ignored) {}
                }
                System.out.println("Child is eating roti " + i + "...");
                vessel.remove();
                vessel.notify();
                try { sleep(500); } catch (InterruptedException ignored) {}
            }
        }
    }
}

public class Q4_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rotis Child wants to eat: ");
        int noOfRoti = sc.nextInt();
        int maxCapacity = 10;

        System.out.println();
        LinkedList<Integer> vessel = new LinkedList<>();
        Thread t1 = new Thread(new makeRoti(vessel, maxCapacity, noOfRoti));
        Thread t2 = new Thread(new eatRoti(vessel, noOfRoti));
        t1.start();
        t2.start(); 
    }
}