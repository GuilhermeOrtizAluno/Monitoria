package screens;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Guilherme Ortiz
 */
public class ManagementMonitorScreen extends javax.swing.JPanel {

    public javax.swing.JButton bDelete;
    public javax.swing.JButton bRegister;
    public javax.swing.JButton bUpdate;
    public javax.swing.JComboBox<String> cbMonitor;
    private javax.swing.JLabel dlTitle;
    private javax.swing.JLabel lTitle;
    private javax.swing.JPanel pContent;
    private javax.swing.JPanel pContentDelete;
    private javax.swing.JPanel pContentRegister;
    private javax.swing.JPanel pContentUpdate;
    private javax.swing.JPanel pDelete;
    public javax.swing.JList pMonitors;
    private javax.swing.JPanel pRegister;
    private javax.swing.JPanel pTitle;
    private javax.swing.JPanel pUpdate;
    private javax.swing.JLabel rlName;
    private javax.swing.JLabel rlPass;
    private javax.swing.JLabel rlTitle;
    private javax.swing.JLabel rlUser;
    public javax.swing.JTextField rtfName;
    public javax.swing.JTextField rtfPass;
    public javax.swing.JTextField rtfUser;
    private javax.swing.JScrollPane spMonitors;
    private javax.swing.JLabel ulMonitor;
    private javax.swing.JLabel ulName;
    private javax.swing.JLabel ulPass;
    private javax.swing.JLabel ulTitle;
    private javax.swing.JLabel ulUser;
    public javax.swing.JTextField utfName;
    public javax.swing.JTextField utfPass;
    public javax.swing.JTextField utfUser;     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

        pTitle = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        pContent = new javax.swing.JPanel();
        pContentRegister = new javax.swing.JPanel();
        pRegister = new javax.swing.JPanel();
        rlTitle = new javax.swing.JLabel();
        rlName = new javax.swing.JLabel();
        rtfName = new javax.swing.JTextField();
        rtfUser = new javax.swing.JTextField();
        rlUser = new javax.swing.JLabel();
        rlPass = new javax.swing.JLabel();
        rtfPass = new javax.swing.JTextField();
        bRegister = new javax.swing.JButton();
        pContentUpdate = new javax.swing.JPanel();
        pUpdate = new javax.swing.JPanel();
        cbMonitor = new javax.swing.JComboBox<>();
        ulTitle = new javax.swing.JLabel();
        ulName = new javax.swing.JLabel();
        utfName = new javax.swing.JTextField();
        ulUser = new javax.swing.JLabel();
        utfUser = new javax.swing.JTextField();
        ulPass = new javax.swing.JLabel();
        utfPass = new javax.swing.JTextField();
        bUpdate = new javax.swing.JButton();
        ulMonitor = new javax.swing.JLabel();
        pContentDelete = new javax.swing.JPanel();
        pDelete = new javax.swing.JPanel();
        dlTitle = new javax.swing.JLabel();
        bDelete = new javax.swing.JButton();
        spMonitors = new javax.swing.JScrollPane();
        pMonitors = new JList();

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

        rlTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rlTitle.setForeground(new java.awt.Color(204, 204, 204));
        rlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rlTitle.setText("Cadastro Monitor");

        rlName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rlName.setText("Nome");

        rtfName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rtfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        rtfUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rtfUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        rlUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rlUser.setText("Usuario");

        rlPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rlPass.setText("Senha");

        rtfPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rtfPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rtfPass.setToolTipText("");
        rtfPass.setPreferredSize(new java.awt.Dimension(60, 23));

        bRegister.setBackground(new java.awt.Color(204, 0, 204));
        bRegister.setText("Cadastrar");

        javax.swing.GroupLayout pRegisterLayout = new javax.swing.GroupLayout(pRegister);
        pRegister.setLayout(pRegisterLayout);
        pRegisterLayout.setHorizontalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rlPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rlUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rlName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rlTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(bRegister, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rtfName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rtfPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rtfUser))
                .addContainerGap())
        );
        pRegisterLayout.setVerticalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rlName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rlUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rlPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pContentRegisterLayout = new javax.swing.GroupLayout(pContentRegister);
        pContentRegister.setLayout(pContentRegisterLayout);
        pContentRegisterLayout.setHorizontalGroup(
            pContentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pContentRegisterLayout.setVerticalGroup(
            pContentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContentRegisterLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(pRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
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
        ulTitle.setText("Gerenciar Monitor");

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

        ulMonitor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ulMonitor.setText("Monitor");

        javax.swing.GroupLayout pUpdateLayout = new javax.swing.GroupLayout(pUpdate);
        pUpdate.setLayout(pUpdateLayout);
        pUpdateLayout.setHorizontalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(utfName)
                    .addComponent(cbMonitor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ulUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ulMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(ulMonitor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ulName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utfName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ulUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ulPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(27, 27, 27)
                .addComponent(pUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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
        dlTitle.setText("Monitores");

        bDelete.setBackground(new java.awt.Color(204, 0, 51));
        bDelete.setText("Deletar");

        spMonitors.setBackground(new java.awt.Color(255, 255, 255));

        pMonitors.setBackground(new java.awt.Color(255, 255, 255));
        pMonitors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
