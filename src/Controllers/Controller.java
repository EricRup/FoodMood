package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author Eric
 */
public abstract class Controller implements Initializable {

    protected static String curView = "";

    public Controller() {
    }

    /**
     * Change the view to the designated stage
     *
     * @param targetStage the stage to change the view to. Proper noun format
     * i.e. Diary or Analysis
     * @param parentStage the stage to return to on window close
     * @return the controller for the requested stage (as a generic Controller)
     */
    public Controller view(String targetStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/" + targetStage + "FXML.fxml"));
            Parent root = loader.load();
            FoodMood.FoodMood.primaryStage.setTitle("FoodMood - " + targetStage);
            FoodMood.FoodMood.primaryStage.setScene(new Scene(root));
            curView = targetStage;
            return loader.getController();
        } catch (IOException e) {
            System.err.println("Error: Class name [" + targetStage + "] doesn't exist in MenuLoader");
            e.printStackTrace();
        }
        return null;
    }
}
