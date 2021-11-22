package asciipaint.command;

/**
 * Command interface.
 */
public abstract interface Commands {
    // @pbt s/Commands/Command
    /**
     * Executes the current instance of the command.
     */
    public void execute();

    /**
     * Undoes last command executed.
     */
    public void undo();


    // @pbt redo is just execute again
    /**
     * Redoes last command executed.
     */
    public void redo();
}
