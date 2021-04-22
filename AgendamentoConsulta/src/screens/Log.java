/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author gui_o
 */
public class Log {
    private JFrame jfLog;
    private JScrollPane spLog;
    private JPanel pLog;
    private JPanel log;
    private JLabel lLog;
   
    public void startLog(){
        
        pLog  = new JPanel();
        //pLog.setSize(400, 35);
        pLog.setBorder(new EmptyBorder(10, 10, 10, 10));
        pLog.setLayout(new BoxLayout(pLog, BoxLayout.Y_AXIS));
        pLog.setBackground(Color.decode("#c91dd8"));
        
        spLog = new JScrollPane(pLog);
        spLog.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spLog.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        jfLog = new JFrame("Log Client");
        jfLog.setLayout(null);
        jfLog.setSize(900, 400);
        jfLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfLog.setContentPane(spLog);
        jfLog.setVisible(true); 
    }
    
    private void ReceivedSend(String type){
        lLog = new JLabel();
        lLog.setText(type);
        lLog.setForeground(Color.white);
        lLog.setFont(new Font(null, Font.BOLD,20));
                
        log = new JPanel();
        log.setBackground(Color.decode("#c91dd8"));
        log.add(lLog);
        
        pLog.add(log);
    }
    
    public void includeLog(String sLog, Color cLog){
        lLog = new JLabel();
        lLog.setText(sLog);
                
        log = new JPanel();
        log.setBorder(new LineBorder(cLog, 5, true));
        log.setSize(400,35);
        log.setBorder(new EmptyBorder(10, 10, 10, 10));
        log.setBackground(cLog);
        log.add(lLog);
        
        pLog.add(log);
        pLog.repaint();
        pLog.validate();
        
        spLog.revalidate();
    }
    
    // Shows what will be sent
    public void showSend(String Send) throws IOException{
        //Terminal
        System.out.println("Send -> "+Send);
        
        //Iterface Log
        includeLog("Send -> "+Send, Color.ORANGE);
        
    }
    
    //Shows what came
    public void showReceived(String received) throws IOException{
         //Terminal
        System.out.println("Received <- "+received);
        
        //Iterface Log
        includeLog("Received <- "+received, Color.cyan);
        
    }
}
