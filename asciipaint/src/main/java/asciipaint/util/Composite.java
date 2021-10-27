package asciipaint.util;

import asciipaint.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g56212
 */
public class Composite extends Component {

    private List<Component> components;

    public Composite(String name, char color) {
        super(name, color);
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

    public void addLeaf(Component leaf) {
        System.out.println(leaf.getName());
        this.components.add(leaf);
        System.out.println(this.components.size());

    }

    public void removeLeaf(Component leaf) {
        this.components.remove(leaf);
    }

    public List<Component> removeGroup() {
        return this.components;
    }

    public void colorGroup(char color) {
        for (Component component : components) {
            component.setColor(color);
        }
    }

    public List<Component> getComponents() {
        return this.components;
    }
}
