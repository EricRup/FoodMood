/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Food;

/**
 *
 * @author David Huynh
 */

public class FoodMenu {
    
    protected Food food;
    
    /**
     * Default Constructor for FoodMenu
     */
    public FoodMenu() {
        
    }
    
    public Food getFood() {
        return this.food;
    }
    
    public void setFood(Food inputFood) {
        this.food = inputFood;
    }
    
    public void exportFoodMood() {
        //code to tell the controller to export food/mood/timestamp to repository
    }
}
