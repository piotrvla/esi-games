package g56212.samegame.model;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a game board of Same Game.
 */
class Board {

    private int size;
    private Block[][] board;
    private static List<Color> colors = Arrays.asList(Color.BLUE,
            Color.RED,
            Color.YELLOW,
            Color.GREEN);

    /**
     * Constructor of game board of same game that needs only width and height
     * to be initialized.
     *
     * @param size width of the board.
     */
    Board(int size) {
        this.size = size;

        this.board = new Block[size][size];

    }

    /**
     * Returns the block at the given position.
     *
     * @param pos Position to get the block from.
     * @return Block given at the position.
     */
    Block getAt(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("Given position is "
                    + "outside of the board");
        }
        return this.board[pos.getX()][pos.getY()];
    }

    /**
     * Fills the whole board with randomly generated colored blocks.
     */
    void fillBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                putAt(randomBlock(), new Position(i, j));
            }
        }
    }

    /**
     * Chooses randomly a random color then creates a new block with this
     * randomly choosen color then returns it.
     *
     * @return New randomly generated colored block.
     */
    private Block randomBlock() {
        int random = (int) (Math.random() * 4);
        return new Block(this.colors.get(random));
    }   
    /**
     * Puts given the given block in the parameters at the given position.
     * @param block Block that must be put in the board.
     * @param pos Position to put the block at.
     */
    void putAt(Block block, Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("Given position is "
                    + "outside of the board");
        }
        if (block == null) {
            throw new IllegalArgumentException("Given block is null");
        }
        this.board[pos.getX()][pos.getY()] = block;
    }
    /**
     * Verifies if the given position is inside the board.
     * @param pos position to check.
     * @return  if the position is inside returns true, if not false.
     */
    private boolean isInside(Position pos) {
        return (pos.getX() >= 0
                && pos.getX() < size
                && pos.getY() < size
                && pos.getY() >= 0);
    }
}
