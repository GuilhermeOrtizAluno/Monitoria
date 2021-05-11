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
    public static MenuMonitorController menuMonitorController;
    public static ManagementMonitorController managementMonitorController;
    public static ManagementMonitoringController managementMonitoringController;
    public static MonitoringManagementController monitoringManagementController;
    
    private String rScreen; 

    public HomeController() {
        instantiation();
        initComponents();
        continuationInitComponents();   
    }
    
    public final void instantiation(){
        rScreen = "managementMonitor";
        menuAdminController = new MenuAdminController();
        menuMonitorController = new MenuMonitorController();
        managementMonitorController = new ManagementMonitorController();
        managementMonitoringController = new ManagementMonitoringController();
        monitoringManagementController = new MonitoringManagementController();
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
        contentAdd("managementMonitor");
    }
    
    public void monitor(){
        pMenu.add(menuMonitorController, CENTER);
        contentAdd("monitoringManagement");
    }
    
    public void reloadscreen(){
        validate();
        repaint();
        revalidate();
    }
    
    public void contentAdd(String sScreen){
        switch(sScreen){
            case "managementMonitor" -> {
                contentRemove();
                pContent.add(managementMonitorController);
                rScreen = "managementMonitor";
                managementMonitorController.cleanFields(true);
            }
            case "managementMonitoring" -> {
                contentRemove();
                pContent.add(managementMonitoringController);
                rScreen = "managementMonitoring";
                managementMonitoringController.cleanFields();
            }
            case "monitoringManagement" -> {
                contentRemove();
                pContent.add(monitoringManagementController);
                rScreen = "monitorManagement";
                //monitoringManagementController.cleanFields();
            }
            
        }
        reloadscreen();
    }
    
    public void contentRemove(){
        switch(rScreen){
            case "managementMonitor" -> {
                pContent.remove(managementMonitorController);
            }
            case "managementMonitoring" -> {
                pContent.remove(managementMonitoringController);
            }
            case "monitoringManagement" -> {
                pContent.remove(monitoringManagementController);
            }
            
        }
        reloadscreen();
    }
    
    @SuppressWarnings("unchecked")
    public void initCBMonitors(Vector<String> vMonitors){
        var mMonitors = new DefaultListModel();
        mMonitors.addAll(vMonitors);
        managementMonitorController.cbMonitor.setModel(new DefaultComboBoxModel<>(vMonitors));
        managementMonitorController.pMonitors.setModel(mMonitors);
        managementMonitoringController.cbMonitor.setModel(new DefaultComboBoxModel<>(vMonitors));
        managementMonitoringController.rcbMonitor.setModel(new DefaultComboBoxModel<>(vMonitors));
    }
    
    @SuppressWarnings("unchecked")
    public void initCBMonitorings(Vector<String> vMonitorings){
        var mMonitorings = new DefaultListModel();
        mMonitorings.addAll(vMonitorings);
        managementMonitoringController.cbMonitoring.setModel(new DefaultComboBoxModel<>(vMonitorings));
        managementMonitoringController.pMonitorings.setModel(mMonitorings);
    }
    
}
