package testing;

/**
 *
 * @author Eric
 */
public class TestHarness {
    public static void main(String[] args){
        String[] send = {"false"};
        FoodMood.FoodMood.main(send);
        
        
        /**
         * -- Test Path --
         * Enter Menu
         * Choose to View Diary (success)
         * Add Meal
         * -- Add Food (success)
         * -- Add Food (success)
         * -- Add Food (success)
         * -- Remove Food (success)
         * -- Save Meal (success)
         * Add Meal
         * -- Remove Food (fail)
         * -- Add Food (success)
         * -- Remove Food (success)
         * -- Save Meal (fail)
         * -- Add food (success)
         * -- Save Meal (success)
         * 
         * Add Mood "Sad"(success)
         * Add Mood "Happy" (success)
         * Remove Mood "Upset" (fail)
         * Remove Mood "Happy" (success)
         * 
         * View Menu (success)
         * Add Mood (fail)
         * Add Food (fail)
         * View Analysis (success)
         * Analyze Food/Mood Today (success)
         * Analyze Food/Mood Yesterday (fail)
         * 
         */
        
    }
}
