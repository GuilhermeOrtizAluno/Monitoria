package screens;

/**
 *
 * @author Guilherme Ortiz
 */
public class StudentManagementScreen extends javax.swing.JPanel {
    
    public javax.swing.JButton bRegister;
    public javax.swing.JButton bUpdate;
    public javax.swing.JComboBox<String> cbMonitoring;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lTitle;
    private javax.swing.JPanel pContent;
    private javax.swing.JPanel pContentMonitoring;
    private javax.swing.JPanel pContentRegister;
    private javax.swing.JPanel pTitle;
    private javax.swing.JPanel pUpdate;
    private javax.swing.JPanel pUpdate1;
    public javax.swing.JTextField tfPass;
    private javax.swing.JLabel ulName;
    private javax.swing.JLabel ulPass;
    private javax.swing.JLabel ulTitle;
    private javax.swing.JLabel ulTitle1;
    private javax.swing.JLabel ulUser;
    public javax.swing.JTextField utfName;
    public javax.swing.JTextField utfPass;
    public javax.swing.JTextField utfUser;
    public javax.swing.JButton bDelete;
    public javax.swing.JComboBox<String> dcbMonitoring;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pContentDelete;
    private javax.swing.JPanel pUpdate2;
    private javax.swing.JLabel ulTitle2;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {

        pTitle = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        pContent = new javax.swing.JPanel();
        pContentRegister = new javax.swing.JPanel();
        pUpdate = new javax.swing.JPanel();
        ulTitle = new javax.swing.JLabel();
        ulName = new javax.swing.JLabel();
        utfName = new javax.swing.JTextField();
        ulUser = new javax.swing.JLabel();
        utfUser = new javax.swing.JTextField();
        ulPass = new javax.swing.JLabel();
        utfPass = new javax.swing.JTextField();
        bUpdate = new javax.swing.JButton();
        pContentMonitoring = new javax.swing.JPanel();
        pUpdate1 = new javax.swing.JPanel();
        ulTitle1 = new javax.swing.JLabel();
        bRegister = new javax.swing.JButton();
        cbMonitoring = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPass = new javax.swing.JTextField();
        pContentDelete = new javax.swing.JPanel();
        pUpdate2 = new javax.swing.JPanel();
        ulTitle2 = new javax.swing.JLabel();
        bDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        dcbMonitoring = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(750, 470));
        setPreferredSize(new java.awt.Dimension(750, 470));
        setLayout(new java.awt.BorderLayout());

        pTitle.setBackground(new java.awt.Color(255, 255, 255));
        pTitle.setPreferredSize(new java.awt.Dimension(750, 40));

        lTitle.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Gerenciamento de Aluno");

        javax.swing.GroupLayout pTitleLayout = new javax.swing.GroupLayout(pTitle);
        pTitle.setLayout(pTitleLayout);
        pTitleLayout.setHorizontalGroup(
            pTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        pTitleLayout.setVerticalGroup(
            pTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(pTitle, java.awt.BorderLayout.PAGE_START);

        pContent.setLayout(new javax.swing.BoxLayout(pContent, javax.swing.BoxLayout.LINE_AXIS));

        pContentRegister.setBackground(new java.awt.Color(255, 255, 255));
        pContentRegister.setMinimumSize(new java.awt.Dimension(250, 430));
        pContentRegister.setPreferredSize(new java.awt.Dimension(250, 430));

        pUpdate.setBackground(new java.awt.Color(255, 255, 255));
        pUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pUpdate.setMaximumSize(new java.awt.Dimension(230, 300));
        pUpdate.setMinimumSize(new java.awt.Dimension(230, 300));

        ulTitle.setBackground(new java.awt.Color(255, 255, 255));
        ulTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ulTitle.setForeground(new java.awt.Color(204, 204, 204));
        ulTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulTitle.setText("Gerenciar");

        ulName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ulName.setText("Nome");

        utfName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        utfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ulUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ulUser.setText("Usuario");

        utfUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        utfUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ulPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ulPass.setText("Senha");

        utfPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        utfPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        utfPass.setToolTipText("");
        utfPass.setPreferredSize(new java.awt.Dimension(60, 23));

        bUpdate.setBackground(new java.awt.Color(204, 0, 204));
        bUpdate.setText("Editar");

        javax.swing.GroupLayout pUpdateLayout = new javax.swing.GroupLayout(pUpdate);
        pUpdate.setLayout(pUpdateLayout);
        pUpdateLayout.setHorizontalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(utfName)
                    .addComponent(ulUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ulName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ulPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ulTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pUpdateLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(utfUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(utfPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pUpdateLayout.setVerticalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ulTitle)
                .addGap(18, 18, 18)
                .addComponent(ulName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utfName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ulUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ulPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pContentRegisterLayout = new javax.swing.GroupLayout(pContentRegister);
        pContentRegister.setLayout(pContentRegisterLayout);
        pContentRegisterLayout.setHorizontalGroup(
            pContentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContentRegisterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        pContentRegisterLayout.setVerticalGroup(
            pContentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentRegisterLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(pUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pContent.add(pContentRegister);

        pContentMonitoring.setBackground(new java.awt.Color(255, 255, 255));
        pContentMonitoring.setMinimumSize(new java.awt.Dimension(250, 430));
        pContentMonitoring.setPreferredSize(new java.awt.Dimension(250, 430));

        pUpdate1.setBackground(new java.awt.Color(255, 255, 255));
        pUpdate1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pUpdate1.setMaximumSize(null);

        ulTitle1.setBackground(new java.awt.Color(255, 255, 255));
        ulTitle1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ulTitle1.setForeground(new java.awt.Color(204, 204, 204));
        ulTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulTitle1.setText("Monitoria");

        bRegister.setBackground(new java.awt.Color(204, 0, 204));
        bRegister.setText("Inscrever-se");

        cbMonitoring.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbMonitoring.setBorder(null);

        jLabel4.setText("Monitoria");

        jLabel5.setText("Senha");

        tfPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pUpdate1Layout = new javax.swing.GroupLayout(pUpdate1);
        pUpdate1.setLayout(pUpdate1Layout);
        pUpdate1Layout.setHorizontalGroup(
            pUpdate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdate1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUpdate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pUpdate1Layout.createSequentialGroup()
                        .addGroup(pUpdate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bRegister, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMonitoring, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ulTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(tfPass))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pUpdate1Layout.setVerticalGroup(
            pUpdate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdate1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ulTitle1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMonitoring, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(bRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout pContentMonitoringLayout = new javax.swing.GroupLayout(pContentMonitoring);
        pContentMonitoring.setLayout(pContentMonitoringLayout);
        pContentMonitoringLayout.setHorizontalGroup(
            pContentMonitoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContentMonitoringLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(pUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        pContentMonitoringLayout.setVerticalGroup(
            pContentMonitoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentMonitoringLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(pUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pContent.add(pContentMonitoring);
        
        pContentDelete.setBackground(new java.awt.Color(255, 255, 255));
        pContentDelete.setMinimumSize(new java.awt.Dimension(250, 430));

        pUpdate2.setBackground(new java.awt.Color(255, 255, 255));
        pUpdate2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pUpdate2.setMaximumSize(new java.awt.Dimension(230, 300));
        pUpdate2.setMinimumSize(new java.awt.Dimension(230, 300));

        ulTitle2.setBackground(new java.awt.Color(255, 255, 255));
        ulTitle2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ulTitle2.setForeground(new java.awt.Color(204, 204, 204));
        ulTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulTitle2.setText("Cancelar Monitoria");

        bDelete.setBackground(new java.awt.Color(204, 0, 204));
        bDelete.setText("Desinscrever-se");

        jLabel6.setText("Monitoria");

        dcbMonitoring.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dcbMonitoring.setBorder(null);

        javax.swing.GroupLayout pUpdate2Layout = new javax.swing.GroupLayout(pUpdate2);
        pUpdate2.setLayout(pUpdate2Layout);
        pUpdate2Layout.setHorizontalGroup(
            pUpdate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdate2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUpdate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ulTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(dcbMonitoring, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pUpdate2Layout.setVerticalGroup(
            pUpdate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdate2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ulTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcbMonitoring, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pContentDeleteLayout = new javax.swing.GroupLayout(pContentDelete);
        pContentDelete.setLayout(pContentDeleteLayout);
        pContentDeleteLayout.setHorizontalGroup(
            pContentDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pUpdate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pContentDeleteLayout.setVerticalGroup(
            pContentDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContentDeleteLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(pUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );

        pContent.add(pContentDelete);

        add(pContent, java.awt.BorderLayout.CENTER);
    }// </editor-fold>                                                           
               
}
