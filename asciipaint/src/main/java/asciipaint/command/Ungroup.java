package asciipaint.command;

import asciipaint.model.AsciiPaint;

public class Ungroup implements Commands {
    private AsciiPaint ascii;
    private String[] command;

    public Ungroup(AsciiPaint ascii, String[] command) {
        this.ascii = ascii;
        this.command = command;

    }

    @Override
    public void execute() {

        this.ascii.ungroup(Integer.parseInt(command[1]));
    }

    @Override
    public void undo() {
        this.ascii.group(this.ascii.getShapesSize() - 1,
                this.ascii.getShapesSize() - 2,
                "a",
                'a');

    }

    @Override
    public void redo() {
        execute();
    }
}
