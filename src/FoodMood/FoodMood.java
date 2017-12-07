package FoodMood;

import Controllers.LoginFXMLController;
import Controllers.MenuFXMLController;
import Models.EntryList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author David Huynh
 */
public class FoodMood extends Application {

    public static EntryList entryList;
    public static LoginFXMLController lControl;
    public static MenuFXMLController mControl;
    public static Stage primaryStage;

    public static void main(String[] args) {
        entryList = load();
        launch();
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
    }
    
    @Override
    public void stop() throws IOException{
        entryList.save();
    }
    
    public static EntryList load(){
        ObjectInputStream in=null;
        EntryList el = null;
        try {
            File f = new File("persistEntries.txt");
            if (f.exists()){
                in = new ObjectInputStream(new FileInputStream(f));
                el = (EntryList) in.readObject();
                in.close();
            }
            else{
                f.createNewFile();
                el = new EntryList();
            }
        } catch (Exception ex) {
            Logger.getLogger(FoodMood.class.getName()).log(Level.SEVERE, null, ex);
        }
        return el;    
    }

}
