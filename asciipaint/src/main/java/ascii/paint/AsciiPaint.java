package ascii.paint;

/**
 *
 * @author g56212
 */
public class AsciiPaint {

    private Drawing drawing;
    /**
     * 
     * @param width
     * @param height 
     */
    public AsciiPaint(int width, int height) {
        this.drawing = new Drawing(width, height);
    }
    /**
     * 
     */
    public AsciiPaint() {
        this.drawing = new Drawing();
    }
    /**
     * 
     * @param x
     * @param y
     * @param radius
     * @param color 
     */
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }
    /**
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color 
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }
    /**
     * 
     * @param x
     * @param y
     * @param side
     * @param color 
     */
    public void newSquare(int x, int y, double side, char color) {
        Point p = new Point(x, y);
        Square s = new Square(p, side, color);

        this.drawing.addShape(s);
    }
    /**
     * 
     * @return 
     */
    public String asAscii() {
        String ascii = "";
        for (int y = 0; y < drawing.getHeight(); y++) {
            for (int x = 0; x < drawing.getWidth(); x++) {
                Point p = new Point(x, y);
                if (drawing.getShapeAt(p) != null) {
                    ascii += drawing.getShapeAt(p).getColor() ;
                } else {
                    ascii += " ";
                }
            }
            ascii += "%n";
        }
        return ascii;

    }
}
