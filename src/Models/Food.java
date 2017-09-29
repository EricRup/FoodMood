package Models;

/**
 *
 * @author David Huynh
 */

public class Food extends Entry{
    
    private int calories;

    /**
     * Constructor that initializes attributes
     * @param date is the date and time of the entry
     * @param name is the name of the food item as a String
     * @param calories is the calories of food item
     */
    public Food(long date, String name, int calories){
        super(date, name);
        this.calories = calories;
    }
    
    /**
     * @param calories the calories to set
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }      
    
    /**
     * @return the calories
     */
    public int getCalories() {
        return calories;
    }

}
