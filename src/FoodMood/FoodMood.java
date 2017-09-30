package FoodMood;

import Controllers.MenuController;
import Views.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author David Huynh
 */
public class FoodMood extends Application{
    public static MenuController mControl;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mControl = new MenuController();
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/AnalysisFXML.fxml"));
        Stage base = primaryStage;
        base.setTitle("FoodMood - Menu");
        Scene analysis = new Scene(root);
        base.setScene(analysis);
        base.show();
    }
    
}
