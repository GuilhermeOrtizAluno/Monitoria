package controllers;

import static app.Program.*;
import dice.ManagerClient;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import screens.ConnectionScreen;

/**
 *
 * @author gui_o
 */
public class ConnectionController extends ConnectionScreen{

   public ConnectionController() {
        initComponents();
        continuationInitComponents();
    } 
    
   private boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
     
   private void continuationInitComponents(){
        bConection.addActionListener((ActionEvent evt) -> {
            try {
                hunldeConnection();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
   }
   
   private void hunldeConnection() throws IOException{
       // Read from interface
        String port = tfPort.getText();
        
        if("".equals(port) || !isInteger(port))
            JOptionPane.showMessageDialog(
                null, 
                "Invalid fields, please try again", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
       else {
            try {
                socket = new Socket("localhost", Integer.valueOf(port));

                clientController.includeLog("Conectado com Servidor pelo ip localhost e pela porta "+port, Color.BLACK, new Color(204, 0, 204));
                clientController.pContentClear("connection");
                managerClient.startReceived();
            
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                    null, 
                    "Error when trying to connect, try again", 
                    "Connection error ", 
                    JOptionPane.ERROR_MESSAGE
                );
            } 
        }
   }
}
