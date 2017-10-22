package Controllers;

import Models.Entry;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import Views.AnchorPaneNode;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;

/**
 *
 * @author Eric
 */

public class DiaryFXMLController extends Controller{

    private Text calendarTitle;
    private Calendar firstDay, lastDay;
    private ObservableList obsEntryList;
    @FXML DatePicker datePicker;
    @FXML ListView diaryListView;
    /**
     * Create a calendar view
     * Instantiates to current month
     */
    public DiaryFXMLController() {
        firstDay = Calendar.getInstance();
        firstDay.set(Calendar.DAY_OF_MONTH, 1);
        lastDay = Calendar.getInstance();
        List<Entry> subList = new ArrayList<>(entryList.subMap(firstDay, lastDay).values());
        obsEntryList = FXCollections.observableList(subList);
        obsEntryList.addListener((ListChangeListener.Change change) -> {
            System.out.println("Changed");
        });
        
        diaryListView.setItems(obsEntryList);
    }
    
    public DiaryFXMLController(Calendar day){
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
    
    /**
     * Initializes JavaFX controller
     * @param url 
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }
}
