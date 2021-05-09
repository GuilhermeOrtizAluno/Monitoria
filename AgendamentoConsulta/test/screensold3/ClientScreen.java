/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensold3;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Guilherme Ortiz
 */
public class ClientScreen extends JFrame {
    
    public JLabel lTitle;
    public JPanel pClient;
    public JPanel pContent;
    public JPanel pExit;
    public JPanel pHeader;
    public JPanel pLog;
    public JPanel pContentLog;
    public JPanel pcCenter;
    public JPanel pcLeft;
    public JPanel pcRight;
    public JScrollPane spLog;
    public JButton bExit;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {
        
        pClient = new javax.swing.JPanel();
        pHeader = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        pExit = new javax.swing.JPanel();
        pContent = new javax.swing.JPanel();
        pcLeft = new javax.swing.JPanel();
        pcRight = new javax.swing.JPanel();
        pcCenter = new javax.swing.JPanel();
        spLog = new javax.swing.JScrollPane();
        bExit = new JButton();
        pLog = new javax.swing.JPanel();
        pContentLog = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        
        bExit.setText("Sair");
        bExit.setBackground(Color.WHITE);
        bExit.setSize(70, 30);

        pClient.setBackground(new java.awt.Color(255, 255, 255));
        pClient.setMinimumSize(new java.awt.Dimension(900, 700));
        pClient.setPreferredSize(new java.awt.Dimension(900, 700));
        pClient.setLayout(new java.awt.BorderLayout());

        pHeader.setBackground(new java.awt.Color(204, 0, 204));
        pHeader.setMinimumSize(new java.awt.Dimension(900, 70));
        pHeader.setPreferredSize(new java.awt.Dimension(900, 70));
        pHeader.setLayout(new java.awt.BorderLayout());

        lTitle.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        lTitle.setForeground(new java.awt.Color(255, 255, 255));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Client");
        pHeader.add(lTitle, java.awt.BorderLayout.CENTER);

        pExit.setBackground(new java.awt.Color(204, 0, 204));

        javax.swing.GroupLayout pExitLayout = new javax.swing.GroupLayout(pExit);
        pExit.setLayout(pExitLayout);
        pExitLayout.setHorizontalGroup(
            pExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pExitLayout.setVerticalGroup(
            pExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pHeader.add(pExit, java.awt.BorderLayout.LINE_END);

        pClient.add(pHeader, java.awt.BorderLayout.PAGE_START);

        pContent.setBackground(new java.awt.Color(255, 255, 255));
        pContent.setLayout(new java.awt.BorderLayout());

        pcLeft.setBackground(new java.awt.Color(255, 255, 255));
        pcLeft.setMinimumSize(new java.awt.Dimension(299, 400));
        pcLeft.setPreferredSize(new java.awt.Dimension(299, 400));

        javax.swing.GroupLayout pcLeftLayout = new javax.swing.GroupLayout(pcLeft);
        pcLeft.setLayout(pcLeftLayout);
        pcLeftLayout.setHorizontalGroup(
            pcLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        pcLeftLayout.setVerticalGroup(
            pcLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pContent.add(pcLeft, java.awt.BorderLayout.LINE_START);

        pcRight.setBackground(new java.awt.Color(255, 255, 255));
        pcRight.setMinimumSize(new java.awt.Dimension(299, 400));
        pcRight.setPreferredSize(new java.awt.Dimension(299, 400));

        javax.swing.GroupLayout pcRightLayout = new javax.swing.GroupLayout(pcRight);
        pcRight.setLayout(pcRightLayout);
        pcRightLayout.setHorizontalGroup(
            pcRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        pcRightLayout.setVerticalGroup(
            pcRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pContent.add(pcRight, java.awt.BorderLayout.LINE_END);

        pcCenter.setBackground(new java.awt.Color(255, 255, 255));
        pcCenter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pcCenter.setMinimumSize(new java.awt.Dimension(299, 400));
        pcCenter.setPreferredSize(new java.awt.Dimension(299, 400));

        javax.swing.GroupLayout pcCenterLayout = new javax.swing.GroupLayout(pcCenter);
        pcCenter.setLayout(pcCenterLayout);
        pcCenterLayout.setHorizontalGroup(
            pcCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );
        pcCenterLayout.setVerticalGroup(
            pcCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pContent.add(pcCenter, java.awt.BorderLayout.CENTER);
        pClient.add(pContent, java.awt.BorderLayout.CENTER);

        pLog.setBackground(new java.awt.Color(204, 0, 204));
        pLog.setBorder(new EmptyBorder(10, 10, 10, 10));
        pLog.setLayout(new BoxLayout(pLog, BoxLayout.Y_AXIS));
        
        pContentLog.setBackground(new java.awt.Color(204, 0, 204));
        pContentLog.add(pLog);

        /*javax.swing.GroupLayout pLog1Layout = new javax.swing.GroupLayout(pLog);
        pLog.setLayout(pLog1Layout);
        pLog1Layout.setHorizontalGroup(
            pLog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        pLog1Layout.setVerticalGroup(
            pLog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );*/

        spLog.setMinimumSize(null);
        spLog.setName(""); // NOI18N
        spLog.setRequestFocusEnabled(false);
        spLog.setViewportView(pContentLog);
        spLog.setMinimumSize(new java.awt.Dimension(900, 200));
        spLog.setPreferredSize(new java.awt.Dimension(900, 200));


        pClient.add(spLog, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setTitle("Client");
        pack();
        setLocationRelativeTo(null);

    }// </editor-fold>                        
                    
}