package g56212.simon.controller;

import g56212.simon.model.Model;
import g56212.simon.view.View;
import java.util.List;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller of Simon game.
 * @author g56212
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, Stage stage) {
        this.model = model;
        this.view = new View(this, model);
        this.view.start(stage);
        // model.initialize();
    }

    public void start(List<Button> colors, double speed) {
        this.model.start(colors, speed);
    }

//    public void last() {
//        this.model.last();
//    }
//
//    public void longest() {
//        this.model.longest();
//    }
    public void click(Button button) {
        this.model.click(button);
    }
}
