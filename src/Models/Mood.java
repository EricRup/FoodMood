/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author David Huynh
 */

public class Mood {
    
    private int moodNum;
    private String moodName;

    /**
     * Default constructor for the MoodList model class
     */
    public Mood() {
    }

    /**
     * Constructor that initializes attributes
     * @param moodNum is the id number associated with the users mood
     * @param moodName is the name of the food item as a String
     */
    public Mood(int moodNum, String moodName) {
        this.moodNum = moodNum;
        this.moodName = moodName;
    }

    /**
     * @return the moodNum
     */
    public int getMoodNum() {
        return moodNum;
    }

    /**
     * @param moodNum the moodNum to set
     */
    public void setMoodNum(int moodNum) {
        this.moodNum = moodNum;
    }

    /**
     * @return the moodName
     */
    public String getMoodName() {
        return moodName;
    }

    /**
     * @param moodName the moodName to set
     */
    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }
    

}
