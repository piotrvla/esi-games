package g56212.samegame.controller;

import g56212.samegame.model.CommandManager;
import g56212.samegame.model.Remove;
import g56212.samegame.model.Game;
import g56212.samegame.view.View;

/**
 * Controller of the terminal mode of the SameGame.
 *
 * @author 56212
 */
public class Controller {

    private final Game samegame;
    private final View view;
    private CommandManager cmd;

    /**
     * Controller creates the instances of SameGame, view and the command
     * manager. Then starts the game by asking the size of the board and the
     * difficulty.
     */
    public Controller() {
        this.samegame = new Game();
        this.view = new View(this.samegame);
        this.samegame.startGame(view.askSize(), view.askDifficulty());
        this.cmd = new CommandManager();

    }

    /**
     * Runs the game till the game isn't over. At every loop the board is shown
     * a new command asked, at the end when the game is over final score and
     * remaining number of blocks is shown.
     */
    void run() {
        while (!this.samegame.isGameOver()) {
            this.view.displayGame();
            String[] command = this.view.askCommand();
            switch (command[0]) {
                case "remove":
                    cmd.add(new Remove(samegame, Integer.parseInt(command[1]) - 1,
                            Integer.parseInt(command[2]) - 1));
                    this.samegame.refactorBoard();
                    break;
                case "redo":
                    cmd.redo(samegame);
                    this.samegame.refactorBoard();
                    break;
                case "undo":
                    cmd.undo(samegame);
                    break;
            }
        }
    }

    /**
     * Main of the SameGame game used to start the game.
     *
     * @param args
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
