package screens;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Guilherme Ortiz
 */
public class LoginRegisterScreen extends JPanel{
    public javax.swing.JButton bLogin;
    public javax.swing.JButton bRegister;
    private javax.swing.JLabel lTitle;
    private javax.swing.JLabel lTitle1;
    public javax.swing.JPanel pLoginRegister;
    private javax.swing.JPanel pLogin;
    private javax.swing.JPanel pRegister;
    public javax.swing.JTextField tfName;
    public javax.swing.JTextField tfPass;
    public javax.swing.JTextField tfPassword;
    public javax.swing.JTextField tfUser;
    public javax.swing.JTextField tfUsername;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

        pLoginRegister = new javax.swing.JPanel();
        pRegister = new javax.swing.JPanel();
        tfPass = new javax.swing.JTextField();
        tfUser = new javax.swing.JTextField();
        lTitle1 = new javax.swing.JLabel();
        bRegister = new javax.swing.JButton();
        tfName = new javax.swing.JTextField();
        pLogin = new javax.swing.JPanel();
        bLogin = new javax.swing.JButton();
        tfUsername = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        lTitle = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(900, 470));
        setMinimumSize(new java.awt.Dimension(900, 470));

        pLoginRegister.setMaximumSize(new java.awt.Dimension(900, 470));
        pLoginRegister.setMinimumSize(new java.awt.Dimension(900, 470));
        pLoginRegister.setPreferredSize(new java.awt.Dimension(900, 470));
        pLoginRegister.setLayout(new java.awt.BorderLayout());

        pRegister.setBackground(new java.awt.Color(255, 255, 255));
        pRegister.setMaximumSize(new java.awt.Dimension(450, 470));
        pRegister.setMinimumSize(new java.awt.Dimension(450, 470));
        pRegister.setPreferredSize(new java.awt.Dimension(450, 470));

        tfPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPass.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));

        tfUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfUser.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        lTitle1.setBackground(new java.awt.Color(255, 255, 255));
        lTitle1.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        lTitle1.setForeground(new java.awt.Color(204, 0, 204));
        lTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle1.setText("Cadastrar");
        lTitle1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bRegister.setBackground(new java.awt.Color(204, 0, 204));
        bRegister.setForeground(new java.awt.Color(255, 255, 255));
        bRegister.setText("Cadastar");

        tfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfName.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        javax.swing.GroupLayout pRegisterLayout = new javax.swing.GroupLayout(pRegister);
        pRegister.setLayout(pRegisterLayout);
        pRegisterLayout.setHorizontalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegisterLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfPass, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tfName)
                        .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pRegisterLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lTitle1)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        pRegisterLayout.setVerticalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegisterLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(lTitle1)
                .addGap(18, 18, 18)
                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bRegister)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pLoginRegister.add(pRegister, java.awt.BorderLayout.LINE_END);

        pLogin.setBackground(new java.awt.Color(204, 0, 204));
        pLogin.setMaximumSize(new java.awt.Dimension(450, 470));
        pLogin.setMinimumSize(new java.awt.Dimension(450, 470));

        bLogin.setBackground(new java.awt.Color(255, 255, 255));
        bLogin.setForeground(new java.awt.Color(204, 0, 204));
        bLogin.setText("Entrar");

        tfUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfUsername.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));
        tfUsername.setBackground(new Color(204, 0, 204));

        tfPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPassword.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));
        tfPassword.setBackground(new Color(204, 0, 204));

        lTitle.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        lTitle.setForeground(new java.awt.Color(255, 255, 255));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Entrar");
        lTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pLoginLayout = new javax.swing.GroupLayout(pLogin);
        pLogin.setLayout(pLoginLayout);
        pLoginLayout.setHorizontalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLoginLayout.createSequentialGroup()
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(lTitle))
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfPassword)
                                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        pLoginLayout.setVerticalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLoginLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(lTitle)
                .addGap(18, 18, 18)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bLogin)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        pLoginRegister.add(pLogin, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pLoginRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pLoginRegister, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>       
}
