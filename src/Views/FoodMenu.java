package Views;

import Models.Food;

/**
 *
 * @author David Huynh
 */

public class FoodMenu {
    
    protected Food food;
    
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
