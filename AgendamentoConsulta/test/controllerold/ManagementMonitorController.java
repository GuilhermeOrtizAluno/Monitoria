/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerold;

import static app.Program.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import screensold3.ManagementMonitorScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class ManagementMonitorController extends ManagementMonitorScreen{
/*
    public ManagementMonitorController() {
        initComponents();
        continuationInitComponents();
        cleanFields();
    }
    
     public void cleanFields(){
        tfUser.setText("");
        tfPass.setText("");
        tfName.setText("");
        revalidate();
    } 
     
    private void continuationInitComponents(){
        bUpdate.addActionListener((ActionEvent evt) -> {
            try {
                hundleUpdate();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        bDelete.addActionListener((ActionEvent evt) -> {
            try {
                hundleDelete();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
   }

    @SuppressWarnings("unchecked")
    private void hundleDelete() throws IOException {
        // Read from interface
        
        String monitor = cbMonitor.getSelectedItem() == null ? "" : cbMonitor.getSelectedItem().toString();
        
        if("".equals(monitor)){
            JOptionPane.showMessageDialog(
                null, 
                "Select a monitor", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JSONObject route = new JSONObject();
        route.put("rota", "usuario.delete");
        route.put("usuario", monitor);

        // Shows what will be sent
        clientController.showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
  
    }
   
    @SuppressWarnings("unchecked")
    private void hundleUpdate() throws IOException {
        // Read from interface
        String monitor = cbMonitor.getSelectedItem() == null ? "" : cbMonitor.getSelectedItem().toString();
        String user = tfUser.getText();
        String pass = tfPass.getText();
        String name = tfName.getText();
        
        if("".equals(name) || "".equals(user) || "".equals(pass)|| "".equals(monitor)){
            JOptionPane.showMessageDialog(
                null, 
                "Invalid fields, please try again", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JSONObject route = new JSONObject();
        route.put("rota", "login.update");
        route.put("usuario", monitor);
        route.put("novo_usuario", user);
        route.put("senha", pass);
        route.put("nome", name);

        // Shows what will be sent
        clientController.showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
        
    }

     */
}
