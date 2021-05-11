package controllers;

import java.io.PrintWriter;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import screens.ManagementMonitorScreen;
import static dice.ManagerClient.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author Guilherme Ortiz Santos
 */
public class ManagementMonitorController extends ManagementMonitorScreen{

    public ManagementMonitorController() {
        initComponents();
        continuationInitComponents();
    }
    
    public void cleanFields(boolean register){
        if(register){
            rtfName.setText("");
            rtfUser.setText("");
            rtfPass.setText("");
        }else{
            utfName.setText("");
            utfUser.setText("");
            utfPass.setText("");
        }
    }
    
    private void continuationInitComponents(){
        bUpdate.addActionListener((ActionEvent evt) -> {
            try {
                hundleUpdate();
            } catch (IOException | JSONException ex) {
                Logger.getLogger(ManagementMonitorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }); 
        bDelete.addActionListener((ActionEvent evt) -> {
            try {
                hundleDelete();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(ManagementMonitorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        bRegister.addActionListener((ActionEvent evt) -> {
            try {
                hundleRegistrar();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ManagementMonitorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
    }

    @SuppressWarnings("unchecked")
    private void hundleRegistrar() throws IOException, JSONException{
        try {
            // Read from interface
            String name = rtfName.getText();
            String user = rtfUser.getText();
            String pass = rtfPass.getText();
            
            if("".equals(name) || "".equals(user) || "".equals(pass)){
                JOptionPane.showMessageDialog(
                    null, 
                    "Invalid fields, please try again", 
                    "Invalid field", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            

            JSONObject route = new JSONObject();
            route.put("rota", "login.registro");
            route.put("nome", name);
            route.put("usuario", user);
            route.put("senha", pass);
            route.put("is_admin", false);
            route.put("is_monitor", true);

            // Shows what will be sent
            logController.showSend(route.toString());
            // Send
            PrintWriter pr = new PrintWriter(socket.getOutputStream());  
            pr.println(route);
            pr.flush();
            
        }catch(Error e){
            
        }
    }

    @SuppressWarnings("unchecked")
    private void hundleDelete() throws IOException, JSONException {
        // Read from interface
        
        String monitor = pMonitors.getSelectedValue() == null ? "" : pMonitors.getSelectedValue().toString();
        
        if("".equals(monitor)){
            JOptionPane.showMessageDialog(
                null, 
                "Select a monitor", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        var respost = JOptionPane.showConfirmDialog(
            null, 
            "Do you really want to delete this user?", 
            "Delete User", 
            JOptionPane.YES_NO_OPTION
        );
        
        if(respost == 1) return;

        JSONObject route = new JSONObject();
        route.put("rota", "usuario.delete");
        route.put("usuario", monitor);

        // Shows what will be sent
        logController.showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
  
    }
   
    @SuppressWarnings("unchecked")
    private void hundleUpdate() throws IOException, JSONException {
        // Read from interface
        String monitor = cbMonitor.getSelectedItem() == null ? "" : cbMonitor.getSelectedItem().toString();
        String user = utfUser.getText();
        String pass = utfPass.getText();
        String name = utfName.getText();
        
        if("".equals(name) || "".equals(user) || "".equals(pass)|| "".equals(monitor)){
            JOptionPane.showMessageDialog(
                null, 
                "Invalid fields, please try again", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        var respost = JOptionPane.showConfirmDialog(
            null, 
            "Do you really want to change this user?", 
            "Update User", 
            JOptionPane.YES_NO_OPTION
        );
        
        if(respost == 1) {
            cleanFields(false);
            return;
        }

        JSONObject route = new JSONObject();
        route.put("rota", "login.update");
        route.put("usuario", monitor);
        route.put("novo_usuario", user);
        route.put("senha", pass);
        route.put("nome", name);

        // Shows what will be sent
        logController.showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
        
    }
}
