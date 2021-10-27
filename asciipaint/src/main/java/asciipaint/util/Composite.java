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
        boolean isInside = false;
        for (Component component : components) {
            if (!isInside) {
                isInside = component.isInside(p);
            }

        }
        return isInside;
    }

    @Override
    public void move(double dx, double dy) {
        for (Component component : components) {
            component.move(dx, dy);

        }
    }

    public void addLeaf(Component leaf) {
        this.components.add(leaf);
    }

    public void removeLeaf(Component leaf) {
        this.components.remove(leaf);
    }
    public void colorGroup(char color){
        for (Component component : components) {
            component.setColor(color);
        }
    
    }

}
