package asciipaint;

/**
 *
 * @author g56212
 */
public abstract class ColoredShape extends Component implements Shape {

    private char color;

    /**
     * Creates a new colored shape with given color.
     *
     * @param color
     * @param name
     */
    public ColoredShape(char color, String name) {
        super(name);
        this.color = color;
    }

    /**
     * Returns the color of the shape.
     *
     * @return
     */
    @Override
    public char getColor() {
        return this.color;
    }

    /**
     * Changes the color of the shape.
     *
     * @param color
     */
    public void setColor(char color) {
        this.color = color;
    }
}
