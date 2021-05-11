package screens;

import javax.swing.JCheckBox;

/**
 *
 * @author Guilherme Ortiz
 */
public class ClientScreen extends javax.swing.JFrame {

    public javax.swing.JButton bClose;
    public javax.swing.JButton bMaximize;
    public javax.swing.JButton bMinimize;
    public javax.swing.JPanel pContentAll;
    private javax.swing.JPanel pControllerPage;
    public JCheckBox cbLog;
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

        pContentAll = new javax.swing.JPanel();
        pControllerPage = new javax.swing.JPanel();
        bClose = new javax.swing.JButton();
        bMaximize = new javax.swing.JButton();
        bMinimize = new javax.swing.JButton();
        cbLog = new JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 680));
        setMinimumSize(new java.awt.Dimension(900, 500));
        setUndecorated(true);

        pContentAll.setMaximumSize(new java.awt.Dimension(900, 680));
        pContentAll.setMinimumSize(new java.awt.Dimension(900, 500));
        pContentAll.setPreferredSize(new java.awt.Dimension(900, 500));
        pContentAll.setLayout(new java.awt.BorderLayout());
        pContentAll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pControllerPage.setBackground(new java.awt.Color(255, 255, 255));
        pControllerPage.setPreferredSize(new java.awt.Dimension(900, 30));
        pControllerPage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bClose.setText("X");

        bMaximize.setText("[]");

        bMinimize.setText("-");
        
        cbLog.setText("Log");

        javax.swing.GroupLayout pControllerPageLayout = new javax.swing.GroupLayout(pControllerPage);
        pControllerPage.setLayout(pControllerPageLayout);
        pControllerPageLayout.setHorizontalGroup(
            pControllerPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pControllerPageLayout.createSequentialGroup()
                .addContainerGap(761, Short.MAX_VALUE)
                .addComponent(cbLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bMaximize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bClose)
                .addContainerGap())
        );
        pControllerPageLayout.setVerticalGroup(
            pControllerPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pControllerPageLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(pControllerPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bClose)
                    .addComponent(bMaximize)
                    .addComponent(bMinimize)
                    .addComponent(cbLog)))
        );

        pContentAll.add(pControllerPage, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pContentAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pContentAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setTitle("Client");
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        y
}
