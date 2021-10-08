package asciipaint;

/**
 * Square.
 * @author g56212
 */
public class Square extends Rectangle {

    /**
     * Creates a square at the given position with its main point as upper left,
     * given length, also its color.
     *
     * @param upperLeft Initial point of the square at the X and Y position
     * @param side length of the side of the square.
     * @param color color of the square.
     */
    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }
}