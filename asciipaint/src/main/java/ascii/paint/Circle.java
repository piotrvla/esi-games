package ascii.paint;

/**
 *
 * @author g56212
 */
public class Circle extends ColoredShape {

    private Point center;
    private double radius;

    public Circle(Point center, double radius, char color) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean isInside(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(double dx, double dy) {
        this.center = new Point(dx, dy);
    }
}
