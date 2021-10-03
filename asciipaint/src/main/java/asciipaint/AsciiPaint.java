package asciipaint;

/**
 *
 * @author g56212
 */
public class AsciiPaint {

    private Drawing drawing;
    /**
<<<<<<< HEAD:asciipaint/src/main/java/asciipaint/AsciiPaint.java
     * Creates new AsciiPaint at given size in the parameters.
     *
=======
     * 
>>>>>>> 1a34caf2aebe57b6a69b76ce6ca50033f3896d6e:asciipaint/src/main/java/ascii/paint/AsciiPaint.java
     * @param width
     * @param height 
     */
    public AsciiPaint(int width, int height) {
        this.drawing = new Drawing(width, height);
    }
    /**
<<<<<<< HEAD:asciipaint/src/main/java/asciipaint/AsciiPaint.java
     * Creates a new Ascii Paint by initialazing it at the default parameters,
     * defined in drawing's class.
=======
     * 
>>>>>>> 1a34caf2aebe57b6a69b76ce6ca50033f3896d6e:asciipaint/src/main/java/ascii/paint/AsciiPaint.java
     */
    public AsciiPaint() {
        this.drawing = new Drawing();
    }
    /**
<<<<<<< HEAD:asciipaint/src/main/java/asciipaint/AsciiPaint.java
     * Creates a new circle then adds it, to the drawing.
     *
     * @param x point X of the center of the circle.
     * @param y point Y of the center of the circle.
     * @param radius radius of the circle.
     * @param color color of the circle.
=======
     * 
     * @param x
     * @param y
     * @param radius
     * @param color 
>>>>>>> 1a34caf2aebe57b6a69b76ce6ca50033f3896d6e:asciipaint/src/main/java/ascii/paint/AsciiPaint.java
     */
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }
    /**
<<<<<<< HEAD:asciipaint/src/main/java/asciipaint/AsciiPaint.java
     * Creates a new rectangle then adds it, to the drawing.
     *
=======
     * 
>>>>>>> 1a34caf2aebe57b6a69b76ce6ca50033f3896d6e:asciipaint/src/main/java/ascii/paint/AsciiPaint.java
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
<<<<<<< HEAD:asciipaint/src/main/java/asciipaint/AsciiPaint.java
     * Creates a new square then adds the square to the drawing.
     *
=======
     * 
>>>>>>> 1a34caf2aebe57b6a69b76ce6ca50033f3896d6e:asciipaint/src/main/java/ascii/paint/AsciiPaint.java
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
<<<<<<< HEAD:asciipaint/src/main/java/asciipaint/AsciiPaint.java
     * Transforms the drawing and its all shapes in to an Ascii Paint string by
     * verifying if at the given point there's a shape, if it's the case its
     * color will be added to the string.
     *
     * @return String with all shapes that the drawing contains.
=======
     * 
     * @return 
>>>>>>> 1a34caf2aebe57b6a69b76ce6ca50033f3896d6e:asciipaint/src/main/java/ascii/paint/AsciiPaint.java
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
<<<<<<< HEAD:asciipaint/src/main/java/asciipaint/AsciiPaint.java

=======
>>>>>>> 1a34caf2aebe57b6a69b76ce6ca50033f3896d6e:asciipaint/src/main/java/ascii/paint/AsciiPaint.java
}
