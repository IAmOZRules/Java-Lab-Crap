package package2;

import java.io.*;
import package1.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static package1.Travel.futureTravels;


class Thread1 implements Runnable {
    String File1;
    Thread t;

    Thread1(String File1){
        this.File1 = File1;
        System.out.println("----- ENTER THE INTERNATIONAL TRAVEL DETAILS -----");
        t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        try {
            FileOutputStream fout1 = new FileOutputStream(File1);
            ObjectOutputStream out1 = new ObjectOutputStream(fout1);
            InternationalTravel it;
            for(int i=0; i<3; i++){
                it = new InternationalTravel();
                it.getInfo();
                out1.writeObject(it);
                sleep(100);
            }
            out1.close(); fout1.close();
            System.out.println("<<---- INTERNATIONAL TRAVEL DETAILS WRITTEN TO File1.txt ---->>\n");
        } catch (Exception ignored) {}

    }
}

class Thread2 implements Runnable {
    String File2;
    Thread t;

    Thread2(String File2){
        this.File2 = File2;
        System.out.println("----- ENTER THE NATIONAL TRAVEL DETAILS -----");
        t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        try {
            FileOutputStream fout2 = new FileOutputStream(File2);
            ObjectOutputStream out2 = new ObjectOutputStream(fout2);
            NationalTravel nt;
            for(int i=0; i<3; i++){
                nt = new NationalTravel();
                nt.getInfo();
                out2.writeObject(nt);
                sleep(100);
            }
            out2.close(); fout2.close();
            System.out.println("<<---- NATIONAL TRAVEL DETAILS WRITTEN TO File2.txt ---->>\n");
        } catch (Exception ignored) {}

    }
}

class Thread3 implements Runnable {
    ArrayList<NationalTravel> NT;
    ArrayList<InternationalTravel> IT;
    String File1, File2;
    Thread t;

    Thread3(String File1, String File2, ArrayList<InternationalTravel> IT, ArrayList<NationalTravel> NT){
        this.File1 = File1;
        this.File2 = File2;
        this.IT = IT;
        this.NT = NT;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try{
            FileInputStream fin1 = new FileInputStream(File1);
            ObjectInputStream in1 = new ObjectInputStream(fin1);
            FileInputStream fin2 = new FileInputStream(File2);
            ObjectInputStream in2 = new ObjectInputStream(fin2);

            NationalTravel na;
            InternationalTravel in;

            try {
                while ((in = (InternationalTravel) in1.readObject()) != null){
                    IT.add(in);
                }
            } catch (Exception ignored) { }
            System.out.println("\n<----- INTERNATIONAL TRAVEL DETAILS ----->");
            System.out.println(IT);

            try {
                while ((na = (NationalTravel) in2.readObject()) != null){
                    NT.add(na);
                }
            } catch (Exception ignored) { }
            System.out.println("\n<----- NATIONAL TRAVEL DETAILS ----->");
            System.out.println(NT);
        } catch (Exception ignored) { }
    }
}

public class Q2_19BCE2686_C1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");

        ArrayList<NationalTravel> NT = new ArrayList<>();
        ArrayList<InternationalTravel> IT = new ArrayList<>();

        String file1 = "File1.txt", file2 = "File2.txt";

        Thread1 t1 = new Thread1(file1);
        try { t1.t.join(); }
        catch (Exception ignored) {}

        Thread2 t2 = new Thread2(file2);
        try { t2.t.join(); }
        catch (Exception ignored) {}

        Thread3 t3 = new Thread3(file1, file2, IT, NT);
        try { t3.t.join(); }
        catch (Exception ignored) {}

        System.out.println();
        futureTravels();
    }
}
