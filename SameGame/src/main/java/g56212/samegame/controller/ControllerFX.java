package g56212.samegame.controller;

import g56212.samegame.model.CommandManager;
import g56212.samegame.model.Position;
import g56212.samegame.model.Remove;
import g56212.samegame.model.Game;
import g56212.samegame.view.ViewFX;

import javafx.stage.Stage;

/**
 * Controller of the javaFX game mode.
 *
 * @author g56212
 */
public class ControllerFX {

    private Game game;
    private ViewFX view;
    private CommandManager cmd;

    /**
     * Constructor of the controller that creates instances of game and view.
     */
    public ControllerFX() {
        this.game = new Game();
        this.view = new ViewFX(this, this.game);

    }

    /**
     * Displays the game.
     *
     * @param stage stage of java fx.
     */
    public void start(Stage stage) {
        view.start(stage);

    }

    /**
     * Starts the game by creating the board with given size and the difficulty,
     * also an instance of command's history is created.
     *
     * @param size size of the board to create.
     * @param difficulty difficulty of the game.
     */
    public void startGame(int size, int difficulty) {
        this.game.startGame(size, difficulty);
        this.cmd = new CommandManager();

    }

    /**
     * Plays a round, by trying to remove clicked block.
     *
     * @param pos Position to try to delete.
     */
    public void play(Position pos) {
        this.cmd.add(new Remove(game, pos.getX(), pos.getY()));
    }

    /**
     * Redoes the last move.
     */
    public void redo() {
        this.cmd.redo(game);
    }

    /**
     * Undoes the last move.
     */
    public void undo() {
        this.cmd.undo(game);
    }

    /**
     * Surrenders the game.
     */
    public void surrender() {
        this.game.surrender();
    }
}
