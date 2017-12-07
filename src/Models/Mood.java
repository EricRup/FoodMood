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
     */
    
    private final String type = "Mood";
    private int strength;
    
    public Mood(LocalDateTime date, String name, int strength) {
        super(date, name);
        this.strength = strength;
    }
    
    public String toString(){
        return getName();
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }
}