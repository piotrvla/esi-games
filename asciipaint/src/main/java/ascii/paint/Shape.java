package ascii.paint;

/**
 *
 * @author g56212
 */
public interface Shape {

    boolean isInside(Point p);

    void move(double dx, double dy);

    char getColor();
}
