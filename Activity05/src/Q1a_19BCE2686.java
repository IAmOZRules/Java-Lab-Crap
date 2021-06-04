import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Q1a_19BCE2686 extends Application {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Button Name Printer");
        Button red = new Button();
        red.setPrefWidth(80);
        red.setText("Red");
        red.setOnAction(e -> {
            System.out.println(red.getText());
        });

        Button green = new Button();
        green.setPrefWidth(80);
        green.setText("Green");
        green.setOnAction(e -> {
            System.out.println(green.getText());
        });

        Button blue = new Button();
        blue.setPrefWidth(80);
        blue.setText("Blue");
        blue.setOnAction(e -> {
            System.out.println(blue.getText());
        });

        Button pink = new Button();
        pink.setPrefWidth(80);
        pink.setText("Pink");
        pink.setOnAction(e -> {
            System.out.println(pink.getText());
        });

        Button black = new Button();
        black.setPrefWidth(80);
        black.setText("Black");
        black.setOnAction(e -> {
            System.out.println(black.getText());
        });


        VBox box = new VBox(5);
        box.setPadding(new Insets(20, 20, 20, 20));

        HBox h = new HBox(3);
        h.getChildren().addAll(red, green, blue, pink, black);

        box.getChildren().addAll(h);
        primaryStage.setScene(new Scene(box, 440, 65));
        primaryStage.show();
    }
}