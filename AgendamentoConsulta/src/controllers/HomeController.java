/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static app.Program.socket;
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

    @FXML
    private Label nomeusuario;
    @FXML
    private Button btnLogout;
    
    @FXML
    private void logout(ActionEvent event) throws IOException {
        JSONObject route = new JSONObject();
        route.put("rota", "login.logout");
        
        // Shows what will be sent
        showSend(route.toString());
        //Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
        
        // Receive string
        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        //Read String
        String sRoute = bf.readLine();
        //Shows what came
        showRecive(sRoute);

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
    
    // Shows what will be sent
    private void showSend(String route) throws IOException{
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 
        System.out.println("Send"+route);
        StackPane pLog = new StackPane();
        Label lLog = new Label();
        lLog.setText("Send"+route);
        pLog.getChildren().add(lLog);
        pLog.getStyleClass().add("box-log");
        //logs.getChildren().add(pLog);
        fwLog.write("Send"+route.toString()+"\n");
        fwLog.flush();
        fwLog.close();
    }
    
    //Shows what came
    private void showRecive(String recive) throws IOException{
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 
        System.out.println("Receive"+recive);
        StackPane pLog = new StackPane();
        Label lLog = new Label();
        lLog.setText("Receive"+recive);
        pLog.getChildren().add(lLog);
        pLog.getStyleClass().add("box-log");
        //logs.getChildren().add(pLog);
        fwLog = new FileWriter(fLog, true); 
        fwLog.write("Receive"+recive+"\n");
        fwLog.flush();
        fwLog.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
