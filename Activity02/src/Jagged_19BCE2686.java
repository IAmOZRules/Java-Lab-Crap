import java.util.Scanner;

public class Jagged_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        Scanner sc = new Scanner(System.in);

        int[][] marks = new int[][] {
                new int[] {30, 30},
                new int[] {15,15,15,15},
                new int[] {10,20,20}
        };

        for(int i=0; i<3; i++){
            if (i == 0) { System.out.print("Enter CAT marks: "); }
            if (i == 1) { System.out.print("Enter Lab Activity marks: "); }
            if (i == 2) { System.out.print("Enter Project Review marks: "); }
            for(int j=0; j<marks[i].length; j++)
                marks[i][j] = Integer.parseInt(sc.next());
        }

        System.out.println("\n-------------------- Average Marks --------------------");
        for(int i=0; i<marks.length; i++){
            float sum = 0;
            float count = marks[i].length;

            for(int j=0; j<marks[i].length; j++) {
                sum += (float) marks[i][j];
            }

            if (i == 0)
                System.out.printf("Average of CAT Marks: %f\n", sum / count);
            if (i == 1)
                System.out.printf("Average of Lab Activity Marks: %f\n", sum / count);
            if (i == 2)
                System.out.printf("Average of Project Review Marks: %f\n", sum / count);
        }
    }
}
