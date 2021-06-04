import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Student implements Serializable{
    String name;
    String regno;
    Double cgpa;
    String block;
    int room;
    Student(String name, String regno, Double cgpa) {
        this.name = name;
        this.regno = regno;
        this.cgpa = cgpa;
        this.block = null;
        this.room = -1;
    }
    @Override
    public String toString() {
        return String.format("Student: %s [%s], CGPA: %.2f, Hostel Details: %s-%d",
                name, regno, cgpa, block, room);
    }
}

class HostelBlock {
    String blockno;
    int noOfRooms;
    volatile int[] rooms;

    HostelBlock(String blockno, int noOfRooms) {
        this.blockno = blockno;
        this.noOfRooms = noOfRooms;
        rooms = new int[noOfRooms];
        // assuming all room have max capacity
        Arrays.fill(rooms, -1);
    }
}

class UnallocatedStudents {
    ArrayList<Student> students;
    volatile int curStudent;
    UnallocatedStudents(ArrayList<Student> students) {
        this.students = students;
        curStudent = 0;
        sortByCGPA(students);
    }
    public void sortByCGPA(ArrayList<Student> students) {
        // System.out.println(students.toString());
        students.sort((o1, o2) -> o2.cgpa.compareTo(o1.cgpa));
        System.out.println("\nAfter sorting by CGPA: " + students.toString());
    }
}

class HostelBlockIncharge implements Runnable {
    String name;
    HostelBlock block;
    UnallocatedStudents us;
    Thread t;

    HostelBlockIncharge(String name, HostelBlock block, UnallocatedStudents us) {
        this.us = us;
        this.name = name;
        this.block = block;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        System.out.println("Incharge: " + Thread.currentThread().getName() + " starting to allocate rooms");
        System.out.println();
        while(true) {
            int curStudentCpy;
            synchronized (us) {
                curStudentCpy = us.curStudent;
                us.curStudent++;
            }
            if (curStudentCpy >= us.students.size()) {
                break;
            }
            Student curStudentObj = us.students.get(curStudentCpy);
            synchronized (curStudentObj) {
                synchronized (block) {
                    int rand_room;
                    Random rand = new Random();
                    // checking for an empty room
                    do {
                        rand_room = rand.nextInt(block.noOfRooms);
                    } while (block.rooms[rand_room] != -1);
                    // assigning that room to the student
                    block.rooms[rand_room] = curStudentCpy;
                    rand_room++;
                    curStudentObj.block = block.blockno;
                    curStudentObj.room = rand_room;
                    // System.out.println("Assigning room #" + rand_room +" for Student #" + curStudentCpy + ", Name: " + curStudentObj.name);
                    System.out.println(String.format("Student #%d, Name: %s, chose room #%d",
                            curStudentCpy, curStudentObj.name, rand_room));
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

public class Q2_19BCE0005 {
    public static void main(String[] args) {
        System.out.println("19BCE0005 Siddharth Gandhi Lab DA4 Q2\n");
        Student s1 = new Student("Sid", "1", 9.6);
        Student s2 = new Student("Abhi", "2", 9.5);
        Student s3 = new Student("Atharva", "3", 9.3);
        Student s4 = new Student("Ranjit", "4", 9.2);
        Student s5 = new Student("Shrey", "5", 9.7);
        Student s6 = new Student("Yash", "6", 9.1);
        int noOfRooms = 6;
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        System.out.println("The students who've NOT been allocated a room yet are: ");
        System.out.println(students);
        UnallocatedStudents us = new UnallocatedStudents(students);
        HostelBlock hb = new HostelBlock("M-Block", noOfRooms);
        HostelBlockIncharge i1 = new HostelBlockIncharge("Ravi", hb, us);
        HostelBlockIncharge i2 = new HostelBlockIncharge("Charan", hb, us);
        try {
            i1.t.join();
            i2.t.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        try {
            FileOutputStream fos = new FileOutputStream("question2.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // oos.writeObject(us.students);
            for (Student s : us.students) {
                oos.writeObject(s);
            }
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            FileInputStream fis = new FileInputStream("question2.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object s;
            try {
                while ((s = ois.readObject()) != null) {
                    System.out.println(s);
                }
            } catch (EOFException eofe) {
                System.out.println("End of file reached.");
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("hi");
            System.out.println(e);
        }
    }
}

