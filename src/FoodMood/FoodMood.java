package FoodMood;

import Controllers.LoginFXMLController;
import Controllers.MenuFXMLController;
import Models.EntryList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author David Huynh
 */
public class FoodMood extends Application{
    public static EntryList entryList;
    public static LoginFXMLController lControl;
    public static MenuFXMLController mControl;
    public static Stage primaryStage;
    Scene scene1, scene2;
    
    public static void main(String[] args) {
        entryList = new EntryList();
        launch();
    }

    public static EntryList getEntryList() {
        return entryList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Startup Scene - Login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/LoginFXML.fxml"));
        Parent root = loader.load();
        lControl = (LoginFXMLController) loader.getController();
        FoodMood.primaryStage = primaryStage;
        FoodMood.primaryStage.setTitle("FoodMood - Login");
        FoodMood.primaryStage.setScene(new Scene(root));
        FoodMood.primaryStage.show();
        
        //Scene 2 - Menu
        
        //Scene 3 - Diary
        
    }
    
}
