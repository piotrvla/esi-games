package g56212.simon.controller;

import g56212.simon.model.Model;
import g56212.simon.view.View;
import g56212.simon.view.ViewMenu;
import java.util.List;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller of Simon game.
 *
 * @author g56212
 */
public class Controller {

    private Model model;
    private View view;
    private ViewMenu viewMenu;

    public Controller(Model model, Stage stage) {
        this.model = model;
        this.viewMenu = new ViewMenu();
        this.view = new View(this, model, viewMenu);
        this.view.start(stage);
        // model.initialize();
    }

    /**
     *
     * @param colors
     * @param speed
     */
    public void start(List<Button> colors, double speed) {
        this.model.start(colors, speed);
    }

    /**
     *
     */
    public void last() {
        this.model.last();
    }

    /**
     *
     */

    public void longest() {
        this.model.longest();
    }

    /**
     *
     * @param button
     */
    public void click(Button button) {
        this.model.click(button);
    }

}
