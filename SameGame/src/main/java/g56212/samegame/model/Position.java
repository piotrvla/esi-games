package g56212.samegame.model;

/**
 * @author g56212
 * Position in the game board.
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructor of a position that needs x and y parameter to be initialized.
     *
     * @param x x of the position.
     * @param y y of the position.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter of x of the position.
     *
     * @return x of the position.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter of y of the position.
     *
     * @return y of the position.
     */
    public int getY() {
        return this.y;
    }
}
