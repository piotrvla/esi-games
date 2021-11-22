package g56212.simon.view;

import g56212.simon.model.Observer;
import g56212.simon.controller.Controller;
import g56212.simon.model.Model;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Duration;
import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javax.sound.midi.MidiUnavailableException;

/**
 * Main View of the game Simon.
 *
 * @author piotr
 */
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

    /**
     * Creates the whole interface of the Simon game.
     *
     * @param primaryStage primary stage of the window.
     */
    public void start(Stage primaryStage) {

        this.model.subscribe(this);
        this.model.subscribe(menu);

        primaryStage.setTitle("SIMON");
        primaryStage.setMinHeight(650);
        primaryStage.setMinWidth(650);

        StackPane stack = new StackPane();
        ViewBackground background = new ViewBackground();

        this.silentMode = menu.getSilentMode();
        stack.getChildren().addAll(background, menu);
        // @pbt not my preferred way to add action to buttons
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

    /**
     * Illuminates and plays a note according to the button given in the
     * parameter.
     *
     * @param button Button to illuminate and play a sound.
     */
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

    /**
     * Updates the interface by illuminating a button only if the object given
     * in the parameter's class equals this of the button, if it's the case the
     * button is illuminated
     *
     * @param args Object to verify if it's class is Button.
     */
    @Override
    public void update(Object args) {

        if (args.getClass().equals(Button.class)) {
            hasBeenClicked((Button) args);
        }

    }

}
