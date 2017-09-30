package Controllers;

import Models.EntryList;
import Views.MenuView;

/**
 *
 * @author Eric
 */
public class MenuController {
    private EntryList entryList;
    private DiaryController dControl;
    private AnalysisController aControl;
    private MenuView menuView;
    private String curView;
    /**
     * Initialize MenuController
     * A centralized controller responsible for general delegation between modules
     */
    public MenuController(){
        curView = "Menu";
        entryList = new EntryList();
        dControl = new DiaryController(entryList);
        aControl = new AnalysisController(entryList);
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
}
