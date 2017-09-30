package Controllers;

import Models.Entry;
import Models.EntryList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author Eric
 */

public class DiaryFXMLController implements Initializable{
    EntryList entryList;
    
    /**
     * Default Constructor for FoodController
     * @param entryList the list of moods and foods stored for the diary
     */
    public DiaryFXMLController(EntryList entryList) {
        this.entryList = entryList;
    }
    
    /**
     * Add entry to static entry list
     * @param entry the entry to add
     * @return if the addition replaced another entry. Should always be false
     */
    public boolean addEntry(Entry entry){
        Entry returned = entryList.add(entry);
        return (returned == null);
    }
    
    /**
     * Remove an entry from the entry list
     * @param entry the entry to remove
     * @return if the removal was successful, aka the entry existed
     */
    public boolean removeEntry(Entry entry){
        return entryList.remove(entry);
    }
    /**
     * Initializes JavaFX controller
     * @param url 
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.entryList = FoodMood.FoodMood.getEntryList();
    }
}
