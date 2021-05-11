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
   }
    
    @SuppressWarnings("unchecked")
    private void initVariables(){
        String sHors[] = {"1M1","1M2","1M3","1M4","1M5","1T1","1T2","1T3","1T4","1T5","1N1","1N2","1N3","1N4","1N5"};
        var mHors = new DefaultListModel();
        mHors.addElement(sHors);
        //pHors.setModel(mHors);
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
            JSONArray horarios = new JSONArray();
            horarios.put("1M2");
            horarios.put("1M3");
            horarios.put("1M4");
            route.put("horarios", horarios);

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
