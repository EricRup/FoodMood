package Models;

import java.util.TreeMap;

/**
 *
 * @author Eric
 */
public class EntryList extends TreeMap {
    
    //Add method to use date/time as key for entries.
    public void add(Entry toAdd){
        this.put(toAdd.getDate(), toAdd);
    }
}
