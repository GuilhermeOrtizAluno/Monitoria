/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import static app.Program.socket;
import static app.Program.log;

/**
 * FXML Controller class
 *
 * @author Maycon
 */
public class RegisterController implements Initializable {
    
    @FXML
    private TextField tfName;
    
    @FXML
    private TextField tfUser;

    @FXML
    private TextField tfPass;
    
    @FXML
    private Button btnRegister;
    
    
        
    @FXML
    @SuppressWarnings("unchecked")
    private void hundleRegistrar(ActionEvent event) throws IOException{
        try {
            // Read from interface
            String name = tfName.getText();
            String user = tfUser.getText();
            String pass = tfPass.getText();

            JSONObject route = new JSONObject();
            route.put("rota", "login.registro");
            route.put("nome", name);
            route.put("usuario", user);
            route.put("senha", pass);
            route.put("is_admin", false);
            route.put("is_monitor", false);

            // Shows what will be sent
            log.showSend(route.toString());
            // Send
            PrintWriter pr = new PrintWriter(socket.getOutputStream());  
            pr.println(route);
            pr.flush();
            
            // Close Screen
            //Stage stage = (Stage) btnRegister.getScene().getWindow();
            //stage.close();
            
        }catch(Error e){
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
