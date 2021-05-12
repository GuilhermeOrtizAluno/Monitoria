package controllers;

import static dice.ManagerClient.*;
import static dice.ManagerClient.usernameON;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import screens.MenuStudentScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class MenuStudentController extends MenuStudentScreen{

    public MenuStudentController() {
        initComponents();
        continuationInitComponents();
    }
    
    private void continuationInitComponents(){
        bStudent.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("studentManagement");
        }); 
        bHors.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("hors");
        });
        bChat.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("chat");
        });
        bDelete.addActionListener((ActionEvent evt) -> {
            try {
                hundleDelete();
            } catch (IOException | JSONException ex) {
                Logger.getLogger(MenuStudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void hundleDelete() throws IOException, JSONException {
        // Read from interface

        JSONObject route = new JSONObject();
        route.put("rota", "usuario.delete");
        route.put("usuario", usernameON);

        // Shows what will be sent
        logController.showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
  
    }
    
}
