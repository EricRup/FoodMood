package Models;

import java.util.Calendar;
import java.util.TreeMap;

/**
 *
 * @author Eric
 */
public class EntryList extends TreeMap<Calendar, Entry> {
    
    /**
     * Add method to use date/time as key for entries.
     * In case of collision, add 1 millisecond until it no longer collides
     * Should never collide in real world conditions
     * 
     * @param toAdd the entry to add to the list
     * @return the Calendar identifier of the new entry
     **/
    public Calendar add(Entry toAdd){
        Calendar manip = toAdd.getDate();
        
        while(get(manip) != null){
            manip.add(Calendar.MILLISECOND, 1);
        }
        toAdd.setDate(manip);
        this.put(manip, toAdd);
        return toAdd.getDate();
        
    }
    
}
