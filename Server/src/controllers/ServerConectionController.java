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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import dice.TCPServer;
import java.sql.Connection;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    private void hundleConection(ActionEvent event) throws IOException{
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
        else startConection(Integer.valueOf(port));

    }
    
    private void startConection(int port){
        // Close Screen
        Stage stage = (Stage) btnConection.getScene().getWindow();
        stage.close();
        TCPServer tcpServer = new TCPServer();
        tcpServer.setServerPort(port);
        tcpServer.StartConnection();
    }
    
   private boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
