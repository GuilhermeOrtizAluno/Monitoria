/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import dice.Route;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static app.Program.socket;
import crud.UserDAO;
import dice.User;
import java.io.PrintWriter;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author gui_o
 */
public class LogController implements Initializable {

    @FXML
    private TextField tfIP;
    
    @FXML
    private TextField tfPort;
    
    @FXML
    private Button btnConection;
    
    @FXML
    private VBox logs;
    
    @FXML
    private void hundleConection(ActionEvent event) throws IOException{
        // Read from interface
        String ip = tfIP.getText();
        String port = tfPort.getText();
        btnConection.setDisable(true);

        // Close Screen
        Stage stage = (Stage) btnConection.getScene().getWindow();
        stage.close();
        
        serverConection(ip, Integer.valueOf(port));
        
    }
    
    private void serverConection(String ip, int port){
        try (ServerSocket ss = new ServerSocket(port)) {
           
            File fLog = new File("log.txt"); 
            fLog.createNewFile();
            /*FileWriter fwLog = new FileWriter(fLog); 
            fwLog.write("conectado\n");
            fwLog.flush();
            fwLog.close();*/

            // Accept connection
            socket = ss.accept();
            
            // Receive string
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            
            while (true) {
                
                //Read String
                String sRoute = bf.readLine();
                
                //Shows what came
                showRecive(sRoute);

                // Convert Json String to Route Object
                Gson gson = new Gson();
                Route rRoute = gson.fromJson(sRoute, Route.class);
                switch (rRoute.getRota()) {
                    case "login.login" :    login(sRoute);    break;
                    case "login.logout" :   logout();         break;   
                    case "login.registro" : register(sRoute); break;
                    case "login.update" :   update(sRoute);   break;
                    case "usuario.delete" : delete(sRoute);   break;
                }
            }

        } catch (Exception ex) {
            //JOptionPane.showConfirmDialog(null, "Error Conection", "Conection", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            //System.exit(0);
        }
    }
    
    private void login(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
      
        // Convert Json String to User Object
        User user = gson.fromJson(string, User.class);
        
        // Search for user in the bank
        //user = dUser.search(user);
        
        JSONObject route = new JSONObject();
        route.put("rota", "login.login"); 
       
        // Valid user
        //if(user.getUsuario() == null)
           //route.put("erro", "Usuario ou Senha invalido");
        /*else*/ route.put("erro", "false");
        
        /* String str = gson.toJson(user); */

        // Shows what will be sent
        showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
    }
    
    private void logout() throws IOException, JSONException{
        JSONObject route = new JSONObject();
        route.put("rota", "login.login");
        route.put("erro", "false");
        
        // Shows what will be sent
        showSend(route.toString());
        
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
    }
    
    private void register(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();

        // Convert Json String to User Object
        User user = gson.fromJson(string, User.class);

        JSONObject route = new JSONObject();
        route.put("rota", "login.registro"); 
        
        // Create User in the bank
        
        //boolean q = dUser.create(user);
        
        //if(q != true){
          //  route.put("erro", "Cadastro não efetuado!");
        //}else{
            route.put("erro", "false");
        //}

        // Shows what will be sent
        showSend(route.toString());
        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
     }
    
    private void update(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
        
        // Convert Json String to User Object
        User user = gson.fromJson(string, User.class);
        
        // Search for user in the bank
        //boolean bool = dUser.update(user);
        
        JSONObject route = new JSONObject();
        route.put("rota", "login.update"); 
       
        // Valid user
        //if(!bool)
          //  route.put("erro", "Alteração nao realizada");
        //else 
            route.put("erro", "false");
        
        /* String str = gson.toJson(user); */

        // Shows what will be sent
        showSend(route.toString());
        // Send
        System.out.println(route);
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
    }
    
    private void delete(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
        
        // Convert Json String to User Object
        User user = gson.fromJson(string, User.class);
        
        // Search for user in the bank
        //boolean bool = dUser.delete(user);
        
        JSONObject route = new JSONObject();
        route.put("rota", "usario.delete"); 
       
        // Valid user
        //if(!bool)
          //  route.put("erro", "Usuario nao deletado");
        //else 
            route.put("erro", "false");
        
        /* String str = gson.toJson(user); */

        // Shows what will be sent
        showSend(route.toString());
        // Send
        System.out.println(route);
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
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
        logs.getChildren().add(pLog);
        fwLog.write("Send"+route+"\n");
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
        logs.getChildren().add(pLog);
        fwLog = new FileWriter(fLog, true); 
        fwLog.write("Receive"+recive+"\n");
        fwLog.flush();
        fwLog.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
