import java.util.Scanner;

class Student {
    static final Scanner sc = new Scanner(System.in);
    String regno;
    String name;

    void GetMethod() {
        System.out.print("Enter the registration number: ");
        regno = sc.next();
        System.out.print("Enter the name: ");
        name = sc.next();
    }

    void PrintMethod() {
        System.out.printf("Name: %s, Reg No: %s\n", name, regno);
    }
}

class Courses{
    static final Scanner sc = new Scanner(System.in);
    String course_code;
    String name;
    String slot;
    String venue;

    void GetInfo() {
        System.out.print("Enter the course code: ");
        course_code = sc.next();
        System.out.print("Enter the name: ");
        name = sc.next();
        System.out.print("Enter the slot: ");
        slot = sc.next();
        System.out.print("Enter the venue: ");
        venue = sc.next();  
    }

    void PrintInfo() {
        System.out.printf(
            "Name: %s, Course Code: %s, Slot: %s, Venue: %s\n", name, course_code, slot, venue
        );
    }
}

class Registration_19BCE2686 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        System.out.println("Enter the details for student 1...");
        s1.GetMethod();
        
        System.out.println("\nEnter the details for student 2...");
        s2.GetMethod();
        
        System.out.println("\nEnter the details for student 3...");
        s3.GetMethod();
        
        System.out.println("\nStudent details are: ");
        System.out.print("Student 1 -> "); s1.PrintMethod();
        System.out.print("Student 2 -> "); s2.PrintMethod();
        System.out.print("Student 3 -> "); s3.PrintMethod();
        
        Courses c1 = new Courses();
        Courses c2 = new Courses();
        Courses c3 = new Courses();

        System.out.println("\nEnter the details for course 1...");
        c1.GetInfo();
        
        System.out.println("\nEnter the details for course 2...");
        c2.GetInfo();
        
        System.out.println("\nEnter the details for course 3...");
        c3.GetInfo();

        System.out.println("\nCourse details are: ");
        System.out.print("Course 1 -> "); c1.PrintInfo();
        System.out.print("Course 2 -> "); c2.PrintInfo();
        System.out.print("Course 3 -> "); c3.PrintInfo();
    }
}