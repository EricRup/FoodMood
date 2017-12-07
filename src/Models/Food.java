package Models;

/**
 *
 * @author David Huynh
 */

public class Food{

    
    private int protein = 0;
    private int sugars = 0;
    private int monoFat = 0;
    private int polyFat = 0;
    private int carbs = 0;
    private int calories = 0;
    private int transFat = 0;
    private int fiber = 0;
    private boolean drink = false;
    private int satFat = 0;
    private String name;
    
    /**
     * Constructor that initializes attributes
     * @param date is the date and time of the entry
     * @param name is the name of the food item as a String
     * @param calories is the calories of food item
     */
      /**
    Constructor that requires a food object to be named
    @param iName is the name of the food
    */
    public Food(String iName){
        
    this.name = iName;
}
    /**
     * @return the drink, a boolean value indicating whether 
     * or not the item is a drink
     */
    public boolean isDrink() {
        
        return drink;
    }

    /**
     * @param drink the drink to set, a boolean value indicating whether 
     * or not the item is a drink
     */
    public void setDrink(boolean drink) {
        this.drink = drink;
    }

    /**
     * @return the fiber
     */
    public int getFiber() {
        return fiber;
    }

    /**
     * @param fiber the fiber to set
     */
    public void setFiber(int fiber) {
        this.fiber = fiber;
    }
    
    
    
    /**
     * @return the protein
     */
    public int getProtein() {
        return protein;
    }

    /**
     * @param protein the protein to set
     */
    public void setProtein(int protein) {
        this.protein = protein;
    }
    
    /**
     * @return the satFat, an integer representing saturated fats in grams
     */
    public int getSatFat() {
        return satFat;
    }

    /**
     * @param satFat the satFat to set, an integer representing saturated fats in grams
     */
    public void setSatFat(int satFat) {
        this.satFat = satFat;
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

    /**
     * @return the sugars, an integer representing sugars in Grams
     */
    public int getSugars() {
        return sugars;
    }

    /**
     * @param sugars the sugars to set, an integer representing sugars in Grams
     */
    public void setSugars(int sugars) {
        this.sugars = sugars;
    }

    /**
     * @return the monoFat, an integer representing mono-unsaturated fats in Grams
     */
    public int getMonoFat() {
        return monoFat;
    }

    /**
     * @param monoFat the monoFat to set, an integer representing 
     * mono-unsaturated fats in Grams
     */
    public void setMonoFat(int monoFat) {
        this.monoFat = monoFat;
    }

    /**
     * @return the polyFat, an integer representing poly-unsaturated fats in Grams
     */
    public int getPolyFat() {
        return polyFat;
    }

    /**
     * @param polyFat the polyFat to set, an integer representing 
     * poly-unsaturated fats in Grams
     */
    public void setPolyFat(int polyFat) {
        this.polyFat = polyFat;
    }

    /**
     * @return the calories, an integer representing calories in Grams
     */
    public int getCalories() {
        return calories;
    }

    /**
     * @param calories the calories to set, an integer representing calories in Grams
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * @return the transFat, an integer representing trans fats in Grams
     */
    public int getTransFat() {
        return transFat;
    }

    /**
     * @param transFat the transFat to set
     */
    public void setTransFat(int transFat) {
        this.transFat = transFat;
    }

    /**
     * @return the carbs
     */
    public int getCarbs() {
        return carbs;
    }

    /**
     * @param carbs the carbs to set
     */
    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }
    
    
    /**
     * @return name for toString to enable TreeSet
     */
    @Override
    public String toString() {
        return this.getName(); 
    }

}
