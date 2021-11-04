package asciipaint.model;

import asciipaint.util.Component;

/**
 * Line - a component of the drawing.
 *
 * @autor piotr
 */
public class Line extends Component {

    private Point a;
    private Point b;

    /**
     * Constructor of the line component. Needs a Point A and point B and a color to be instanced.
     *
     * @param a     point A of the line.
     * @param b     point B of the line.
     * @param color color of the line.
     */
    public Line(Point a, Point b, char color) {
        super("Line", color);
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


}
