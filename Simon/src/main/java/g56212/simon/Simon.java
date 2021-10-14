package g56212.simon;
import g56212.simon.controller.Controller;
import g56212.simon.model.Model;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;



/**
 *
 * @author piotr
 */
public class Simon extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        Controller controller = new Controller(model, stage);
        
    }

}
