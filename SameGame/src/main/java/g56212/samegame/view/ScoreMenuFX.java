package g56212.samegame.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Score UI of the game.
 *
 * @author g56212
 */
public class ScoreMenuFX extends VBox {

    private Label score;
    private Label recentScore;
    private Label remainingBlocks;

    /**
     * Constructor of the score UI that creates labels to score, recent score
     * and the number of remaining blocks.
     */
    ScoreMenuFX() {
        super(15);
        String labelStyle = "-fx-text-fill: white; -fx-font-size:18px;";
        this.score = new Label("Score :");
        this.score.setStyle(labelStyle);
        this.recentScore = new Label("Recent Score: ");
        this.recentScore.setStyle(labelStyle);
        this.remainingBlocks = new Label("Blocks left: ");
        this.remainingBlocks.setStyle(labelStyle);
        HBox scores = new HBox(15);
        scores.getChildren().addAll(this.score, this.recentScore);
        scores.setAlignment(Pos.CENTER);
        this.getChildren().addAll(scores, remainingBlocks);
        this.setAlignment(Pos.TOP_CENTER);
    }

    /**
     * Updates the score by updating the text with the score given as an
     * argument.
     *
     * @param Score recent score to be displayed.
     */
    void setScore(int score) {
        this.score.setText("Score: " + score);
    }

    /**
     * Updates the recent score by updating the text with the recent score given
     * as an argument.
     *
     * @param recScore recent score to be displayed.
     */
    void setRecentScore(int recScore) {
        this.recentScore.setText("Recent score: " + recScore);
    }

    /**
     * Updates the number of remaining blocks by updating the text with the
     * remaining number given as an argument.
     *
     * @param remainBlocks current actual remaining blocks number.
     */
    void setRemainingBlocks(int remainBlocks) {
        this.remainingBlocks.setText("Blocks left: " + remainBlocks);
    }
}
