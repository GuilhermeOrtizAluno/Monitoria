/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import static app.Program.socket;
import com.google.gson.Gson;
import dice.Route;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
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
        
        // received string
        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        //Read String
        String sRoute = bf.readLine();
        //Shows what came
        log.showReceived(sRoute);

        Pane root = FXMLLoader.load(getClass().getResource("../screens/Login.fxml"));
        
        // Close Screen
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.close();

        // Opens screen
        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show(); 

        // Close Connection Serve
        //s.close();

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

            // received string
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            //Read String
            String sRoute = bf.readLine();
            //Shows what came
            log.showReceived(sRoute);
            
            // Convert Json String to Route Object
            Gson gson = new Gson(); 
            Route rRoute = gson.fromJson(sRoute, Route.class);

            Pane root;
            //Valid Login
            if("false".equals(rRoute.getErro())){
                root =  FXMLLoader.load(getClass().getResource("../screens/Login.fxml"));
                //usuario = gson.fromJson(sRoute, User.class);
            }else{
                root =  FXMLLoader.load(getClass().getResource("../screens/Home.fxml"));
            }
            
            // Opens screen
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show(); 
            
            // Close Screen
            Stage stage = (Stage) btnDelete.getScene().getWindow();
            stage.close();
            
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

            // received string
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            //Read String
            String sRoute = bf.readLine();
            //Shows what came
            log.showReceived(sRoute);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
