package Module4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class employee implements Comparable<employee>{
    String name;
    int empid;
    int age;

    void setEmployee(String name, int empid, int age){
        this.name = name;
        this.empid = empid;
        this.age = age;
    }

    public String toString() {
        return String.format("Name: %s, Id: %d, Age: %d", name, empid, age);
    }

    @Override
    public int compareTo(employee e) {
        return name.compareTo(e.name);
    }
}

public class CollectionEg2 {
    public static void main(String[] args) {
        employee e1 = new employee();
        e1.setEmployee("Shreyaans", 1, 20);
        employee e2 = new employee();
        e2.setEmployee("Siddharth", 2, 19);
        employee e3 = new employee();
        e3.setEmployee("Akula", 3, 20);

        ArrayList<employee> Coll = new ArrayList<employee>();
        Coll.add(e1); Coll.add(e2); Coll.add(e3);

        //  root interface to traverse through objects of a class
        Iterator<employee> i1 = Coll.iterator();
        System.out.println("All employees are: ");
        while(i1.hasNext()){
            System.out.println(i1.next());
        }

        Collections.sort(Coll);
        System.out.println("\nSorted employees are: ");
        for(employee e: Coll){
            System.out.println(e);
        }

        System.out.println("\nEmployees after removing one employee are: ");
        Coll.removeIf(e->e.empid==2);
        for(employee e: Coll){
            System.out.println(e);
        }
    }
}
