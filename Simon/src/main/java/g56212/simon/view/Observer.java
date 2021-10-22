package g56212.simon.view;

import javafx.scene.control.Button;
import g56212.simon.model.GameState;

/**
 *
 * @author piotr
 */
public interface Observer {

    void update(Button button, GameState state);
}
