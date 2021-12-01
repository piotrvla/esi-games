package g56212.samegame.view;

import g56212.samegame.controller.ControllerFX;
import g56212.samegame.model.SameGame;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

/**
 *
 * @author g56212
 */
public class MainZoneFX extends StackPane {
    
    private BoardFX board;
    private MenuFX menuFX;
    
    MainZoneFX(SameGame game, ControllerFX controller) {
        this.board = new BoardFX(game, controller);
        this.board.setAlignment(Pos.CENTER);
        this.menuFX = new MenuFX(10, controller);
        this.getChildren().addAll(board, menuFX);
        this.setAlignment(Pos.CENTER);
        this.setMinSize(546, 546);
        this.setMaxSize(546, 546);
    }
    
    void setVisible() {
        this.menuFX.setVisible(true);
    }
    
    void setUnvisible() {
        this.menuFX.setVisible(false);
    }
    
    void updateBoard() {
        this.board.updateBoard();
    }
    
    void createBoard() {
        this.board.createBoard();
    }
}
