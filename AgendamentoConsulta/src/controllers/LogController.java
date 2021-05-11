package controllers;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import screens.LogScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class LogController extends LogScreen{
    
    private JLabel lLog, lClient;
    private JPanel pType;
    private JPanel log, client;
    private int yLog;
    private int yClient;
    private int x;
    private boolean logUsers;

    public LogController() {
        initComponents();
        initVariable();
    }
    
     private void initVariable(){
        yLog = 5;
        yClient = 5;
        x = 5;
        logUsers = false;
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
        if(!logUsers) pLog.add(Box.createRigidArea(new Dimension(0,5)));
        pLog.repaint();
        pLog.validate();
        
        spLog.revalidate();
        
    }   
    
    public void includeLogUsers(JSONObject routeAll, boolean broadcast) throws JSONException{
        
        logUsers = !logUsers;

        String route = "{\"rota\":\"" + routeAll.getString("rota") + "\",";
        if(!broadcast) route += "\"erro\":\"" + routeAll.getString("erro") + "\",";
        
        includeLog("Received <- "+route, Color.BLACK, !broadcast ? Color.CYAN : Color.PINK);
        
        includeLog("\"usuarios\":[", Color.BLACK, Color.WHITE);
        
        JSONArray usuarios = routeAll.getJSONArray("usuarios");
        for(int i = 0; i < usuarios.length(); i++){
            org.json.JSONObject user = usuarios.getJSONObject(i);
             includeLog(i==0 ? "" + user.toString() : "," + user.toString(), Color.BLACK,  Color.WHITE);
        }
        
        logUsers = !logUsers;
        
        includeLog("]}", Color.BLACK, Color.WHITE);
        
    }
    
    public void includeLogMonitorings(JSONObject routeAll) throws JSONException{
        
        logUsers = !logUsers;

        String route = "{\"rota\":\"" + routeAll.getString("rota") + "\",";
        route += "\"erro\":\"" + routeAll.getString("erro") + "\",";
        
        includeLog("Received <- "+route, Color.BLACK, Color.CYAN );
        
        includeLog("\"monitorias\":[", Color.BLACK, Color.WHITE);
        
        JSONArray monitorias = routeAll.getJSONArray("monitorias");
        for(int i = 0; i < monitorias.length(); i++){
            org.json.JSONObject monitoria = monitorias.getJSONObject(i);
             includeLog(i==0 ? "" + monitoria.toString() : "," + monitoria.toString(), Color.BLACK,  Color.WHITE);
        }
        
        logUsers = !logUsers;
        
        includeLog("]}", Color.BLACK, Color.WHITE);
        
    }
    
    public void includeCliente(String sClient){
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
        
        //pContent.add(client);
        //pContent.repaint();
        //pContent.validate();
        
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
    
}
