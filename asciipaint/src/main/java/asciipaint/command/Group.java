package asciipaint.command;

import asciipaint.model.AsciiPaint;

/**
 * Group command, that regroups 2 components.
 */
public class Group implements Commands {
    private AsciiPaint ascii;
    private String[] command;

    public Group(AsciiPaint ascii, String[] command) {
        this.ascii = ascii;
        this.command = command;
    }

    @Override
    public void execute() {
        // @pbt code is not robust
        // @pbt group is for more than 2 shapes (use varargs)
        this.ascii.group(Integer.parseInt(command[1]),
                Integer.parseInt(command[2]),
                command[3].charAt(0));
    }

    @Override
    public void undo() {
        this.ascii.ungroup(this.ascii.getShapesSize() - 1);
    }

    @Override
    public void redo() {
        execute();
    }
}
