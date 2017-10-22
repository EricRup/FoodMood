package testing;

import Controllers.*;
import FoodMood.FoodMood;
import static FoodMood.FoodMood.mControl;
import Models.Food;
import Models.Meal;
import Models.Mood;
import java.io.IOException;
import java.util.Calendar;  
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eric
 */
public class TestHarness extends Application{
    public static void main(String[] args) throws IOException{        
        /**
         * -- Test Path --
         * Enter Menu
         * Choose to View Diary (success)
         * Add Meal
         * -- Add Food (success)
         * -- Add Food (success)
         * -- Add Food (success)
         * -- Remove Food (success)
         * 
         * Add Mood "Sad"(success)
         * Add Mood "Happy" (success)
         * Remove Mood "Upset" (fail)
         * Remove Mood "Sad" (success)
         * 
         * View Menu (success)
         * View Analysis (success)
         * Analyze Food Nutrition (success)
         * Analyze Food time (fail)
         * Remove Meal (success)
         * Remove Happy (success)
         * Analyze Nutrition (fail)
         * 
         */
        System.out.println("Launching TestHarness");
        launch();

        
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/MenuFXML.fxml"));
        Parent root = loader.load();
        mControl = (MenuFXMLController) loader.getController();
        primaryStage.setTitle("FoodMood - Menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        
        System.out.println("Entering Main Menu\n---------------------------");
        if (mControl.getCurView().equals("Menu")){
            System.out.println("Successfully entered Menu View");
        }
        else{
            System.err.println("Failed to enter Menu View");
        }
        
        System.out.println("Navigating to Diary\n---------------------------");
        DiaryFXMLController dControl = (DiaryFXMLController) mControl.view("Diary");
        if (mControl.getCurView().equals("Diary"))
            System.out.println("Successfully entered Diary View");
        else
            System.err.println("Failed to enter Diary View");
        
        System.out.println("Creating a meal\n---------------------------");
        Meal meal = new Meal(Calendar.getInstance(), "Salad")
                .addFood(new Food("Spinach"))
                .addFood(new Food("Tomato"))
                .addFood(new Food("Salt")); 
        System.out.println("Adding Spinach, Tomato and Salt to new meal");
        System.out.println(meal.printFoods());
        
        if (meal.printFoods().equals("Foods in Meal\nSpinach\nTomato\nSalt\n"))
            System.out.println("Successful food add to meal");
        else
            System.err.println("Failed add food to meal");
        System.out.println("Removing Spinach");
        meal.removeFood("Spinach");
        System.out.println(meal.printFoods());
        
        if (meal.printFoods().equals("Foods in Meal\nTomato\nSalt\n"))
            System.out.println("Successful remove food from meal");
        else
            System.err.println("Failed to remove food from meal");
        
        System.out.println("Adding meal to Entry List\n---------------------------");
        Calendar mealkey = dControl.addEntry(meal);
        if (mealkey != null)
            System.out.println("Successful add to Entry List");
        else
            System.err.println("Failed to add to Entry List");
        
        System.out.println("Adding Moods to Entry List\n---------------------------");
        Calendar moodkey = dControl.addEntry(new Mood(Calendar.getInstance(), "Happy"));
        Calendar mood2key = dControl.addEntry(new Mood(Calendar.getInstance(), "Sad"));
        
        //Test mood1
        if (moodkey != null)
            System.out.println("Mood 1 successfully input");
        else
            System.err.println("Mood 1 failed to input");
        
        //Test mood2
        if (mood2key != null)
            System.out.println("Mood 2 successfully input");
        else
            System.err.println("Mood 2 failed to input");
        
        //test for proper failure (remove non-existent key)
        if (!dControl.removeEntry(new Mood(Calendar.getInstance(), "Upset")))
            System.out.println("Successful failure to remove non-existent key");
        else
            System.err.println("Failed to fail removal non-existent key");
        
        //test for proper removal (remove "sad" mood)
        if (dControl.removeEntry(mood2key))
            System.out.println("Successfully removed mood 'Sad'");
        else
            System.err.println("Failed to remove 'Sad'");
        
        System.out.println("Traversing to Menu\n---------------------------");
        mControl.view("Menu");
        if ("Menu".equals(mControl.getCurView()))
            System.out.println("Successful traversal to Menu");
        else
            System.err.println("Failed to traverse back to Menu");
        
        
        System.out.println("Traversing to Analysis\n---------------------------");
        AnalysisFXMLController aControl = (AnalysisFXMLController) mControl.view("Analysis");        
        if ("Analysis".equals(mControl.getCurView()))
            System.out.println("Successful traversal to Analysis");
        else
            System.err.println("Failed to traverse back to Analysis");
        
        String nutrAnalyze = aControl.nutritionAnalysis();
        String freqAnalyze = aControl.frequencyAnalysis();
        String timeAnalyze = aControl.timeAnalysis();
        
        String nutrExpected = "Nutrion Analyzed";
        String freqExpected = "Eating Frequency Analyzed";
        String timeExpected = "Time of Eating Analyzed";
        
        System.out.println("Testing Analysis\n---------------------------");
        if (nutrAnalyze != null && nutrAnalyze.equals(nutrExpected))
            System.out.println("Nutrition analysis successful");
        else
            System.err.println("Nutrition analysis failed");
        
        if (freqAnalyze != null && freqAnalyze.equals(freqExpected))
            System.out.println("Frequency analysis successful");
        else
            System.err.println("Frequency analysis failed");
        
        if (timeAnalyze != null && timeAnalyze.equals(timeExpected))
            System.out.println("Time analysis successful");
        else
            System.err.println("Time analysis failed");
        
        System.out.println("Clearing Entry List");
        
        dControl.removeEntry(moodkey);
        dControl.removeEntry(mealkey);
        
        nutrAnalyze = aControl.nutritionAnalysis();
        freqAnalyze = aControl.frequencyAnalysis();
        timeAnalyze = aControl.timeAnalysis();
        
        System.out.println("Ensuring failure on analyze no data");
        
        if (nutrAnalyze == null)
            System.out.println("Nutrition analysis failed successfully");
        else
            System.err.println("Nutrition analysis failed to fail");
        
        if (freqAnalyze == null)
            System.out.println("Frequency analysis failed successfully");
        else
            System.err.println("Frequency analysis failed to fail");
        
        if (timeAnalyze == null)
            System.out.println("Time analysis failed successfully");
        else
            System.err.println("Time analysis failed to fail");
    }
    
}
