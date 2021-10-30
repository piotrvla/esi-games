package asciipaint.command;

public interface Commands {
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
