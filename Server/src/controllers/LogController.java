/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import screens.Log;

/**
 * FXML Controller class
 *
 * @author gui_o
 */
public class LogController extends Log {
    
    private Pane log;
    private Label lLog;
    
    private BorderPane controller;
    
    private StackPane content;

    private VBox logs;

    public LogController() {
        //p
    }
    
    
    
    
    private void hundleGuilherme(ActionEvent event) throws MalformedURLException, IOException{
        URL url = new URL("https://api.whatsapp.com/send?phone=5542999730002&text=Venho%20atrav%C3%A9s%20do%20site%20Novo%20Rio%20Im%C3%B3veis%2C%20para%20perguntar-lhe%20%3A");
        url.openConnection();
    }
    
    private void ReceivedSend(String type){
        
        /*lLog = new JLabel();
        lLog.setText(type);
        lLog.setForeground(Color.white);
        lLog.setFont(new Font(null, Font.BOLD,20));
                
        log = new JPanel();
        log.setBackground(Color.decode("#c91dd8"));
        log.add(lLog);
        
        pLog.add(log);*/
    }
    
    public void includeLog(String sLog){
        lLog = new Label();
        lLog.setText(sLog);
                
        log = new Pane();
        log.getChildren().add(lLog);
        
        this.logs.getChildren().add(log);
        
    }   
    
}
