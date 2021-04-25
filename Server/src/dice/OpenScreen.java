/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author Guilherme Ortiz
 */
public class OpenScreen {
    private Pane view;
    
    public Pane getPage(String screen){
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../screens/"+screen+".fxml"));
            view = loader.load();
           
            /*URL uPage = Program.class.getResource("../screens/"+screen+".fxml");
            
            if(null == uPage) throw new java.io.FileNotFoundException("FXML file can't be found");
            
            view = new FXMLLoader().load(uPage);*/
        } catch (IOException e) {
            System.out.println("Error pags");
        }
        
        return view;
        
    }
    
}
