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
    public Mood(String name){
        super(LocalDateTime.now(), name);
    }
    public Mood(LocalDateTime date, String name) {
        super(date, name);
    }
    
    public String toString(){
        return getName();
    }
}