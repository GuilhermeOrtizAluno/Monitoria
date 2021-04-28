/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Guilherme Ortiz
 */
public class Log extends javax.swing.JFrame {

    private JLabel lTitle;
    public JPanel pContent;
    private JPanel pLog;
    private JPanel pServer;
    private JPanel pTitle;
    private JScrollPane spLog;
    
    /**
     * Creates new form Log1
     */
    public Log() {
        initComponents();
    }

    public JPanel getpContent() {
        return pContent;
    }

    public void setpContent(JPanel pContent) {
        this.pContent = pContent;
    }

    public JPanel getpLog() {
        return pLog;
    }

    public void setpLog(JPanel pLog) {
        this.pLog = pLog;
    }

    public JScrollPane getSpLog() {
        return spLog;
    }

    public void setSpLog(JScrollPane spLog) {
        this.spLog = spLog;
    }
    
    
    @SuppressWarnings("unchecked")                       
    private void initComponents() {
        
        //Title
        lTitle = new JLabel("Server");
        lTitle.setFont(new Font("MV Boli", 1, 24)); // NOI18N
        lTitle.setForeground(new Color(255, 255, 255));
        lTitle.setSize(300, 500);
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
       
        //Panel Title
        pTitle = new JPanel();
        pTitle.setBackground(new Color(204, 0, 204));
        pTitle.setSize(new Dimension(500, 200));
        pTitle.add(lTitle);
        
        //Screens
        pContent = new JPanel();
        pContent.setBackground(new Color(255, 255, 255));
        
        //Panel Log
        pLog = new JPanel();
        pLog.setBackground(new Color(204, 0, 204));
        
        //ScrollPane Log
        spLog = new JScrollPane();
        spLog.setBackground(new Color(204, 0, 204));
        spLog.setViewportView(pLog);

        //Panel Main
        pServer = new JPanel();
        pServer.setBackground(new Color(255, 255, 255));
        pServer.add(pTitle, BorderLayout.PAGE_START);
        pServer.add(pContent, BorderLayout.LINE_START);
        pServer.add(pTitle, BorderLayout.CENTER);
        
        //JFrame
        setContentPane(pServer);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }// </editor-fold>                        

    public void main() {
        
        ServerConection serverConection = new ServerConection();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log().setVisible(true);
            }
        });
    }
               
}
