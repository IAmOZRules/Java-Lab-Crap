    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.util.Scanner;

    public class Q1a_19BCE2686 {
        public static void main(String[] args) {
            System.out.println("SHREYAANS NAHATA: 19BCE2686\n");

            Scanner sc = new Scanner(System.in);
            String regno, name, cgpa, fav_food, fav_place, phno;

            System.out.print("Enter your Registration Number: ");
            regno = sc.next();
            System.out.print("Enter your Name: ");
            name = sc.next();
            System.out.print("Enter your CGPA: ");
            cgpa = sc.next();
            System.out.print("Enter your Favourite Food: ");
            fav_food = sc.next();
            System.out.print("Enter your Favourite Place: ");
            fav_place = sc.next();
            System.out.print("Enter your Phone Number: ");
            phno = sc.next();

            regno = "Registration Number: " + regno + "\n";
            name = "Name: " + name + "\n";
            cgpa = "CGPA: " + cgpa + "\n";
            fav_food = "Favourite Food: " + fav_food + "\n";
            fav_place = "Favourite Place: " + fav_place + "\n";
            phno = "Phone Number: " + phno + "\n";

            try {
                FileOutputStream ob1 = new FileOutputStream("question1.txt");
                byte[] REGNO = regno.getBytes();
                byte[] NAME = name.getBytes();
                byte[] CGPA = cgpa.getBytes();
                byte[] FAV_FOOD = fav_food.getBytes();
                byte[] FAV_PLACE = fav_place.getBytes();
                byte[] PHNO = phno.getBytes();
                ob1.write(REGNO); ob1.write(NAME); ob1.write(CGPA);
                ob1.write(FAV_FOOD); ob1.write(FAV_PLACE); ob1.write(PHNO);
                ob1.close();

                System.out.println("\n----- READING CONTENTS FROM FILE! -----");
                System.out.println("FILE: question1.txt\n");
                FileInputStream obj2 = new FileInputStream("question1.txt");
                int c = 0;
                while ((c=obj2.read()) != -1){
                    System.out.print((char)c);
                }
                obj2.close();
            } catch (Exception ignored) {}
        }
    }
