/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author David Huynh
 */
public class MoodList {
    
    private ArrayList<Food> listOfMoods = new ArrayList();
    
    /**
     * Default constructor for the MoodList model class
     */
    public MoodList(){
        
    }
    /**
     * This method adds moods item to the @param listOfMoods
     */
    
    public void addFood(Food newFood) {
        getListOfMoods().add(newFood);
    }
    
     /**
     * This method prints mood items in the @param listOfMoods
     */
    public void printFood(){
        for(int i = 0; i < getListOfMoods().size(); i++){
            Food currentFood =(Food) getListOfMoods().get(i);
            System.out.println("Food Name: " + currentFood.getFoodName());
            
        }
    }

    /**
     * @return the listOfMoods
     */
    public ArrayList<Food> getListOfMoods() {
        return listOfMoods;
    }

    /**
     * @param listOfMoods the listOfMoods to set
     */
    public void setListOfMoods(ArrayList<Food> listOfMoods) {
        this.listOfMoods = listOfMoods;
    }
}
