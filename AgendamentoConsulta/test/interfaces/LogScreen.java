/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Guilherme Ortiz
 */
public class LogScreen extends javax.swing.JPanel {

    /**
     * Creates new form LogScreen
     */
    public LogScreen() {
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

        spLog = new javax.swing.JScrollPane();
        pLog = new javax.swing.JPanel();

        spLog.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spLog.setMinimumSize(null);
        spLog.setName(""); // NOI18N
        spLog.setPreferredSize(new java.awt.Dimension(901, 230));
        spLog.setRequestFocusEnabled(false);

        pLog.setBackground(new java.awt.Color(204, 0, 204));
        pLog.setPreferredSize(new java.awt.Dimension(898, 225));

        javax.swing.GroupLayout pLogLayout = new javax.swing.GroupLayout(pLog);
        pLog.setLayout(pLogLayout);
        pLogLayout.setHorizontalGroup(
            pLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        pLogLayout.setVerticalGroup(
            pLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );

        spLog.setViewportView(pLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spLog, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spLog, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel pLog;
    public javax.swing.JScrollPane spLog;
    // End of variables declaration//GEN-END:variables
}