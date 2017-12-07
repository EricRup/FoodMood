/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import FoodMood.FoodMood;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Walrus
 */
public class AnalysisFXMLController extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * analyzes the effects of quantity and quality of food eaten
     *
     * @return if the analysis was successful
     */
    public String nutritionAnalysis() {
        if (FoodMood.entryList.isEmpty()) {
            return null;
        }
        return "Nutrion Analyzed";
    }

    /**
     * analyzes the effects of eating a different number of times a day
     *
     * @return if the analysis was successful
     */
    public String frequencyAnalysis() {
        if (FoodMood.entryList.isEmpty()) {
            return null;
        }
        return "Eating Frequency Analyzed";
    }

    /**
     * analyzes the effects of eating at different times of day
     *
     * @return if the analysis was successful
     */
    public String timeAnalysis() {
        if (FoodMood.entryList.isEmpty()) {
            return null;
        }
        return "Time of Eating Analyzed";
    }

}
