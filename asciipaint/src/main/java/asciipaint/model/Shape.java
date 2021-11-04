package asciipaint.model;

/**
 * Represents all kind of shapes in our drawing.
 *
 * @author g56212
 */
public interface Shape {

    /**
     * Checks if the given point is inside a shape.
     *
     * @param p point to check.
     * @return boolean, true if it's inside, if not false.
     */
    abstract boolean isInside(Point p);

    /**
     * Moves the main point of the shape at the given position in the parameter.
     *
     * @param dx x of the point to move at.
     * @param dy y of the point to move at.
     */
    abstract void move(double dx, double dy);

    /**
     * Returns the color of the shape.
     *
     * @return char color of the shape.
     */
    char getColor();


}
