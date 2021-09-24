package ascii.paint;

/**
 *
 * @author g56212
 */
public abstract class ColoredShape implements Shape {

    private char color;

    public ColoredShape(char color) {
        this.color = color;
    }

    @Override
    public char getColor() {
        return this.color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    @Override
    public boolean isInside(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(double dx, double dy) {
    }
}
