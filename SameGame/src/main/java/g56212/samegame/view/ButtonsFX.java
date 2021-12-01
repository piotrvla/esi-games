package g56212.samegame.view;

import g56212.samegame.controller.ControllerFX;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author g56212
 */
public class ButtonsFX extends HBox {

    private Button redo;
    private Button undo;
    private Button gameOver;
    private ControllerFX controller;

    ButtonsFX(ControllerFX controller) {
        super(15);
        this.controller = controller;
        this.redo = new Button("Redo");
        this.undo = new Button("Undo");
        redo.setOnMouseClicked(
                mouseEvent -> this.controller.redo()
        );
        undo.setOnMouseClicked(
                mouseEvent -> this.controller.undo());
        this.gameOver = new Button("Give Up");
        this.gameOver.setOnMouseClicked(
                mouseEvent -> this.controller.surrender()
        );
        redo.setStyle("-fx-border-radius:120px;"
                + " -fx-background-color:#ea4a2a;"
                + " -fx-cursor:pointer;"
                + " -fx-color:#000000;"
                + " -fx-font-family:Arial;"
                + " -fx-font-size:15px;"
                + " -fx-padding:5px 10px;"
                + " -fx-text-decoration:none;");
        undo.setStyle("-fx-border-radius:120px;"
                + " -fx-background-color:#ea4a2a;"
                + " -fx-cursor:pointer;"
                + " -fx-color:#000000;"
                + " -fx-font-family:Arial;"
                + " -fx-font-size:15px;"
                + " -fx-padding:5px 10px;"
                + " -fx-text-decoration:none;");
        this.gameOver.setStyle("-fx-border-radius:120px;"
                + " -fx-background-color:#ea4a2a;"
                + " -fx-cursor:pointer;"
                + " -fx-color:#000000;"
                + " -fx-font-family:Arial;"
                + " -fx-font-size:15px;"
                + " -fx-padding:5px 10px;"
                + " -fx-text-decoration:none;");

        this.setAlignment(Pos.BOTTOM_CENTER);

        this.getChildren().addAll(redo, gameOver, undo);
    }

}
