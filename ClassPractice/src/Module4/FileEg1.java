package Module4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileEg1 {
    public static void main(String[] args) {
        try {
            FileOutputStream ob1 = new FileOutputStream("D:\\abc.txt", true);
            ob1.write(102);
            String a = "Why the fuck am I learning this shit";
            byte[] BA = a.getBytes();
            ob1.write(BA);
            ob1.close();
            
            FileInputStream obj2 = new FileInputStream("D:\\abc.txt");
            int c = 0;
            while ((c=obj2.read()) != -1){
                System.out.print((char)c);
            }
            obj2.close();
            
        } catch (Exception ex) {
            System.out.println("File not found motherfucker!");
        }
    }
}
