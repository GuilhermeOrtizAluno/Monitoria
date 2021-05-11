package controllers;

import static dice.ManagerClient.*;
import static java.awt.BorderLayout.CENTER;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import org.json.JSONException;
import org.json.JSONObject;
import screens.HomeScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class HomeController extends HomeScreen{
    
    public static MenuAdminController menuAdminController;
    public static ManagementMonitorController managementMonitorController;
    public static ManagementMonitoringController managementMonitoringController;

    public HomeController() {
        instantiation();
        initComponents();
        continuationInitComponents();   
    }
    
    public final void instantiation(){
        menuAdminController = new MenuAdminController();
        managementMonitorController = new ManagementMonitorController();
        managementMonitoringController = new ManagementMonitoringController();
    }
    
    private void continuationInitComponents(){
        bLogout.addActionListener((ActionEvent evt) -> {
            try {
                hundleLogout();
            } catch (IOException | JSONException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
    }
     
    @SuppressWarnings("unchecked")
    private void hundleLogout() throws IOException, JSONException {
        JSONObject route = new JSONObject();
        route.put("rota", "login.logout");
        
        // Shows what will be sent
        logController.showSend(route.toString());
        //Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
        
    }
    
    public void admin(){
        pMenu.add(menuAdminController, CENTER);
        adminManagementMonitor();
    }
    
    public void adminClear(boolean register){
        managementMonitorController.cleanFields(register);
    }
    
    public void adminManagementMonitor(){
        switchScreen();
        pContent.add(managementMonitorController);
        reloadscreen();
    }
    
    public void adminManagementMonitoring(){
        switchScreen();
        pContent.add(managementMonitoringController);
        reloadscreen();
    }
    
    public void switchScreen(){
        pContent.remove(managementMonitoringController);
        pContent.remove(managementMonitorController);
    }
    
    public void reloadscreen(){
        validate();
        repaint();
        revalidate();
    }
    
    @SuppressWarnings("unchecked")
    public void initCBMonitors(Vector<String> vMonitors){
        var mMonitors = new DefaultListModel();
        mMonitors.addAll(vMonitors);
        managementMonitorController.cbMonitor.setModel(new DefaultComboBoxModel<>(vMonitors));
        managementMonitorController.pMonitors.setModel(mMonitors);
        managementMonitoringController.cbMonitor.setModel(new DefaultComboBoxModel<>(vMonitors));
        managementMonitoringController.rcbMonitor.setModel(new DefaultComboBoxModel<>(vMonitors));
        //managementMonitoringController.pMonitors.setModel(mMonitors);
    }
    
}
