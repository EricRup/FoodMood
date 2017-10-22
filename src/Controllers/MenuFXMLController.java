package Controllers;

import Models.EntryList;
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
    private DiaryFXMLController dControl;
    private AnalysisFXMLController aControl;

    /**
     * Initialize MenuController A centralized controller responsible for
     * general delegation between modules
     */
    public MenuFXMLController() {
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
        if (entryList == null) {
            entryList = new EntryList();
        }
    }
  
    @FXML
    protected void handleDiaryButtonAction(ActionEvent event) {
        view("Diary");
    }

    @FXML
    protected void handleAnalysisButtonAction(ActionEvent event) {
        view("Analysis");
    }
}
