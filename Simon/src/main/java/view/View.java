package view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.StackPane;

public class View
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SIMON");

        GridPane background = new GridPane();
        GridPane menu = new GridPane();
        StackPane stack = new StackPane();

        Button red = new Button();
        Button green = new Button();
        Button yellow = new Button();
        Button blue = new Button();

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        row1.setPercentHeight(50);
        row2.setPercentHeight(50);
        column1.setPercentWidth(50);
        column2.setPercentWidth(50);
        background.getRowConstraints().addAll(row1, row2);
        background.getColumnConstraints().addAll(column1, column2);

        red.setStyle("-fx-background-color: #df3612");
        yellow.setStyle("-fx-background-color: #f0f400");
        blue.setStyle("-fx-background-color: #00cff4");
        green.setStyle("-fx-background-color: #6bffac");
        red.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        yellow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        blue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        green.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        background.add(red, 1, 1);
        background.add(blue, 0, 0);
        background.add(yellow, 1, 0);
        background.add(green, 0, 1);

        Scene scene = new Scene(background, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
