package asciipaint.command;

import asciipaint.model.AsciiPaint;
import asciipaint.util.Component;

public class Delete implements Commands {
    private String[] command;
    private AsciiPaint ascii;
    private Component deleted;


    Delete(String[] command, AsciiPaint paint) {
        this.command = command;
        this.ascii = paint;
    }


    @Override
    public void execute() {
       this.deleted =this.ascii.delete(Integer.parseInt(this.command[1]));
    }

    @Override
    public void undo() {
        this.ascii.addShape(deleted);
    }

    @Override
    public void redo() {
        execute();
    }
}
