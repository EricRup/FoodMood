package Controllers;

import static Controllers.Controller.entryList;
import Models.Entry;
import Models.Mood;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.text.TextFlow;
import javafx.util.Callback;

/**
 *
 * @author Eric
 */

public class DiaryFXMLController extends Controller{

    private Calendar currentDay, nextDay;
    private ObservableList obsEntryList;
    @FXML DatePicker datePicker;
    @FXML ListView diaryListView;
    /**
     * Create a calendar view
     * Instantiates to current month
     */
    public DiaryFXMLController() {
        
    }
    
    @FXML protected void addOnClick(ActionEvent event){
        
    }
    @FXML protected void editOnClick(ActionEvent event){
        
    }
    @FXML protected void deleteOnClick(ActionEvent event){
        
    }
    /**
     * Add entry to static entry list
     * @param entry the entry to add
     * @return the Date identifier. Null if failed to add
     */
    public Calendar addEntry(Entry entry){
        return entryList.add(entry);
    }
    
    /**
     * Remove an entry from the entry list
     * @param entry the entry to remove
     * @return if the removal was successful
     */
    public boolean removeEntry(Entry entry){
        return entryList.remove(entry.getDate(), entry);
    }
    
    public boolean removeEntry(Calendar date){
        return entryList.remove(date) != null;
    }
    
    public Entry getEntry(Calendar date){
        return entryList.get(date);
    }
    
    public ArrayList<TextFlow> getEntriesText(Calendar day){
        ArrayList<TextFlow> entriesText = new ArrayList<>();
        
        
        return entriesText;
    }
    
    public void setDay(Calendar date){
        currentDay = date;
        currentDay = setZeroes(currentDay);
        nextDay = (Calendar) currentDay.clone();
        nextDay.add(Calendar.DATE, 1);
        nextDay = setZeroes(nextDay);
        List<Entry> subList = entryList.values()
                .stream()
                .filter(p -> p.getDate().after(currentDay))
                .filter(p -> p.getDate().before(nextDay))
                .collect(Collectors.toList());
        obsEntryList = FXCollections.observableList(subList);
        diaryListView.setItems(obsEntryList);
    }
    private void testData(){
        
        addEntry(new Mood(Calendar.getInstance(), "Sad"));
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, -3);
        addEntry(new Mood(cal2, "Happy"));
        Calendar cal3 = (Calendar) cal2.clone();
        cal3.add(Calendar.HOUR, 1);
        addEntry(new Mood(cal3, "Sad"));
        
    }
    private Calendar setZeroes(Calendar day){
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        return day;
    }
    @FXML
    protected void updateDate(ActionEvent event){
        Calendar date = GregorianCalendar.from(datePicker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()));
        setDay(date);
    }
    
    //Implement dayCellFactory to read number of entries on each date and 
    private void dayCellSetup(){
        final Callback<DatePicker, DateCell> dayCellFactory = (final DatePicker datePicker1) -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                Calendar cal = GregorianCalendar.from(item.atStartOfDay().atZone(ZoneId.systemDefault()));
                Calendar cal2 = (Calendar) cal.clone();
                cal2.add(Calendar.DATE,1);
                List<Entry> subList = entryList.values()
                        .stream()
                        .filter(p -> p.getDate().after(cal))
                        .filter(p -> p.getDate().before(cal2))
                        .collect(Collectors.toList());
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
     * @param url 
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testData();
        dayCellSetup();
        setDay(Calendar.getInstance());
    }
}