package g56212.samegame.controller;

import g56212.samegame.model.CommandManager;
import g56212.samegame.model.Position;
import g56212.samegame.model.Remove;
import g56212.samegame.model.SameGame;
import g56212.samegame.view.ViewFX;

import javafx.stage.Stage;

public class ControllerFX {

    private SameGame game;
    private ViewFX view;
    private CommandManager cmd;

    public ControllerFX() {
        this.game = new SameGame();
        this.view = new ViewFX(this, this.game);

    }

    public void start(Stage stage) {
        view.start(stage);

    }

    public void startGame(int size, int difficulty) {
        this.game.startGame(size, difficulty);
        this.cmd = new CommandManager();

    }

    public void play(Position pos) {
        this.cmd.add(new Remove(game, pos.getX(), pos.getY()));
    }

    public void redo() {
        this.cmd.redo(game);
    }

    public void undo() {
        this.cmd.undo(game);
    }

    public void surrender() {
        this.game.surrender();
    }
}
