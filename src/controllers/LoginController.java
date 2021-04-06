/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author gui_o
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfUser;

    @FXML
    private TextField tfPass;
    
    
    @FXML
    private void hundleLogin(ActionEvent event){
        String user = tfUser.getText();
        String pass = tfPass.getText();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
