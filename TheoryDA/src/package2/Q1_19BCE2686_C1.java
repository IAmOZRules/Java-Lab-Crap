package package2;
import package1.*;

import java.util.Scanner;

import static package1.Travel.futureTravels;

public class Q1_19BCE2686_C1 {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");

        NationalTravel n1 = new NationalTravel();
        NationalTravel n2 = new NationalTravel();
        NationalTravel n3 = new NationalTravel();

        InternationalTravel i1 = new InternationalTravel();
        InternationalTravel i2 = new InternationalTravel();
        InternationalTravel i3 = new InternationalTravel();

        System.out.println("----- ENTER THE NATIONAL TRAVEL DETAILS -----");
        n1.getInfo(); n2.getInfo(); n3.getInfo();
        System.out.println("----- ENTER THE INTERNATIONAL TRAVEL DETAILS -----");
        i1.getInfo(); i2.getInfo(); i3.getInfo();

        futureTravels();

        System.out.println("----- NATIONAL TRAVEL DETAILS -----");
        n1.printInfo(); n2.printInfo(); n3.printInfo();
        System.out.println("----- INTERNATIONAL TRAVEL DETAILS -----");
        i1.printInfo(); i2.printInfo(); i3.printInfo();
    }
}
