import java.util.Scanner;

import static java.lang.Thread.sleep;

class Travel {
    int outerCars = 0, cityCars = 0;
    public void outerCars (){ outerCars += 1; }
    public void cityCars (){ cityCars += 1; }
}

class OuterCars implements Runnable {
    final Travel travel;
    int numCars, maxCapacity;
    public OuterCars(Travel travel, int numCars, int maxCapacity){
        this.travel = travel;
        this.maxCapacity = maxCapacity;
        this.numCars = numCars;
    }

    @Override
    public void run() {
        for (int i=0; i<=numCars; i++) {
            while (travel.outerCars >= maxCapacity) {
                System.out.println("Cars at Outer End:\t" + maxCapacity);
                System.out.println("\nOUTER END HAS 10 CARS. ALLOWING CARS TO PASS TO CITY!\n");
                try { travel.wait(); }
                catch (Exception ignored) { }
                travel.outerCars = 0;
            }
            System.out.println("Cars at Outer End:\t" + travel.outerCars);
            travel.outerCars();

            try { travel.notifyAll(); sleep(500); } catch (Exception ignored) {}
        }
    }
}

class CityCars implements Runnable {
    final Travel travel;
    int numCars, maxCapacity;
    public CityCars(Travel travel, int numCars, int maxCapacity){
        this.travel = travel;
        this.maxCapacity = maxCapacity;
        this.numCars = numCars;
    }

    @Override
    public synchronized void run() {
        for (int i=0; i<=numCars; i++) {
            while (travel.cityCars >= maxCapacity) {
                System.out.println("Cars at City End:\t" + maxCapacity);
                System.out.println("\nCITY END HAS 10 CARS. ALLOWING CARS TO PASS TO OUTER!\n");
                try { travel.wait(); }
                catch (Exception ignored) { }
                travel.cityCars = 0;
            }
            System.out.println("Cars at City End:\t" + travel.cityCars);
            travel.cityCars();
            try { travel.notifyAll(); sleep(500); } catch (Exception ignored) {}
        }
    }
}

public class Q5_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");

        Travel travel = new Travel();
        Scanner sc = new Scanner(System.in);
        int maxCapacity = 10;

        System.out.print("Enter the number of cars at the City End:\t");
        int numCityCars = sc.nextInt();
        System.out.print("Enter the number of cars at the Outer End:\t");
        int numOuterCars = sc.nextInt();
        System.out.println();

        Thread t1 = new Thread(new CityCars(travel, numCityCars, maxCapacity));
        Thread t2 = new Thread(new OuterCars(travel, numOuterCars, maxCapacity));
        t1.start(); t2.start();
    }
}
