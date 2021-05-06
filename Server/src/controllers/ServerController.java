package controllers;

import static app.Program.*;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import screens.ServerScreen;

/**
 *
 * @author Guilherme Ortiz Santos
 */
public class ServerController extends ServerScreen {
    
    private JLabel lLog;
    private JPanel pType;
    private JPanel log;
    private int yLog, x;
    private boolean logUsers;
    
    public void start() {
        initComponents();
        setVisible(true);
        pContent.add(connectionController);
        yLog = 5;
        x = 5;
        logUsers = false;
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
        //log.setMinimumSize(new Dimension(600, 35));
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
        
        spLog.repaint();
        spLog.validate();
        spLog.revalidate();
    }   
    
    public void includeLogUsers(JSONObject routeAll, boolean broadcast) throws JSONException{
        
        logUsers = !logUsers;

        String route = "{\"rota\":\"" + routeAll.getString("rota") + "\",";
        if(!broadcast) route += "\"erro\":\"" + routeAll.getString("erro") + "\",";
        
        includeLog("Send -> "+route, Color.BLACK, !broadcast ? Color.BLUE : Color.PINK);
        
        includeLog("\"usuarios\":[", Color.BLACK, Color.WHITE);
        
        JSONArray usuarios = routeAll.getJSONArray("usuarios");
        for(int i = 0; i < usuarios.length(); i++){
            JSONObject user = usuarios.getJSONObject(i);
             includeLog(i==0 ? "" + user.toString() : "," + user.toString(), Color.BLACK,  Color.WHITE);
        }
        
         logUsers = !logUsers;
        
        includeLog("]}", Color.BLACK, Color.WHITE);
        
    }
    
}
