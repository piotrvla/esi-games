package asciipaint.command;

import asciipaint.model.AsciiPaint;

/**
 * Ungroup command, ungroups a composite.
 */
public class Ungroup implements Commands {
    private AsciiPaint ascii;
    private String[] command;
    private char color;

    public Ungroup(AsciiPaint ascii, String[] command) {
        this.ascii = ascii;
        this.command = command;

    }

    @Override
    public void execute() {
        this.color = this.ascii.getColor(Integer.parseInt(command[1]));
        this.ascii.ungroup(Integer.parseInt(command[1]));
    }

    @Override
    public void undo() {
        this.ascii.group(
                this.ascii.getShapesSize() - 1,
                this.ascii.getShapesSize() - 2,
                this.color);

    }

    @Override
    public void redo() {
        execute();
    }
}
