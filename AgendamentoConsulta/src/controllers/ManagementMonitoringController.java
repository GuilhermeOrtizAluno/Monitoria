package controllers;

import static dice.ManagerClient.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import screens.ManagementMonitoringScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class ManagementMonitoringController extends ManagementMonitoringScreen{

    public ManagementMonitoringController() {
        initComponents();
        continuationInitComponents();
        initVariables();
    }
    
    public void cleanFields(){
        tfName.setText("");
        tfPass.setText("");
        revalidate();
    } 

    private void continuationInitComponents(){
        bRegister.addActionListener((ActionEvent evt) -> {
            try {
                hundleRegistrar();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ManagementMonitoringController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        bUpdate.addActionListener((ActionEvent evt) -> {
            try {
                hundleUpdate();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ManagementMonitoringController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        bDelete.addActionListener((ActionEvent evt) -> {
            try {
                hundleDelete();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ManagementMonitoringController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
   }
    
    @SuppressWarnings("unchecked")
    private void initVariables(){
        String sHors[] = {"1M1","1M2","1M3","1M4","1M5","1T1","1T2","1T3","1T4","1T5","1N1","1N2","1N3","1N4","1N5"};
        var mHors = new DefaultListModel();
        for(var hors : sHors)
            mHors.addElement(hors);
        pHors.setModel(mHors);
        rpHors.setModel(mHors);
    }
    
    @SuppressWarnings("unchecked")
    private void hundleRegistrar() throws IOException, JSONException{
        try {
            // Read from interface
            String monitor = cbMonitor.getSelectedItem() == null ? "" : cbMonitor.getSelectedItem().toString();
            var lHorarios = pHors.getSelectedValuesList() == null ? "" : pHors.getSelectedValuesList();
            String name = tfName.getText();
            String pass = tfPass.getText();
            
            if("".equals(name) || "".equals(pass) || "".equals(monitor)|| "".equals(lHorarios)){
                JOptionPane.showMessageDialog(
                    null, 
                    "Invalid fields, please try again", 
                    "Invalid field", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            JSONObject route = new JSONObject();
            route.put("rota", "monitoria.registro");
            route.put("nome", name);
            route.put("senha", pass);
            route.put("usuario_monitor", monitor);
            route.put("horarios", new JSONArray(lHorarios));

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
    private void hundleUpdate() throws IOException, JSONException{
        try {
            // Read from interface
            String monitor = rcbMonitor.getSelectedItem() == null ? "" : cbMonitor.getSelectedItem().toString();
            String monitoria = cbMonitoring.getSelectedItem() == null ? "" : cbMonitoring.getSelectedItem().toString();
            var lHorarios = rpHors.getSelectedValuesList() == null ? "" : pHors.getSelectedValuesList();
            String name = rtfName.getText();
            String pass = rtfPass.getText();
            
            if("".equals(name) || 
               "".equals(pass) || 
               "".equals(monitor) || 
               "".equals(monitoria) || 
               "".equals(lHorarios)
            ){
                JOptionPane.showMessageDialog(
                    null, 
                    "Invalid fields, please try again", 
                    "Invalid field", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            JSONObject route = new JSONObject();
            route.put("rota", "monitoria.update");
            route.put("nome", name);
            route.put("senha", pass);
            route.put("usuario_monitor", monitor);
            route.put("id", monitoria);
            route.put("horarios", new JSONArray(lHorarios));

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
    private void hundleDelete() throws IOException, JSONException{
        try {
            // Read from interface
            String monitoring = pMonitorings.getSelectedValue() == null ? "" : pMonitorings.getSelectedValue().toString();
        
            if("".equals(monitoring)){
                JOptionPane.showMessageDialog(
                    null, 
                    "Select a monitoring", 
                    "Invalid field", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            var respost = JOptionPane.showConfirmDialog(
                null, 
                "Do you really want to delete this monitoring?", 
                "Delete Monitorings", 
                JOptionPane.YES_NO_OPTION
            );

            if(respost == 1) return;

            JSONObject route = new JSONObject();
            route.put("rota", "monitoria.delete");
            route.put("usuario", monitoring);

            // Shows what will be sent
            logController.showSend(route.toString());
            // Send
            PrintWriter pr = new PrintWriter(socket.getOutputStream());  
            pr.println(route);
            pr.flush();
            
        }catch(Error e){
            
        }
    }
    
}
