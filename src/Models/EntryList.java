package Models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Eric
 */
public class EntryList extends TreeMap<LocalDateTime, Entry> {

    private final String SEPARATOR = "\t";
    private final String END = "\n";

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
        File f = new File("persistEntries.txt");
        StringBuilder sb = new StringBuilder();
        
        if (!f.isFile()) {
            f.createNewFile();
        }
        
        for (Map.Entry<LocalDateTime, Entry> entry
                : this.entrySet()) {
            LocalDateTime key = entry.getKey();
            Entry diaryEntry = entry.getValue();
            
            sb.append(key)
                    .append(SEPARATOR)
                    .append(diaryEntry.getType())
                    .append(SEPARATOR)
                    .append(diaryEntry.getName())
                    .append(SEPARATOR);

            if (diaryEntry instanceof Mood) {
                Mood de = (Mood) diaryEntry;
                sb.append(diaryEntry.getName())
                        .append(SEPARATOR)
                        .append(de.getStrength())
                        .append(END);
            }
            if (diaryEntry instanceof Meal) {
                Meal de = (Meal) diaryEntry;

                for (Food food : de.getFoods()) {
                    sb.append(food.isDrink())
                            .append(SEPARATOR)
                            .append(food.getCalories())
                            .append(SEPARATOR)
                            .append(food.getCarbs())
                            .append(SEPARATOR)
                            .append(food.getSatFat())
                            .append(SEPARATOR)
                            .append(food.getMonoFat())
                            .append(SEPARATOR)
                            .append(food.getPolyFat())
                            .append(SEPARATOR)
                            .append(food.getSugars())
                            .append(SEPARATOR)
                            .append(food.getFiber())
                            .append(END);
                }
            }
        }
        Writer writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream(f), "utf-8"));
        writer.write(sb.toString());
    }
}
