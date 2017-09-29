/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author David Huynh
 */

public class Food {
    
    private int ID;
    private String foodName;
    private int calories;

    /**
     * Default constructor for the Food model class
     */
    public Food() {

    }

    /**
     * Constructor that initializes attributes
     * @param ID is the id number associated with the food item
     * @param foodName is the name of the food item as a String
     * @param calories is the calories of food item
     */
    public Food(int ID, String foodName, int calories){
        this.ID = ID;
        this.foodName = foodName;
        this.calories = calories;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * @param foodName the foodName to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * @return the calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * @param calories the calories to set
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }      
}
