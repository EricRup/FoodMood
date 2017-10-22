package Controllers;

import Models.EntryList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 *
 * @author Eric, David
 */
public class MenuFXMLController extends Controller implements Initializable{
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
    @FXML private Text actiontarget;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        view("Menu");
    }
    @FXML protected void handleViewDiary(ActionEvent event) {
        dControl = (DiaryFXMLController) view("Diary");
    }
    @FXML protected void handleViewAnalysis(ActionEvent event) {
        aControl = (AnalysisFXMLController) view("Analysis");
    }
}
