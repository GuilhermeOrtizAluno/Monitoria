/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import dice.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

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
    
    private static Socket s;
    
    
    @FXML
    private void hundleLogin(ActionEvent event) throws IOException{
        String user = tfUser.getText();
        String pass = tfPass.getText();
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rota", "login.login");
        jsonObject.put("usuario", user);
        jsonObject.put("senha", pass);
        PrintWriter pr = new PrintWriter(s.getOutputStream());  
        pr.println(jsonObject);
        pr.flush();
        
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        Gson gson = new Gson(); 
        User usuario = gson.fromJson(str, User.class);
        
        //s.close();
    }
    
    public static void Client(){
        try {
            s = new Socket("localhost", 4999);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Client();
    }    
    
}
