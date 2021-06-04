import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Q2_19BCE2686 extends Application {
    static final String DB_URL = "jdbc:mysql://localhost/jdbc";
    static final String USER = "root";
    static final String PASS = "2187";

    void updateDB(String name, String relationship, LocalDate dob, String fav_color, String fav_place, String phno, int age){
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
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = new TextField(); tf1.setPrefWidth(175);
        TextField tf2 = new TextField(); tf2.setPrefWidth(175);
        DatePicker tf3 = new DatePicker();
        TextField tf4 = new TextField(); tf4.setPrefWidth(175);
        TextField tf5 = new TextField(); tf5.setPrefWidth(175);
        TextField tf6 = new TextField(); tf6.setPrefWidth(175);
        TextField tf7 = new TextField(); tf7.setPrefWidth(175);

        Label l1 = new Label("Name: \t\t\t");
        Label l2 = new Label("Relationship: \t\t");
        Label l3 = new Label("Date of Birth: \t\t");
        Label l4 = new Label("Favourite Color: \t");
        Label l5 = new Label("Favourite Place: \t");
        Label l6 = new Label("Phone Number: \t");
        Label l7 = new Label("Age: \t\t\t");


        primaryStage.setTitle("My Family Page");
        Button btn = new Button();
        btn.setText("Submit");
        btn.setOnAction(e -> {
            String name = tf1.getText();
            String relationship = tf2.getText();
            LocalDate dob = tf3.getValue();
            String fav_color = tf4.getText();
            String fav_place = tf5.getText();
            String phno = tf6.getText();
            int age = Integer.parseInt(tf7.getText());

            updateDB(name, relationship, dob, fav_color, fav_place, phno, age);
        });

        VBox box = new VBox(5);
        box.setPadding(new Insets(20, 20, 20, 20));

        HBox h1 = new HBox(3);
        HBox h2 = new HBox(3);
        HBox h3 = new HBox(3);
        HBox h4 = new HBox(3);
        HBox h5 = new HBox(3);
        HBox h6 = new HBox(3);
        HBox h7 = new HBox(3);
        HBox h8 = new HBox(3);

        h1.getChildren().addAll(l1, tf1);
        h2.getChildren().addAll(l2, tf2);
        h3.getChildren().addAll(l3, tf3);
        h4.getChildren().addAll(l4, tf4);
        h5.getChildren().addAll(l5, tf5);
        h6.getChildren().addAll(l6, tf6);
        h7.getChildren().addAll(l7, tf7);
        h8.getChildren().addAll(btn);

        h8.setAlignment(Pos.TOP_RIGHT); h8.setPadding(new Insets(2));

        box.getChildren().addAll(h1, h2, h3, h4, h5, h6, h7, h8);
        primaryStage.setScene(new Scene(box, 325, 280));
        primaryStage.show();
    }
}