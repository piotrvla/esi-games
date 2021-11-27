package g56212.samegame.model;

/**
 *
 *
 */
public interface Observable {

    void notifyObs(String update);

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
