package g56212.samegame.view;

import g56212.samegame.controller.ControllerFX;
import g56212.samegame.model.Game;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Main zone of the game that interacts with the user, it's represented as a
 * stack pane which groups game board and the menu.
 *
 * @author g56212
 */
public class MainZoneFX extends StackPane {

    private BoardFX board;
    private BoardFX secondBoard;
    private MenuFX menuFX;
    private ControllerFX controller;
    private boolean hasScene=false;
    /**
     * Constructor of the main zone that creates the board and the menu.
     *
     * @param game Current instance of same game object.
     * @param controller current instance of the controller fx.
     */
    MainZoneFX(Game game, ControllerFX controller) {
        this.controller = controller;
        this.board = new BoardFX(game, controller);
        this.secondBoard = new BoardFX(game, controller);
        this.board.setAlignment(Pos.CENTER);
        this.menuFX = new MenuFX(10, controller);
        menuFX.getStart().setOnMouseClicked(
                mouseEvent -> setStart()
        );;
        this.getChildren().addAll(board, menuFX);
        this.setAlignment(Pos.CENTER);
        this.setMinSize(546, 546);
        this.setMaxSize(546, 546);
    }

    /**
     * Sets visible the menu.
     */
    void setVisible() {
        this.menuFX.setVisible(true);
    }

    /**
     * Sets invisible the menu.
     */
    void setUnvisible() {
        this.menuFX.setVisible(false);
    }

    /**
     * Updates the board by calling game board's method.
     */
    void updateBoard() {
        this.board.updateBoard();
        this.secondBoard.updateBoard();
    }

    /**
     * Creates the board by calling game board's method.
     */
    void createBoard() {
        this.board.createBoard();
    }

    /**
     * Sets the state by using number of the remaining blocks.
     *
     * @param nbBlocks number of remaining blocks.
     */
    void setState(int nbBlocks) {
        this.menuFX.setState(nbBlocks);
    }

    void setStart() {
        this.controller.startGame(this.menuFX.getSize(),
                this.menuFX.getDifficulty());
        if (!hasScene) {
            Scene scene = new Scene(secondBoard, 546, 546);
            Stage stage = new Stage();
            stage.setTitle("Board");
            stage.setScene(scene);
            stage.show();
            hasScene=true;
        }
    }
}
