package Module4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileEg2 {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("D:\\2 _ Haruka Kanata.mp3");
            System.out.println(fin.available());
            FileOutputStream fout = new FileOutputStream("D:\\2 _ Haruka KanataNew.mp3", true);

            int c;
            while ((c=fin.read()) != -1){
                fout.write(c);
            }
            fin.close();
            fout.close();
        } catch (Exception ex) {
            System.out.println("File not found motherfucker!");
        }
        System.out.println("This shit is done!");
    }
}
