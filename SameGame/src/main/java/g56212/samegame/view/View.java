package g56212.samegame.view;

import g56212.samegame.model.Block;
import g56212.samegame.model.Position;
import g56212.samegame.model.Game;
import java.util.Scanner;

/**
 * View of the same game terminal game mode.
 *
 * @author 56212
 */
public class View {

    private Game sameGame;
    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * View needs only SameGame instance to be initialized.
     *
     * @param sameGame
     */
    public View(Game sameGame) {
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
        System.out.println("Remaining blocks: " + this.sameGame.getRemainingBlocks());
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

        return command;
    }

    private int readInt(String message) {

        System.out.println(message);
        while (!keyboard.hasNextInt()) {
            keyboard.next();
            System.out.println("Le nombre saisi n'est pas un entier.");
            System.out.println(message);
        }
        return keyboard.nextInt();
    }

    /**
     * Reads the input from the keyboard, the input must be an integer which has
     * to be between a specified range
     *
     * @param message Message to print to the user, whenever the value doesn't
     * respect the conditions
     * @param min value that must be smaller than read value.
     * @param max value that must be bigger than read value.
     *
     * @return Returns an integer that is between the given range.
     */
    public int readBetweenRange(String message, int min, int max) {

        int nb = readInt(message);
        while (nb < min || nb > max) {
            System.out.println("The number isn't between " + min
                    + " and " + max);
            nb = readInt(message);
        }
        return nb;
    }

    /**
     * Asks and returns the user input as a size of the game.
     *
     * @return an integer is returned between 5 and 20.
     */
    public int askSize() {
        return readBetweenRange("Enter the size of the board between 5 and 20",
                5, 20);

    }

    /**
     * Returns the user input as a difficulty of the game.
     *
     * @return an integer is returned between 2 and 5.
     */
    public int askDifficulty() {
        return readBetweenRange("Enter the difficulty of the game, between "
                + "2 and 5", 2, 5);
    }

    /**
     * Displays a message as an error.
     *
     * @param message message to print.
     */
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * Displays final score and the number of remaining blocks.
     */
    public void displayFinalScore() {
        System.out.println("Final score: " + this.sameGame.getScore());
        System.out.println("Remaining blocks: " + this.sameGame.getRemainingBlocks());
    }
}
