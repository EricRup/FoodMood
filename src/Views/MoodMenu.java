package Views;

import Models.Mood;
import java.util.ArrayList;

/**
 *
 * @author David Huynh
 */

public class MoodMenu {
    
    protected Mood mood;
    protected ArrayList<Mood> moodList;
    
    public void addNewMood(Mood newMood) {
        this.moodList.add(newMood);
        //controller export moodList for user to repository
    }
    
    public void setMood(Mood inputMood) {
        this.mood = inputMood;
    }
    
    public Mood getMood() {
        return this.mood;
    }
    
    public ArrayList getMoodList() {
        return this.moodList;
    }
}
