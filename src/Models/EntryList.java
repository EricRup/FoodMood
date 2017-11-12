package Models;

import java.time.LocalDateTime;
import java.util.TreeMap;

/**
 *
 * @author Eric
 */
public class EntryList extends TreeMap<LocalDateTime, Entry> {
    
    /**
     * Add method to use date/time as key for entries.
     * In case of collision, add 1 millisecond until it no longer collides
     * Should never collide in real world conditions
     * 
     * @param toAdd the entry to add to the list
     * @return the LocalDateTime identifier of the new entry
     **/
    public LocalDateTime add(Entry toAdd){
        LocalDateTime manip = toAdd.getDate();
        
        while(get(manip) != null){
            manip = manip.plusNanos(1);
        }
        toAdd.setDate(manip);
        this.put(manip, toAdd);
        return toAdd.getDate();
        
    }
    
}
