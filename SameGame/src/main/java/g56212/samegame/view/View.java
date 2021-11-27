package g56212.samegame.view;

import g56212.samegame.model.Block;
import g56212.samegame.model.Position;
import g56212.samegame.model.SameGame;
import java.util.Scanner;

/**
 * View of the same game terminal game mode.
 *
 * @author 56212
 */
public class View {

    private SameGame sameGame;
    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * View needs only SameGame instance to be initialized.
     *
     * @param sameGame
     */
    public View(SameGame sameGame) {
        this.sameGame = sameGame;
    }

    /**
     * Displays the whole game.
     */
    public void displayGame() {
        for (int i = 0; i < this.sameGame.getSize(); i++) {
            for (int j = 0; j < this.sameGame.getSize(); j++) {
                Block color = this.sameGame.getAt(new Position(i, j));
                if (color != null) {
                    switch (color.getColor()) {
                        case RED ->
                            System.out.print("R ");
                        case BLUE ->
                            System.out.print("B ");
                        case GREEN ->
                            System.out.print("G ");
                        case YELLOW ->
                            System.out.print("Y ");
                        case ORANGE ->
                            System.out.print("O ");
                    }
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();

        }
        System.out.println("Current score: " + this.sameGame.getScore());
        System.out.println("Recent score: " + this.sameGame.getRecentScore());
    }

    /**
     * Asks the user a command that can't be different than: remove, redo and
     * undo.
     *
     * @return String array with every command parameters.
     */
    public String[] askCommand() {
        System.out.println("Enter your command please");
        String nbParam = "\\d{1,3}";
        String pattern
                = "(remove " + nbParam + " " + nbParam + ")"
                + "|(redo)"
                + "|(undo)";
        keyboard.useDelimiter("\n");
        while (!keyboard.hasNext(pattern)) {
            displayError("Error! Your command " + keyboard.next() + " doesn't seem right");
        }

        String[] command = keyboard.next().split(" ");
        if (command[0].equals("remove")) {
            while (Integer.parseInt(command[1]) <= 0
                    || Integer.parseInt(command[1]) > this.sameGame.getSize()
                    || Integer.parseInt(command[2]) <= 0
                    || Integer.parseInt(command[2]) > this.sameGame.getSize()) {
                displayError("Error! Your command must be between 1 and " + this.sameGame.getSize());
                askCommand();
            }
        }
        return command;
    }

    public void displayError(String message) {
        System.err.println(message);
    }
}
