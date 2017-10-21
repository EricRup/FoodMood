package FoodMood;

import Controllers.LoginFXMLController;
import Controllers.MenuFXMLController;
import Models.EntryList;
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
    public static EntryList entryList;
    public static LoginFXMLController lControl;
    public static Stage primaryStage;
    
    
    public static void main(String[] args) {
        entryList = new EntryList();
        launch();
    }

    public static EntryList getEntryList() {
        return entryList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/LoginFXML.fxml"));
        Parent root = loader.load();
        lControl = (LoginFXMLController) loader.getController();
        FoodMood.primaryStage = primaryStage;
        FoodMood.primaryStage.setTitle("FoodMood - Menu");
        FoodMood.primaryStage.setScene(new Scene(root));
        FoodMood.primaryStage.show();
    }
    
}
