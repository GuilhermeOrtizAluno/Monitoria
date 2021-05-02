package controllers;

import static app.Program.*;
import bd.ConnectionFactory;
import dice.TCPServer;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.io.IOException;
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
            serverController.pContent.remove(connectionController);
            serverController.pContent.add(usersController);
            serverController.revalidate();
           
            TCPServer tcps = new TCPServer(Integer.valueOf(port));
            tcps.StartConnection();
       }
   }
}
