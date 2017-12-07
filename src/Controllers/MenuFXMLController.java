package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Eric, David
 */
public class MenuFXMLController extends Controller implements Initializable{
    public DiaryFXMLController dControl;
    /**
     * Initialize MenuController A centralized controller responsible for
     * general delegation between modules
     */
    public MenuFXMLController() {
        super();
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
    }
  
    @FXML
    protected void handleDiaryButtonAction(ActionEvent event) {
        dControl = (DiaryFXMLController) view("Diary");
    }

    @FXML
    protected void handleAnalysisButtonAction(ActionEvent event) {
        view("Analysis");
    }

    
}


