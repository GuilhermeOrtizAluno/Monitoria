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
public class LoginScreen extends JPanel {
    
    public JButton bRegister;
    public JButton bSingIn;
    public JLabel lPass;
    public JLabel lRegister;
    public JLabel lTitle;
    public JLabel lUser;
    public JTextField tfPass;
    public JTextField tfUser;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

        lTitle = new javax.swing.JLabel();
        lUser = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        lPass = new javax.swing.JLabel();
        tfPass = new javax.swing.JTextField();
        bSingIn = new javax.swing.JButton();
        lRegister = new javax.swing.JLabel();
        bRegister = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(230, 300));
        setMinimumSize(new java.awt.Dimension(230, 300));
        setPreferredSize(new  java.awt.Dimension(230, 300));
        setSize(330, 300);
        setName(""); // NOI18N

        lTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lTitle.setForeground(new java.awt.Color(204, 204, 204));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Login");

        lUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lUser.setText("Usuario");

        tfUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPass.setToolTipText("Usuario");
        tfPass.setPreferredSize(new java.awt.Dimension(60, 23));

        lPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lPass.setText("Senha");

        tfPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPass.setToolTipText("Senha");
        tfPass.setPreferredSize(new java.awt.Dimension(60, 23));

        bSingIn.setBackground(new java.awt.Color(204, 0, 204));
        bSingIn.setForeground(new java.awt.Color(255, 255, 255));
        bSingIn.setText("Entrar");

        lRegister.setText("Não tem uma conta? ");

        bRegister.setBackground(new java.awt.Color(204, 0, 204));
        bRegister.setForeground(new java.awt.Color(0, 204, 204));
        bRegister.setText("Cadastre-se");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lRegister)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bRegister))
                            .addComponent(lPass, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bSingIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lUser)
                .addGap(3, 3, 3)
                .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(bSingIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bRegister)
                        .addComponent(lRegister)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>                        
                 
}