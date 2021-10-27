package asciipaint;

import asciipaint.util.Component;

/**
 * Rectangle.
 *
 * @author g56212
 */
public class Rectangle extends Component {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Creates a rectangle with its main point as upper left, with its size
     * width x height, and its color.
     *
     * @param upperLeft Main point of the shape in the drawing.
     * @param width width of the shape.
     * @param height height of the shape.
     * @param color color of the shape.
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super("Rectangle", color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean isInside(Point p) {
        return p.getX() >= this.upperLeft.getX()
                && p.getX() <= this.upperLeft.getX() + (this.width - 1)
                && p.getY() <= this.upperLeft.getY()
                && p.getY() >= this.upperLeft.getY() - (this.height - 1);
    }

    @Override
    public void move(double dx, double dy) {
        this.upperLeft = new Point(dx, dy);

    }

}
