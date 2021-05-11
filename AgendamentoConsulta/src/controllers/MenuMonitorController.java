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
            homeController.adminManagementMonitor();
        }); 
        bHors.addActionListener((ActionEvent evt) -> {
            homeController.adminManagementMonitoring();
        });
        bChat.addActionListener((ActionEvent evt) -> {
            homeController.adminManagementMonitoring();
        });
    }
    
}
