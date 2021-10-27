package asciipaint;

/**
 *
 * @author piotr
 */
public abstract class Component {

    private final String name;

    Component(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
