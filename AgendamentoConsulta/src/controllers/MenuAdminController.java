package controllers;

import java.awt.event.ActionEvent;
import screens.MenuAdminScreen;
import static dice.ManagerClient.*;

/**
 *
 * @author Guilherme Ortiz
 */
public class MenuAdminController extends MenuAdminScreen{

    public MenuAdminController() {
        initComponents();
        continuationInitComponents();
    }
    
     private void continuationInitComponents(){
        bMonitor.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("managementMonitor");
        }); 
        bMonitoria.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("managementMonitoring");
        }); 
    }
    
    
}
