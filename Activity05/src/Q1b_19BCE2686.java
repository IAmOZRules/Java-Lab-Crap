import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Q1b_19BCE2686 extends Application {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Button Color Changer");

        Button red = new Button();
        red.setPrefWidth(80);
        red.setText("Red");
        red.setOnAction(e -> {
            System.out.println(red.getText());
            red.setStyle("-fx-background-color: Red;" +
                    "-fx-text-fill: White;" +
                    "-fx-border-color: Black;" +
                    "-fx-border-width: 1;");
        });

        Button green = new Button();
        green.setPrefWidth(80);
        green.setText("Green");
        green.setOnAction(e -> {
            System.out.println(green.getText());
            green.setStyle("-fx-background-color: Green;" +
                    "-fx-text-fill: White;" +
                    "-fx-border-color: Black;" +
                    "-fx-border-width: 1;");
        });

        Button blue = new Button();
        blue.setPrefWidth(80);
        blue.setText("Blue");
        blue.setOnAction(e -> {
            System.out.println(blue.getText());
            blue.setStyle("-fx-background-color: Blue;" +
                    "-fx-text-fill: White;" +
                    "-fx-border-color: Black;" +
                    "-fx-border-width: 1;");
        });

        Button pink = new Button();
        pink.setPrefWidth(80);
        pink.setText("Pink");
        pink.setOnAction(e -> {
            System.out.println(pink.getText());
            pink.setStyle("-fx-background-color: Pink;" +
                    "-fx-border-color: Black;" +
                    "-fx-border-width: 1;");
        });

        Button black = new Button();
        black.setPrefWidth(80);
        black.setText("Black");
        black.setOnAction(e -> {
            System.out.println(black.getText());
            black.setStyle("-fx-background-color: Black;" +
                    "-fx-text-fill: White;" +
                    "-fx-border-color: Black;" +
                    "-fx-border-width: 1;");
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