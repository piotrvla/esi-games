package asciipaint.util;

import asciipaint.model.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class that regroups components(leaves and composites).
 *
 * @author g56212
 */
public class Composite extends Component {

    private List<Component> components;

    /**
     * Constructor of the composite, needs a color to be instanced
     *
     * @param color color of the composite.
     */
    public Composite(char color) {
        super("group", color);
        this.components = new ArrayList<>();
    }

    @Override
    public boolean isInside(Point p) {
        for (Component element : this.components) {
            if (element.isInside(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(double dx, double dy) {
        for (Component component : components) {
            component.move(dx, dy);

        }
    }

    // @pbt composite pattern, implies getChildren method
    /**
     * Adds a leaf to the composite.
     *
     * @param leaf leaf to add.
     */
    public void addLeaf(Component leaf) {
        this.components.add(leaf);

    }

    /**
     * Removes a leaf by using it's instance.
     *
     * @param leaf leaf to remove.
     */
    public void removeLeaf(Component leaf) {
        this.components.remove(leaf);
    }

    /**
     * Removes the composite, by returning it's list of components.
     *
     * @return list of components.
     */
    public List<Component> removeGroup() {
        return this.components;

    }

    /**
     * Colors every component that is in the group.
     *
     * @param color new color.
     */
    public void colorGroup(char color) {
        for (Component component : components) {
            component.setColor(color);
        }
    }

}
