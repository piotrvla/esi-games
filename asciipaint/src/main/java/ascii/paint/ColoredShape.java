package ascii.paint;

/**
 *
 * @author g56212
 */
public abstract class ColoredShape implements Shape {

    private char color;

    /**
     * Creates a new colored shape with given color.
     * @param color
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * Returns the color of the shape.
     * @return
     */
    @Override
    public char getColor() {
        return this.color;
    }

    /**
     * Changes the color of the shape.
     * @param color
     */
    public void setColor(char color) {
        this.color = color;
    }
}
