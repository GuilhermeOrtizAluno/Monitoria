/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensold3;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Guilherme Ortiz
 */
public class RegisterMonitorScreen extends JPanel {
    
    public JButton bSingUp;
    public JLabel lNome;
    public JLabel lPass;
    public JLabel lTitle;
    public JLabel lUser;
    public JTextField tfName;
    public JTextField tfPass;
    public JTextField tfUser;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Component">                          
    public void initComponents() {

        lTitle = new javax.swing.JLabel();
        lUser = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        lPass = new javax.swing.JLabel();
        tfPass = new javax.swing.JTextField();
        bSingUp = new javax.swing.JButton();
        tfName = new javax.swing.JTextField();
        lNome = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setSize(230, 300);

        lTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lTitle.setForeground(new java.awt.Color(204, 204, 204));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Cadastro Monitor");

        lUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lUser.setText("Usuario");

        tfUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lPass.setText("Senha");

        tfPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPass.setToolTipText("");
        tfPass.setPreferredSize(new java.awt.Dimension(60, 23));

        bSingUp.setBackground(new java.awt.Color(204, 0, 204));
        bSingUp.setText("Cadastrar");

        tfName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lNome.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSingUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPass)
                            .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNome)
                            .addComponent(lUser))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(bSingUp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>                                                              
                  
}