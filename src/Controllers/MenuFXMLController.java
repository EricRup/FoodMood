package Controllers;

import Models.EntryList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eric
 */
public class MenuFXMLController extends Controller implements Initializable{
    private String curView;
    private DiaryFXMLController dControl;
    private AnalysisFXMLController aControl;
    /**
     * Initialize MenuController
     * A centralized controller responsible for general delegation between modules
     */
    public MenuFXMLController(){
        curView = "Menu";        
    }

    /**
     * @return the curView
     */
    public String getCurView() {
        return curView;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (entryList == null){
            entryList = new EntryList();
        }
    }

    /**
     * Change the view to the designated stage
     * @param stage the stage to change the view to. Proper noun format i.e. Diary or Analysis
     * @return the controller for the requested stage (as a generic Controller)
     */
    public Controller view(String targetStage, Stage stage){
        
        if (!curView.equals(targetStage)){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/"+targetStage+"FXML.fxml"));
                Parent root = loader.load();
                stage.setTitle("FoodMood - "+targetStage);
                stage.setScene(new Scene(root));
                curView = targetStage;
                return loader.getController();
            }   
            catch(IOException e){
                System.err.println("Error: Class name ["+targetStage+"] doesn't exist in MenuLoader");
            }
        }
        return null;
    }
}
