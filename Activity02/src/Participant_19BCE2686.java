import java.util.Scanner;
public class Participant_19BCE2686{
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();
        System.out.println();
        Participant[] arr = new Participant[n];

        for (int i=0; i<n; i++) {
            System.out.printf("Enter the NAME of participant %d: ", i+1);
            String name = sc.next();
            System.out.printf("Enter the PHONE NUMBER of participant %d: ", i+1);
            String phno = sc.next();
            System.out.printf("Enter the BRANCH of participant %d: ", i+1);
            String branch = sc.next();
            System.out.printf("Enter the UNIVERSITY of participant %d: ", i+1);
            String university = sc.next();
            System.out.printf("Enter the TEST RESULT of participant %d: ", i+1);
            String testresult = sc.next();
            System.out.println();

            arr[i] = new Participant(name, phno, branch, university, testresult);
        }
        
        System.out.println("-------------- RESULTS --------------");
        for (int i=0; i<n; i++) {
            Participant.DisplayResult(arr[i]);
        }
        System.out.println();
        sc.close();
    }
}
class Participant {
    String Name;
    String Phno;
    String Branch;
    String University;
    String TestResult;

    public Participant (String Name, String Phno, String Branch, String University, String TestResult) {
        this.Name = Name;
        this.Phno = Phno;
        this.Branch = Branch;
        this.University = University;
        this.TestResult = TestResult;
    }

    static void DisplayResult (Participant p) {
        switch (p.TestResult) {
            case "L1" -> System.out.printf("%s selected for Full-Time Internship and Full-Time Job!\n", p.Name);
            case "L2", "L3" -> {
                System.out.printf("%s selected for Full-Time Internship! ", p.Name);
                System.out.print("Job maybe offered based on Internship performance.\n");
            }
            case "L4", "L5" -> System.out.printf("%s selected for Part-Time Internship for 21 days!\n", p.Name);
            default -> System.out.println("The result is invalid! Please input one of [L1, L2, L3, L4, L5]!");
        }
    }
}