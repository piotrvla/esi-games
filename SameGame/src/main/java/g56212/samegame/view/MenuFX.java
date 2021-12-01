package g56212.samegame.view;

import g56212.samegame.controller.ControllerFX;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Menu of the game, used to change the size or the difficulty, or restart the
 * game.
 *
 * @author g56212
 */
class MenuFX extends VBox {

    private ControllerFX controller;
    private HBox buttons;
    private ComboBox difficulty;
    private ComboBox size;

   MenuFX(int spacing, ControllerFX controller) {
        super(spacing);
        this.setMinSize(200, 150);

        this.setStyle(" -fx-background-color: rgba(215, 179, 255,0.9);"
                + " -fx-content-display: top;"
                + " -fx-border-color: rgb(255, 0, 102);"
                + " -fx-border-width: 2;");

        this.controller = controller;
        this.buttons = new HBox(10);
        Label diff = new Label("Select the difficulty of the game:");
        this.difficulty = new ComboBox();
        difficulty.getItems().addAll(2, 3, 4, 5);
        this.difficulty.getSelectionModel().selectFirst();
        Label textSize = new Label("Select the size of the game: ");
        this.size = new ComboBox();
        this.size.getItems().addAll(5, 8, 10, 13);
        this.size.getSelectionModel().selectFirst();
        Button start = new Button("Start");
        start.setStyle("-fx-border-radius:120px;"
                + " -fx-background-color:#ea4a2a;"
                + " -fx-cursor:pointer;"
                + " -fx-color:#000000;"
                + " -fx-font-family:Arial;"
                + " -fx-font-size:15px;"
                + " -fx-padding:5px 10px;"
                + " -fx-text-decoration:none;");

        this.buttons.getChildren().add(start);
        this.buttons.setAlignment(Pos.CENTER);
        start.setOnMouseClicked(
                mouseEvent -> this.controller.startGame((int) this.size.getValue(),
                        (int) this.difficulty.getValue()));
        this.getChildren().addAll(diff, this.difficulty, textSize, this.size, this.buttons);
        this.setAlignment(Pos.CENTER);
    }

    void setVisibible() {
        this.setVisible(true);
    }

    void setUnvisible() {
        this.setVisible(false);
    }

}
