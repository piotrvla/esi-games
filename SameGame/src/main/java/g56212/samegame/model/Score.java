package g56212.samegame.model;

/**
 * Score in the game.
 *
 * @author 56212
 */
class Score {

    private int score;
    private int recentScore;

    /**
     * Creates a score by initializing its value at 0, same for the recent
     * score.
     */
    Score() {
        this.score = 0;
        this.recentScore = 0;
    }

    /**
     * Creates a score by using already existing score values.
     *
     * @param score
     * @param recentScore
     */
    Score(int score, int recentScore) {
        this.score = score;
        this.recentScore = recentScore;
    }

    /**
     * Gets the score, and the recent score using the number of deleted blocks.
     *
     * @param deletedBlocks
     */
    void addScore(int deletedBlocks) {
        this.score += ((deletedBlocks * (deletedBlocks - 1)));
        this.recentScore = deletedBlocks * (deletedBlocks - 1);
    }

    /**
     * Getter of the score.
     *
     * @return Score is returned.
     */
    int getScore() {
        return this.score;
    }

    /**
     * Getter of the recent score of the last move.
     *
     * @return Recent score of the last move is returned.
     */
    int getRecentScore() {
        return this.recentScore;
    }

}
