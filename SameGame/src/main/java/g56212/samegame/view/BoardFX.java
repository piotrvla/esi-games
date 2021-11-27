package g56212.samegame.view;

import g56212.samegame.controller.ControllerFX;
import g56212.samegame.model.Colors;
import g56212.samegame.model.Position;
import g56212.samegame.model.SameGame;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setMargin;
import javafx.scene.paint.Color;

/**
 *
 * @author g56212
 */
public class BoardFX extends GridPane {

    private final SameGame game;
    private final ControllerFX controller;
    private BlockFX[][] boardFx;

    public BoardFX(SameGame game, ControllerFX controller) {
        this.game = game;
        this.controller = controller;
    }

    void createBoard() {
        this.getChildren().clear();
        int size = game.getSize();
        boardFx = new BlockFX[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                BlockFX tile;
                if (game.getAt(new Position(row, column)) != null) {

                    Colors color = game.getAt(new Position(row, column)).getColor();
                    switch (color) {
                        case RED ->
                            tile = new BlockFX(Color.RED);
                        case GREEN ->
                            tile = new BlockFX(Color.GREEN);
                        case BLUE ->
                            tile = new BlockFX(Color.BLUE);
                        case YELLOW ->
                            tile = new BlockFX(Color.YELLOW);
                        case ORANGE ->
                            tile = new BlockFX(Color.ORANGE);
                        default ->
                            tile = new BlockFX(Color.BLANCHEDALMOND);
                    }
                } else {
                    tile = new BlockFX(Color.GRAY);
                }
                boardFx[row][column] = tile;
                boardFx[row][column].setPosition(new Position(row, column));
                this.add(tile, column, row);
                setMargin(tile, new Insets(2, 2, 0, 0));

            }
        }
        setEventHandlerOn();
    }

    void setEventHandlerOn() {
        for (BlockFX[] blockFXs : boardFx) {
            for (BlockFX blockFX : blockFXs) {
                if (blockFX != null) {
                    blockFX.setOnMouseClicked(
                            mouseEvent -> controller.play(blockFX.getPosition()));
                }
            }
        }
    }

    void updateBoard() {
        createBoard();
    }
}
