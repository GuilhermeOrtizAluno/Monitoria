/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static app.Program.*;
import static app.Program.socket;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONObject;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import screens.LoginScreen;

/**
 * FXML Controller class
 *
 * @author gui_o
 */
public class LoginController extends LoginScreen{ 
    
    public LoginController(){ 
        initComponents();
        continuationInitComponents();
        cleanFields();
    }
    
    public void cleanFields(){
        tfUser.setText("");
        tfPass.setText("");
        revalidate();
    } 
    
    private void continuationInitComponents(){
        bSingIn.addActionListener((ActionEvent evt) -> {
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
            String user = tfUser.getText();
            String pass = tfPass.getText();
            
            if("".equals(user) || "".equals(pass)){
                JOptionPane.showMessageDialog(
                    null, 
                    "Invalid fields, please try again", 
                    "Invalid field", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            JSONObject route = new JSONObject();
            route.put("rota", "login.login");
            route.put("usuario", user);
            route.put("senha", pass);

            // Shows what will be sent
            clientController.showSend(route.toString());
            
            // Send
            PrintWriter pr = new PrintWriter(socket.getOutputStream());  
            pr.println(route);
            pr.flush();
            
        }catch(Error e){
            
        }
    }
    
    private void hundleRegister() throws IOException{
        try {
            clientController.pContentClear();
            clientController.pContentAdd("registerStudent");
        } catch (Error e){
            
        }
    }  
    
}
