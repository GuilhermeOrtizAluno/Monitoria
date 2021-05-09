package controllers;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import screens.ConnectionScreen;
import static app.Program.*;
import static dice.Functions.*;
import static dice.ManagerClient.*;

/**
 *
 * @author gui_o
 */
public class ConnectionController extends ConnectionScreen{
    
    private static final Point point = new Point();

    public ConnectionController() {
        initComponents();
        continuationInitComponents();
    } 
    
    public void start(){
        cleanFields();
        setVisible(true);
    }
   
    public final void cleanFields(){
        tfPort.setText("");
        revalidate();
    } 
     
    private void continuationInitComponents(){
        addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent e) {
            point.x = e.getX();
            point.y = e.getY();
          }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
          public void mouseDragged(MouseEvent e) {
            Point p = getLocation();
            setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
          }
        });
        bConnect.addActionListener((ActionEvent evt) -> {
            try {
                hunldeConnection();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        bClose.addActionListener((ActionEvent evt) -> {
            close();
        }); 
    }
    
    public void close() {
        dispose();
    }
   
    private void hunldeConnection() throws IOException{
        // Read from interface
        String ip = tfIP.getText();
        String port = tfPort.getText();
        
        if("".equals(ip) || !isInteger(port))
            JOptionPane.showMessageDialog(
                null, 
                "Invalid fields, please try again", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
       else {
            try {
                socket = new Socket(ip, Integer.valueOf(port));

                logController.includeLog("Conectado com Servidor pelo ip localhost e pela porta "+port, Color.BLACK, new Color(204, 0, 204));
                managerClient.startClient();
            
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
