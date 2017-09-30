package FoodMood;

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
    public static Stage primaryStage;
    /**
     * @param args[] [0] whether to initialize visuals
     */
    public static void main(String[] args) {
        entryList = new EntryList();
        
        if (!args[0].equals("false")){
            launch();
        }
    }

    public static EntryList getEntryList() {
        return entryList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/AnalysisFXML.fxml"));
        FoodMood.primaryStage = primaryStage;
        primaryStage.setTitle("FoodMood - Menu");
        Scene analysis = new Scene(root);
        primaryStage.setScene(analysis);
        primaryStage.show();
    }
    
}
