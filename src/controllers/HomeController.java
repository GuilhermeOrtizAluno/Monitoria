/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import dice.User;
import java.io.BufferedReader;
import javafx.scene.control.Label;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

/**
 * FXML Controller class
 *
 * @author Maycon
 */
public class HomeController implements Initializable {

    @FXML
    private Label nomeusuario;
    @FXML
    private Button btnLogout;

    private static Socket s;
    
    @FXML
    private void logout(ActionEvent event) throws IOException {
        nomeusuario.setText("Maycon");
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rota", "login.logout");
        
        PrintWriter pr = new PrintWriter(s.getOutputStream());  
        
        pr.println(jsonObject);
        pr.flush();
        
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        
        System.out.println(str);

        Stage stage = (Stage) btnLogout.getScene().getWindow();

        Pane root = FXMLLoader.load(getClass().getResource("../Screens/Login.fxml"));
        Stage primaryStage = new Stage();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        
        stage.close();
        s.close();
        primaryStage.show();

    }

    public static void Client() {
        try {
            s = new Socket("localhost", 4999);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Client();
    }

}
