package g56212.simon.view;

import g56212.simon.controller.Controller;
import g56212.simon.model.GameState;
import g56212.simon.model.Model;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Duration;
import javafx.animation.PauseTransition;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javax.sound.midi.MidiUnavailableException;
import static g56212.simon.model.GameState.GAME_OVER;
import static g56212.simon.model.GameState.RUNNING;
import static g56212.simon.model.GameState.TIME_IS_OVER;
import javafx.application.Platform;

public class View
        implements Observer {

    private Controller controller;
    private Model model;
    private CheckBox silentMode;
    private ViewMenu menu;

    public View(Controller controller, Model model, ViewMenu viewMenu) {
        this.controller = controller;
        this.model = model;
        this.menu = viewMenu;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("SIMON");

        StackPane stack = new StackPane();
        ViewBackground background = new ViewBackground();

        this.silentMode = menu.getSilentMode();
        stack.getChildren().addAll(background, menu);
        this.model.subscribe(this);
        List<Button> buttons = background.getButtons();

        for (Button button : buttons) {
            button.setOnAction(actionEvent -> {
                this.controller.click(button);
            });
        }

        menu.getStart().setOnAction(actionEvent -> {
            this.controller.start(buttons, menu.getGameSpeed());
        });

        menu.getLast().setOnAction(actionEvent -> {

            this.controller.last();

        });
        menu.getLongest().setOnAction(actionEvent -> {

            this.controller.longest();

        });
        Scene scene = new Scene(stack, 650, 650);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void hasBeenClicked(Button button) {

        button.setOpacity(0.5);

        var pause = new PauseTransition(Duration.seconds(0.3));
        pause.setOnFinished(ev -> {
            try {
                Sound.playSound(button, this.silentMode);
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            button.setOpacity(1.);
        });
        pause.play();

    }

    @Override
    public void update(Button button, GameState state) {
        if (button != null) {
            hasBeenClicked(button);
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                switch (state) {
                    case GAME_OVER:
                        menu.setMessage("GAME IS OVER");
                        break;
                    case TIME_IS_OVER:
                        menu.setMessage("TIME IS OVER");
                        break;
                    case RUNNING:
                        menu.setMessage("Info");
                        break;
                }
            }

        }
        );

    }

}
