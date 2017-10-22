package Controllers;

import Models.EntryList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Eric, David
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

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        view("Menu");
    }

}
