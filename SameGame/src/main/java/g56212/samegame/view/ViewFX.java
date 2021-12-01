package g56212.samegame.view;

import g56212.samegame.controller.ControllerFX;
import g56212.samegame.model.Observer;
import g56212.samegame.model.SameGame;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewFX implements Observer {
    
    private ControllerFX controller;
    private SameGame game;
    private VBox root;
    private ButtonsFX buttons;
    private MainZoneFX mainZone;
    private ScoreMenuFX scoreMenu;
    
    public ViewFX(ControllerFX controller, SameGame game) {
        this.game = game;
        this.controller = controller;
        this.game.subscribe(this);
    }

    /**
     * Creates the whole interface of the SameGame and starts the program.
     *
     * @param primaryStage primary stage of the window.
     */
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        primaryStage.setTitle("SameGame - 56212 Smolinski Piotr");
        this.root = new VBox(30);
        
        root.setStyle("-fx-background-color: linear-gradient(to top right, #ff7f50, #6a5acd);");
        root.setAlignment(Pos.CENTER);
        this.buttons = new ButtonsFX(controller);
        buttons.setVisible(false);
        this.mainZone = new MainZoneFX(game, controller);
        this.scoreMenu = new ScoreMenuFX();
        this.scoreMenu.setVisible(false);
        root.getChildren().addAll(scoreMenu, mainZone, buttons);
        root.setMinSize(1000, 750);
        Scene scene = new Scene(root, 1000, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void startGame() {
        mainZone.updateBoard();
    }
    
    @Override
    public void update(String update) {
        if (update.equals("update")) {
            this.game.refactorBoard();
            mainZone.updateBoard();
            scoreMenu.setScore(this.game.getScore());
            scoreMenu.setRecentScore(this.game.getRecentScore());
            scoreMenu.setRemainingBlocks(this.game.getRemainingBlocks());
        } else if (update.equals("start")) {
            buttons.setVisible(true);
            scoreMenu.setVisible(true);
            mainZone.setUnvisible();
            mainZone.createBoard();
            
            
        } else if (update.equals("redoError")) {
            
        } else if (update.equals("undoError")) {
            
        } else if (update.equals("removeError")) {
            Alert sheesh = new Alert(Alert.AlertType.ERROR, "Nothing to remove");
            sheesh.show();
        } else if (update.equals("gameOver")) {
            scoreMenu.setVisible(false);
            mainZone.setVisible();
            buttons.setVisible(false);
            mainZone.setState(this.game.getRemainingBlocks());
            
        } else if (update.equals("surrender")) {
            mainZone.setVisible();
            buttons.setVisible(false);
            scoreMenu.setVisible(false);
            mainZone.setState(this.game.getRemainingBlocks());
        }
    }
}
