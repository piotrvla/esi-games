package g56212.simon.model;

import g56212.simon.view.Observer;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
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
        this.gameSequence=new ArrayList();
        this.userSequence=new ArrayList();
        playSequence();
    }

    public void playSequence() {
        if (this.inProgress) {
            Button randomButton = randomColor();
            this.gameSequence.add(randomButton);
            this.indexSequence = 0;
            var timeline = new Timeline((new KeyFrame(Duration.seconds(1), event -> {

                notifyObs(this.gameSequence.get(this.indexSequence));
                this.indexSequence++;

            })));
            timeline.setCycleCount(this.gameSequence.size());
            timeline.play();
        }
    }

    public void click(Button button) {
        this.userSequence.add(button);
        System.out.println(button.getId());
        notifyObs(button);
        if (this.gameSequence.size() == this.userSequence.size()) {
            checkSequence();
        }

    }

//    public void last() {
//        playSequence(this.lastSequence);
//    }
//
//    public void longest() {
//        playSequence(this.longestSequence);
//    }
    private Button randomColor() {
        int randomNb = (int) (Math.random() * 4);
        return this.colors.get(randomNb);
    }

    public void checkSequence() {
        int i = 0;
        while (i < gameSequence.size()) {
            if (!equals(userSequence.get(i), gameSequence.get(i))) {
                System.out.println("perdu PAS BONNE SEQUENCE");
                inProgress = false;
                gameSequence = new ArrayList();
            }
            i++;
        }
        userSequence = new ArrayList();
        lastSequence = gameSequence;
        if (lastSequence.size() > longestSequence.size()) {
            longestSequence = lastSequence;
        }
        playSequence();

    }

    public void addNewRandomColorToGameSequence() {

    }

    private boolean equals(Button a, Button b) {
        return a.getId().equals(b.getId());
    }

    public void timer() {
        var pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(ev -> {
            checkSequence();
        });
        pause.play();
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

    public int getGameSequenceSize() {
        return this.gameSequence.size();
    }
}
