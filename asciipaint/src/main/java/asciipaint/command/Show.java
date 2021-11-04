package asciipaint.command;

import asciipaint.model.AsciiPaint;

public class Show implements Commands{
    private AsciiPaint ascii;

    public Show(AsciiPaint ascii) {
        this.ascii = ascii;

    }


    @Override
    public void execute() {
        this.ascii.asAscii();
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
