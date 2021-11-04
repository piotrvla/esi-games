package asciipaint.command;

import asciipaint.model.AsciiPaint;

/**
 * Add command that adds a shape to the drawing.
 */
public class Add implements Commands {

    private String[] command;
    private AsciiPaint ascii;


    public Add(String[] command, AsciiPaint paint) {
        this.command = command;
        this.ascii = paint;


    }

    @Override
    public void execute() {
        switch (command[1].toLowerCase()) {
            case "circle":
                this.ascii.newCircle(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        command[5].charAt(0));
                break;
            case "rectangle":
                this.ascii.newRectangle(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        Double.parseDouble(command[5]),
                        command[6].charAt(0));
                break;
            case "square":
                this.ascii.newSquare(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        command[5].charAt(0));
                break;
            case "line":
                this.ascii.newLine(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Integer.parseInt(command[4]),
                        Integer.parseInt(command[5]),
                        command[6].charAt(0));
                break;
        }
    }


    public void undo() {
        this.ascii.delete(this.ascii.getShapesSize() - 1);

    }


    public void redo() {
        execute();
    }

}
