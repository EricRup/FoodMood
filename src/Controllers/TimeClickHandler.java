/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static FoodMood.FoodMood.entryList;
import Models.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

/**
 *
 * @author Walrus
 */
public class TimeClickHandler implements EventHandler<MouseEvent> {

    ListView listView;

    public TimeClickHandler(ListView listView) {
        this.listView = listView;
    }

    @Override
    public void handle(MouseEvent e) {
        if (((int) listView.getUserData()) != 0) {
            final Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.initOwner(FoodMood.FoodMood.primaryStage);
            VBox EntryViews = new VBox();
            Button edit = new Button("Edit");
            Button delete = new Button("Delete");

            //Edit Logic
            edit.setOnAction((event) -> {
                Entry selectedEntry = (Entry) listView.getSelectionModel().getSelectedItems().get(0);
                VBox editBox = new VBox();
                editBox.setPadding(new Insets(50, 50, 50, 50));
                editBox.setSpacing(10);
                editBox.setAlignment(Pos.BASELINE_CENTER);
                if (selectedEntry.getClass() == Meal.class) {
                    Meal selectedMeal = (Meal) selectedEntry;
                    editBox.getChildren().add(new Label("Meal Name"));
                    TextField name = new TextField(selectedMeal.getName());
                    editBox.getChildren().add(name);
                    editBox.getChildren().add(new Label("Food Name"));
                    ComboBox foods = new ComboBox();
                    ArrayList<Food> foodList = new ArrayList(5);
                    foodList.add(new Food("Milk"));
                    foodList.add(new Food("Eggs"));
                    foodList.add(new Food("Cheese"));
                    foodList.add(new Food("Fries"));
                    foods.setItems(FXCollections.observableList(foodList));
                    foods.valueProperty().set(selectedMeal.getFoods().get(0));
                    editBox.getChildren().add(foods);
                    Button saveButton = new Button("Save");
                    saveButton.setOnAction((ActionEvent event2) -> {
                        selectedMeal.setName(name.getText());
                        selectedMeal.removeFood(selectedMeal.getFoods().get(0));
                        selectedMeal.addFood((Food) foods.valueProperty().getValue());
                        entryList.remove(selectedMeal.getDate());
                        entryList.add(selectedMeal);
                        FoodMood.FoodMood.mControl.dControl.filterDailyList(selectedMeal.getDate().toLocalDate().atStartOfDay());
                        popup.close();
                    });

                    editBox.getChildren().add(saveButton);
                } else if (selectedEntry.getClass() == Mood.class) {
                    Mood selectedMood = (Mood) selectedEntry;
                    editBox.getChildren().add(new Label("Mood Type"));
                    ComboBox moods = new ComboBox();
                    ArrayList<String> moodList = new ArrayList(5);
                    moodList.add("Happy");
                    moodList.add("Nervous");
                    moodList.add("Sad");
                    moodList.add("Angry");
                    moodList.add("Relaxed");
                    moods.setItems(FXCollections.observableList(moodList));
                    moods.valueProperty().set(selectedMood.getName());
                    editBox.getChildren().add(moods);
                    editBox.getChildren().add(new Label("Mood Strength"));
                    ComboBox strengths = new ComboBox();
                    ArrayList<String> strengthLevels = new ArrayList(5);
                    strengthLevels.add("1");
                    strengthLevels.add("2");
                    strengthLevels.add("3");
                    strengthLevels.add("4");
                    strengthLevels.add("5");
                    strengths.setItems(FXCollections.observableList(strengthLevels));
                    strengths.valueProperty().set(selectedMood.getStrength() + "");
                    editBox.getChildren().add(strengths);
                    Button saveButton = new Button("Save");
                    saveButton.setOnAction((ActionEvent event2) -> {
                        String moodString = (String) moods.getSelectionModel().getSelectedItem();
                        int strength = Integer.parseInt((String) strengths.getSelectionModel().getSelectedItem());
                        if (moodString != null && strength != 0) {
                            selectedMood.setName(moodString);
                            selectedMood.setStrength(strength);
                            entryList.remove(selectedMood.getDate());
                            entryList.add(selectedMood);
                            FoodMood.FoodMood.mControl.dControl.filterDailyList(selectedMood.getDate().toLocalDate().atStartOfDay());
                            popup.close();

                        }
                    });
                    editBox.getChildren().add(saveButton);
                }
                Scene editPopup = new Scene(editBox);
                popup.setScene(editPopup);

            });

            delete.setOnAction((event1) -> {
                LocalDateTime date = ((Entry) listView.getSelectionModel().getSelectedItems().get(0)).getDate();
                FoodMood.FoodMood.mControl.dControl.removeEntry(date);
                FoodMood.FoodMood.mControl.dControl.filterDailyList(date.toLocalDate().atStartOfDay());
                popup.close();
            });

            EntryViews.getChildren().add(edit);
            EntryViews.getChildren().add(delete);
            EntryViews.setAlignment(Pos.CENTER);
            Scene entryPopup = new Scene(EntryViews);
            popup.setScene(entryPopup);
            popup.setOnHiding((WindowEvent event) -> {
                //TODO refresh DiaryFXML on close, using date from this ListView or its Parent
            });
            popup.show();
        }
    }
}
