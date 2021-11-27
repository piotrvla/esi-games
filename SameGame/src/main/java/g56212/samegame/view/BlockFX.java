package g56212.samegame.view;

import g56212.samegame.model.Position;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Represents a colored block in the javafx game mode.
 *
 * @author g56212
 */
public class BlockFX extends Rectangle {

    private Position position;

    /**
     * Block need only a color to be instanced.
     *
     * @param color Color of the block.
     */
    public BlockFX(Color color) {
        super(0, 0, color);
        double SQUARE_SIZE = 40;
        this.setWidth(SQUARE_SIZE);
        this.setHeight(SQUARE_SIZE);
    }

    /**
     * Sets the position of the current block at the position given in the
     * parameter.
     *
     * @param position Position to set to the block.
     */
    void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Returns the position of the block.
     *
     * @return position of the block.
     */
    Position getPosition() {
        return position;
    }

}
