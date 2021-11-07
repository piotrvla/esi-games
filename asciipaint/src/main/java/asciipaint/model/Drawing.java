package asciipaint.model;

import asciipaint.util.Component;
import asciipaint.util.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Drawing of the AsciiPaint
 *
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

    /**
     * Returns the list of components.
     *
     * @return list of components.
     */
    public List<Component> listOfComponents() {
        return this.shapes;
    }

    /**
     * Moves a component by x and y pixels in the drawing.
     *
     * @param pos Position of the component.
     * @param dx  number of pixels to move X
     * @param dy  number of pixels to move Y
     */
    void move(int pos, int dx, int dy) {
        if (this.shapes.size() == 0 || pos > this.shapes.size()) {
            throw new IllegalArgumentException("Component does not exist.");
        }
        this.shapes.get(pos).move(dx, dy);
    }

    /**
     * Groups up 2 components into the single one.
     *
     * @param leafA First leaf to be grouped.
     * @param leafB Second leaf to be grouped.
     * @param color color of the group.
     */
    void groupLeaves(int leafA, int leafB, char color) {
        if (leafA > this.shapes.size() || this.shapes.size() == 0 ||
                leafB > this.shapes.size()) {
            throw new IllegalArgumentException("These shapes doesn't exist");
        }
        Composite comp = new Composite(color);
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

    /**
     * Ungroups a group of components.
     *
     * @param comp Position of the component to ungroup.
     */
    void ungroupLeaves(int comp) {
        if (!(this.shapes.get(comp) instanceof Composite)) {
            throw new IllegalArgumentException("Component isn't a group!");
        } else if (this.shapes.size() == 0 || comp > this.shapes.size()) {
            throw new IllegalArgumentException("Component does not exist.");
        }
        List<Component> leaves = ((Composite) this.shapes.get(comp)).removeGroup();
        for (Component leaf : leaves) this.shapes.add(leaf);
        this.shapes.remove(comp);

    }

    /**
     * Colors up the component.
     *
     * @param component position of the component to color.
     * @param color     new color of the component.
     */
    void color(int component, char color) {

        if (this.shapes.size() == 0 || component > this.shapes.size()) {
            throw new IllegalArgumentException("Component does not exist.");
        }
        this.shapes.get(component).setColor(color);
    }

    /**
     * Returns the color of the component.
     *
     * @param component position of the component.
     * @return color of the component.
     */
    char getColor(int component) {
        if (this.shapes.size() == 0 || component > this.shapes.size()) {
            throw new IllegalArgumentException("Component does not exist.");
        }
        return this.shapes.get(component).getColor();

    }

    /**
     * Deletes a component from the list of the component.
     *
     * @param comp Position of the component to delete.
     * @return Deleted component.
     */
    public Component delete(int comp) {
        if (this.shapes.size() == 0 || comp > this.shapes.size()) {
            throw new IllegalArgumentException("Component does not exist.");
        }
        return this.shapes.remove(comp);
    }

    /**
     * Returns the size of the component list.
     *
     * @return component list size.
     */
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
