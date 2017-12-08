/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author Walrus
 */
public class Analysis {

    EntryList entryList;
    Meal meal;

    public Analysis(EntryList iEntryList) {
        this.entryList = iEntryList;
    }

    public List<String> analyzeNutrition() {
        //This should perform logistic regression, but I can't find a library to use in pure Java
        //nor do I know enough about logistic regression to adapt one, so it just counts and compares
        // moods based on the nutrititional value of recently eaten meals

        ArrayList<String> recs = new ArrayList<>();
        HashMap<String, HashMap<String, Integer>> mealNutrition = new HashMap<>();
        HashMap<String, ArrayList<Mood>> nutrientMoods = new HashMap<>();

        for (Map.Entry<LocalDateTime, Entry> entry
                : entryList.entrySet()) {
            LocalDateTime key = entry.getKey();

            if (entry instanceof Meal) {
                meal = (Meal) entry.getValue();
                String name = meal.getName();
                HashMap<String, Integer> foodNutrition = new HashMap<>();
                LocalDateTime endTime = key.plusHours(6);
                List<Entry> moodSearch = getSubList(key, endTime);
                mealNutrition.put(meal.getName(), meal.getTotals());

                for (Entry relevantEntry : moodSearch) {
                    if (relevantEntry instanceof Mood) {

                        ArrayList<Mood> relevantMoods = new ArrayList<>();
                        Mood relevantMood = (Mood) relevantEntry;
                        relevantMoods.add(relevantMood);
                        for (Map.Entry<String, Integer> nutrientInfo : meal.getTotals().entrySet()) {
                            if (nutrientInfo.getValue() > 30 && !nutrientInfo.getKey().equals("calories")) {
                                if (nutrientMoods.containsKey(nutrientInfo.getKey())) {
                                    ArrayList<Mood> updatedMoods = nutrientMoods.get(nutrientInfo.getKey());
                                    updatedMoods.addAll(relevantMoods);
                                    nutrientMoods.put(nutrientInfo.getKey(), updatedMoods);
                                } else {
                                    nutrientMoods.put(nutrientInfo.getKey(), relevantMoods);
                                }
                            }
                        }
                    }
                }

            }
        }

        for (Map.Entry<String, ArrayList<Mood>> entry : nutrientMoods.entrySet()) {
            String nutrient = entry.getKey();
            ArrayList<Mood> moods = entry.getValue();

            if (moods.size() < 10) {
                String rec = "There is not enough data to determine what influence " + nutrient + " has on your mood";
                recs.add(rec);
            } else {
                HashMap<String, Integer> moodCount = new HashMap<>();
                for (Mood mood : moods) {
                    if (moodCount.containsKey(mood.getName())) {
                        int count = moodCount.get(mood.getName()) + 1;
                        moodCount.put(mood.getName(), count);
                    } else {
                        moodCount.put(mood.getName(), 1);
                    }
                }
                for (Map.Entry<String, Integer> moodCounted : moodCount.entrySet()) {
                    if (moodCounted.getValue() > (moods.size() / 5)) {
                        String rec = "I think that eating more than 20g of "
                                + nutrient + " in one sitting may make you feel "
                                + moodCounted.getKey();
                        recs.add(rec);
                    }
                }
            }
        }

        return recs;
    }

    private List<Entry> getSubList(LocalDateTime startTime, LocalDateTime endTime) {
        return entryList.values()
                .stream()
                .filter(p -> p.getDate().isAfter(startTime))
                .filter(p -> p.getDate().isBefore(endTime))
                .collect(Collectors.toList());
    }
}
