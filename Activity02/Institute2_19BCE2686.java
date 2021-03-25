import java.util.Scanner;

class AcademicActivites {
    Scanner sc = new Scanner(System.in);
    int teachingHours;
    int accHours;
    int evalHours;

    void getValues() {
        System.out.print("Enter teaching hours: ");
        teachingHours = sc.nextInt();
        System.out.print("Enter accreditation hours: ");
        accHours = sc.nextInt();
        System.out.print("Enter evaluation hours: ");
        evalHours = sc.nextInt();
    }

    void printValues() {
        System.out.printf("|%d    |%d    |%d    |", teachingHours, accHours, evalHours);
    }
}

class ResearchActivities {
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

public class Institute2_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        AcademicActivites a1 = new AcademicActivites();
        AcademicActivites a2 = new AcademicActivites();
        AcademicActivites a3 = new AcademicActivites();
        ResearchActivities r1 = new ResearchActivities();
        ResearchActivities r2 = new ResearchActivities();
        ResearchActivities r3 = new ResearchActivities();

        System.out.println("Enter the details for Teacher 1...");
        a1.getValues(); r1.getValues();
        System.out.println("\nEnter the details for Teacher 2...");
        a2.getValues(); r2.getValues();
        System.out.println("\nEnter the details for Teacher 3...");
        a3.getValues(); r3.getValues();

        int[] hours = {a1.teachingHours, a2.teachingHours, a3.teachingHours};
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
        System.out.println("Teacher   |TH   |AH   |EH   |NP   |IF   |Citations");
        for(int hour:hours){
            if (hour == a1.teachingHours){
                System.out.print("Teacher 1 ");
                a1.printValues(); r1.printValues();
            }
            else if (hour == a2.teachingHours){
                System.out.print("Teacher 2 ");
                a2.printValues(); r2.printValues();
            }
            else if (hour == a3.teachingHours){
                System.out.print("Teacher 3 ");
                a3.printValues(); r3.printValues();
            }
        }
    }

}
