package g56212.samegame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a game board of Same Game.
 */
class Board {

    private int size;
    private Block[][] board;
    private List<Position> positions;
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
     * Removes the whole color spot only if the number of the block of the same
     * color in the same spot is bigger than 2;
     *
     * @param pos Position to remove the color spot.
     *
     */
    void removeSpot(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("Position isn't inside the board");
        }
        if (countColors(pos) >= 2) {
            for (Position color : this.positions) {
                removeAt(color);
            }
        }
    }
    /**
     * Checks if there's any spot left with bigger number of colored blocks than 
     * 1 single block left.
     * @return True if the number of blocks is bigger than 1, if not - false.
     */
    boolean isGameOver() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (countColors(new Position(i, j)) >= 2) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Removes the block at the given position. The
     *
     * @param pos Position to remove the colored block at.
     *
     */
    private void removeAt(Position pos) {
        if (this.board[pos.getX()][pos.getY()] != null) {
            throw new IllegalArgumentException("The block at the given"
                    + " position is null");
        }
        this.board[pos.getX()][pos.getY()] = null;

    }

    /**
     * Counts the number of the block contained in the single spot. This method
     * uses another one that adds to the global list every single block of the
     * same color. This list is used to get the size of the spot.
     *
     * @param pos Position to count the number of the blocks at.
     * @return Returns the number of the blocks of the same color contained in
     * the single spot.
     */
    private int countColors(Position pos) {
        if (isInside(pos)) {
            throw new IllegalArgumentException("Position isn't inside the board");
        }
        boolean[][] checked = new boolean[this.size][this.size];
        this.positions = new ArrayList<>();
        if (this.board[pos.getX()][pos.getY()] != null) {
            this.positions.add(pos);
            checked[pos.getX()][pos.getY()] = true;
            for (Position neighbour : getNeighbours(pos)) {
                getSpotPositions(neighbour, checked);
            }
        }
        return this.positions.size();
    }

    /**
     * Adds to the global list position of the every single block that is inside
     * the spot. Initial position must be not null, it's value in the boolean
     * array 2D path must be at false.
     */
    private void getSpotPositions(Position pos, boolean[][] checked) {
        if (!checked[pos.getX()][pos.getY()] && this.board[pos.getX()][pos.getY()] != null) {
            checked[pos.getX()][pos.getY()] = true;
            this.positions.add(pos);
            for (Position neighbour : getNeighbours(pos)) {
                getSpotPositions(neighbour, checked);
            }
        }
    }

    /**
     * Adds to the list every neighbour of the block at the given position. The
     * block at the given position can't be null, must be inside the board.
     *
     * @param pos Position to get the neighbours from.
     * @return Returns every single neighbour of the block if the conditions are
     * respected.
     */
    private List<Position> getNeighbours(Position pos) {
        List<Position> neighbours = new ArrayList<>();

        int x = pos.getX();
        int y = pos.getY();
        if (this.board[pos.getX()][pos.getY()] != null) {
            if (isInside(new Position(x - 1, y)) && board[x - 1][y] != null) {
                if (board[pos.getX()][pos.getY()].equals(board[x - 1][y])) {
                    neighbours.add(new Position(x - 1, y));
                }
            }
            if (isInside(new Position(x + 1, y)) && board[x + 1][y] != null) {
                if (board[pos.getX()][pos.getY()].equals(board[x + 1][y])) {
                    neighbours.add(new Position(x + 1, y));
                }
            }
            if (isInside(new Position(x, y + 1)) && board[x][y + 1] != null) {
                if (board[pos.getX()][pos.getY()].equals(board[x][y + 1])) {
                    neighbours.add(new Position(x, y + 1));
                }
            }
            if (isInside(new Position(x, y - 1)) && board[x][y - 1] != null) {
                if (board[pos.getX()][pos.getY()].equals(board[x][y - 1])) {
                    neighbours.add(new Position(x, y - 1));
                }
            }
        }

        return neighbours;
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
     *
     * @param block Block that must be put in the board.
     * @param pos Position to put the block at.
     */
    private void putAt(Block block, Position pos) {
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
     *
     * @param pos position to check.
     * @return if the position is inside returns true, if not false.
     */
    private boolean isInside(Position pos) {
        return (pos.getX() >= 0
                && pos.getX() < size
                && pos.getY() < size
                && pos.getY() >= 0);
    }

}
