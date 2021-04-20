/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author gui_o
 */
public class LogController implements Initializable {

    @FXML
    private VBox logs;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    // Shows what will be sent
    public void showSend(String route) throws IOException{
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 
        System.out.println("Send -> "+route);
        StackPane pLog = new StackPane();
        Label lLog = new Label();
        lLog.setText("Send -> "+route);
        pLog.getChildren().add(lLog);
        pLog.getStyleClass().add("box-log");
        logs.getChildren().add(pLog);
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
        logs.getChildren().add(pLog);
        fwLog = new FileWriter(fLog, true); 
        fwLog.write("Received <- " + received+"\n");
        fwLog.flush();
        fwLog.close();
    }
    
}
