package g56212.simon.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author g56212
 */
public class ViewMenu {

    public ViewMenu() {
        HBox menuButtons = new HBox(8);
        VBox menu = new VBox(10);

        Button longest = new Button();
        longest.setText("Longest");
        Button start = new Button();
        Button last = new Button();
        start.setText("start");
        last.setText("Last");

        String style = "-fx-border-radius:50px;"
                + " -fx-background-color:#a816b5;"
                + " -fx-cursor:pointer;"
                + " -fx-color:#000000;"
                + " -fx-font-family:Arial;"
                + " -fx-font-size:15px;"
                + " -fx-padding:5px 10px;"
                + " -fx-text-decoration:none;";

        longest.setStyle(style);
        last.setStyle(style);
        start.setStyle(style);
        menuButtons.getChildren().addAll(longest, start, last);
        menuButtons.setAlignment(Pos.CENTER);

        Label title = new Label();
        title.setText("SIMON");
        title.setAlignment(Pos.TOP_CENTER);
        title.setStyle("-fx-font-size: 32px;"
                + "   -fx-font-family: Arial Black;");

        CheckBox silentMode = new CheckBox();
        silentMode.setText("Silent mode");

        VBox menuSpeed = new VBox(10);
        Slider gameSpeed = new Slider(0, 5, 2.5);
        gameSpeed.setMaxWidth(200);
        gameSpeed.setShowTickMarks(true);
        Label gameSpeedText = new Label();
        gameSpeedText.setText(" Speed");
        menuSpeed.setAlignment(Pos.CENTER);
        menuSpeed.getChildren().addAll(gameSpeed, gameSpeedText);
    }
}
