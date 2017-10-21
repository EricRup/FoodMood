/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.EntryList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author David
 */
public class LoginFXMLController extends Controller implements Initializable {
   
    private String curView;
            
     public LoginFXMLController(){
        curView = "Login";        
    }

            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (entryList == null){
            entryList = new EntryList();

        }  
    }
        /*
     * FXML Scene Login
     */
    @FXML private Text actiontarget;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Signing In");
    }
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
    
        Scene scene = new Scene(root, 300, 275);
    
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Change the view to the designated stage
     * @param stage the stage to change the view to. Proper noun format i.e. Diary or Analysis
     * @return the controller for the requested stage (as a generic Controller)
     */
    public Controller view(String targetStage, Stage stage){
        
        if (!curView.equals(targetStage)){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/"+targetStage+"FXML.fxml"));
                Parent root = loader.load();
                stage.setTitle("FoodMood - "+targetStage);
                stage.setScene(new Scene(root));
                curView = targetStage;
                return loader.getController();
            }   
            catch(IOException e){
                System.err.println("Error: Class name ["+targetStage+"] doesn't exist in MenuLoader");
            }
        }
        return null;
    }
    
}
