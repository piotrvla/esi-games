package g56212.simon.model;

import javafx.scene.control.Button;

/**
 *
 * @author piotr
 */
public interface Observable {

    /**
     * Notifies the observer by giving an object as an argument, in our case it
     * may only be a button or a state.
     *
     * @param args Object that will be transferred to the view.
     */
    void notifyObs(Object args);

    /**
     * Allows the observer to subscribe the subject (model), it will allow the
     * model to notify the view about any incoming changes.
     *
     * @param ob Observer that will subscribe the subject.
     */
    void subscribe(Observer ob);

    /**
     * Unsubscribes the subject.
     *
     * @param ob Observer that will unsubscribe the subject.
     */
    void unsubscribe(Observer ob);

}
