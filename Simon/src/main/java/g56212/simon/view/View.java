package g56212.simon.view;

import g56212.simon.controller.Controller;
import g56212.simon.model.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.InvalidationListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

public class View
        extends Application implements Observer {

    private Controller controller;
    private Model model;

    public View(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        model.addListener((InvalidationListener) model);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void update(Observable o, Object o1) {
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SIMON");

        GridPane background = new GridPane();

        StackPane stack = new StackPane();

        Button red = new Button();
        red.setId("red");

        Button green = new Button();
        green.setId("green");
        Button yellow = new Button();
        yellow.setId("yellow");
        Button blue = new Button();
        blue.setId("blue");

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        row1.setPercentHeight(50);
        row2.setPercentHeight(50);
        column1.setPercentWidth(50);
        column2.setPercentWidth(50);
        background.getRowConstraints().addAll(row1, row2);
        background.getColumnConstraints().addAll(column1, column2);

        red.setStyle("-fx-background-color: #df3612");
        yellow.setStyle("-fx-background-color: #f0f400");
        blue.setStyle("-fx-background-color: #00cff4");
        green.setStyle("-fx-background-color: #6bffac");
        red.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        yellow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        blue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        green.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        background.add(red, 1, 1);
        background.add(blue, 0, 0);
        background.add(yellow, 1, 0);
        background.add(green, 0, 1);

        HBox menuButtons = new HBox(8);
        VBox menu = new VBox(10);

        Button longest = new Button();
        longest.setText("Longest");
        Button start = new Button();
        Button last = new Button();
        start.setText("start");
        last.setText("Last");

        String style = "-fx-border-radius:50px;"
                + " -fx-background-color:#a816b5;"
                + " -fx-cursor:pointer;"
                + " -fx-color:#000000;"
                + " -fx-font-family:Arial;"
                + " -fx-font-size:15px;"
                + " -fx-padding:5px 10px;"
                + " -fx-text-decoration:none;";

        longest.setStyle(style);
        last.setStyle(style);
        start.setStyle(style);
        menuButtons.getChildren().addAll(longest, start, last);
        menuButtons.setAlignment(Pos.CENTER);

        Label title = new Label();
        title.setText("SIMON");
        title.setAlignment(Pos.TOP_CENTER);
        title.setStyle("-fx-font-size: 32px;"
                + "   -fx-font-family: Arial Black;");

        CheckBox silentMode = new CheckBox();
        silentMode.setText("Silent mode");

        VBox menuSpeed = new VBox(10);
        Slider speed = new Slider(0, 5, 2.5);
        speed.setMaxWidth(200);
        speed.setShowTickMarks(true);
        Label speedText = new Label();
        speedText.setText(" Speed");
        menuSpeed.setAlignment(Pos.CENTER);
        menuSpeed.getChildren().addAll(speed, speedText);

        menu.setMaxSize(250, 200);
        menu.setStyle("-fx-background-color:rgba(219, 219, 219, 0.9)");

        menu.getChildren().addAll(title, menuSpeed, menuButtons, silentMode);
        menu.setAlignment(Pos.CENTER);
        stack.getChildren().addAll(background, menu);

        // ACTION ON CLICK
        red.setOnAction(actionEvent -> {

            try {
                hasBeenClicked(red, silentMode);
            } catch (MidiUnavailableException ex) {
                ex.printStackTrace();
            }
        });
        yellow.setOnAction(actionEvent -> {

            try {
                hasBeenClicked(yellow, silentMode);
            } catch (MidiUnavailableException ex) {
                ex.printStackTrace();
            }
        });
        green.setOnAction(actionEvent -> {

            try {
                hasBeenClicked(green, silentMode);
            } catch (MidiUnavailableException ex) {
                ex.printStackTrace();
            }
        });
        blue.setOnAction(actionEvent -> {
            try {
                hasBeenClicked(blue, silentMode);
            } catch (MidiUnavailableException ex) {
                ex.printStackTrace();
            }
        });

        //CREATING A LIST OF BUTTONS
        List colors = new ArrayList<Button>();
        colors.add(red);
        colors.add(yellow);
        colors.add(green);
        colors.add(blue);

        start.setOnAction(actionEvent -> {
            playSequence(colors, silentMode);
        });

        Scene scene = new Scene(stack, 650, 650);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void hasBeenClicked(Button button, CheckBox sound) throws MidiUnavailableException {
        button.setOpacity(0.5);
        playSoundOnClick(button, sound);
        var pause = new PauseTransition(Duration.seconds(0.3));
        pause.setOnFinished(ev -> {
            button.setOpacity(1.);
        });
        pause.play();
    }

    private int getNoteByIdButton(Button button) {
        int note = 0;
        switch (button.getId()) {
            case "red":
                note = 65;
                break;
            case "blue":
                note = 66;
                break;
            case "yellow":
                note = 67;
                break;
            case "green":
                note = 68;
                break;
        }
        return note;
    }

    private void playSoundOnClick(Button button, CheckBox sound) throws MidiUnavailableException {
        final int note = getNoteByIdButton(button);
        if (!sound.isSelected()) {
            var synth = MidiSystem.getSynthesizer();
            synth.open();
            var channel = synth.getChannels()[0];
            channel.noteOn(note, 80);
            var pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(ev -> channel.noteOff(0));
            pause.play();

        }
    }

    private void playSequence(List<Button> colors, CheckBox silentMode) {
        var timeline = new Timeline((new KeyFrame(Duration.seconds(1), event -> {
            try {
                hasBeenClicked(randomColor(colors), silentMode);
            } catch (MidiUnavailableException ex) {
                ex.printStackTrace();
            }
        })));
        timeline.setCycleCount(3);
        timeline.play();
    }

    private Button randomColor(List<Button> colors) {
        return colors.get((int) (Math.random() * colors.size()));
    }

}
