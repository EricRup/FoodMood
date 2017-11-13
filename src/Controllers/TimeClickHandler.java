/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Walrus
 */
public class TimeClickHandler implements EventHandler<MouseEvent>{
    ListView listView;   
    public TimeClickHandler(ListView listView){
           this.listView = listView;
       }
    public void handle(MouseEvent e){
        System.out.println(listView.getId());
    }
}
