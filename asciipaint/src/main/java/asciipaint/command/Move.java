package asciipaint.command;

import asciipaint.model.AsciiPaint;

/**
 * Move command, moves a component.
 */
public class Move implements Commands {

    private String[] command;
    private AsciiPaint ascii;

    public Move(String[] command, AsciiPaint paint) {
        this.command = command;
        this.ascii = paint;
    }

    @Override
    public void execute() {

        this.ascii.move(Integer.parseInt(command[1]),
                Integer.parseInt(command[2]),
                Integer.parseInt(command[3]));

    }

    @Override
    public void undo() {
        this.ascii.move(Integer.parseInt(command[1]),
                -Integer.parseInt(command[2]),
                -Integer.parseInt(command[3]));
    }

    @Override
    public void redo() {
        execute();
    }
}
