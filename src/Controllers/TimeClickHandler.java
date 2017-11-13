/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static Controllers.Controller.entryList;
import javafx.scene.control.Button;
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

    public void handle(MouseEvent e) {
        final Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(FoodMood.FoodMood.primaryStage);
        VBox EntryViews = new VBox();
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        EntryViews.getChildren().add(edit);
        EntryViews.getChildren().add(delete);
        EntryViews.getChildren().add(listView);
        Scene entryPopup = new Scene(EntryViews, 300, 300);
        popup.setScene(entryPopup);
        popup.setOnHiding(new EventHandler<WindowEvent>() {

         @Override
         public void handle(WindowEvent event) {
        //TODO refresh DiaryFXML on close, using date from this ListView or its Parent
         }
        });
        popup.show();
    }
}
