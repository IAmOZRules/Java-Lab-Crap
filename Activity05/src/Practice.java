import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice {
    static final String DB_URL = "jdbc:mysql://localhost/jdbc";
    static final String USER = "root";
    static final String PASS = "2187";

    static void addToDB(String name, String relationship, String dob, String fav_color, String fav_place, String phno, int age){
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ){
            String sql = String.format("INSERT INTO family_info VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%d')", name, relationship, dob, fav_color, fav_place, phno, age);
            System.out.println("EXECUTING QUERY: " + sql);
            stmt.executeUpdate(sql);
            System.out.println("Query SUCCESSFULLY Executed!\n");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        addToDB("Palash", "Brother", "2003-04-29", "Orange", "Bangalore", "4283587689", 18);
    }
}


