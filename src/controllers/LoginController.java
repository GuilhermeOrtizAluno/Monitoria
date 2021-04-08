/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import dice.Route;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
    
    @FXML
    private Button btnLogin;
    
    private static Socket s;
    
    
    @FXML
    private void hundleLogin(ActionEvent event) throws IOException{
        try {
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
        Route rota = gson.fromJson(str, Route.class);
        
        
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        User usuario;
        
        Pane root;
        
        if(rota.getErro() == null){
            root =  FXMLLoader.load(getClass().getResource("../Screens/Home.fxml"));
            usuario = gson.fromJson(str, User.class);
        }else{
            root =  FXMLLoader.load(getClass().getResource("../Screens/Login.fxml"));
        }

        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        
        stage.close();
        primaryStage.setScene(scene);
        
        s.close();
        
        primaryStage.show(); 
        }catch(Error e){
            
        }
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
