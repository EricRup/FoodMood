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
     * @return the Entry it replaced. Should always be null.
     **/
    public Entry add(Entry toAdd){
        Calendar manip = toAdd.getDate();
        while(this.get(manip) != null){
            manip.add(Calendar.MILLISECOND, 1);
        }
        toAdd.setDate(manip);
        return this.put(manip, toAdd);
        
    }
    
    /**
     * Removes the entry requested for removal
     * @param toRemove the entry to remove
     * @return if the entry existed in the list.
     */
    public boolean remove(Entry toRemove){
        if (toRemove != null && this.get(toRemove.getDate()) != null){
            this.remove(toRemove.getDate());
            return true;
        }
        else{
            return false;
        }
    }
}
