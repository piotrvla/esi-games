package asciipaint.model;

import asciipaint.util.Component;

import java.util.List;

/**
 * @author g56212
 */
public class AsciiPaint {

    private Drawing drawing;

    /**
     * Creates new AsciiPaint at given size in the parameters.
     *
     * @param width  width of the drawing.
     * @param height height of the drawing.
     */
    public AsciiPaint(int width, int height) {
        this.drawing = new Drawing(width, height);
    }

    /**
     * Creates a new Ascii Paint by initializing it at the default parameters,
     * defined in drawing's class.
     */
    public AsciiPaint() {
        this.drawing = new Drawing();
    }

    /**
     * Creates a new shape, the circle with its size and position given in the
     * arguments.
     *
     * @param x      point X of the center of the circle.
     * @param y      point Y of the center of the circle.
     * @param radius radius of the circle.
     * @param color  color of the circle.
     */
    public void newCircle(int x, int y, double radius, char color) {
        if (0 > x || x > this.drawing.getWidth()
                || 0 > y || y > this.drawing.getHeight()) {
            throw new IllegalArgumentException("Out of bonds");
        }
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    /**
     * Creates a new shape, the rectangle with its size and position given in
     * the arguments.
     *
     * @param x      point X of the center of the rectangle.
     * @param y      point Y of the center of the rectangle.
     * @param width  width of the rectangle.
     * @param height height of the rectangle.
     * @param color  color of the shape.
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        if (0 > x || x > this.drawing.getWidth()
                || 0 > y || y > this.drawing.getHeight()) {
            throw new IllegalArgumentException("Out of bonds");
        }
        drawing.addShape(new Rectangle(new Point(x, y), width, height, color));

    }

    /**
     * Creates a new shape, the square with its size and position given in the
     * arguments.
     *
     * @param x     point X of the center of the square.
     * @param y     point Y of the center of the square.
     * @param side  size of the side of the square.
     * @param color color of the shape.
     */
    public void newSquare(int x, int y, double side, char color) {
        if (0 > x || x > this.drawing.getWidth()
                || 0 > y || y > this.drawing.getHeight()) {
            throw new IllegalArgumentException("Out of bonds");
        }
        Point p = new Point(x, y);
        Square s = new Square(p, side, color);

        this.drawing.addShape(s);
    }

    /**
     * @param x
     * @param y
     * @param dx
     * @param dy
     * @param color
     */
    public void newLine(int x, int y, int dx, int dy, char color) {
        if (0 > x || x > this.drawing.getWidth()
                || 0 > y || y > this.drawing.getHeight()
                || 0 > dx || dx > this.drawing.getWidth()
                || 0 > dy || dy > this.drawing.getHeight()) {
            throw new IllegalArgumentException("Out of bonds");
        }

        this.drawing.addShape(new Line(new Point(x, y),
                new Point(dx, dy), color));
    }

    public void addShape(Component comp) {

        this.drawing.addShape(comp);

    }

    /**
     * Transforms the drawing and its all shapes in to an Ascii Paint string by
     * verifying if at the given point there's a shape, if it's the case its
     * color will be added to the string.
     *
     * @return String with all shapes that the drawing contains.
     */
    public String asAscii() {
        StringBuilder ascii = new StringBuilder();
        for (int y = 0; y < drawing.getHeight(); y++) {
            for (int x = 0; x < drawing.getWidth(); x++) {
                Point p = new Point(x, y);
                if (drawing.getShapeAt(p) != null) {
                    ascii.append(drawing.getShapeAt(p).getColor());
                } else {
                    ascii.append(" ");
                }
            }
            ascii.append("\n");
        }
        return ascii.toString();

    }

    public int getShapesSize() {
        return this.drawing.getShapeSize();

    }

    public List<Component> list() {
        return this.drawing.listOfComponents();

    }

    public void move(int pos, int dx, int dy) {
        this.drawing.move(pos, dx, dy);
    }

    public void group(int composantA, int composantB, String name, char color) {
        this.drawing.groupLeafs(composantA, composantB, name, color);
    }

    public Component delete(int comp) {
        return this.drawing.delete(comp);

    }

    public void ungroup(int composant) {
        this.drawing.ungroupLeafs(composant);
    }
}
