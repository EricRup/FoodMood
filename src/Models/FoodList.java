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
public class FoodList {
        
    private ArrayList<Food> listOfFood = new ArrayList();
    
    /**
     * Default constructor for the FoodList model class
     */
    public FoodList(){
        
    }
    
    /**
     * This method adds food item to the @param listOfFood
     */
    public void addFood(Food newFood) {
        getListOfFood().add(newFood);
    }
    
     /**
     * This method prints food items in the @param listOfFood
     */
    public void printFood(){
        for(int i = 0; i < getListOfFood().size(); i++){
            Food currentFood =(Food) getListOfFood().get(i);
            System.out.println("Food Name: " + currentFood.getFoodName());
            
        }
    }

    /**
     * @return the listOfFood
     */
    public ArrayList<Food> getListOfFood() {
        return listOfFood;
    }

    /**
     * @param listOfFood the listOfFood to set
     */
    public void setListOfFood(ArrayList<Food> listOfFood) {
        this.listOfFood = listOfFood;
    }
}
