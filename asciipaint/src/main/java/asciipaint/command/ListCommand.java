package asciipaint.command;

import asciipaint.model.AsciiPaint;

public class ListCommand implements Commands {

    private AsciiPaint ascii;

    public ListCommand(AsciiPaint ascii) {
        this.ascii = ascii;

    }


    @Override
    public void execute() {
        this.ascii.list();
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }


}
