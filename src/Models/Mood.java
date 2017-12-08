package Models;

import java.time.LocalDateTime;

/**
 *
 * @author David Huynh
 */

public class Mood extends Entry{
    /**
     * Constructor that initializes attributes
     * @param date is the date and time of the entry
     * @param name is the name of the food item as a String
     * @param strength is the indicated strength of this mood
     */
  
    private int strength;
  
    public Mood(LocalDateTime date, String name, int strength) {
        super(date, name);
        this.strength = strength;
        setType("Mood");
    }
    
    public Mood(String name, int strength){
        super(LocalDateTime.now(), name);
        this.strength = strength;
        setType("Mood");
    }
    @Override
    public String toString(){
        return getName() + ": "+getStrength();
    }

    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }
}