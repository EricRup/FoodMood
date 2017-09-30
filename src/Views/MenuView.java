package Views;

import Controllers.MenuController;

/**
 *
 * @author David Huynh
 */
public class MenuView {
    private MenuController mControl;
    
    public MenuView(MenuController mControl){
        this.mControl = mControl;
    }
            
    public void viewDiary() {
        mControl.viewDiary();
    }
    
    public void viewAnalysis() {
        mControl.viewAnalysis();
    }
    
}
