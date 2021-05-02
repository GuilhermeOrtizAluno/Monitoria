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
public class ConnectionScreen extends javax.swing.JPanel {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTitle = new javax.swing.JLabel();
        lIP = new javax.swing.JLabel();
        tfIP = new javax.swing.JTextField();
        lPass = new javax.swing.JLabel();
        tfPort = new javax.swing.JTextField();
        bConnection = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(230, 270));
        setMinimumSize(new java.awt.Dimension(230, 270));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(230, 270));

        lTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lTitle.setForeground(new java.awt.Color(204, 204, 204));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Conectar com Servidor");

        lIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lIP.setText("IP");

        tfIP.setEditable(false);
        tfIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfIP.setForeground(new java.awt.Color(204, 204, 204));
        tfIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfIP.setText("localhost");
        tfIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIPActionPerformed(evt);
            }
        });

        lPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lPass.setText("Porta");

        tfPort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPort.setToolTipText("");
        tfPort.setPreferredSize(new java.awt.Dimension(60, 23));

        bConnection.setBackground(new java.awt.Color(204, 0, 204));
        bConnection.setText("Conectar");
        bConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConnectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lPass, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lIP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPort, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bConnection, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lIP)
                .addGap(3, 3, 3)
                .addComponent(tfIP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(bConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void bConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConnectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bConnectionActionPerformed

    private void tfIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bConnection;
    public javax.swing.JLabel lIP;
    public javax.swing.JLabel lPass;
    public javax.swing.JLabel lTitle;
    public javax.swing.JTextField tfIP;
    public javax.swing.JTextField tfPort;
    // End of variables declaration//GEN-END:variables
}
