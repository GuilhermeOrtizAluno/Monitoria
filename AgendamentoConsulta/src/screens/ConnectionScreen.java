/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

/**
 *
 * @author Guilherme Ortiz
 */
public class ConnectionScreen extends javax.swing.JFrame {

    public javax.swing.JButton bConnect;
    public javax.swing.JButton bClose;
    public javax.swing.JTextField tfIP;
    public javax.swing.JTextField tfPort;
    private javax.swing.JLabel lTitle;
    private javax.swing.JPanel pConnection;
    private javax.swing.JPanel pFields;
    private javax.swing.JPanel pHeader;  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

        pConnection = new javax.swing.JPanel();
        pFields = new javax.swing.JPanel();
        tfIP = new javax.swing.JTextField();
        tfPort = new javax.swing.JTextField();
        bConnect = new javax.swing.JButton();
        pHeader = new javax.swing.JPanel();
        bClose = new javax.swing.JButton();
        lTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(240, 280));
        setUndecorated(true);

        pConnection.setBackground(new java.awt.Color(255, 255, 255));
        pConnection.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pConnection.setLayout(null);

        pFields.setBackground(new java.awt.Color(255, 255, 255));

        tfIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfIP.setText("localhost");
        tfIP.setBorder(javax.swing.BorderFactory.createTitledBorder("IP"));

        tfPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPort.setBorder(javax.swing.BorderFactory.createTitledBorder("Porta"));

        bConnect.setBackground(new java.awt.Color(204, 0, 204));
        bConnect.setForeground(new java.awt.Color(255, 255, 255));
        bConnect.setText("Conectar");
        
        javax.swing.GroupLayout pFieldsLayout = new javax.swing.GroupLayout(pFields);
        pFields.setLayout(pFieldsLayout);
        pFieldsLayout.setHorizontalGroup(
            pFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFieldsLayout.createSequentialGroup()
                .addGroup(pFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFieldsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIP, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pFieldsLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(bConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pFieldsLayout.setVerticalGroup(
            pFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFieldsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tfIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(bConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pConnection.add(pFields);
        pFields.setBounds(20, 90, 200, 180);

        pHeader.setBackground(new java.awt.Color(204, 0, 204));

        bClose.setBackground(new java.awt.Color(255, 255, 255));
        bClose.setForeground(new java.awt.Color(204, 0, 204));
        bClose.setText("x");

        lTitle.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lTitle.setForeground(new java.awt.Color(255, 255, 255));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Conectar com Servidor");
        lTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pHeaderLayout = new javax.swing.GroupLayout(pHeader);
        pHeader.setLayout(pHeaderLayout);
        pHeaderLayout.setHorizontalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bClose)
                .addContainerGap())
            .addComponent(lTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pHeaderLayout.setVerticalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pConnection.add(pHeader);
        pHeader.setBounds(0, 0, 240, 110);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setTitle("Client");
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        
                
}
