package asciipaint.command;

import asciipaint.model.AsciiPaint;

/**
 * Color command, used to color a component.
 */
public class Color implements Commands {
    private String[] command;

    private char color;
    private char lastColor;
    private AsciiPaint paint;

    public Color(AsciiPaint paint, String[] command) {
        this.paint = paint;
        this.command = command;

    }

    @Override
    public void execute() {
        this.lastColor = this.paint.getColor(Integer.parseInt(command[1]));
        this.paint.color(Integer.parseInt(command[1]), command[2].charAt(0));
    }

    @Override
    public void undo() {
        this.paint.color(Integer.parseInt(command[1]), this.lastColor);
    }

    @Override
    public void redo() {
        execute();
    }
}
