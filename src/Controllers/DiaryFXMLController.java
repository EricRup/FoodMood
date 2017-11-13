package Controllers;

import static Controllers.Controller.entryList;
import Models.Entry;
import Models.Food;
import Models.Meal;
import Models.Mood;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Eric
 */
public class DiaryFXMLController extends Controller {

    private LocalDate currentDay;
    private ObservableList obsEntryList;
    @FXML
    DatePicker datePicker;
    @FXML
    VBox diaryListBox;
    @FXML
    ListView diaryListView;
    @FXML
    VBox timeBox;
    @FXML
    ListView zero, two, four, six, eight, ten, twelve, fourteen, sixteen, eighteen, twenty, twentyTwo;

    /**
     * Create a calendar view Instantiates to current month
     */
    public DiaryFXMLController() {
        super();
    }

    @FXML
    protected void addOnClick(ActionEvent event) {
        System.out.println("Working");
        List<Node> temp = diaryListBox.getChildren().filtered(p -> p.isFocused());

        if (temp.size() > 0) {
            final Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.initOwner(FoodMood.FoodMood.primaryStage);
            VBox addBox = new VBox(20);
            Button foodButton = new Button("Food");
            Button moodButton = new Button("Mood");
            //FoodButton
            foodButton.setOnAction((ActionEvent event1) -> {
                VBox foodBox = new VBox(20);
                foodBox.setPadding(new Insets(50, 50, 50, 50));
                foodBox.setSpacing(10);
                foodBox.setAlignment(Pos.BASELINE_CENTER);
                foodBox.getChildren().add(new Label("Meal Name"));
                foodBox.getChildren().add(new TextField());
                foodBox.getChildren().add(new Label("Food Name"));
                ComboBox foods = new ComboBox();
                ArrayList<Food> foodList = new ArrayList(5);
                foodList.add(new Food("Milk"));
                foodList.add(new Food("Eggs"));
                foodList.add(new Food("Cheese"));
                foodList.add(new Food("Fries"));
                foods.setItems(FXCollections.observableList(foodList));
                foodBox.getChildren().add(foods);
                Button addButton = new Button("Add");
                addButton.setOnAction((ActionEvent event2) -> {
                    LocalDateTime tempDate = currentDay.atStartOfDay().plusHours(Integer.parseInt(temp.get(0).getId()) * 2);
                    Meal meal = new Meal(tempDate, ((TextField) foodBox.getChildren().get(1)).getText());
                    meal.addFood((Food) foods.valueProperty().getValue());
                    this.addEntry(meal);
                    filterDailyList(currentDay.atStartOfDay());
                    popup.close();
                });

                foodBox.getChildren().add(addButton);
                Scene foodPopup = new Scene(foodBox, 300, 300);
                popup.setScene(foodPopup);
            });

            //MoodButton
            moodButton.setOnAction((ActionEvent event1) -> {
                VBox moodBox = new VBox(20);
                moodBox.setPadding(new Insets(50, 50, 50, 50));
                moodBox.setSpacing(10);
                moodBox.setAlignment(Pos.BASELINE_CENTER);
                moodBox.getChildren().add(new Label("Mood Type"));
                ComboBox moods = new ComboBox();
                ArrayList<Mood> moodList = new ArrayList(5);
                
                moods.setItems(FXCollections.observableList(moodList));
                moodBox.getChildren().add(moods);
                Button addButton = new Button("Add");
                moodBox.getChildren().add(addButton);
                Scene foodPopup = new Scene(moodBox, 300, 300);
                popup.setScene(foodPopup);
                
                });

            //Initial Popup aftering clicking on add button
            addBox.setPadding(new Insets(50, 50, 50, 50));
            addBox.setSpacing(10);
            addBox.setAlignment(Pos.BASELINE_CENTER);
            addBox.getChildren().addAll(foodButton, moodButton);
            Scene popupScene = new Scene(addBox, 200, 200);
            popup.setScene(popupScene);
            popup.show();
        }
    }

    @FXML
    protected void editOnClick(ActionEvent event) {

    }

    @FXML
    protected void deleteOnClick(ActionEvent event) {
        //int selectedItem = diaryListView.getSelectionModel().getSelectedIndex();
        //obsEntryList.remove(selectedItem);

    }

    /**
     * Add entry to static entry list
     *
     * @param entry the entry to add
     * @return the Date identifier. Null if failed to add
     */
    public LocalDateTime addEntry(Entry entry) {
        return entryList.add(entry);
    }

    /**
     * Remove an entry from the entry list
     *
     * @param entry the entry to remove
     * @return if the removal was successful
     */
    public boolean removeEntry(Entry entry) {
        return entryList.remove(entry.getDate(), entry);
    }

    public boolean removeEntry(LocalDateTime date) {
        return entryList.remove(date) != null;
    }

    public Entry getEntry(LocalDateTime date) {
        return entryList.get(date);
    }

    public void filterDailyList(LocalDateTime date) {
        diaryListBox.getChildren().forEach((list) -> {
            ListView cur = (ListView) list;
            int offset = Integer.parseInt(cur.getId());
            ObservableList obsEntries = FXCollections.observableList(getSubList(date.plusHours(offset * 2).minusNanos(1), date.plusHours((offset + 1) * 2)));
            cur.setItems(obsEntries);

        });
    }

    private void testData() {

        LocalDateTime cal = LocalDate.now().atStartOfDay();
        addEntry(new Mood(cal, "Sad"));
        addEntry(new Mood(cal.plusHours(4), "Happy"));
        addEntry(new Mood(cal.plusHours(8), "Tasty"));

    }

    @FXML
    protected void updateDate(ActionEvent event) {
        currentDay = datePicker.getValue();
        filterDailyList(currentDay.atStartOfDay());
    }

    //Implement dayCellFactory to read number of entries on each date and 
    private void dayCellSetup() {
        final Callback<DatePicker, DateCell> dayCellFactory = (final DatePicker datePicker1) -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                List<Entry> subList = getSubList(item.atStartOfDay().minusNanos(1), item.plusDays(1).atStartOfDay());
                if (subList.size() > 0) {
                    this.setTooltip(new Tooltip(subList.size() + " entries"));
                    setStyle("-fx-background-color: #00ffff;");
                }
            }

        };
        datePicker.setDayCellFactory(dayCellFactory);
    }

    /**
     * Initializes JavaFX controller
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testData();
        dayCellSetup();
        datePicker.setValue(LocalDate.now());
        currentDay = datePicker.getValue();
        filterDailyList(LocalDate.now().atStartOfDay());
        diaryListBox.getChildren().forEach((list) -> {
            list.setOnMouseClicked(new TimeClickHandler((ListView) list));
        });
    }

    private List<Entry> getSubList(LocalDateTime startDate, LocalDateTime endDate) {
        return entryList.values()
                .stream()
                .filter(p -> p.getDate().isAfter(startDate))
                .filter(p -> p.getDate().isBefore(endDate))
                .collect(Collectors.toList());
    }
}
