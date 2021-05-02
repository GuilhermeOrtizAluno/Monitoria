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
import org.json.simple.JSONObject;

/**
 * FXML Controller class
 *
 * @author Maycon
 */
public class HomeController {

    /*
    

    private void handleDelete( ) throws IOException {
        // Read from interface
            //String user = tfUser.getText();
            //String pass = tfPass.getText();

            JSONObject route = new JSONObject();
            route.put("rota", "usuario.delete");
            //route.put("usuario", user);
            //route.put("senha", pass);

            // Shows what will be sent
            //log.showSend(route.toString());
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
        String pass = tfPass.getText();

        JSONObject route = new JSONObject();
        route.put("rota", "login.update");
        route.put("usuario", user);
        route.put("senha", pass);

        // Shows what will be sent
        log.showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();

    }
    
*/

}
