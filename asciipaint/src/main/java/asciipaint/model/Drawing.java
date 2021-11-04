package asciipaint.model;

import asciipaint.util.Component;
import asciipaint.util.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g56212
 */
public class Drawing {

    private List<Component> shapes;
    private int height;
    private int width;

    /**
     * Creates a drawing with default parameters as height at 50, and width at
     * 50;
     */
    public Drawing() {
        this.height = 50;
        this.width = 50;
        this.shapes = new ArrayList();
    }

    /**
     * Creates a drawing with the given parameteres.
     *
     * @param width  width of the drawing.
     * @param height height of the drawing.
     */
    public Drawing(int width, int height) {
        this.width = width;
        this.height = height;
        this.shapes = new ArrayList();

    }

    /**
     * Adds a shape to our list of shapes.
     *
     * @param shape shape to add to the list.
     */
    public void addShape(Component shape) {
        shapes.add(shape);
    }

    /**
     * Verifies if there's an existing shape at the position X and Y if it's the
     * case the shape is returned, if not else.
     *
     * @param p point to check if there's any shape.
     * @return A shape or null if there's no shape.
     */
    public Shape getShapeAt(Point p) {
        for (Component shape : shapes) {
            if (shape.isInside(p)) {
                return shape;
            }
        }
        return null;
    }

    public List<Component> listOfComponents() {
        return this.shapes;
    }

    public void move(int pos, int dx, int dy) {
        this.shapes.get(pos).move(dx, dy);
    }

    public void groupLeafs(int leafA, int leafB, String name, char color) {

        Composite comp = new Composite(name, color);
        comp.addLeaf(this.shapes.get(leafA));
        comp.addLeaf(this.shapes.get(leafB));
        if (leafA > leafB) {
            this.shapes.remove(leafA);
            this.shapes.remove(leafB);
        } else {
            this.shapes.remove(leafB);
            this.shapes.remove(leafA);
        }

        this.shapes.add(comp);
    }

    public void ungroupLeafs(int comp) {
        if (!(this.shapes.get(comp) instanceof Composite)) {
            throw new IllegalArgumentException("Component isn't a group!");
        }
        List<Component> leafs = ((Composite) this.shapes.get(comp)).removeGroup();
        for (Component leaf : leafs) {
            this.shapes.add(leaf);
        }
        this.shapes.remove(comp);

    }

    public Component delete(int comp) {
        return this.shapes.remove(comp);
    }

    List<Component> getShapes() {
        return this.shapes;
    }

    int getShapeSize() {
        return this.shapes.size();

    }


    /**
     * Returns the height of the drawing.
     *
     * @return height.
     */
    int getHeight() {
        return this.height;
    }

    /**
     * Returns the width of the drawing.
     *
     * @return width.
     */
    int getWidth() {
        return this.width;
    }

}
