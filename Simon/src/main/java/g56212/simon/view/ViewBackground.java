package g56212.simon.view;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * View responsable for the background of the Simon game.
 *
 * @author piotr
 */
public class ViewBackground extends GridPane {

    private final List<Button> buttons;

    /**
     * Constructor of the view background, that initializes every single 
     * component of the background (colors and it's size.)
     */
    public ViewBackground() {
        this.buttons = new ArrayList();

        Button red = new Button();
        red.setId("red");

        Button green = new Button();
        green.setId("green");
        Button yellow = new Button();
        yellow.setId("yellow");
        Button blue = new Button();
        blue.setId("blue");

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        row1.setPercentHeight(50);
        row2.setPercentHeight(50);
        column1.setPercentWidth(50);
        column2.setPercentWidth(50);
        this.getRowConstraints().addAll(row1, row2);
        this.getColumnConstraints().addAll(column1, column2);

        red.setStyle("-fx-background-color: #df3612");
        yellow.setStyle("-fx-background-color: #f0f400");
        blue.setStyle("-fx-background-color: #00cff4");
        green.setStyle("-fx-background-color: #6bffac");
        red.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        yellow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        blue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        green.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        this.add(red, 1, 1);
        this.add(blue, 0, 0);
        this.add(yellow, 1, 0);
        this.add(green, 0, 1);

        this.buttons.add(red);
        this.buttons.add(yellow);
        this.buttons.add(green);
        this.buttons.add(blue);
    }

    /**
     * Getter of the gridpane with every composite of the background.
     *
     * @return gridpane.
     */
    GridPane getBackGround() {
        return this;
    }

    /**
     * Getter of the list with every color (button) used to play the game.
     *
     * @return list of the buttons.
     */
    List getButtons() {
        return this.buttons;
    }
}
