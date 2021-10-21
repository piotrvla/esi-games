package asciipaint;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g56212
 */
public class Drawing {

    private List<Shape> shapes;
    int height;
    int width;

    /**
     * Creates a drawing with default parameters as height at 50, and width at
     * 50;
     *
     */
    public Drawing() {
        this(50,50);
        /*
        this.height = 50;
        this.width = 50;
        this.shapes = new ArrayList();
        */
    }

    /**
     * Creates a drawing wth the given parameteres.
     *
     * @param width width of the drawing.
     * @param height height of the drawing.
     */
    public Drawing(int width, int height) {
        this.width = width;
        this.height = height;
        this.shapes = new ArrayList();

    }

    /**
     * Adds a shape to our list of shapes.
     *
     * @param shape shape to add to the list.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Verifies if there's an existing shape at the position X and Y if it's the
     * case the shape is returned, if not else.
     *
     * @param p point to check if there's any shape.
     * @return A shape or null if there's no shape.
     */
    public Shape getShapeAt(Point p) {
        for (Shape shape : shapes) {
            if (shape.isInside(p)) {
                return shape;
            }
        }
        return null;
    }

    /**
     * Returns the height of the drawing.
     *
     * @return height.
     */
    int getHeight() {
        return this.height;
    }

    /**
     * Returns the width of the drawing.
     *
     * @return width.
     */
    int getWidth() {
        return this.width;
    }

}
