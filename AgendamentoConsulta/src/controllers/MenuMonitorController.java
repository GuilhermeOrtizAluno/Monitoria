package controllers;

import static dice.ManagerClient.homeController;
import java.awt.event.ActionEvent;
import screens.MenuMonitorScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class MenuMonitorController extends MenuMonitorScreen{

    public MenuMonitorController() {
        initComponents();
        continuationInitComponents();
    }
    
    private void continuationInitComponents(){
        bMonitoring.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("monitoringManagement");
        }); 
        bHors.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("managementMonitoring");
        });
        bChat.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("chat");
        });
    }
    
}
