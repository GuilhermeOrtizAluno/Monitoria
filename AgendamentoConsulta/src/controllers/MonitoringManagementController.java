package controllers;

import static dice.ManagerClient.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import screens.MonitoringManagementScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class MonitoringManagementController extends MonitoringManagementScreen{

    public MonitoringManagementController() {
        initComponents();
        initVariables();
        continuationInitComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initVariables(){
        String sHors[] = {"1M1","1M2","1M3","1M4","1M5","1T1","1T2","1T3","1T4","1T5","1N1","1N2","1N3","1N4","1N5"};
        var mHors = new DefaultListModel();
        for(var hors : sHors)
            mHors.addElement(hors);
        rpHors.setModel(mHors);
    }
    
    private void continuationInitComponents(){
        bUpdate.addActionListener((ActionEvent evt) -> {
            try {
                hundleUpdate();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ManagementMonitoringController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
   }
    
    public void cleanFields(){
        tfName.setText("");
        tfPass.setText("");
        revalidate();
    } 
    
    @SuppressWarnings("unchecked")
    private void hundleUpdate() throws IOException, JSONException{
        try {
            // Read from interface[
            String monitoria = cbMonitoring.getSelectedItem() == null ? "" : cbMonitoring.getSelectedItem().toString();
            List lHorarios = rpHors.getSelectedValuesList() == null ? null : rpHors.getSelectedValuesList();
            String name = tfName.getText();
            String pass = tfPass.getText();
            
            if("".equals(name) || 
               "".equals(pass) || 
               "".equals(monitoria)
            ){
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
                "Do you really want to update this monitoring?", 
                "Update Monitorings", 
                JOptionPane.YES_NO_OPTION
            );

            if(respost == 1) return;
            
            String monitoring = "1";
            
            for(var i = 0; i < monitoringsAll.length(); i++){
                JSONObject joMonitoring = monitoringsAll.getJSONObject(i);
                if(joMonitoring.getString("nome").equals(monitoria))
                    monitoring = joMonitoring.getString("id");
            }

            JSONObject route = new JSONObject();
            route.put("rota", "monitoria.update");
            route.put("nome", name);
            route.put("senha", pass);
            route.put("id", monitoring);
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
    
    
    
}
