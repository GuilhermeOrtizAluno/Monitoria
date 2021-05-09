package screens;

/**
 *
 * @author Guilherme Ortiz
 */
public class MenuAdminScreen extends javax.swing.JPanel {

    private javax.swing.JButton bMonitor;
    private javax.swing.JButton bMonitoria;  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

        bMonitor = new javax.swing.JButton();
        bMonitoria = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 0, 204));

        bMonitor.setText("Monitor");

        bMonitoria.setText("Monitoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bMonitoria, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(bMonitor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bMonitoria)
                .addContainerGap(220, Short.MAX_VALUE))
        );
    }// </editor-fold>                        
                               
}
