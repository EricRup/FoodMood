package Models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Eric
 */
public class EntryList extends TreeMap<LocalDateTime, Entry> {

    private final String SEPARATOR = "\t";
    private final String END = "\n";
    private final File f = new File("persistEntries.txt");
    public EntryList() throws IOException{
        load();
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
        StringBuilder sb = new StringBuilder();
        
        if (!f.isFile()) {
            f.createNewFile();
        }
        System.out.println("Saving");
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
                sb.append(de.getStrength())
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
        writer.flush();
    }
    
private void load() throws IOException {

       if (!f.isFile()) {
           f.createNewFile();
       }
       System.out.println("Loading");
       List<String> lines = Files.readAllLines(Paths.get("persistEntries.txt"), StandardCharsets.UTF_8);

       for (String line : lines) {
           String[] entryDetails = line.split("\\t");
           LocalDateTime key = LocalDateTime.parse(entryDetails[0]);
           String name = entryDetails[2];

           if (entryDetails[1].equals("Mood")) {
               int strength = Integer.parseInt(entryDetails[3]);
               Mood mood = new Mood(key, name, strength);
               this.add(mood);
           } else if (entryDetails[1].equals("Meal")) {
               int i = 3;
               Meal meal = new Meal(key, name);

               while (i < entryDetails.length) {
                   String foodName = entryDetails[i];
                   i++;
                   boolean drink = Boolean.parseBoolean(entryDetails[i]);
                   i++;
                   int cal = Integer.parseInt(entryDetails[i]);
                   i++;
                   int carbs = Integer.parseInt(entryDetails[i]);
                   i++;
                   int satFat = Integer.parseInt(entryDetails[i]);
                   i++;
                   int monoFat = Integer.parseInt(entryDetails[i]);
                   i++;
                   int polyFat = Integer.parseInt(entryDetails[i]);
                   i++;
                   int sugars = Integer.parseInt(entryDetails[i]);
                   i++;
                   int fibers = Integer.parseInt(entryDetails[i]);
                   i++;
                   int protein = Integer.parseInt(entryDetails[i]);
                   i++;
                   Food food = new Food(foodName);
                   food.setCalories(cal);
                   food.setDrink(drink);
                   food.setCarbs(carbs);
                   food.setSatFat(satFat);
                   food.setFiber(fibers);
                   food.setProtein(protein);
                   food.setSugars(sugars);
                   food.setPolyFat(polyFat);
                   food.setMonoFat(monoFat);
                   meal.addFood(food);
               }
               this.add(meal);
           }

       }

   }
}
