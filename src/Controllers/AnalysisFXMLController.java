/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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

    /**
     * Constructor instantiates a collection of Entries
     */
    public AnalysisFXMLController(){
        
    }
    /**
     * analyzes the effects of quantity and quality of food eaten
     */
    public void nutritionAnalysis(){
        
        System.out.println("Nutrion Analyzed");
    }
    /**
     * analyzes the effects of eating a different number of times a day
     */
    public void frequencyAnalysis(){
       
        System.out.println("Eating Frequency Analyzed");
    }
    /**
     * analyzes the effects of eating at different times of day
     */
    public void timeAnalysis(){
        System.out.println("Time of Eating Analyzed");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
