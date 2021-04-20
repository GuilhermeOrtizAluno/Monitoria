/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import com.google.gson.Gson;
import controllers.LogController;
import crud.UserDAO;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author gui_o
 */
public class ManagerServer extends Thread {
    private InputStreamReader in;
    private BufferedReader bf;
    private PrintWriter pr;
    private final Socket clientSocket;

    public ManagerServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    public void Connection () {
        try {
            in = new InputStreamReader(clientSocket.getInputStream());
            bf = new BufferedReader(in);
            pr = new PrintWriter(clientSocket.getOutputStream());
            this.start();
        }catch(IOException e) {
            System.out.println("Connection:"+e.getMessage());
        }
    }
    
    @Override
    public void run(){
        try { // an echo server
            while (true) {
                
                //Read String
                String sRoute = bf.readLine();
                
                //Shows what came
                showReceived(sRoute);

                // Convert Json String to Route Object
                Gson gson = new Gson();
                Route rRoute = gson.fromJson(sRoute, Route.class);
                switch (rRoute.getRota()) {
                    case "login.login" -> login(sRoute);
                    case "login.logout" -> logout();
                    case "login.registro" -> register(sRoute);
                    case "login.update" -> update(sRoute);
                    case "usuario.delete" -> delete(sRoute);                  
                }
            }
         } catch(EOFException e) {
             System.out.println("EOF:"+e.getMessage());
         } catch(IOException e) {
             System.out.println("IO:"+e.getMessage());
         } catch (JSONException ex) {
            Logger.getLogger(ManagerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{ 
            try {
                clientSocket.close();
            }catch (IOException e){
                /*close failed*/
            }
        }
    }
    
    private void login(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
      
        // Convert Json String to User Object
        User user = gson.fromJson(string, User.class);
        
        // Search for user in the bank
        user = dUser.search(user);
        
        JSONObject route = new JSONObject();
        route.put("rota", "login.login"); 
       
        // Valid user
        if(user.getUsuario() == null)
           route.put("erro", "Usuario ou Senha invalido");
        else route.put("erro", "false");
        
        //Send User
        String str = gson.toJson(user); 

        // Shows what will be sent
        showSend(route.toString());
        // Send
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
        
        boolean q = dUser.create(user);
        
        if(q != true){
            route.put("erro", "Cadastro não efetuado!");
        }else{
            route.put("erro", "false");
        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
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
        boolean bool = dUser.update(user);
        
        JSONObject route = new JSONObject();
        route.put("rota", "login.update"); 
       
        // Valid user
        if(!bool)
            route.put("erro", "Alteração nao realizada");
        else 
            route.put("erro", "false");
        
        String str = gson.toJson(user); 

        // Shows what will be sent
        showSend(route.toString());
        // Send
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
        boolean bool = dUser.delete(user);
        
        JSONObject route = new JSONObject();
        route.put("rota", "usario.delete"); 
       
        // Valid user
        if(!bool)
            route.put("erro", "Usuario nao deletado");
        else 
            route.put("erro", "false");

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
        //pr.close();
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
        System.out.println("Received <- " + received);
        StackPane pLog = new StackPane();
        Label lLog = new Label();
        lLog.setText("Receive <- " + received);
        pLog.getChildren().add(lLog);
        pLog.getStyleClass().add("box-log");
        //logs.getChildren().add(pLog);
        fwLog = new FileWriter(fLog, true); 
        fwLog.write("Received <- " + received+"\n");
        fwLog.flush();
        fwLog.close();
    }
    
}
