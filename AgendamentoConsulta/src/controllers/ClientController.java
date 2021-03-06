package controllers;

import static dice.ManagerClient.*;
import static java.awt.BorderLayout.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import screens.ClientScreen;

/**
 *
 * @author gui_o
 */
public class ClientController extends ClientScreen {
    
    private boolean maximized, minimized;
    private String screen;
    private static Point point;

    public void start() {
        initComponents();
        continuationInitComponents();
        initVariable();
        pContentAdd("loginRegister");
        setVisible(true);
    }
    
    private void initVariable(){
        maximized = false;
        minimized = false;
        point = new Point();
    }
    
    private void continuationInitComponents(){
        bClose.addActionListener((ActionEvent evt) -> {
            System.exit(0);
        });
        bMaximize.addActionListener((ActionEvent evt) -> {
            //setExtendedState(maximized ? NORMAL : MAXIMIZED_BOTH);
            //maximized = !maximized;
        });
        bMaximize.addActionListener((ActionEvent evt) -> {
            //setExtendedState(ICONIFIED);
        });
        cbLog.addItemListener((java.awt.event.ItemEvent evt) -> {
            log();
        });
        addMouseListener(new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            point.x = e.getX();
            point.y = e.getY();
          }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
          @Override
          public void mouseDragged(MouseEvent e) {
            Point p = getLocation();
            setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
          }
        });
    
    }
    
    private void hundleGuilherme() throws MalformedURLException, IOException{
        URL url = new URL("https://api.whatsapp.com/send?phone=5542999730002&text=Venho%20atrav%C3%A9s%20do%20site%20Novo%20Rio%20Im%C3%B3veis%2C%20para%20perguntar-lhe%20%3A");
        url.openConnection();
    }
    
    public void pContentClear (){
        switch(screen){
            case "connection"           -> pContentAll.remove(connectionController); 
            case "loginRegister"        -> pContentAll.remove(loginRegisterController);
            case "home"                 -> pContentAll.remove(homeController);
            /*
            case "registerMonitor"      -> {
                pcLeft.remove(registerMonitorController);
                pcCenter.remove(managementMonitorController);
                
            }
            case "managementMonitor"    -> {
                pcLeft.remove(registerMonitorController);
                pcCenter.remove(managementMonitorController);
            }
            case "updateStudent" -> pcLeft.remove(updateStudentController);
            case "registerMonitoring" ->{
                pcLeft.remove(registerMonitorController);
                pcCenter.remove(managementMonitorController);
                pcRight.remove(registerMonitoringController);
            }
*/
        }
        pContentAll.repaint();
        pContentAll.validate();
        pContentAll.revalidate();
        repaint();
        validate();
        revalidate();
    }
    
    public void pContentAdd(String type){
        switch(type){
            case "connection" -> 
            {
                connectionController.cleanFields();
                pContentAll.add(connectionController); 
                screen = "connection";
            }
            case "loginRegister" -> {
                loginRegisterController.cleanFields();
                pContentAll.add(loginRegisterController, CENTER); 
                screen = "loginRegister";
            }
            case "home" -> {
                pContentAll.add(homeController, CENTER); 
                screen = "home";
            }
            case "admin" -> {
                homeController.admin();
            }
            case "monitor" -> {
                homeController.monitor();
            }
            case "student" -> {
                homeController.student();
            }
            /*
            case "registerMonitor"  -> 
            {
                registerMonitorController.cleanFields();
                pcLeft.add(registerMonitorController);
                screen = "registerMonitor";
            }
            case "managementMonitor" ->
            {
                managementMonitorController.cleanFields();
                pcCenter.add(managementMonitorController);
                screen = "managementMonitor";
            }
            case "updateStudent" ->{
                updateStudentController.cleanFields();
                pcLeft.add(updateStudentController);
                screen = "updateStudent";
            }
            case "registerMonitoring" ->{
                registerMonitoringController.cleanFields();
                pcRight.add(registerMonitoringController);
                screen = "registerMonitoring";
            }*/
        }
        pContentAll.repaint();
        pContentAll.validate();
        pContentAll.revalidate();
        repaint();
        validate();
        revalidate();
    }
    
    public void log(){
         if(!cbLog.isSelected()) {
            pContentAll.remove(logController);
            pContentAll.setSize(new java.awt.Dimension(900, 500));
            setSize(new java.awt.Dimension(900, 500));
        }
        else {
            pContentAll.add(logController, PAGE_END);
            pContentAll.setSize(new java.awt.Dimension(900, 680));
            setSize(new java.awt.Dimension(900, 680));
        }
        pContentAll.repaint();
        pContentAll.validate();
        pContentAll.revalidate();
        repaint();
        validate();
        revalidate();
    }
}
