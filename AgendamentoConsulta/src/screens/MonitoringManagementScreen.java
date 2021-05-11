package screens;

/**
 *
 * @author Guilherme Ortiz
 */
public class MonitoringManagementScreen extends javax.swing.JPanel {

    private javax.swing.JButton bUpdate;
    public javax.swing.JComboBox<String> cbMonitoring;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lTitle;
    private javax.swing.JPanel pContent;
    private javax.swing.JPanel pTitle;
    private javax.swing.JPanel pUpdate;
    private javax.swing.JPanel rpHors;
    private javax.swing.JScrollPane spHors;
    public javax.swing.JTextField tfName;
    public javax.swing.JTextField tfPass;
    private javax.swing.JLabel ulTitle;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {

        pTitle = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        pContent = new javax.swing.JPanel();
        pUpdate = new javax.swing.JPanel();
        ulTitle = new javax.swing.JLabel();
        bUpdate = new javax.swing.JButton();
        tfName = new javax.swing.JTextField();
        spHors = new javax.swing.JScrollPane();
        rpHors = new javax.swing.JPanel();
        tfPass = new javax.swing.JTextField();
        cbMonitoring = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

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

        pUpdate.setBackground(new java.awt.Color(255, 255, 255));
        pUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pUpdate.setMaximumSize(null);

        ulTitle.setBackground(new java.awt.Color(255, 255, 255));
        ulTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ulTitle.setForeground(new java.awt.Color(204, 204, 204));
        ulTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulTitle.setText("Gerenciar Monitoria");

        bUpdate.setBackground(new java.awt.Color(204, 0, 204));
        bUpdate.setText("Editar");

        tfName.setEditable(false);
        tfName.setBackground(new java.awt.Color(255, 255, 255));
        tfName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfName.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        spHors.setBackground(new java.awt.Color(255, 255, 255));
        spHors.setBorder(javax.swing.BorderFactory.createTitledBorder("Horarios"));

        rpHors.setBackground(new java.awt.Color(255, 255, 255));
        rpHors.setPreferredSize(new java.awt.Dimension(102, 50));

        javax.swing.GroupLayout rpHorsLayout = new javax.swing.GroupLayout(rpHors);
        rpHors.setLayout(rpHorsLayout);
        rpHorsLayout.setHorizontalGroup(
            rpHorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );
        rpHorsLayout.setVerticalGroup(
            rpHorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );

        spHors.setViewportView(rpHors);

        tfPass.setEditable(false);
        tfPass.setBackground(new java.awt.Color(255, 255, 255));
        tfPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPass.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));

        cbMonitoring.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbMonitoring.setBorder(null);

        jLabel4.setText("Monitoria");

        javax.swing.GroupLayout pUpdateLayout = new javax.swing.GroupLayout(pUpdate);
        pUpdate.setLayout(pUpdateLayout);
        pUpdateLayout.setHorizontalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ulTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addGroup(pUpdateLayout.createSequentialGroup()
                        .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(tfPass, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMonitoring, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(spHors)))
                .addContainerGap())
        );
        pUpdateLayout.setVerticalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ulTitle)
                .addGap(11, 11, 11)
                .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pUpdateLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMonitoring, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spHors))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pContentLayout = new javax.swing.GroupLayout(pContent);
        pContent.setLayout(pContentLayout);
        pContentLayout.setHorizontalGroup(
            pContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(pUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        pContentLayout.setVerticalGroup(
            pContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(pUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        add(pContent, java.awt.BorderLayout.CENTER);
    }// </editor-fold>                        
               
}
