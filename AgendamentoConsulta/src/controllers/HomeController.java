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
    public static MenuStudentController menuStudentController;
    public static ManagementMonitorController managementMonitorController;
    public static ManagementMonitoringController managementMonitoringController;
    public static MonitoringManagementController monitoringManagementController;
    public static StudentManagementController studentManagementController;
    public static HorsController horsController;
    public static ChatController chatController;
    
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
        menuStudentController = new MenuStudentController();
        managementMonitorController = new ManagementMonitorController();
        managementMonitoringController = new ManagementMonitoringController();
        monitoringManagementController = new MonitoringManagementController();
        studentManagementController = new StudentManagementController();
        horsController = new HorsController();
        chatController = new ChatController();
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
        
        switch(stUser){
            case "admin" -> pMenu.remove(menuAdminController);
            case "monitor" -> pMenu.remove(menuMonitorController);
            case "aluno" -> pMenu.remove(menuAdminController);
        }
        
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
    
    public void student(){
        pMenu.add(menuStudentController, CENTER);
        contentAdd("studentManagement");
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
                managementMonitorController.cleanFields();
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
                rScreen = "monitoringManagement";
                monitoringManagementController.cleanFields();
            }
            case "studentManagement" -> {
                contentRemove();
                pContent.add(studentManagementController);
                rScreen = "studentManagement";
                studentManagementController.cleanFields();
            }
            case "chat" -> {
                contentRemove();
                pContent.add(chatController);
                rScreen = "chat";
            }
            case "hors" -> {
                contentRemove();
                pContent.add(horsController);
                rScreen = "hors";
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
            case "studentManagement" -> {
                pContent.remove(studentManagementController);
            }
            case "chat" -> {
                pContent.remove(chatController);
            }
            case "hors" -> {
                pContent.remove(horsController);
            }
            
        }
        reloadscreen();
    }
    
    public void cleanFields(){
        managementMonitorController.cleanFields();
        managementMonitoringController.cleanFields();
        monitoringManagementController.cleanFields();
        studentManagementController.cleanFields();
    }
    
    public void chatMessageReceveid(String message) throws JSONException{
        chatController.includeMessageReceveid(new JSONObject(message));
    }
    
    @SuppressWarnings("unchecked")
    public void initCBUsers(Vector<String> vUsers){
        //Monitor/Aluno Chat
        chatController.cbUser.setModel(new DefaultComboBoxModel<>(vUsers));
    }
    
    @SuppressWarnings("unchecked")
    public void initCBMonitors(Vector<String> vMonitors){
        var mMonitors = new DefaultListModel();
        mMonitors.addAll(vMonitors);
        
        //Admin monitor
        managementMonitorController.cbMonitor.setModel(new DefaultComboBoxModel<>(vMonitors));
        managementMonitorController.pMonitors.setModel(mMonitors);
        
        //Admin monitorias
        managementMonitoringController.cbMonitor.setModel(new DefaultComboBoxModel<>(vMonitors));
        managementMonitoringController.rcbMonitor.setModel(new DefaultComboBoxModel<>(vMonitors));
        
    }
    
    @SuppressWarnings("unchecked")
    public void initCBMonitorings(Vector<String> vMonitorings){
        var mMonitorings = new DefaultListModel();
        mMonitorings.addAll(vMonitorings);
        
        //Admin monitoria
        managementMonitoringController.cbMonitoring.setModel(new DefaultComboBoxModel<>(vMonitorings));
        managementMonitoringController.pMonitorings.setModel(mMonitorings);
        
        //Monitor monitoria
        monitoringManagementController.cbMonitoring.setModel(new DefaultComboBoxModel<>(vMonitorings));
        
        //Aluno inicial
        studentManagementController.cbMonitoring.setModel(new DefaultComboBoxModel<>(vMonitorings));
        
        //Monitor Hors
        if("monitor".equals(stUser))
            horsController.cbMonitoring.setModel(new DefaultComboBoxModel<>(vMonitorings));
        
    }
    
    @SuppressWarnings("unchecked")
    public void initCBMonitorings1(Vector<String> vMonitorings){
        var mMonitorings = new DefaultListModel();
        mMonitorings.addAll(vMonitorings);
        
        //Aluno Horarios
        horsController.cbMonitoring.setModel(new DefaultComboBoxModel<>(vMonitorings));
        
        //Aluno inicial
         studentManagementController.dcbMonitoring.setModel(new DefaultComboBoxModel<>(vMonitorings));
    }
    
}
