package g56212.samegame.model;

import java.util.Stack;

/**
 * CommandManager class manages the executed commands
 *
 * @author g56212
 */
public class CommandManager {

    private final Stack<Command> undoStack;
    private final Stack<Command> redoStack;

    public CommandManager() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    /**
     * Adds the given command to the history of executed commands, then the
     * command is executed.
     *
     * @param command Command to execute.
     */
    public void add(Command command) {
        //@pbt naming, s/add/execute[command]
        undoStack.push(command);
        command.execute();
        redoStack.clear();
    }

    /**
     * Undoes the last command and keeps the trace of.
     *
     * @param game Instance of SameGame to undo the move at.
     */
    public void undo(Game game) {
        if (!undoStack.empty()) {
            undoStack.lastElement().undo();
            redoStack.push(undoStack.lastElement());
            undoStack.pop();
        } else {
            game.notifyObs("undoError");
        }
    }

    /**
     * Redoes the last command only if the instance of the last command is not
     * Remove.
     *
     * @param game Instance of SameGame to redo the move at.
     */
    public void redo(Game game) {
        if (!redoStack.empty()) {
            redoStack.lastElement().execute();
            undoStack.push(redoStack.lastElement());
            redoStack.pop();
        } else {
            game.notifyObs("redoError");
        }
    }
}
