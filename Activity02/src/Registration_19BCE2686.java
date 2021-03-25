import java.util.Scanner;

// Student class
class Student{
    public static Scanner sc = new Scanner(System.in);
    String Regno;
    String Name;
    static String University;       //Static variable
    static int Counter;             //Static variable

    // Constructor
    public Student() {
        University = "VIT";
        Counter = 0;
    }

    // Parametrized Constructor
    public Student (String regno, String name) {
        Regno = regno;
        Name = name;
    }

    public void GetMethod () {
        System.out.print("Registration Number: ");
        Regno = sc.next();
        System.out.print("Name: ");
        Name = sc.next();
    }

    public void PrintMethod() {
        System.out.printf("Student Registration Number and Name -> %s: %s\n", Regno, Name);
        System.out.printf("University Name -> %s\n", University);
    }
}

// Courses Class
class Courses{
    public static Scanner sc = new Scanner(System.in);
    String Code;
    String Name;
    String Slot;
    String Venue;

    // Parametrized Constructor
    public Courses (String Code, String Name, String Slot, String Venue) {
        this.Code = Code;
        this.Name = Name;
        this.Slot = Slot;
        this.Venue= Venue;
    }

    public void GetMethod () {
        System.out.print("Enter the Course Code: ");
        Code = sc.next();
        System.out.print("Enter the Course Name: ");
        Name = sc.next();
        System.out.print("Enter the Course Slot: ");
        Slot = sc.next();
        System.out.print("Enter the Course Venue: ");
        Venue = sc.next();
    }

    public void PrintMethod() {
        System.out.printf("Course Code and Course Name -> %s: %s\n", Code, Name);
        System.out.printf("Course Slot and Venue -> %s: %s\n", Slot, Venue);
    }
}

// Main Class
public class Registration_19BCE2686 {

    // Prints column separators
    static void printColumnSeparator(String choice) {
        switch (choice) {
            case "table" -> System.out.println("|-----------|-------------------|-------------------|-------------------|-------|--------|");
            case "courses" -> System.out.println("|---------------|-------------------|-------|-----------|");
        }
    }

    // Method to display all courses
    static void displayCourses (Courses[] arr) {
        System.out.println("| Course Code\t| Course Name \t\t| Slot \t| Venue\t\t|");
        printColumnSeparator("courses");
        for (int i=0; i<4; i++) {
            System.out.printf("| %s\t\t| %s\t\t| %s\t| %s\t|\n", arr[i].Code, arr[i].Name, arr[i].Slot, arr[i].Venue);
        }
        System.out.println();
    }

    // Method to get course details and check for slot clashes
    static String[][][] getCourseDetails(String[][][] studentCourses, int studentID) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Course Code and Slot Choice 1: ");
        studentCourses[studentID][0][0] = sc.next().toUpperCase();      // Course 1 Code
        studentCourses[studentID][0][1] = sc.next().toUpperCase();      // Course 1 Slot

        System.out.print("Enter Course Code and Slot Choice 2: ");
        studentCourses[studentID][1][0] = sc.next().toUpperCase();      // Course 2 Code
        studentCourses[studentID][1][1] = sc.next().toUpperCase();      // Course 2 Slot

        while (studentCourses[studentID][0][1].equals(studentCourses[studentID][1][1])){
            System.out.println("Course slots clash! Please enter details for course 2 again...");
            System.out.print("\nEnter Course Code and Slot Choice 2: ");
            studentCourses[studentID][1][0] = sc.next().toUpperCase();      // Course Code
            studentCourses[studentID][1][1] = sc.next().toUpperCase();      // Course Slot
        }
        return studentCourses;
    }

    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        Scanner sc = new Scanner(System.in);

        // Creating course objects
        Courses[] course = new Courses[4];
        course[0] = new Courses("CSE1001", "Programming", "A1", "SJT601");
        course[1] = new Courses("CSE1002", "Digital Logic", "A1", "SJT602");
        course[2] = new Courses("CSE2001", "Algorithms", "B1", "SJT603");
        course[3] = new Courses("CSE2002", "Blockchain", "B1", "SJT604");

        // Creating student objects
        Student[] student = new Student[2];

        // Taking information about students
        for (int i=0; i<2 ; i++) {
            System.out.printf("Enter details for student %d: \n", i+1);
            student[i] = new Student();
            student[i].GetMethod();
            System.out.println();
        }

        // 3 dimensional array to store student course name and course code
        // studentCourses[i][j][k] stores information about slot for the jth course for the ith student
        String[][][] studentCourses = new String[2][2][2];

        // Take course information from the students
        for (int i=0; i<2; i++) {
            System.out.printf("%s, choose two subjects from the displayed list: \n", student[i].Name);
            displayCourses(course);
            getCourseDetails(studentCourses, i);
            System.out.println();
        }

        // Print information about each student
        for(int i=0; i<2; i++){
            System.out.printf("Details for student %s are...\n", student[i].Name);
            System.out.println("| Reg No\t| Student Name\t\t| Course Code\t\t| Course Name\t\t| Slot\t| Venue\t |");
            printColumnSeparator("table");

            for(int j=0; j<2; j++){
                for (int k=0; k<4; k++){
                    if(studentCourses[i][j][0].equals(course[k].Code)){
                        System.out.printf("| %s\t| %s\t\t\t| %s\t\t\t| %s\t\t| %s\t| %s |\n",
                                student[i].Regno, student[i].Name, course[k].Code, course[k].Name, course[k].Slot, course[k].Venue);
                    }
                }
            }
            System.out.println();
        }
    }
}