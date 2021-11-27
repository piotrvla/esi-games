package g56212.samegame.model;

public class SameGame {

    private Board board;

    /*
     * Constructor of SameGame facade that initializes and fills the board
     * with randomly generated colored blocks.
     * @param size size of the game board.
     */
    public SameGame(int size) {
        this.board = new Board(size);
    }

    /**
     * Removes the spot of the blocks.
     *
     * @param pos Position to remove the spot at.
     */
    public void removeSpot(Position pos) {
        this.board.removeSpot(pos);
    }

    /**
     * Returns the block that's at the given position.
     *
     * @param pos Position to get the block at.
     * @return Block at the given position.
     */
    public Block getAt(Position pos) {
        return this.board.getAt(pos);
    }

    /**
     * Puts a block at the given position.
     *
     * @param block block to put.
     * @param pos position to put the block at.
     */
    public void putAt(Block block, Position pos) {
        this.board.putAt(block, pos);
    }

    /**
     * Returns the size of the board.
     *
     * @return size of the board.
     */
    public int getSize() {
        return this.board.getSize();
    }

    /**
     * Returns total score of the current game.
     *
     * @return total score.
     */
    public int getScore() {
        return this.board.getScore();
    }

    /**
     * Returns the recent score of the last move.
     *
     * @return score of last move.
     */
    public int getRecentScore() {
        return this.board.getRecentScore();
    }

}
