/**
 *
 * @author
 */
package g56212.samegame.controller;

import g56212.samegame.model.SameGame;
import g56212.samegame.view.View;

public class Controller {

    private final SameGame samegame;
    private final View view;

    public Controller() {
        this.samegame = new SameGame(10, 5);
        this.view = new View(this.samegame);
    }

    void run() {
        this.view.displayGame();
        while(!this.samegame.isGameOver()){
        
        
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
