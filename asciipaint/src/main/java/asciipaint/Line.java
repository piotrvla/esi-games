package asciipaint;

/**
 *
 * @autor piotr
 */
public class Line extends ColoredShape {

    private Point a;
    private Point b;
    private final String name="Line";

    public Line(Point a, Point b, char color) {
        super(color);
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean isInside(Point p) {
        double coefficient = (this.b.getY() - this.a.getY())
                / (this.b.getX() - this.a.getX());
        double k = this.a.getY() - coefficient * this.a.getX();
        return coefficient * p.getX() + k == p.getY();
    }

    @Override
    public void move(double dx, double dy) {
        this.a.move(dx, dy);
        this.b.move(dx, dy);
    }

    @Override
    public String getName() {
        return this.name;
    }

}
