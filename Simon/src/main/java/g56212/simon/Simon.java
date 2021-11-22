package g56212.simon;

import g56212.simon.controller.Controller;
import g56212.simon.model.Model;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

// @pbt there are a little echo in application

/**
 * Main class of the game Simon
 *
 * @author piotr
 */
public class Simon extends Application {
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
        Model model = new Model();
        Controller controller = new Controller(model, stage);

    }

}
