package Models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Eric
 */
public class EntryList extends TreeMap<LocalDateTime, Entry> implements Serializable {

    private final String SEPARATOR = "\t";
    private final String END = "\n";

    public EntryList(){
    }
    /**
     * Add method to use date/time as key for entries. In case of collision, add
     * 1 millisecond until it no longer collides Should never collide in real
     * world conditions
     *
     * @param toAdd the entry to add to the list
     * @return the LocalDateTime identifier of the new entry
     *
     */
    public LocalDateTime add(Entry toAdd) {
        LocalDateTime manip = toAdd.getDate();

        while (get(manip) != null) {
            manip = manip.plusNanos(1);
        }
        toAdd.setDate(manip);
        this.put(manip, toAdd);
        return toAdd.getDate();

    }

    public void save() throws IOException {
        FileOutputStream fout=new FileOutputStream("persistEntries.txt");  
        ObjectOutputStream out=new ObjectOutputStream(fout); 
        out.writeObject(this);
        out.flush();
    }
}
