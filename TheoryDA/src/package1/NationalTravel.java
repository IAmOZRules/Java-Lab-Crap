package package1;

import java.util.Scanner;

public class NationalTravel extends Travel {
    public String type;
    public String visa;

    public NationalTravel() {
        type = "National";
        visa = "Not Required";
    }

    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the national destination: ");
        destination = sc.next();
        System.out.print("Enter the year: ");
        year = sc.nextInt();
        System.out.print("Enter the duration of travel (in days): ");
        duration = sc.nextInt();
        System.out.println();
    }

    public void printInfo() {
        System.out.printf("Type of Travel: %s, Visa: %s\n" +
                        "Destination: %s\n" +
                        "Year: %d, Duration (in days): %d\n\n",
                type, visa, destination, year, duration);
    }

    @Override
    public String toString() {
        return "\n\nType of Travel: " + type + ", Visa: " + visa + "\n" +
                "Destination: " + destination + ", " +
                "Year: " + year + ", Duration (in days): " + duration;
    }
}
