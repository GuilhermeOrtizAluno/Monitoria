package controllers;

import static java.awt.BorderLayout.CENTER;
import screens.HomeScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class HomeController extends HomeScreen{
    
    public static MenuAdminController menuAdminController;

    public HomeController() {
        menuAdminController = new MenuAdminController();
        initComponents();
    }
    
    public void admin(){
        pMenu.add(menuAdminController, CENTER);
    }
    
}
