/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static app.Program.socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;
import static app.Program.log;
import static app.Program.managerClient;

/**
 * FXML Controller class
 *
 * @author gui_o
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfUser;

    @FXML
    private TextField tfPass;
    
    @FXML
    private Button btnLogin;
        
    @FXML
    @SuppressWarnings("unchecked")
    private void hundleLogin(ActionEvent event) throws IOException{
        try {
            // Read from interface
            String user = tfUser.getText();
            String pass = tfPass.getText();

            JSONObject route = new JSONObject();
            route.put("rota", "login.login");
            route.put("usuario", user);
            route.put("senha", pass);

            // Shows what will be sent
            log.showSend(route.toString());
            
            // Send
            PrintWriter pr = new PrintWriter(socket.getOutputStream());  
            pr.println(route);
            pr.flush();
            
            // Close Screen
            //Stage stage = (Stage) btnLogin.getScene().getWindow();
            //stage.close();
            
        }catch(Error e){
            
        }
    }
        
    @FXML
    private Hyperlink hpLink;
    
    @FXML
    private void hundleRegister(ActionEvent event) throws IOException{
        try {
            
            managerClient.openStage(FXMLLoader.load(getClass().getResource("../screens/Register.fxml")));
        } catch (Error e){
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
