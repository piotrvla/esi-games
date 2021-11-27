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
    private Score score;
    private List<Position> positions;
    private int remainingBlock;
    private static List<Colors> colors = Arrays.asList(Colors.BLUE,
            Colors.RED,
            Colors.YELLOW,
            Colors.GREEN,
            Colors.ORANGE);

    /**
     * Constructor of game board of same game that needs only width and height
     * to be initialized.
     *
     * @param size width of the board.
     */
    Board(int size) {
        this.size = size;
        this.board = new Block[size][size];
        this.score = new Score();
        this.remainingBlock = size * size;
    }

    /**
     * Returns the block at the given position.
     *
     * @param pos Position to get the block from.
     * @return Block given at the position.
     */
    Block getAt(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("Given position is outside of the board");
        }
        return this.board[pos.getX()][pos.getY()];
    }

    void fillBoard(int difficulty) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                putAt(randomBlock(difficulty), new Position(i, j));
            }
        }
    }

    /**
     * Chooses randomly a random color then creates a new block with this
     * randomly chosen color then returns it.
     *
     * @return New randomly generated colored block.
     */
    private Block randomBlock(int difficulty) {
        if (difficulty <= 1 || difficulty > 5) {
            throw new IllegalArgumentException("Error: cannot play with this kind of difficulty.");
        }
        int random = (int) (Math.random() * difficulty);
        return new Block(this.colors.get(random));
    }

    /**
     * Removes the whole color spot only if the number of the block of the same
     * color in the same spot is bigger than 2; Number of deleted blocks is
     * returned.
     *
     * @param pos Position to remove the color spot.
     * @return number of deleted blocks in the spot.
     */
    private void removeAt(Position pos) {
        if (this.board[pos.getX()][pos.getY()] != null) {
            this.board[pos.getX()][pos.getY()] = null;
        }
    }

    boolean canRemoveAt(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("Position isn't inside the board");
        }
        return countColors(pos) >= 2;
    }

    /**
     * Removes the whole spot whenever it's number of blocks is 2 or more.
     *
     * @param pos Position to remove the spot at.
     */
    void removeSpot(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("Position isn't inside the board");
        }
        int count = countColors(pos);
        if (count < 2) {
            throw new IllegalArgumentException("Cannot remove the spot.");
        }
        this.remainingBlock -= count;
        this.score.addScore(count);

        for (Position color : this.positions) {
            removeAt(color);
        }

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
     * Counts the number of the block contained in the single spot. This method
     * uses another one that adds to the global list every single block of the
     * same color. This list is used to get the size of the spot.
     *
     * @param pos Position to count the number of the blocks at.
     * @return Returns the number of the blocks of the same color contained in
     * the single spot.
     */
    int countColors(Position pos) {
        if (!isInside(pos)) {
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
     * Adds to the list every neighbour of the block at the given position. The
     * block at the given position can't be null, must be inside the board.
     *
     * @param pos Position to get the neibghours from.
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
     * Refactors the board by sliding every block to the bottom.
     */
    void refactorBoard() {
        refactorRow();
        refactorColumn();
    }

    /**
     * Refactors the rows by sliding them to the left. This method checks at
     * first if there's any empty space in the row, starting from the left side.
     * If the empty space is found, a colored block is put at this place.
     * Whenever an empty spaceis found, it's filled with this block, and the
     * block last position is set at null.
     */
    private void refactorRow() {
        for (int i = 0; i < size; i++) {
            int checkBlock = size - 1;
            int blockToMove = size - 1;
            while (checkBlock >= 0 && blockToMove >= 0) {
                while (checkBlock >= 0 && this.board[checkBlock][i] != null) {
                    checkBlock--;
                }
                if (checkBlock >= 0) {
                    blockToMove = checkBlock - 1;
                }
                while (blockToMove >= 0 && this.board[blockToMove][i] == null) {
                    blockToMove--;
                }
                if (checkBlock >= 0 && blockToMove >= 0) {
                    board[checkBlock][i] = board[blockToMove][i];
                    board[blockToMove][i] = null;
                }
            }
        }
    }

    /**
     * Refactors the columns by sliding them down. It's searching for an empty
     * block to slide all remaining blocks which are above this empty cell,
     * every block's last position that was moved, is set as null.
     */
    private void refactorColumn() {
        int checkBlock = 0;
        int blockToMove = 0;
        while (checkBlock < size && blockToMove < size) {
            while (checkBlock < size && this.board[size - 1][checkBlock] != null) {
                checkBlock++;
            }
            if (checkBlock < size) {
                blockToMove = checkBlock + 1;
            }
            while (blockToMove < size && this.board[size - 1][blockToMove] == null) {
                blockToMove++;
            }
            if (blockToMove < size && checkBlock < size) {
                for (int i = 0; i < size; i++) {
                    this.board[i][checkBlock] = this.board[i][blockToMove];
                    this.board[i][blockToMove] = null;
                }
            }

        }

    }

    @Override
    public Board clone() {
        Board cloneBoard = new Board(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.getAt(new Position(i, j)) != null) {
                    cloneBoard.putAt(new Block(getAt(new Position(i, j)).getColor()), new Position(i, j));
                } else {
                    cloneBoard.putAt(null, new Position(i, j));
                }
            }
        }
        cloneBoard.setScore(new Score(getScore(), getRecentScore()));
        return cloneBoard;
    }

    private void setScore(Score score) {
        this.score = score;
    }

    /**
     * Puts at the given position a colored block that isn't null and is inside
     * the board.
     *
     * @param block Colored block to put in the board.
     * @param pos Position where the block must be put.
     */
    void putAt(Block block, Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("Given position is outside of the board");
        }
        this.board[pos.getX()][pos.getY()] = block;
    }

    /**
     * Checks if the game is over or not, the only condition is that there must
     * be a spot with bigger amount of blocks than 2. These blocks must be of
     * the same color.
     *
     * @return True if there's no spot left, false if there's any spot with more
     * than 1 block in the spot.
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
     * Verifies if the given position is inside the board or not.
     *
     * @param pos Position to check if it's inside the board.
     * @return True if the position is inside the board, false if not.
     */
    private boolean isInside(Position pos) {
        return (pos.getX() >= 0 && pos.getX() < size && pos.getY() < size && pos.getY() >= 0);
    }

    /**
     * Returns the size of the board, the board is of the size n x n, then
     * there's only one value returned.
     *
     * @return Size of the board.
     */
    int getSize() {
        return this.size;
    }

    /**
     * Returns the current total score.
     *
     * @return Score.
     */
    int getScore() {
        return this.score.getScore();
    }

    /**
     * Returns the score of the last move.
     *
     * @return score of the last move.
     */
    int getRecentScore() {
        return this.score.getRecentScore();
    }

    int getRemainingBlocks() {
        return this.remainingBlock;
    }

}
