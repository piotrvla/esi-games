package g56212.samegame.model;

/**
 * Commands that are supposed to execute, undo, redo will implement this class.
 *
 * @author 56212
 */
public interface Command {

    /**
     * Execute command.
     */
    void execute();

    /**
     * Undo last command.
     */
    void undo();
}
