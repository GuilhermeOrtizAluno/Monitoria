/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bd.ConnectionFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.Connection;
import javax.swing.JOptionPane;
import static app.Program.*;

/**
 * FXML Controller class
 *
 * @author gui_o
 */
public class ServerConectionController implements Initializable {
    
    @FXML
    private TextField tfPort;
    
    @FXML
    private Button btnConection;
    
    @FXML
    private void hundleConection() throws IOException{
        // Read from interface
        String port = tfPort.getText();
        
        Connection con = ConnectionFactory.getConnection();
        
        if(con == null) 
            JOptionPane.showMessageDialog(
                null, 
                "Error when trying to connect to the database", 
                "Error SQL", 
                JOptionPane.ERROR_MESSAGE
            );
       else if("".equals(port) || !isInteger(port))
            JOptionPane.showMessageDialog(
                null, 
                "Invalid fields, please try again", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
       else {
           door = Integer.valueOf(port);
           connectionServe.close();
       }
    }
    
   private boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //while(true){}
    }    
    
}
