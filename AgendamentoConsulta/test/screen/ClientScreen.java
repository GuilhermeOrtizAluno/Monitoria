/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

/**
 *
 * @author Guilherme Ortiz
 */
public class ClientScreen extends javax.swing.JFrame {

    /**
     * Creates new form ClientScreen
     */
    public ClientScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pClient = new javax.swing.JPanel();
        pHeader = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        pExit = new javax.swing.JPanel();
        pContent = new javax.swing.JPanel();
        pcLeft = new javax.swing.JPanel();
        pcRight = new javax.swing.JPanel();
        pcCenter = new javax.swing.JPanel();
        spLog = new javax.swing.JScrollPane();
        pLog = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));

        pClient.setBackground(new java.awt.Color(255, 255, 255));
        pClient.setMinimumSize(new java.awt.Dimension(900, 600));
        pClient.setPreferredSize(new java.awt.Dimension(900, 600));
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
            .addGap(0, 70, Short.MAX_VALUE)
        );

        pHeader.add(pExit, java.awt.BorderLayout.LINE_END);

        pClient.add(pHeader, java.awt.BorderLayout.PAGE_START);

        pContent.setBackground(new java.awt.Color(255, 255, 255));
        pContent.setLayout(new java.awt.BorderLayout());

        pcLeft.setBackground(new java.awt.Color(255, 255, 255));
        pcLeft.setMinimumSize(new java.awt.Dimension(299, 330));
        pcLeft.setPreferredSize(new java.awt.Dimension(299, 330));

        javax.swing.GroupLayout pcLeftLayout = new javax.swing.GroupLayout(pcLeft);
        pcLeft.setLayout(pcLeftLayout);
        pcLeftLayout.setHorizontalGroup(
            pcLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        pcLeftLayout.setVerticalGroup(
            pcLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        pContent.add(pcLeft, java.awt.BorderLayout.LINE_START);

        pcRight.setBackground(new java.awt.Color(255, 255, 255));
        pcRight.setMinimumSize(new java.awt.Dimension(299, 330));
        pcRight.setPreferredSize(new java.awt.Dimension(299, 330));

        javax.swing.GroupLayout pcRightLayout = new javax.swing.GroupLayout(pcRight);
        pcRight.setLayout(pcRightLayout);
        pcRightLayout.setHorizontalGroup(
            pcRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        pcRightLayout.setVerticalGroup(
            pcRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        pContent.add(pcRight, java.awt.BorderLayout.LINE_END);

        pcCenter.setBackground(new java.awt.Color(255, 255, 255));
        pcCenter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pcCenter.setMinimumSize(new java.awt.Dimension(299, 330));
        pcCenter.setPreferredSize(new java.awt.Dimension(299, 330));

        javax.swing.GroupLayout pcCenterLayout = new javax.swing.GroupLayout(pcCenter);
        pcCenter.setLayout(pcCenterLayout);
        pcCenterLayout.setHorizontalGroup(
            pcCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );
        pcCenterLayout.setVerticalGroup(
            pcCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        pContent.add(pcCenter, java.awt.BorderLayout.CENTER);

        pClient.add(pContent, java.awt.BorderLayout.CENTER);

        spLog.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spLog.setMinimumSize(new java.awt.Dimension(900, 200));
        spLog.setName(""); // NOI18N
        spLog.setPreferredSize(new java.awt.Dimension(900, 200));
        spLog.setRequestFocusEnabled(false);

        pLog.setBackground(new java.awt.Color(204, 0, 204));

        javax.swing.GroupLayout pLogLayout = new javax.swing.GroupLayout(pLog);
        pLog.setLayout(pLogLayout);
        pLogLayout.setHorizontalGroup(
            pLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        pLogLayout.setVerticalGroup(
            pLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        spLog.setViewportView(pLog);

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lTitle;
    public javax.swing.JPanel pClient;
    public javax.swing.JPanel pContent;
    public javax.swing.JPanel pExit;
    public javax.swing.JPanel pHeader;
    public javax.swing.JPanel pLog;
    public javax.swing.JPanel pcCenter;
    public javax.swing.JPanel pcLeft;
    public javax.swing.JPanel pcRight;
    public javax.swing.JScrollPane spLog;
    // End of variables declaration//GEN-END:variables
}
