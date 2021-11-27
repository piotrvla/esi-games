package g56212.samegame.view;

import g56212.samegame.model.Position;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author g56212
 */
public class BlockFX extends Rectangle {

    private Position position;

    public BlockFX(Color color) {
        super(0, 0, color);
        double SQUARE_SIZE = 40;
        this.setWidth(SQUARE_SIZE);
        this.setHeight(SQUARE_SIZE);
    }

    void setPosition(Position position) {
        this.position = position;
    }

    Position getPosition() {
        return position;
    }

}
