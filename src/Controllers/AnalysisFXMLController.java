/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.EntryList;
import Models.Food;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Walrus
 */
public class AnalysisFXMLController implements Initializable {

    private EntryList entryList;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        entryList = FoodMood.FoodMood.getEntryList();
    }    
  
    /**
     * analyzes the effects of quantity and quality of food eaten
     * @return if the analysis was successful
     */
    public boolean nutritionAnalysis(){
        if (entryList.isEmpty()){
            return false;
        }
        System.out.println("Nutrion Analyzed");
        return true;
    }
    /**
     * analyzes the effects of eating a different number of times a day
     * @return if the analysis was successful
     */
    public boolean frequencyAnalysis(){
        if (entryList.isEmpty()){
            return false;
        }
        System.out.println("Eating Frequency Analyzed");
        return true;
    }
    /**
     * analyzes the effects of eating at different times of day
     * @return if the analysis was successful
     */
    public boolean timeAnalysis(){
        if (entryList.isEmpty()){
            return false;
        }
        System.out.println("Time of Eating Analyzed");
        return true;
    }
    
}
