/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static app.Program.log;
import static app.Program.socket;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import screens.Log;

/**
 * FXML Controller class
 *
 * @author gui_o
 */
public class ClientConectionController implements Initializable {

    @FXML
    private TextField tfIP;
    
    @FXML
    private TextField tfPort;
    
    @FXML
    private Button btnConection;
     
    @FXML
    private void hundleConection(ActionEvent event) throws IOException{
        
        // Read from interface
        String ip = tfIP.getText();
        String port = tfPort.getText();

        if("".equals(ip) || "".equals(port) || !isInteger(port))
            JOptionPane.showMessageDialog(
                null, 
                "Invalid fields, please try again", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
        else Connection(ip, Integer.valueOf(port));
            
    }
    
    private void Connection(String ip, int port) throws IOException{
        try {
            socket = new Socket(ip, port);
            
            log = new Log();
            log.startLog();
            
            // Close Screen Conection
            Stage stage = (Stage) btnConection.getScene().getWindow();
            stage.close();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                null, 
                "Error when trying to connect, try again", 
                "Connection error ", 
                JOptionPane.ERROR_MESSAGE
            );
        } 
    }
    
    private boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
