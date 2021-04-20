package Module4;

import java.io.*;
import java.util.Scanner;

class emp implements Serializable{
    int empid;
    String name;
    String phno;
    void getEmp() {
        System.out.print("Enter ID, Name and Ph. No: ");
        Scanner sc = new Scanner(System.in);
        empid = sc.nextInt();
        name = sc.next();
        phno = sc.next();
    }
}

public class FileEg3 {
    public static void main(String[] args) {
        // Serialization - Object into stream
        emp obj1 = new emp(); obj1.getEmp();
        emp obj2 = new emp(); obj2.getEmp();

        try {
            FileOutputStream fout = new FileOutputStream("Name.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(obj1); out.writeObject(obj2);
            out.close(); fout.close();

            FileInputStream fin = new FileInputStream("Name.txt");
            ObjectInputStream in = new ObjectInputStream(fin);

            emp temp = (emp)in.readObject();
            System.out.println(temp);
            System.out.printf("\nValues are: %s %s %s\n", temp.empid, temp.name, temp.phno);
            temp = (emp)in.readObject();
            System.out.println(temp);
            System.out.printf("\nValues are: %s %s %s\n", temp.empid, temp.name, temp.phno);
            temp = (emp)in.readObject();
            System.out.println(temp);

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
