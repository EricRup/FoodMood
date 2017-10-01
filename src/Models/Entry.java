package Models;

import java.util.Calendar;
import javafx.util.Pair;

/**
 *
 * @author Eric
 */
public abstract class Entry {
    private Calendar date;
    private String name;
    
    /**
     * Constructor that initializes attributes
     * @param date is the date and time associated with this entry
     * @param name the name of the entry
     */
    public Entry(Calendar date, String name){
        this.date = date;
        this.name = name;
    }
    
    /**
     * @param date the date to set
     */
    public void setDate(Calendar date){
        this.date = date;
    }
    
    /**
     * @return the date
     */
    public Calendar getDate(){
        return date;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "t:"+date.getTimeInMillis();
    }
}
