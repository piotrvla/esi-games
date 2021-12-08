package g56212.samegame.model;

/**
 * Remove command that allows to delete a spot in the game.
 */
public class Remove implements Command {

    private Game sameGame;
    private Board lastMove;
    private int x;
    private int y;

    /**
     * Remove constructor that needs SameGame instance, X and Y of the position
     * to delete from.
     *
     * @param sameGame Current instance of the game.
     * @param x X of the position to delete at.
     * @param y Y of the position to delete at.
     */
    public Remove(Game sameGame, int x, int y) {
        this.sameGame = sameGame;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.lastMove = this.sameGame.clone();
        this.sameGame.removeSpot(new Position(x, y));
    }

    @Override
    public void undo() {
        this.sameGame.setBoard(lastMove);
    }
    

}
