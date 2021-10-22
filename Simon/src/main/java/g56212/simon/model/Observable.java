package g56212.simon.model;

import g56212.simon.view.Observer;
import javafx.scene.control.Button;

/**
 *
 * @author piotr
 */
public interface Observable {
    void notifyObs(Button button, GameState state);
    void subscribe(Observer ob);
    void unsubscribe(Observer ob);
    
}
