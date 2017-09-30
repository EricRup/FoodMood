package Controllers;

import Models.EntryList;
import Views.DiaryView;

/**
 *
 * @author Eric
 */

public class DiaryController {
    DiaryView diary;
    EntryList entryList;
    
    /**
     * Default Constructor for FoodController
     */
    public DiaryController(EntryList entryList) {
        this.entryList = entryList;
        diary = new DiaryView(this, entryList);
    }
    
    public void view(){
        //diary.view();
    }
    
}
