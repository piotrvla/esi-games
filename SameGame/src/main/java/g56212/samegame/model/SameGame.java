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
        this.board.fillBoard();
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

    public void putAt(Block block, Position pos) {
        this.board.putAt(block, pos);
    }

}
