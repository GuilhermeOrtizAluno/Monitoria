package controllers;

import static dice.ManagerClient.*;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONObject;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import screens.LoginRegisterScreen;

/**
 * FXML Controller class
 *
 * @author gui_o
 */
public class LoginRegisterController extends LoginRegisterScreen{ 
    
    public LoginRegisterController(){ 
        initComponents();
        continuationInitComponents();
        cleanFields();
    }
    
    public final void cleanFields(){
        tfUser.setText("");
        tfPass.setText("");
        tfUsername.setText("");
        tfPassword.setText("");
        tfName.setText("");
        revalidate();
    } 
    
    private void continuationInitComponents(){
        bLogin.addActionListener((ActionEvent evt) -> {
            try {
                hundleLogin();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        bRegister.addActionListener((ActionEvent evt) -> {
            try {
                hundleRegister();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
   }

    @SuppressWarnings("unchecked")
    private void hundleLogin() throws IOException{
        try {
            // Read from interface
            String user = tfUsername.getText();
            String pass = tfPassword.getText();
            
            if("".equals(user) || "".equals(pass)){
                JOptionPane.showMessageDialog(
                    null, 
                    "Invalid fields, please try again", 
                    "Invalid field", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            usernameON = user;

            JSONObject route = new JSONObject();
            route.put("rota", "login.login");
            route.put("usuario", user);
            route.put("senha", pass);

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
    private void hundleRegister() throws IOException{
        try {
            // Read from interface
            String name = tfName.getText();
            String user = tfUser.getText();
            String pass = tfPass.getText();
            
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
            route.put("is_monitor", false);

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
