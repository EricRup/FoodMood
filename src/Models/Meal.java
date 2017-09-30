/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Walrus
 */
public class Meal extends Entry{
    
    ArrayList<Food> foodConsumed = new ArrayList<>();
    
    public Meal(Calendar date) {
        super(date);
    }
    
    public void addFood(Food toAdd){
        foodConsumed.add(toAdd);
        
        for (Food f : foodConsumed){
            System.out.println(f.getName());
        }
    }
    
}
