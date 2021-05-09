
package screensold3;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author gui_o
 */
public class ConnectionScreen extends JPanel {
    
    public JButton bConnection;
    public JLabel lIP;
    public JLabel lPass;
    public JLabel lTitle;
    public JTextField tfIP;
    public JTextField tfPort;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

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
        setSize(230, 270);

        lTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lTitle.setForeground(new java.awt.Color(204, 204, 204));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Conectar com Servidor");

        lIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lIP.setText("IP");

        tfIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfIP.setText("localhost");

        lPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lPass.setText("Porta");

        tfPort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPort.setToolTipText("");
        tfPort.setPreferredSize(new java.awt.Dimension(60, 23));

        bConnection.setBackground(new java.awt.Color(204, 0, 204));
        bConnection.setText("Conectar");
        
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
    }// </editor-fold>                                                           
                 
}
