package g56212.simon.model;

/**
 * Different states of the game.
 *
 * @author g56212
 */
public enum GameState {
    /**
     * Used to notify the user whenever the time is over.
     */
    TIME_IS_OVER,
    /**
     * Used whenever the game is still running.
     */
    RUNNING,
    /**
     * Used to notify the user that his sequence is wrong.
     */
    GAME_OVER;
}
