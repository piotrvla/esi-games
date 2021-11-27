package g56212.samegame;

import g56212.samegame.controller.ControllerFX;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 * Main class of the game Simon
 *
 * @author piotr
 */
public class SameGame extends Application {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        ControllerFX controller = new ControllerFX();
        controller.start(stage);
    }

}
