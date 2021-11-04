package asciipaint.util;

import asciipaint.model.ColoredShape;

/**
 * @author piotr
 */
public abstract class Component extends ColoredShape {

    private final String name;

    public Component(String name, char color) {
        super(color);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
