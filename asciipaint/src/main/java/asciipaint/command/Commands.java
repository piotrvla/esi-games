package asciipaint.command;

/**
 * Command interface.
 */
public abstract interface Commands {
    /**
     * Executes the current instance of the command.
     */
    public void execute();

    /**
     * Undoes last command executed.
     */
    public void undo();

    /**
     * Redoes last command executed.
     */
    public void redo();
}
