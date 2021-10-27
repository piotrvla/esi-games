package asciipaint;

/**
 *
 * @author g56212
 */
public class AsciiPaint {

    private Drawing drawing;

    /**
     *
     * Creates new AsciiPaint at given size in the parameters.
     *
     * @param width width of the drawing.
     * @param height height of the drawing.
     */
    public AsciiPaint(int width, int height) {
        this.drawing = new Drawing(width, height);
    }

    /**
     *
     * Creates a new Ascii Paint by initialazing it at the default parameters,
     * defined in drawing's class.
     *
     */
    public AsciiPaint() {
        this.drawing = new Drawing();
    }

    /**
     * Creates a new shape, the circle with its size and position given in the
     * arguments.
     *
     * @param x point X of the center of the circle.
     * @param y point Y of the center of the circle.
     * @param radius radius of the circle.
     * @param color color of the circle.
     *
     *
     */
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    /**
     *
     *
     *
     * Creates a new shape, the rectangle with its size and position given in
     * the arguments.
     *
     * @param x point X of the center of the rectangle.
     * @param y point Y of the center of the rectangle.
     * @param width width of the rectangle.
     * @param height height of the rectangle.
     * @param color color of the shape.
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        drawing.addShape(new Rectangle(new Point(x, y), width, height, color));

    }

    /**
     *
     * Creates a new shape, the square with its size and position given in the
     * arguments.
     *
     * @param x point X of the center of the square.
     * @param y point Y of the center of the square.
     * @param side size of the side of the square.
     * @param color color of the shape.
     */
    public void newSquare(int x, int y, double side, char color) {
        Point p = new Point(x, y);
        Square s = new Square(p, side, color);

        this.drawing.addShape(s);
    }

    /**
     *
     * @param x
     * @param y
     * @param dx
     * @param dy
     * @param color
     */
    public void newLine(int x, int y, int dx, int dy, char color) {

        this.drawing.addShape(new Line(new Point(x, y),
                new Point(dx, dy), color));
    }
    /**
     * 
     */
    public void displayShapes() {
        for (int i = 0; i < this.drawing.getShapes().size(); i++) {
            System.out.println("N° " + i + " | "
                    + this.drawing.getShapes().get(i).getName());
        }
    }

    /**
     *
     * Transforms the drawing and its all shapes in to an Ascii Paint string by
     * verifying if at the given point there's a shape, if it's the case its
     * color will be added to the string.
     *
     * @return String with all shapes that the drawing contains.
     */
    public String asAscii() {
        String ascii = "";
        for (int y = 0; y < drawing.getHeight(); y++) {
            for (int x = 0; x < drawing.getWidth(); x++) {
                Point p = new Point(x, y);
                if (drawing.getShapeAt(p) != null) {
                    ascii += drawing.getShapeAt(p).getColor();
                } else {
                    ascii += " ";
                }
            }
            ascii += "\n";
        }
        return ascii;

    }

}
