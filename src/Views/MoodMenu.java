/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public MoodMenu() {
        
    }
    
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
