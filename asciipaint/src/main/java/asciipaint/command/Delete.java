package asciipaint.command;

import asciipaint.model.AsciiPaint;
import asciipaint.util.Component;

/**
 * Delete command, that deletes a component from the drawing.
 */
public class Delete implements Commands {
    private String[] command;
    private AsciiPaint ascii;
    private Component deleted;


    public Delete(String[] command, AsciiPaint paint) {
        this.command = command;
        this.ascii = paint;
    }

    @Override
    public void execute() {
        this.deleted = this.ascii.delete(Integer.parseInt(this.command[1]));
    }

    public void undo() {
        this.ascii.addShape(deleted);
        this.deleted = null;
    }

    public void redo() {
        execute();
    }
}
