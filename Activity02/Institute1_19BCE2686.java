import java.util.Scanner;

class HealthActivites {
    Scanner sc = new Scanner(System.in);
    String activity;
    int duration;
    int calories;

    void getValues() {
        System.out.print("Enter activity name: ");
        activity = sc.next();
        System.out.print("Enter activity duration: ");
        duration = sc.nextInt();
        System.out.print("Enter calories burnt: ");
        calories = sc.nextInt();
    }

    void printValues() {
        System.out.printf("|%s         |%d          |%d          |", activity, duration, calories);
    }
}

class ResearchActivity {
    Scanner sc = new Scanner(System.in);
    int noOfPapers;
    int impactFactor;
    int citations;

    void getValues() {
        System.out.print("Enter number of papers: ");
        noOfPapers = sc.nextInt();
        System.out.print("Enter Impact Factor: ");
        impactFactor = sc.nextInt();
        System.out.print("Enter Citations: ");
        citations = sc.nextInt();
    }

    void printValues() {
        System.out.printf("%d    |%d    |%d\n", noOfPapers, impactFactor, citations);
    }
}

public class Institute1_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        HealthActivites h1 = new HealthActivites();
        HealthActivites h2 = new HealthActivites();
        HealthActivites h3 = new HealthActivites();
        ResearchActivity r1 = new ResearchActivity();
        ResearchActivity r2 = new ResearchActivity();
        ResearchActivity r3 = new ResearchActivity();

        System.out.println("Enter the details for Teacher 1...");
        h1.getValues(); r1.getValues();
        System.out.println("\nEnter the details for Teacher 2...");
        h2.getValues(); r2.getValues();
        System.out.println("\nEnter the details for Teacher 3...");
        h3.getValues(); r3.getValues();

        int[] hours = {h1.duration, h2.duration, h3.duration};
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                int tmp;
                if (hours[i] > hours[j]) {
                    tmp = hours[i];
                    hours[i] = hours[j];
                    hours[j] = tmp;
                }
            }
        }

        System.out.println("\n----------------- Teacher Information -----------------");
        System.out.println("Teacher   |Activity  |Duration   |Calories   |NP   |IF   |Citations");
        for(int hour:hours){
            if (hour == h1.duration){
                System.out.print("Teacher 1 ");
                h1.printValues(); r1.printValues();
            }
            else if (hour == h2.duration){
                System.out.print("Teacher 2 ");
                h2.printValues(); r2.printValues();
            }
            else if (hour == h3.duration){
                System.out.print("Teacher 3 ");
                h3.printValues(); r3.printValues();
            }
        }
    }

}
