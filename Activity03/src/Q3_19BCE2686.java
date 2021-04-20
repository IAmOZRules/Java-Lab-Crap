public class Q3_19BCE2686 extends Thread{
    private final int[] arr; private final int[] count;
    int start, end;

    public Q3_19BCE2686(int[] arr, int[] count, int start, int end){
        this.arr = arr;
        this.count = count;
        this.start = start;
        this.end = end;
    }

    synchronized public void run() {
        for (int i=start; i<=end; i++) {
            count[arr[i]] += 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");

        int[] arr = new int[1000];
        int[] count = {0,0,0,0,0,0};
        for (int i=0; i< arr.length; i++) arr[i] = (int)(Math.random() * 6);

        Q3_19BCE2686 t1 = new Q3_19BCE2686(arr, count, 0, 166);
        Q3_19BCE2686 t2 = new Q3_19BCE2686(arr, count, 167, 332);
        Q3_19BCE2686 t3 = new Q3_19BCE2686(arr, count, 333, 498);
        Q3_19BCE2686 t4 = new Q3_19BCE2686(arr, count, 499, 664);
        Q3_19BCE2686 t5 = new Q3_19BCE2686(arr, count, 665, 830);
        Q3_19BCE2686 t6 = new Q3_19BCE2686(arr, count, 831, 999);

        t1.start(); t2.start(); t3.start(); t4.start(); t5.start(); t6.start();

        // Suspending the process for 5 seconds to let all the threads complete executing
        try { sleep(200); }
        catch (InterruptedException e) { e.printStackTrace(); }

        for (int i=0; i<count.length; i++) {
            if (i == 0) System.out.println("Number of people who did not register for any event: " + count[0]);
            else System.out.println("Number of people who registered for Event E" + i + " : " + count[i]);
        }
    }
}
