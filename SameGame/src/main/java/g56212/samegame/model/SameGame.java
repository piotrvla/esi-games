package g56212.samegame.model;

import java.util.ArrayList;
import java.util.List;

public class SameGame implements Observable {

    private Board board;
    private List<Observer> observers;

    /*
     * Constructor of SameGame facade that initializes and fills the board
     * with randomly generated colored blocks.
     * @param size size of the game board.
     */
    public SameGame() {
        this.observers = new ArrayList<>();
        notifyObs("ready");

    }

    public void startGame(int size, int difficulty) {
        this.board = new Board(size);
        this.board.fillBoard(difficulty);
        notifyObs("start");
        notifyObs("update");

    }

    /**
     * Removes the spot of the blocks.
     *
     * @param pos Position to remove the spot at.
     */
    public void removeSpot(Position pos) {
        if (this.board.canRemoveAt(pos)) {
            this.board.removeSpot(pos);
            refactorBoard();
            isGameOver();
            notifyObs("update");
        } else {
            notifyObs("removeError");
        }
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

    public void refactorBoard() {
        this.board.refactorBoard();
    }

    /**
     * Verifies if the game is over or not.
     *
     * @return true if there's no any spot of 2 blocks at least left.
     */
    public boolean isGameOver() {
        if (this.board.isGameOver()) {
            notifyObs("gameOver");
            return true;
        } else {
            return false;
        }

    }

    /**
     * Clones the current board and returns it as a new instance.
     *
     * @return Cloned board.
     */
    public Board clone() {
        return this.board.clone();
    }

    /**
     * Remplaces the board by the board given in the parameter.
     *
     * @param board
     */
    public void setBoard(Board board) {
        this.board = board;
        notifyObs("update");
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

    public int getRemainingBlocks() {
        return this.board.getRemainingBlocks();
    }
    /**
     * Allows to surren
     */
    public void surrender() {
        this.board = null;
        notifyObs("surrender");
    }

    @Override
    public void notifyObs(String update) {
        for (Observer observer : observers) {
            observer.update(update);
        }
    }

    @Override
    public void subscribe(Observer ob) {
        this.observers.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        this.observers.remove(ob);
    }

}
