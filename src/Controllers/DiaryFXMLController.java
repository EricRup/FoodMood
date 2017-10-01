package Controllers;

import Models.Entry;
import Models.EntryList;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 *
 * @author Eric
 */

public class DiaryFXMLController extends Controller{

    
    /**
     * Add entry to static entry list
     * @param entry the entry to add
     * @return the Date identifier. Null if failed to add
     */
    public Calendar addEntry(Entry entry){
        return entryList.add(entry);
    }
    
    /**
     * Remove an entry from the entry list
     * @param entry the entry to remove
     * @return if the removal was successful
     */
    public boolean removeEntry(Entry entry){
        return entryList.remove(entry.getDate(), entry);
    }
    
    public boolean removeEntry(Calendar date){
        return entryList.remove(date) != null;
    }
    
    public Entry getEntry(Calendar date){
        return entryList.get(date);
    }
    
    /**
     * Initializes JavaFX controller
     * @param url 
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
