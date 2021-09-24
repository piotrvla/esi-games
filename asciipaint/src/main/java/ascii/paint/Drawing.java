package ascii.paint;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g56212
 */
public class Drawing {

    private List<Shape> shapes;
    int height;
    int width;

    public Drawing() {
        this.height = 100;
        this.width = 100;
        this.shapes = new ArrayList();
    }

    public Drawing(int width, int height) {
        this.width = width;
        this.height = height;
        this.shapes = new ArrayList();

    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    // public Shape getShapeAt(Point p) {
    //}
    int getHeight() {
        return this.height;
    }

    int getWidth() {
        return this.width;
    }

}
