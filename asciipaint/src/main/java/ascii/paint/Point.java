package ascii.paint;

/**
 * Point in our drawing.
 *
 * @author g56212
 */
public class Point {

    private double x;
    private double y;

    /**
     * Creates a point with parameters X and Y.
     *
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a new point with 
     * @param p
     */
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Moving the point at the given position in the parameter.
     * @param dx X to be moved at.
     * @param dy Y to be moved at.
     */
    public void move(double dx, double dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * Calculate the distance between 2 points using pythagore's method.
     * @param other The other point to get the distance between.
     * @return the distance between 2 points.
     */
    public double distanceTo(Point other) {
        double distance = Math.sqrt(
                Math.pow(other.x - this.x, 2)
                + Math.pow(other.y - this.y, 2));
        return distance;
    }
    /**
     * Returns X of the point.
     * @return X
     */
    double getX() {
        return this.x;
    }
    /**
     * Returns Y of the point.
     * @return Y
     */
    double getY() {
        return this.y;
    }
}
