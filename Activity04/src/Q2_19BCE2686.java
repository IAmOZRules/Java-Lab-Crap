import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Students implements Serializable{
    String name, regno, block;
    Float cgpa;
    int room;

    Students(String name, String regno, Float cgpa){
        this.name = name;
        this.regno = regno;
        this.cgpa = cgpa;
        this.block = null;      // Block not yet assigned
        this.room = -1;         // Room not yet assigned
    }

    @Override
    public String toString() {
        return "Student: " + name + " [" + regno + "], CGPA: " + cgpa +
                ", Hostel Details: " + block + "-[" + room + "]";
    }

    // to sort students by CGPA
    ArrayList<Students> students;
    volatile int current_student;
    Students(ArrayList<Students> students) {
        this.students = students;
        current_student = 0;
    }

    void sort_by_CGPA(){
        students.sort((o1, o2) -> o2.cgpa.compareTo(o1.cgpa));
//        System.out.println(students.toString());
        for (Students s : students){
            System.out.println(s);
        }
    }
}

class HostelBlocks {
    String name;
    int room_capacity;
    volatile int[] rooms;       // Can be accessed and modified by all threads

    HostelBlocks(String name, int room_capacity){
        this.name = name;
        this.room_capacity = room_capacity;
        rooms = new int[room_capacity];

        // All rooms initially unassigned
        for(int i=0; i<room_capacity; i++) rooms[i] = -1;
    }
}

class Hostel_Incharge implements Runnable {
    String name;
    HostelBlocks block;
    Students unallocated;
    Thread t;

    Hostel_Incharge(String name, HostelBlocks block, Students unallocated){
        this.name = name;
        this.block = block;
        this.unallocated = unallocated;
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            int cur_student_copy;
            synchronized (unallocated){
                cur_student_copy = unallocated.current_student;
                unallocated.current_student++;
            }

            if (cur_student_copy >= unallocated.students.size()) break;
            Students current_student_obj = unallocated.students.get(cur_student_copy);

            synchronized (current_student_obj) {
                synchronized (block){
                    int random_room;
                    Random random = new Random();
                    do { random_room = random.nextInt(block.room_capacity);
                    } while (block.rooms[random_room] != -1);

                    block.rooms[random_room] = cur_student_copy;
                    random_room++;
                    current_student_obj.block = block.name;
                    current_student_obj.room = random_room;

                    System.out.printf("%s -> Reg No: %d, Name: %s, Hostel Details: %s-[%d]\n",
                            Thread.currentThread().getName(),
                            cur_student_copy+1, current_student_obj.name,
                            current_student_obj.block, random_room);
                    try { Thread.sleep(100); }
                    catch (Exception ignored) { }
                }
            }
        }
    }
}

public class Q2_19BCE2686 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");

        Students s1 = new Students("Shreyaans", "111", (float) 9.6);
        Students s2 = new Students("Siddharth", "112", (float) 8.4);
        Students s3 = new Students("Akula", "113", (float) 8.9);
        Students s4 = new Students("Hemang", "114", (float) 9.2);
        Students s5 = new Students("Parth", "115", (float) 7.3);

        ArrayList<Students> students = new ArrayList<Students>();
        students.add(s1); students.add(s2); students.add(s3); students.add(s4); students.add(s5);
        int room_capacity = students.size();

        Students unallocated = new Students(students);

        System.out.println("<----- SORTING STUDENTS BY CGPA ----->");
        unallocated.sort_by_CGPA();

        HostelBlocks h1 = new HostelBlocks("P", room_capacity);

        System.out.println("\n<----- HOSTEL ROOM ALLOCATION STARTED ----->\n");
        Hostel_Incharge i1 = new Hostel_Incharge("Incharge1", h1, unallocated);
        Hostel_Incharge i2 = new Hostel_Incharge("Incharge2", h1, unallocated);

        try { i1.t.join(); i2.t.join(); }
        catch (Exception ignored) { }

        try {
            FileOutputStream fout = new FileOutputStream("question2.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);

            for (Students s:unallocated.students) out.writeObject(s);
            out.flush(); out.close();

        } catch (Exception ignored) { }

        System.out.println("\n<----- STUDENT DETAILS WRITTEN TO question2.txt ----->\n");
        System.out.println("<----- HOSTEL ROOM ALLOCATION ENDED ----->\n");
        System.out.println("<----- PRINTING FINAL HOTEL ROOM ALLOCATION DETAILS----->");
        try {
            FileInputStream fin = new FileInputStream("question2.txt");
            ObjectInputStream in = new ObjectInputStream(fin);
            Object s;
            try {
                while ((s = in.readObject()) != null) {
                    System.out.println(s);
                }
            } catch (Exception ignored) {}
            in.close();
        } catch (Exception ignored) {}
    }
}