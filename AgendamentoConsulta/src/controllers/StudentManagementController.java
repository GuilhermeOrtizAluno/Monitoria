package controllers;

import static dice.ManagerClient.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import screens.StudentManagementScreen;

/**
 *
 * @author Guilherme Ortiz Santos
 */
public class StudentManagementController extends StudentManagementScreen{

    public StudentManagementController() {
        initComponents();
        continuationInitComponents();
    }
    
    public void cleanFields(){
        utfUser.setText("");
        utfPass.setText("");
        utfName.setText("");
        tfPass.setText("");
        revalidate();
    } 

    private void continuationInitComponents(){
        bUpdate.addActionListener((ActionEvent evt) -> {
            try {
                hundleUpdate();
            } catch (IOException | JSONException ex) {
                Logger.getLogger(StudentManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bRegister.addActionListener((ActionEvent evt) -> {
            try {
                hundleRegister();
            } catch (IOException | JSONException ex) {
                Logger.getLogger(StudentManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        bDelete.addActionListener((ActionEvent evt) -> {
            try {
                hundleDelete();
            } catch (IOException | JSONException ex) {
                Logger.getLogger(StudentManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
   }
    
   
    @SuppressWarnings("unchecked")
    private void hundleUpdate() throws IOException, JSONException {
        // Read from interface
        String user = utfUser.getText();
        String pass = utfPass.getText();
        String name = utfName.getText();
        
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
        route.put("rota", "login.update");
        route.put("usuario", usernameON);
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
    
    @SuppressWarnings("unchecked")
    private void hundleRegister() throws IOException, JSONException {
        // Read from interface
        
        String monitoria = cbMonitoring.getSelectedItem() == null ? "" : cbMonitoring.getSelectedItem().toString();
        String pass = tfPass.getText();
        
        if("".equals(pass) || "".equals(monitoria)){
            JOptionPane.showMessageDialog(
                null, 
                "Invalid fields, please try again", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        String monitoring = "1";
            
        for(var i = 0; i < monitoringsAll.length(); i++){
            JSONObject joMonitoring = monitoringsAll.getJSONObject(i);
            if(joMonitoring.getString("nome").equals(monitoria))
                monitoring = joMonitoring.getString("id");
        }

        JSONObject route = new JSONObject();
        route.put("rota", "aluno-monitoria.inscrever");
        route.put("senha", pass);
        route.put("usuario_aluno", usernameON);
        route.put("id", monitoring);

        // Shows what will be sent
        logController.showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
    }
    
    @SuppressWarnings("unchecked")
    private void hundleDelete() throws IOException, JSONException {
        // Read from interface
        
        String monitoria = dcbMonitoring.getSelectedItem() == null ? "" : dcbMonitoring.getSelectedItem().toString();
        
        if("".equals(monitoria)){
            JOptionPane.showMessageDialog(
                null, 
                "Invalid fields, please try again", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        String monitoring = "1";
            
        for(var i = 0; i < monitoringsAll.length(); i++){
            JSONObject joMonitoring = monitoringsAll.getJSONObject(i);
            if(joMonitoring.getString("nome").equals(monitoria))
                monitoring = joMonitoring.getString("id");
        }

        JSONObject route = new JSONObject();
        route.put("rota", "aluno-monitoria.delete");
        route.put("usuario_aluno", usernameON);
        route.put("id", monitoring);

        // Shows what will be sent
        logController.showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
    }
    
    
}
