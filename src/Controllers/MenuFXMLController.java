package Controllers;

import Models.EntryList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author Eric
 */
public class MenuFXMLController implements Initializable{
    private static EntryList entryList;
    private String curView;
    /**
     * Initialize MenuController
     * A centralized controller responsible for general delegation between modules
     */
    public MenuFXMLController(){
        curView = "Menu";
        entryList = new EntryList();
        viewMenu();        
    }
    /**
     * Set the view to DiaryView
     */
    public void viewDiary(){
        if (!curView.equals("Diary")){
            //dControl.view();
            curView = "Diary";
        }
    }
    
    /**
     * Set the view to AnalysisView
     */
    public void viewAnalysis(){
        if (!curView.equals("Analysis")){
            //aControl.view();
            curView = "Analysis";
        }
    }
    /**
     * Set the view to MenuView
     */
    public final void viewMenu(){
        //menuView.view();
        
    }

    /**
     * @return the entryList
     */
    public EntryList getEntryList() {
        return entryList;
    }

    /**
     * @param entryList the entryList to set
     */
    public void setEntryList(EntryList entryList) {
        this.entryList = entryList;
    }

    /**
     * @return the curView
     */
    public String getCurView() {
        return curView;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        entryList = FoodMood.FoodMood.getEntryList();
    }
}
