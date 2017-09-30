package Views;

import Controllers.*;
import Models.EntryList;
/**
 *
 * @author Eric
 */
public class DiaryView {
    private DiaryController dControl;
    private EntryList entryList;
    
    public DiaryView(DiaryController dControl, EntryList entryList){
        this.dControl = dControl;
        this.entryList = entryList;
    }
}
