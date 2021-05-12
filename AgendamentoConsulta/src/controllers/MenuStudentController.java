package controllers;

import static dice.ManagerClient.homeController;
import java.awt.event.ActionEvent;
import screens.MenuStudentScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class MenuStudentController extends MenuStudentScreen{

    public MenuStudentController() {
        initComponents();
        continuationInitComponents();
    }
    
    private void continuationInitComponents(){
        bStudent.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("studentManagement");
        }); 
        bHors.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("");
        });
        bChat.addActionListener((ActionEvent evt) -> {
            homeController.contentAdd("chat");
        });
        bDelete.addActionListener((ActionEvent evt) -> {
            
        });
    }
    
}
