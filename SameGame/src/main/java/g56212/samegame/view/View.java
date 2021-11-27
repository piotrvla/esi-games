package g56212.samegame.view;

import g56212.samegame.model.Block;
import g56212.samegame.model.Position;
import g56212.samegame.model.SameGame;
import java.util.Scanner;

/**
 *
 * @author 56212
 */
public class View {

    private SameGame sameGame;
    private static final Scanner keyboard = new Scanner(System.in);

    public View(SameGame sameGame) {
        this.sameGame = sameGame;
    }

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
}
