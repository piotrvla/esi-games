package g56212.samegame.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author g56212
 */
public class ScoreMenuFX extends VBox {

    private Label score;
    private Label recentScore;
    private Label remainingBlocks;

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

    void setScore(int score) {
        this.score.setText("Score: " + score);
    }

    void setRecentScore(int recScore) {
        this.recentScore.setText("Recent score: " + recScore);
    }

    void setRemainingBlocks(int remainBlocks) {
        this.remainingBlocks.setText("Blocks left: " + remainBlocks);
    }
}
