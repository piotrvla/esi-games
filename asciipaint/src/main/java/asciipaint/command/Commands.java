package asciipaint.command;

public abstract interface Commands {
    /**
     *
     */
    public void execute();

    /**
     *
     */
    public void undo();

    /**
     *
     */
    public void redo();
}
