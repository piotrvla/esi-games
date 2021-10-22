package g56212.simon.model;

import g56212.simon.view.Observer;

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
    private List<Button> gameSequence = new ArrayList();
    private List<Button> userSequence = new ArrayList();
    private List<Button> lastSequence;
    private List<Button> longestSequence;
    private List<Button> colors;
    private double speed;
    private boolean inProgress;
    private int indexSequence;

    public Model() {
        this.observer = new ArrayList();
        this.lastSequence = new ArrayList();
        this.longestSequence = new ArrayList();
    }

    public void start(List<Button> colors, double speed) {
        this.inProgress = true;
        this.colors = colors;
        this.speed = speed;
        this.gameSequence = new ArrayList();
        this.userSequence = new ArrayList();
        playSequenceStart();
    }

    private void playSequenceStart() {

        Button randomButton = randomColor();
        this.gameSequence.add(randomButton);
        this.indexSequence = 0;
        var timeline = new Timeline((new KeyFrame(Duration.seconds(1 / this.speed), event -> {
            notifyObs(gameSequence.get(this.indexSequence));
            this.indexSequence++;
        })));
        timeline.setCycleCount(gameSequence.size());
        timeline.play();

        timer();

    }

    public void playSequence(List<Button> list) {

        System.out.println(list.size());
        this.indexSequence = 0;
        var timeline = new Timeline((new KeyFrame(Duration.seconds(1 / this.speed), event -> {

            notifyObs(list.get(this.indexSequence));
            this.indexSequence++;

        })));

        timeline.setCycleCount(list.size());
        timeline.play();
    }

    public void click(Button button) {
        this.userSequence.add(button);
        System.out.println(button.getId());
        notifyObs(button);

    }

    public void last() {
        if (!(lastSequence == null)) {
            playSequence(this.lastSequence);
        }
    }

    public void longest() {
        if (!(longestSequence == null)) {
            playSequence(this.longestSequence);
        }
    }

    private Button randomColor() {
        int randomNb = (int) (Math.random() * 4);
        return this.colors.get(randomNb);
    }

    private void checkSequence() {
        int i = 0;
        lastSequence = gameSequence;
        if (gameSequence.size() != this.userSequence.size()) {
            this.inProgress = false;
        }
        while (i < this.gameSequence.size() && inProgress) {
            if (!equals(this.userSequence.get(i), this.gameSequence.get(i))) {
                this.inProgress = false;
                this.lastSequence = this.gameSequence;
                this.gameSequence = new ArrayList();
                System.out.println(this.lastSequence.size());
            }
            i++;
        }
        this.userSequence = new ArrayList();

        if (gameSequence.size() > this.longestSequence.size()) {
            this.longestSequence = gameSequence;
        }
        if (inProgress) {
            playSequenceStart();
        }
    }

    private boolean equals(Button a, Button b) {
        return a.getId().equals(b.getId());
    }

    private void timer() {
        var timerTask = new TimerTask() {
            @Override
            public void run() {

                checkSequence();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, (long) ((3000 + (this.gameSequence.size() * 500))));
    }

    @Override
    public void notifyObs(Button button) {
        for (Observer obs : observer) {
            obs.update(button);
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
