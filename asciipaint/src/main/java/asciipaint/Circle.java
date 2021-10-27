package asciipaint;

/**
 *
 * @author g56212
 */
public class Circle extends ColoredShape {

    private Point center;
    private double radius;
 

    /**
     * Creates a circle with given center, radius and its color.
     *
     * @param center center of the circle.
     * @param radius radius of the circle.
     * @param color color of the circle.
     */
    public Circle(Point center, double radius, char color) {
        super(color,"Color");
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean isInside(Point p) {
        return Math.pow(p.getX() - center.getX(), 2)
                + Math.pow((p.getY() - center.getY()), 2) < Math.pow(radius, 2);
    }

    @Override
    public void move(double dx, double dy) {
        this.center = new Point(dx, dy);
    }



}
