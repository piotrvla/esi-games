package g56212.samegame.view;

import g56212.samegame.controller.ControllerFX;
import g56212.samegame.model.Observer;
import g56212.samegame.model.SameGame;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 56212
 */
public class ViewFX implements Observer {

    private SameGame game;
    private ControllerFX controller;
    private VBox root;

    public ViewFX(ControllerFX controller, SameGame game) {
        this.game = game;
        this.controller = controller;
        this.game.subscribe(this);
    }

    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        primaryStage.setTitle("SameGame");
        this.root = new VBox(10);
        Scene scene = new Scene(root, 1000, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void update(String update) {

    }
}
