/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.HashMap;

/**
 *
 * @author Walrus
 */
public class Meal extends Entry {

    /*
     * @return the type
     */
    public String getType() {
        return type;
    }

    ArrayList<Food> foodConsumed = new ArrayList<>();
    private final String type = "Meal";

    public Meal(LocalDateTime date, String name) {
        super(date, name);
    }

    public Meal addFood(String iName) {
        foodConsumed.add(new Food(iName));
        return this;
    }

    public Meal addFood(Food toAdd) {
        foodConsumed.add(toAdd);
        return this;
    }

    public void addFoods(Collection<Food> toAdd) {
        foodConsumed.addAll(toAdd);
    }

    public Meal removeFood(String iName) {
        Optional<Food> f = foodConsumed.stream().filter(obj -> obj.getName().equals(iName)).findFirst();
        if (f.isPresent()) {
            foodConsumed.remove(f.get());
        }
        return this;
    }

    public Meal removeFood(Food toRemove) {
        foodConsumed.remove(toRemove);
        return this;
    }

    public ArrayList<Food> getFoods() {
        return foodConsumed;
    }

    public String printFoods() {
        String toReturn = "Foods in Meal\n";
        Iterator<Food> i = foodConsumed.iterator();
        while (i.hasNext()) {
            toReturn += i.next().getName() + "\n";
        }
        return toReturn;
    }

    public HashMap<String, Integer> getTotals() {
        int totalSugar = 0;
        int totalCarbs = 0;
        int totalFiber = 0;
        int totalProtein = 0;

        for (Food food : this.getFoods()) {
            totalSugar += food.getSugars();
            totalFiber += food.getFiber();
            totalProtein += food.getProtein();
            totalCarbs += food.getCarbs();
            totalCalories += food.getCalories();
        }
        HashMap< String, Integer> totals = new HashMap<String, Integer>();
        totals.put("sugar", totalSugar);
        totals.put("fiber", totalFiber);
        totals.put("protein", totalProtein);
        totals.put("carbs", totalCarbs);
        totals.put("calories", totalCalories);
        
        return totals
    }

    @Override
    public String toString() {
        return getName();
    }

}
