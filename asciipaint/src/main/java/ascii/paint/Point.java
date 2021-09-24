package ascii.paint;

/**
 *
 * @author g56212
 */
public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void move(double dx, double dy) {
        this.x=dx;
        this.y=dy;
    }

    public double distanceTo(Point other) {
        return this.x - other.x + this.y - other.y;
    }
}
