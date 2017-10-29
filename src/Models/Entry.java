package Models;

import java.time.LocalDateTime;

/**
 *
 * @author Eric
 */
public abstract class Entry {
    private LocalDateTime date;
    private String name;
    
    /**
     * Constructor that initializes attributes
     * @param date is the date and time associated with this entry
     * @param name the name of the entry
     */
    public Entry(LocalDateTime date, String name){
        this.date = date;
        this.name = name;
    }
    
    /**
     * @param date the date to set
     */
    public void setDate(LocalDateTime date){
        this.date = date;
    }
    
    /**
     * @return the date
     */
    public LocalDateTime getDate(){
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
        return "date:"+date.toString();
    }
}
