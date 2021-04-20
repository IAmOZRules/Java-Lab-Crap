package Module4;

import java.util.ArrayList;

public class CollectionEg1 {
    public static void main(String[] args) {
        ArrayList<String> coll = new ArrayList<String>();
        coll.add("100");
        coll.add("abcd");
        for (String i:coll){
            System.out.println(i);
        }
    }
}
