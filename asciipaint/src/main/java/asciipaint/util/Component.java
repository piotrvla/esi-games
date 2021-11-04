package asciipaint.util;

import asciipaint.model.ColoredShape;

/**
 * Component that represents the shapes and the groups.
 *
 * @author piotr
 */
public abstract class Component extends ColoredShape {

    private final String name;

    /**
     * Constructor of the component, needs a name and it's color to be instanced.
     *
     * @param name  name of the component.
     * @param color color of the component.
     */
    public Component(String name, char color) {
        super(color);
        this.name = name;
    }

    /**
     * Returns the name of the component.
     *
     * @return name of the component.
     */
    public String getName() {
        return this.name;
    }
}
