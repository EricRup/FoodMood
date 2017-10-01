package Controllers;

import Models.EntryList;
import javafx.fxml.Initializable;

/**
 *
 * @author Eric
 */
public abstract class Controller implements Initializable {
    protected static EntryList entryList = new EntryList();
    
    public Controller(){
    }
}
