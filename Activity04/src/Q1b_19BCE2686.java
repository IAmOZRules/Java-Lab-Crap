import java.io.*;

public class Q1b_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");

        String str = ""; String space = " ";
        int success_count = 0, hardwork_count = 0;
        try {
            System.out.println("\n----- READING CONTENTS FROM FILE! -----");
            System.out.println("FILE: question2.txt\n");
            FileInputStream obj = new FileInputStream("question2.txt");

            int c = 0;
            while ((c=obj.read()) != -1){
                str += (char) c;
                str = str.toLowerCase();
                if (str.endsWith(" ")){
                    str = "";
                }
                else {
                    if (str.equals("success")) {
                        success_count += 1;
                        str = "";
                    }
                    if (str.equals("hardwork")) {
                        hardwork_count += 1;
                        str = "";
                    }
                }
            }
            obj.close();

            System.out.println("\"Success\" was found " + success_count + " times.");
            System.out.println("\"Hardwork\" was found " + hardwork_count + " times.");
        } catch (Exception ignored) {}
    }
}
