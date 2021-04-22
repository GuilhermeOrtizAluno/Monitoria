package dice;

import static app.Program.socket;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static app.Program.log;
import java.awt.Color;
import javafx.application.Platform;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gui_o
 */
public class ManagerClient extends Thread{
    private InputStreamReader in;
    private BufferedReader bf;
    Stage primaryStage;
    Scene scene;
    
    public void startReceived() throws IOException{
        in = new InputStreamReader(socket.getInputStream());
        bf = new BufferedReader(in);
        
        // Opens screen Login
        Pane root = FXMLLoader.load(getClass().getResource("../screens/Login.fxml"));
        primaryStage = new Stage();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(eh->{
            System.exit(0);
        });
        primaryStage.show();

        this.start();
    }
    
    @Override
    public void run(){
        try { // an echo server
            while (true) {
                
                //Read String
                String sRoute = bf.readLine();
                
                // Convert Json String to Route Object
                Gson gson = new Gson();
                Route rRoute = gson.fromJson(sRoute, Route.class);
                
                //Shows what came
                if("cliente.usuarios-ativos".equals(rRoute.getRota())){
                    System.out.println("Received <- "+sRoute);
                    log.includeLog("Received <- "+sRoute, Color.PINK);
                }else log.showReceived(sRoute);
                
                switch (rRoute.getRota()) {
                    case "login.login" -> login(sRoute);
                    case "login.logout" -> logout();
                    case "login.registro" -> register(sRoute);
                    case "login.update" -> update(sRoute);
                    case "usuario.delete" -> delete(sRoute);
                    case "cliente.usuarios-ativos" -> users();
                    case "mensagem.mesagem" -> mensagem();
                    default -> errorRoute();
                }
            }
         } catch(EOFException e) {
             System.out.println("EOF:"+e.getMessage());
         } catch(IOException e) {
             System.out.println("IO:"+e.getMessage());
         }
        catch(Exception e){
            System.out.println(e);
        }
         finally{ 
            try {
                socket.close();
            }catch (IOException e){
                /*close failed*/
            }
        }
    } 
    
    public void openStage(Pane root){
        // Opens screen
        new Thread(() -> {
            Platform.runLater(() ->{
                scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show(); 

            });
        }).start();
    }

    private void login(String sRoute) throws IOException {
        
        // Convert Json String to Route Object
        Gson gson = new Gson(); 
        Route rRoute = gson.fromJson(sRoute, Route.class);

        Pane root;
        //Valid Login
        if("false".equals(rRoute.getErro())){
            root =  FXMLLoader.load(getClass().getResource("../screens/Home.fxml"));
            //usuario = gson.fromJson(sRoute, User.class);
        }else{
            root =  FXMLLoader.load(getClass().getResource("../screens/Login.fxml"));
        }

        openStage(root);

    }

    private void logout() throws IOException {
        
        Pane root = FXMLLoader.load(getClass().getResource("../screens/Login.fxml"));
        openStage(root);
    }

    private void register(String sRoute) throws IOException {
        // Convert Json String to Route Object
        Gson gson = new Gson(); 
        Route rRoute = gson.fromJson(sRoute, Route.class);

        Pane root;

        if("false".equals(rRoute.getErro())){
            root = FXMLLoader.load(getClass().getResource("../screens/Login.fxml"));
        }else{
            root = FXMLLoader.load(getClass().getResource("../screens/Register.fxml"));
        }

        openStage(root);
    }

    private void update(String sRoute) throws IOException {
        
    }

    private void delete(String sRoute) throws IOException {
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
        openStage(root);
    }

    private void users() {

    }

    private void mensagem() {

    }

    private void errorRoute() {
        JOptionPane.showMessageDialog(
            null, 
            "No route found", 
            "Route error", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    
}
