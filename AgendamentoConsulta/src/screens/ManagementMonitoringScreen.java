package screens;

/**
 *
 * @author Guilherme Ortiz Santos
 */
public class ManagementMonitoringScreen extends javax.swing.JPanel {

    public javax.swing.JButton bDelete;
    public javax.swing.JButton bRegister;
    public javax.swing.JButton bUpdate;
    public javax.swing.JComboBox<String> cbMonitor;
    public javax.swing.JComboBox<String> cbMonitoring;
    private javax.swing.JLabel dlTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lTitle;
    private javax.swing.JPanel pContent;
    private javax.swing.JPanel pContentDelete;
    private javax.swing.JPanel pContentRegister;
    private javax.swing.JPanel pContentUpdate;
    private javax.swing.JPanel pDelete;
    public javax.swing.JList pHors;
    private javax.swing.JPanel pMonitors;
    private javax.swing.JPanel pRegister;
    private javax.swing.JPanel pTitle;
    private javax.swing.JPanel pUpdate;
    public javax.swing.JComboBox<String> rcbMonitor;
    public javax.swing.JList rpHors;
    private javax.swing.JScrollPane rspHors;
    public javax.swing.JTextField rtfName;
    public javax.swing.JTextField rtfPass;
    private javax.swing.JScrollPane spHors;
    private javax.swing.JScrollPane spMonitors;
    public javax.swing.JTextField tfName;
    public javax.swing.JTextField tfPass;
    private javax.swing.JLabel ulTitle;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

        pTitle = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        pContent = new javax.swing.JPanel();
        pContentRegister = new javax.swing.JPanel();
        pRegister = new javax.swing.JPanel();
        cbMonitor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        bRegister = new javax.swing.JButton();
        spHors = new javax.swing.JScrollPane();
        pHors = new javax.swing.JList();
        tfPass = new javax.swing.JTextField();
        pContentUpdate = new javax.swing.JPanel();
        pUpdate = new javax.swing.JPanel();
        ulTitle = new javax.swing.JLabel();
        bUpdate = new javax.swing.JButton();
        rcbMonitor = new javax.swing.JComboBox<>();
        rtfName = new javax.swing.JTextField();
        rspHors = new javax.swing.JScrollPane();
        rpHors = new javax.swing.JList();
        rtfPass = new javax.swing.JTextField();
        cbMonitoring = new javax.swing.JComboBox<>();
        pContentDelete = new javax.swing.JPanel();
        pDelete = new javax.swing.JPanel();
        dlTitle = new javax.swing.JLabel();
        bDelete = new javax.swing.JButton();
        spMonitors = new javax.swing.JScrollPane();
        pMonitors = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(750, 470));
        setPreferredSize(new java.awt.Dimension(750, 470));
        setLayout(new java.awt.BorderLayout());

        pTitle.setBackground(new java.awt.Color(255, 255, 255));
        pTitle.setPreferredSize(new java.awt.Dimension(750, 40));

        lTitle.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Gerenciamento de Monitor");

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

        pRegister.setBackground(new java.awt.Color(255, 255, 255));
        pRegister.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbMonitor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbMonitor.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitor"));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Cadastro Monitoria");

        tfName.setBackground(new java.awt.Color(255, 255, 255));
        tfName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfName.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        bRegister.setBackground(new java.awt.Color(204, 0, 204));
        bRegister.setText("Criar");

        spHors.setBackground(new java.awt.Color(255, 255, 255));
        spHors.setBorder(javax.swing.BorderFactory.createTitledBorder("Horarios"));

        pHors.setBackground(new java.awt.Color(255, 255, 255));
        pHors.setPreferredSize(new java.awt.Dimension(102, 90));

        javax.swing.GroupLayout pHorsLayout = new javax.swing.GroupLayout(pHors);
        pHors.setLayout(pHorsLayout);
        pHorsLayout.setHorizontalGroup(
            pHorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        pHorsLayout.setVerticalGroup(
            pHorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        spHors.setViewportView(pHors);

        tfPass.setBackground(new java.awt.Color(255, 255, 255));
        tfPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPass.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));

        javax.swing.GroupLayout pRegisterLayout = new javax.swing.GroupLayout(pRegister);
        pRegister.setLayout(pRegisterLayout);
        pRegisterLayout.setHorizontalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(bRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfName)
                    .addComponent(cbMonitor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spHors)
                    .addComponent(tfPass))
                .addContainerGap())
        );
        pRegisterLayout.setVerticalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spHors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pContentRegisterLayout = new javax.swing.GroupLayout(pContentRegister);
        pContentRegister.setLayout(pContentRegisterLayout);
        pContentRegisterLayout.setHorizontalGroup(
            pContentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContentRegisterLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pContentRegisterLayout.setVerticalGroup(
            pContentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pContent.add(pContentRegister);

        pContentUpdate.setBackground(new java.awt.Color(255, 255, 255));
        pContentUpdate.setMinimumSize(new java.awt.Dimension(250, 430));
        pContentUpdate.setPreferredSize(new java.awt.Dimension(250, 430));

        pUpdate.setBackground(new java.awt.Color(255, 255, 255));
        pUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pUpdate.setMaximumSize(new java.awt.Dimension(230, 300));
        pUpdate.setMinimumSize(new java.awt.Dimension(230, 300));

        ulTitle.setBackground(new java.awt.Color(255, 255, 255));
        ulTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ulTitle.setForeground(new java.awt.Color(204, 204, 204));
        ulTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulTitle.setText("Gerenciar Monitoria");

        bUpdate.setBackground(new java.awt.Color(204, 0, 204));
        bUpdate.setText("Editar");

        rcbMonitor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rcbMonitor.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitor"));

        rtfName.setBackground(new java.awt.Color(255, 255, 255));
        rtfName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rtfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rtfName.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        rspHors.setBackground(new java.awt.Color(255, 255, 255));
        rspHors.setBorder(javax.swing.BorderFactory.createTitledBorder("Horarios"));

        rpHors.setBackground(new java.awt.Color(255, 255, 255));
        rpHors.setPreferredSize(new java.awt.Dimension(102, 50));

        javax.swing.GroupLayout rpHorsLayout = new javax.swing.GroupLayout(rpHors);
        rpHors.setLayout(rpHorsLayout);
        rpHorsLayout.setHorizontalGroup(
            rpHorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        rpHorsLayout.setVerticalGroup(
            rpHorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        rspHors.setViewportView(rpHors);

        rtfPass.setBackground(new java.awt.Color(255, 255, 255));
        rtfPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rtfPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rtfPass.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));

        cbMonitoring.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbMonitoring.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitoria"));

        javax.swing.GroupLayout pUpdateLayout = new javax.swing.GroupLayout(pUpdate);
        pUpdate.setLayout(pUpdateLayout);
        pUpdateLayout.setHorizontalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ulTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rcbMonitor, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rspHors, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rtfPass, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rtfName)
                    .addComponent(cbMonitoring, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pUpdateLayout.setVerticalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ulTitle)
                .addGap(18, 18, 18)
                .addComponent(cbMonitoring, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rcbMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rtfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rspHors, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pContentUpdateLayout = new javax.swing.GroupLayout(pContentUpdate);
        pContentUpdate.setLayout(pContentUpdateLayout);
        pContentUpdateLayout.setHorizontalGroup(
            pContentUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pContentUpdateLayout.setVerticalGroup(
            pContentUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pContent.add(pContentUpdate);

        pContentDelete.setBackground(new java.awt.Color(255, 255, 255));
        pContentDelete.setMinimumSize(new java.awt.Dimension(250, 430));

        pDelete.setBackground(new java.awt.Color(255, 255, 255));
        pDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pDelete.setMaximumSize(new java.awt.Dimension(230, 300));
        pDelete.setMinimumSize(new java.awt.Dimension(230, 300));

        dlTitle.setBackground(new java.awt.Color(255, 255, 255));
        dlTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        dlTitle.setForeground(new java.awt.Color(204, 204, 204));
        dlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dlTitle.setText("Monitoria");

        bDelete.setBackground(new java.awt.Color(204, 0, 51));
        bDelete.setText("Deletar");

        spMonitors.setBackground(new java.awt.Color(255, 255, 255));

        pMonitors.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pMonitorsLayout = new javax.swing.GroupLayout(pMonitors);
        pMonitors.setLayout(pMonitorsLayout);
        pMonitorsLayout.setHorizontalGroup(
            pMonitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        pMonitorsLayout.setVerticalGroup(
            pMonitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        spMonitors.setViewportView(pMonitors);

        javax.swing.GroupLayout pDeleteLayout = new javax.swing.GroupLayout(pDelete);
        pDelete.setLayout(pDeleteLayout);
        pDeleteLayout.setHorizontalGroup(
            pDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dlTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spMonitors))
                .addContainerGap())
        );
        pDeleteLayout.setVerticalGroup(
            pDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dlTitle)
                .addGap(18, 18, 18)
                .addComponent(spMonitors, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pContentDeleteLayout = new javax.swing.GroupLayout(pContentDelete);
        pContentDelete.setLayout(pContentDeleteLayout);
        pContentDeleteLayout.setHorizontalGroup(
            pContentDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContentDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pContentDeleteLayout.setVerticalGroup(
            pContentDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentDeleteLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pContent.add(pContentDelete);

        add(pContent, java.awt.BorderLayout.CENTER);
    }// </editor-fold>                                                            
               
}
