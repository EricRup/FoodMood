package Models;

import java.util.Calendar;

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
    public Mood(Calendar date, String name) {
        super(date, name);
    }
    
    public String toString(){
        return getName();
    }
}