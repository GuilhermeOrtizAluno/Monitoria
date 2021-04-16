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
import java.io.File;
import java.io.FileWriter;
import javafx.scene.control.Label;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

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
        showSend(route.toString());
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
        showReceived(sRoute);

        Pane root = FXMLLoader.load(getClass().getResource("../Screens/Login.fxml"));
        
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
            
            File fLog = new File("log.txt");
            FileWriter fwLog = new FileWriter(fLog, true); 

            // Shows what will be sent
            showSend(route.toString());
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
            showReceived(sRoute);
            
            // Convert Json String to Route Object
            Gson gson = new Gson(); 
            Route rRoute = gson.fromJson(sRoute, Route.class);

            Pane root;
            //Valid Login
            if("false".equals(rRoute.getErro())){
                root =  FXMLLoader.load(getClass().getResource("../Screens/Login.fxml"));
                //usuario = gson.fromJson(sRoute, User.class);
            }else{
                root =  FXMLLoader.load(getClass().getResource("../Screens/Home.fxml"));
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
            String pass = tfPass.getText();

            JSONObject route = new JSONObject();
            route.put("rota", "login.update");
            route.put("usuario", user);
            route.put("senha", pass);
            
            File fLog = new File("log.txt");
            FileWriter fwLog = new FileWriter(fLog, true); 

            // Shows what will be sent
            showSend(route.toString());
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
            showReceived(sRoute);
    }
    
     // Shows what will be sent
    private void showSend(String route) throws IOException{
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 
        System.out.println("Send -> "+route);
        StackPane pLog = new StackPane();
        Label lLog = new Label();
        lLog.setText("Send -> "+route);
        pLog.getChildren().add(lLog);
        pLog.getStyleClass().add("box-log");
        //logs.getChildren().add(pLog);
        fwLog.write("Send -> "+route+"\n");
        fwLog.flush();
        fwLog.close();
    }
    
    //Shows what came
    private void showReceived(String received) throws IOException{
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 
        System.out.println("Received <- "+received);
        StackPane pLog = new StackPane();
        Label lLog = new Label();
        lLog.setText("Received <- "+received);
        pLog.getChildren().add(lLog);
        pLog.getStyleClass().add("box-log");
        //logs.getChildren().add(pLog);
        fwLog = new FileWriter(fLog, true); 
        fwLog.write("Received <- "+received+"\n");
        fwLog.flush();
        fwLog.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
