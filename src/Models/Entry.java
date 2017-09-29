package Models;

/**
 *
 * @author Eric
 */
public abstract class Entry {
    private long date;
    private String name;
    
    /**
     * Constructor that initializes attributes
     * @param date is the date and time associated with this entry
     * @param name is the identifying name of this entry
     */
    public Entry(long date, String name){
        this.date = date;
        this.name = name;    
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDate(long date){
        this.date = date;
    }
    public long getDate(){
        return date;
    }
}
