/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
    private GridLayout glLog;
    private JPanel log;
    private JLabel lLog;
   
    public void startLog(){
        glLog = new GridLayout(0,2);
        glLog.setHgap(10);
        glLog.setVgap(10);
        
        pLog  = new JPanel();
        pLog.setSize(400, 35);
        pLog.setBorder(new EmptyBorder(10, 10, 10, 10));
        pLog.setLayout(glLog);
        pLog.setBackground(Color.decode("#c91dd8"));
        
        ReceivedSend("Received");
        ReceivedSend("Send");
        
        spLog = new JScrollPane(pLog);
        spLog.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spLog.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        jfLog = new JFrame("Log Server");
        jfLog.setSize(900, 400);
        jfLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfLog.setContentPane(spLog);
        jfLog.setVisible(true); 
    }
    
    public void ReceivedSend(String type){
        lLog = new JLabel();
        lLog.setText(type);
        lLog.setForeground(Color.white);
        lLog.setFont(new Font(null, Font.BOLD,20));
                
        log = new JPanel();
        log.setBackground(Color.decode("#c91dd8"));
        log.add(lLog);
        
        pLog.add(log);
    }
    
    public void includeLog(String sLog){
        lLog = new JLabel();
        lLog.setText(sLog);
                
        log = new JPanel();
        log.setBorder(new LineBorder(Color.white, 5, true));
        //log.setSize(400,35);
        log.setBackground(Color.WHITE);
        log.add(lLog);
        
        pLog.add(log);
        pLog.repaint();
        pLog.validate();
        
        spLog.revalidate();
    }
}
