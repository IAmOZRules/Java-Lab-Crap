import java.util.*;

public class IQ_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        int cat = 0; int temp = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        int[] student = new int[n];
        int[] student_sorted = new int[n];
        int[] genius = new int[n];

        for(int i=0; i<n; i++) {
            System.out.printf("Enter the ID of student %d: ", i+1);
            student[i] = sc.nextInt();
            student_sorted[i] = student[i];
        }

        for (int i = 0; i < student_sorted.length; i++) {
            for (int j = i+1; j < student_sorted.length; j++) {
                if(student_sorted[i] < student_sorted[j]) {
                    temp = student_sorted[i];
                    student_sorted[i] = student_sorted[j];
                    student_sorted[j] = temp;
                }
            }
        }

        System.out.println();
        for (int marks:student_sorted){
            if (marks > 144) { cat = 1; }
            else if (marks >= 85 && marks < 144) { cat = 0; }
            else { cat = -1; }

            switch (cat) {
                case 1 -> {
                    for (int i = 0; i < n; i++) {
                        if (student[i] == marks) {
                            genius[i] = i+1;
                            System.out.printf("Student %d is a Genius [IQ: %d]\n", i+1, student[i]);
                        }
                    }
                }
                case 0 -> {
                    for (int i = 0; i < n; i++) {
                        if (student[i] == marks) {
                            System.out.printf("Student %d is Average [IQ: %d]\n", i+1, student[i]);
                        }
                    }
                }
                case -1 -> {
                    for (int i = 0; i < n; i++) {
                        if (student[i] == marks) {
                            System.out.printf("Student %d is Below Average[IQ: %d] \n", i+1, student[i]);
                        }
                    }
                }
            }
        }

        System.out.println("\n---------- The Geniuses ----------");
        for(int i=0; i<n; i++){
            if (genius[i] > 0)
                System.out.printf("Student %d\n", genius[i]);
        }
    }
}