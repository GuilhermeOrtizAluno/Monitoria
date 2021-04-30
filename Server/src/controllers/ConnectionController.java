package controllers;

import static app.Program.*;
import bd.ConnectionFactory;
import java.sql.Connection;
import javax.swing.JOptionPane;
import dice.TCPServer;
import java.awt.event.ActionEvent;
import screens.ConnectionScreen;

/**
 *
 * @author gui_o
 */
public class ConnectionController extends ConnectionScreen{

   public ConnectionController() {
        initComponents();
        setVisible(true);
        continuationInitComponents();
    } 
    
   private boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
     
   private void continuationInitComponents(){
        bConection.addActionListener((ActionEvent evt) -> {
            hunldeConnection();
        }); 
   }
   
   private void hunldeConnection(){
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
            setVisible(false);
            serverController.startLog();
            TCPServer tcps = new TCPServer(Integer.valueOf(port));
            tcps.StartConnection();
       }
   }
   
}
