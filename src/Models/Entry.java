package Models;

import java.util.Calendar;

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
     * @param name is the identifying name of this entry
     */
    public Entry(Calendar date){
        this.date = date;   
    }
    
    public void setDate(Calendar date){
        this.date = date;
    }
    public Calendar getDate(){
        return date;
    }
}
