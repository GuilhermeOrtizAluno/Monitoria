/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerold;

import static app.Program.socket;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import screensold3.RegisterMonitoringScreen;

/**
 *
 * @author guilherme.santos
 */
public class RegisterMonitoringController extends RegisterMonitoringScreen{
/*
    public RegisterMonitoringController() {
        initComponents();
        continuationInitComponents();
        cleanFields();
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
            }
        }); 
   }
    
    @SuppressWarnings("unchecked")
    private void hundleRegistrar() throws IOException{
        try {
            // Read from interface
            String monitor = cbMonitor.getSelectedItem() == null ? "" : cbMonitor.getSelectedItem().toString();
            String name = tfName.getText();
            String pass = tfPass.getText();
            
            if("".equals(name) || "".equals(pass) || "".equals(monitor)){
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
            clientController.showSend(route.toString());
            // Send
            PrintWriter pr = new PrintWriter(socket.getOutputStream());  
            pr.println(route);
            pr.flush();
            
        }catch(Error e){
            
        }
    }
    */
}
