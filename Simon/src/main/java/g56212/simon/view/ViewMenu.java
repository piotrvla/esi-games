package g56212.simon.view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import g56212.simon.model.GameState;
import static g56212.simon.model.GameState.GAME_OVER;
import static g56212.simon.model.GameState.RUNNING;
import static g56212.simon.model.GameState.TIME_IS_OVER;

/**
 * Menu view of the Simon's game.
 *
 * @author g56212
 */
public class ViewMenu extends VBox implements Observer {

    private final Slider gameSpeed;
    private final CheckBox silentMode;
    private final Button last;
    private final Button longest;
    private final Button start;
    private final Label message;

    /**
     * Constructor of ViewMenu that creates the whole interface of the menu.
     */
    public ViewMenu() {
        this.setSpacing(15);

        this.gameSpeed = new Slider(0.5, 5.5, 3);
        this.silentMode = new CheckBox();
        this.longest = new Button();
        this.longest.setText("Longest");
        this.start = new Button();
        this.last = new Button();
        this.start.setText("start");
        this.last.setText("Last");

        String style = "-fx-border-radius:50px;"
                + " -fx-background-color:#a816b5;"
                + " -fx-cursor:pointer;"
                + " -fx-color:#000000;"
                + " -fx-font-family:Arial;"
                + " -fx-font-size:15px;"
                + " -fx-padding:5px 10px;"
                + " -fx-text-decoration:none;";

        this.longest.setStyle(style);
        this.last.setStyle(style);
        this.start.setStyle(style);

        HBox menuButtons = new HBox(8);
        menuButtons.getChildren().addAll(this.longest, this.start, this.last);
        menuButtons.setAlignment(Pos.CENTER);

        Label title = new Label();

        title.setText("SIMON");
        title.setAlignment(Pos.TOP_CENTER);
        title.setStyle("-fx-font-size: 32px;"
                + "   -fx-font-family: Arial Black;");

        this.silentMode.setText("Silent mode");

        VBox menuSpeed = new VBox();

        this.gameSpeed.setMaxWidth(200);
        this.gameSpeed.setShowTickMarks(true);
        Label gameSpeedText = new Label();
        gameSpeedText.setText("Speed");
        menuSpeed.setAlignment(Pos.CENTER);
        menuSpeed.getChildren().addAll(this.gameSpeed, gameSpeedText);
        menuSpeed.setAlignment(Pos.CENTER);
        this.message = new Label("Info");
        this.setMaxSize(250, 250);
        this.setStyle("-fx-background-color:rgba(219, 219, 219, 0.9)");

        this.getChildren().addAll(title, menuSpeed, menuButtons, this.message, this.silentMode);
        this.setAlignment(Pos.CENTER);

    }

    /**
     * Updates the message whenever the class of the object given in the
     * parameter is equal to GameState class, if it's the case message is set
     * depending of the state given in the parameter.
     *
     * @param args Object used to check and to set the message.
     */
    @Override
    public void update(Object args) {
        if (args.getClass().equals(GAME_OVER.getClass())) {

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    switch ((GameState) args) {
                        case GAME_OVER:
                            setMessage("GAME OVER");
                            break;
                        case TIME_IS_OVER:
                            setMessage("TIME IS OVER");
                            break;
                        case RUNNING:
                            setMessage("Info");
                            break;
                        default:
                            break;
                    }
                }

            }
            );
        }
    }

    /**
     * Returns the game speed from the slider.
     *
     * @return speed of the game as a double value.
     */
    Double getGameSpeed() {
        return this.gameSpeed.getValue();
    }

    /**
     *
     * @return
     */
    CheckBox getSilentMode() {
        return this.silentMode;
    }

    /**
     *
     * @return
     */
    Button getLast() {
        return this.last;

    }

    /**
     *
     * @return
     */
    Button getLongest() {
        return this.longest;
    }

    /*
    
    
     */
    Button getStart() {
        return this.start;
    }

    void setMessage(String message) {
        this.message.setText(message);
    }

}
