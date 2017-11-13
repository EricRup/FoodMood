/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.EntryList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author David
 */
public class LoginFXMLController extends Controller implements Initializable {
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;

    public LoginFXMLController() {
        super();
        curView = "Login";
    }

    /**
     * @return the curView
     */
    public String getCurView() {
        return curView;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        view("Menu");
    }
    

}
