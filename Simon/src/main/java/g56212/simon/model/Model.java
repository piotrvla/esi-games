package g56212.simon.model;

import static g56212.simon.model.GameState.GAME_OVER;
import static g56212.simon.model.GameState.RUNNING;
import static g56212.simon.model.GameState.TIME_IS_OVER;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

/**
 * Model of Simon game.
 *
 * @author g56212
 */
public class Model implements Observable {

    private List<Observer> observer;
    // @pbt list of string or color ok… but no button
    private List<Button> gameSequence = new ArrayList();
    private List<Button> userSequence = new ArrayList();
    private List<Button> lastSequence;
    private List<Button> longestSequence;
    private List<Button> colors;
    private double speed;
    private int indexSequence;
    private GameState state;

    /**
     * Constructor of the model that initialize observer list, last and longest
     * sequence list.
     */
    public Model() {
        this.observer = new ArrayList();
        this.lastSequence = new ArrayList();
        this.longestSequence = new ArrayList();
    }

    /**
     * Starts a game, by retrieving the speed, list of the colors, swapping the
     * state to RUNNING,
     *
     * @param colors every available color used to play the game.
     * @param speed speed of the game.
     */
    public void start(List<Button> colors, double speed) {
        this.colors = colors;
        this.speed = speed;
        this.gameSequence = new ArrayList();
        this.userSequence = new ArrayList();
        this.state = RUNNING;
        notifyObs(state);
        playSequenceStart();
    }

    /**
     * Plays the sequence by adding a new random color to repeat, then displays
     * every color from the first to the new one.
     */
    private void playSequenceStart() {

        Button randomButton = randomColor();
        this.gameSequence.add(randomButton);
        this.indexSequence = 0;
        var timeline = new Timeline((new KeyFrame(
                Duration.seconds(1 / this.speed), event -> {
            notifyObs(gameSequence.get(this.indexSequence));
            this.indexSequence++;
        })));
        timeline.setCycleCount(gameSequence.size());
        timeline.play();

        timer();

    }

    /**
     * Displays the sequence given in the parameter from the 1st element to the
     * last one.
     *
     * @param list list to display as a sequence of colors.
     */
    public void playSequence(List<Button> list) {
        // @pbt view can play sequence. just notify now sequence is ready
        System.out.println(list.size());
        this.indexSequence = 0;
        var timeline = new Timeline((new KeyFrame(Duration.seconds(1 / this.speed), event -> {

            notifyObs(list.get(this.indexSequence));
            this.indexSequence++;

        })));

        timeline.setCycleCount(list.size());
        timeline.play();
    }

    /**
     * Notifies the observer that a button was clicked.
     *
     * @param button
     */
    public void click(Button button) {
        this.userSequence.add(button);
        notifyObs(button);

    }

    /**
     * Chooses a new random color within the list of the colors.
     *
     * @return A new random button.
     */
    private Button randomColor() {
        int randomNb = (int) (Math.random() * 4);
        return this.colors.get(randomNb);
    }

    /**
     * Verifies the user sequence if it's the same as the random generated one,
     * at the start it verifies
     */
    private void checkSequence() {
        int i = 0;
        lastSequence = gameSequence;
        if (gameSequence.size() != this.userSequence.size()) {
            this.state = TIME_IS_OVER;

        }
        while (i < this.gameSequence.size() && this.state == RUNNING) {
            if (!equals(this.userSequence.get(i), this.gameSequence.get(i))) {
                this.state = GAME_OVER;
                this.lastSequence = this.gameSequence;
                this.gameSequence = new ArrayList();
            }
            i++;
        }
        this.userSequence = new ArrayList();

        if (gameSequence.size() > this.longestSequence.size()) {
            this.longestSequence = gameSequence;
        }
        if (this.state == RUNNING) {
            playSequenceStart();
        }
    }

    /**
     * Equals method used to compare two colors.
     *
     * @param a Color a to check.
     * @param b Color b to check.
     * @return a boolean.
     */
    private boolean equals(Button a, Button b) {
        return a.getId().equals(b.getId());
    }

    /**
     * Timer that runs playSequence and notifies the observer after an amount of
     * time.
     */
    private void timer() {
        var timerTask = new TimerTask() {
            @Override
            public void run() {
                checkSequence();
                notifyObs(state);
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, (long) ((3000 + (this.gameSequence.size() * 500))));

    }

    /**
     * Plays the last sequence of the colors played in the current instance of
     * the game.
     */
    public void last() {
        if (!(lastSequence == null)) {
            playSequence(this.lastSequence);
        }
    }

    /**
     * Plays the longest sequence of the colors played in the current instance
     * of the game.
     */
    public void longest() {
        if (!(longestSequence == null)) {
            playSequence(this.longestSequence);
        }
    }

    @Override
    public void notifyObs(Object args) {
        for (Observer obs : observer) {
            obs.update(args);
        }
    }

    @Override
    public void subscribe(Observer ob) {
        observer.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        observer.remove(ob);
    }

}
