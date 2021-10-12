package g56212.simon.controller;

import g56212.simon.model.Model;
import g56212.simon.view.View;

/**
 *
 * @author g56212
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this, model);
        //model.initialize();
    }
}
