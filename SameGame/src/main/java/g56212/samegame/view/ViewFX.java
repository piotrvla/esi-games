package g56212.samegame.view;

import g56212.samegame.controller.ControllerFX;
import g56212.samegame.model.Observer;
import g56212.samegame.model.Game;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main view of the game mode java fx.
 *
 * @author g56212
 */
public class ViewFX implements Observer {

    private ControllerFX controller;
    private Game game;
    private VBox root;
    private ButtonsFX buttons;
    private MainZoneFX mainZone;
    private ScoreMenuFX scoreMenu;

    /**
     * Constructor of the main View.
     *
     * @param controller current instance of controllerFX
     * @param game current instance of SameGame.
     */
    public ViewFX(ControllerFX controller, Game game) {
        this.game = game;
        this.controller = controller;
        this.game.subscribe(this);
    }

    /**
     * Creates the whole interface of the SameGame by instancing the score UI,
     * main zone that interacts with the player, all the buttons responsible for
     * redoing/undoing the last move, also to give up. Then the program is
     * started.
     *
     * @param primaryStage primary stage of the window.
     */
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        primaryStage.setTitle("SameGame - 56212 Smolinski Piotr");
        this.root = new VBox(30);

        root.setStyle("-fx-background-color: linear-gradient(to top right, #ff7f50, #6a5acd);");
        root.setAlignment(Pos.CENTER);
        this.buttons = new ButtonsFX(controller);
        buttons.setVisible(false);
        this.mainZone = new MainZoneFX(game, controller);
        this.scoreMenu = new ScoreMenuFX();
        this.scoreMenu.setVisible(false);
        root.getChildren().addAll(scoreMenu, mainZone, buttons);
        root.setMinSize(1000, 750);
        Scene scene = new Scene(root, 1000, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Starts the game by updating the board.
     */
    public void startGame() {
        mainZone.updateBoard();
    }

    @Override
    public void update(String update) {
        if (update.equals("update")) {
            this.game.refactorBoard();
            mainZone.updateBoard();
            scoreMenu.setScore(this.game.getScore());
            scoreMenu.setRecentScore(this.game.getRecentScore());
            scoreMenu.setRemainingBlocks(this.game.getRemainingBlocks());
        } else if (update.equals("start")) {
            buttons.setVisible(true);
            scoreMenu.setVisible(true);
            mainZone.setUnvisible();
            mainZone.createBoard();

        } else if (update.equals("redoError")) {
            Alert redoError = new Alert(Alert.AlertType.ERROR, "Nothing to redo");
            redoError.show();
        } else if (update.equals("undoError")) {
            Alert undoError = new Alert(Alert.AlertType.ERROR, "Nothing to undo");
            undoError.show();
        } else if (update.equals("removeError")) {
            Alert removeError = new Alert(Alert.AlertType.ERROR, "Nothing to remove");
            removeError.show();
        } else if (update.equals("gameOver")) {
            mainZone.setVisible();
            buttons.setVisible(false);
            mainZone.setState(this.game.getRemainingBlocks());

        } else if (update.equals("surrender")) {
            mainZone.setVisible();
            buttons.setVisible(false);
            //Litteral 1 represents that the game is lost.
            mainZone.setState(1);
        }
    }
}
