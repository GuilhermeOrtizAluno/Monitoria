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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import static app.Program.log;

/**
 * FXML Controller class
 *
 * @author Maycon
 */
public class HomeController implements Initializable {

    //@FXML
    //private Label nomeusuario;
    
    @FXML
    private Button btnLogout;
    
    @FXML
    private Button btnDelete;
    
    @FXML
    private TextField tfUser;

    @FXML
    private TextField tfPass;
    
    @FXML
    private Button btnUpdate;
    
    @FXML
    @SuppressWarnings({"unchecked"})
    private void handleLogout(ActionEvent event) throws IOException {
        JSONObject route = new JSONObject();
        route.put("rota", "login.logout");
        
        // Shows what will be sent
        log.showSend(route.toString());
        //Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
        
        // Close Screen
        //Stage stage = (Stage) btnLogout.getScene().getWindow();
        //stage.close();
    }
    
    @FXML
    @SuppressWarnings("unchecked")
    private void handleDelete(ActionEvent event) throws IOException {
        // Read from interface
            String user = tfUser.getText();
            String pass = tfPass.getText();

            JSONObject route = new JSONObject();
            route.put("rota", "usuario.delete");
            route.put("usuario", user);
            route.put("senha", pass);

            // Shows what will be sent
            log.showSend(route.toString());
            // Send
            PrintWriter pr = new PrintWriter(socket.getOutputStream());  
            pr.println(route);
            pr.flush();
            
            // Close Screen
            //Stage stage = (Stage) btnDelete.getScene().getWindow();
            //stage.close();  
    }
   
    @FXML
    @SuppressWarnings({"unchecked", "unchecked"})
    private void handleUpdate(ActionEvent event) throws IOException {
        // Read from interface
        String user = tfUser.getText();
        //String pass = tfPass.getText();

        JSONObject route = new JSONObject();
        route.put("rota", "login.update");
        route.put("usuario", user);
        //route.put("senha", pass);

        // Shows what will be sent
        log.showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
