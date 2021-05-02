package controllers;

import static app.Program.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.simple.JSONObject;
import screens.ClientScreen;

/**
 *
 * @author gui_o
 */
public class ClientController extends ClientScreen {
    
    private JLabel lLog, lClient;
    private JPanel pType;
    private JPanel log, client;
    private int yLog;
    private int yClient;
    private int x;
    
    private void continuationInitComponents(){
        bExit.addActionListener((ActionEvent evt) -> {
            try {
                hundleLogout();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
   }

    public void start() {
        initComponents();
        continuationInitComponents();
        pContentAdd("connection");
        yLog = 5;
        yClient = 5;
        x = 5;
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    private void hundleLogout() throws IOException {
        JSONObject route = new JSONObject();
        route.put("rota", "login.logout");
        
        // Shows what will be sent
        showSend(route.toString());
        //Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
        
    }
    
    private void hundleGuilherme() throws MalformedURLException, IOException{
        URL url = new URL("https://api.whatsapp.com/send?phone=5542999730002&text=Venho%20atrav%C3%A9s%20do%20site%20Novo%20Rio%20Im%C3%B3veis%2C%20para%20perguntar-lhe%20%3A");
        url.openConnection();
    }
    
    public void includeLog(String sLog, Color legend, Color cType){
        lLog = new JLabel();
        lLog.setForeground(legend);
        lLog.setText(sLog);
        lLog.setLocation(26, 7);
        //lLog.setAlignmentX(LEFT_ALIGNMENT);
        
        pType = new JPanel();
        pType.setSize(20, 20);
        //pType.setLocation(3, 7);
        //pType.setAlignmentX(LEFT_ALIGNMENT);
        pType.setBackground(cType);
                
        log = new JPanel();
        log.setSize(600,35);
        //  log.setLayout(new FlowLayout());
        //log.setBorder(new EmptyBorder(10, 10, 10, 10));
        //log.setBorder(new LineBorder(Color.WHITE, 5, true));
        log.setBackground(Color.WHITE);
        log.setLocation(x, yLog);
        log.add(pType);
        log.add(lLog);
        
        yLog += 40;
        
        pLog.add(log);
        pLog.repaint();
        pLog.validate();
        
        spLog.revalidate();
        
    }   
    
    public void includeClient(String sClient){
        lClient = new JLabel();
        lClient.setText(sClient);
        
        pType = new JPanel();
        pType.setSize(20, 20);
        pType.setBackground(Color.GREEN);
                
        client = new JPanel();
        client.setSize(300,35);
        client.setLocation(x, yClient);
        client.add(pType);
        client.add(lClient);
        
        yClient += 40;
        
        pContent.add(client);
        pContent.repaint();
        pContent.validate();
        
        revalidate();
    }
    
        // Shows what will be sent
    public void showSend(String send) throws IOException {
        //Terminal
        System.out.println("Send -> " + send);

        //Iterface Log
        includeLog("Send -> "+send, Color.BLACK, Color.BLUE);
        
        //Log txt
        File fLog = new File("log.txt");
        try (FileWriter fwLog = new FileWriter(fLog, true)) {
            fwLog.write("Send -> " + send + "\n");
            fwLog.flush();
        }
    }

    //Shows what came
    public void showReceived(String received, Color legend) throws IOException {
        //Terminal
        System.out.println("Received <- " + received);

        //Iterface Log
        includeLog("Received <- "+received, legend, Color.CYAN);
        
        //Log txt
        File fLog = new File("log.txt");
        try (FileWriter fwLog = new FileWriter(fLog, true)) {
            fwLog.write("Received <- " + received + "\n");
            fwLog.flush();
        }
    }
    
    public void pContentClear (){
        switch(screen){
            case "connection"           -> pcCenter.remove(connectionController); 
            case "login"                -> pcCenter.remove(loginController);
            case "registerStudent"      -> pcCenter.remove(registerStudentController);
            case "registerMonitor"      -> {
                pExit.remove(bExit);
                pcLeft.remove(registerMonitorController);
                pcCenter.remove(managementMonitorController);
                
            }
            case "managementMonitor"    -> {
                pExit.remove(bExit);
                pcLeft.remove(registerMonitorController);
                pcCenter.remove(managementMonitorController);
            }

        }
        pcCenter.repaint();
        pcCenter.validate();
        pcLeft.repaint();
        pcLeft.validate();
        pcRight.repaint();
        pcRight.validate();
        pExit.repaint();
        pExit.validate();
        pContent.revalidate();
        pHeader.revalidate();
    }
    
    public void pContentAdd(String type){
        switch(type){
            case "connection" -> 
            {
                pcCenter.add(connectionController); 
                screen = "connection";
            }
            case "login" -> {
                pcCenter.add(loginController); 
                screen = "login";
            }
            case "registerStudent" -> {
                pcCenter.add(registerStudentController);
                screen = "registerStudent";
            }
            case "registerMonitor"  -> 
            {
                pExit.add(bExit);
                pcLeft.add(registerMonitorController);
                screen = "registerMonitor";
            }
            case "managementMonitor" ->
            {
                pcCenter.add(managementMonitorController);
                screen = "managementMonitor";
            }
        }
        pcCenter.repaint();
        pcCenter.validate();
        pcLeft.repaint();
        pcLeft.validate();
        pcRight.repaint();
        pcRight.validate();
        pContent.revalidate();
    }
}
