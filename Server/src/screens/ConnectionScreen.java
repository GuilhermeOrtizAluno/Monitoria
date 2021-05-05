
package screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 *
 * @author gui_o
 */
public class ConnectionScreen extends JPanel {
    
    public JButton bConection;
    public JLabel lIP;
    public JLabel lPort;
    public JLabel lTitle;
    public JPanel pConection;
    public JTextField tfIP;
    public JTextField tfPort;
                          
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">    
    public void initComponents() {

        pConection =    new JPanel();
        lTitle =        new JLabel();
        tfIP =          new JTextField();
        lIP =           new JLabel();
        lPort =         new JLabel();
        tfPort =        new JTextField();
        bConection =    new JButton();

        pConection.setBackground(new Color(255, 255, 255));

        lTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lTitle.setForeground(new Color(204, 204, 204));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lTitle.setText("Iniciar Servidor");

        tfIP.setEditable(false);
        tfIP.setBackground(new Color(204, 204, 204));
        tfIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfIP.setHorizontalAlignment(JTextField.CENTER);
        tfIP.setText("localhost");

        lIP.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lIP.setText("IP");

        lPort.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lPort.setText("Porta");

        tfPort.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        tfPort.setHorizontalAlignment(JTextField.CENTER);
        tfPort.setToolTipText("");
        tfPort.setPreferredSize(new Dimension(60, 23));

        bConection.setBackground(new Color(204, 0, 204));
        bConection.setText("Iniciar");

        GroupLayout pConectionLayout = new GroupLayout(pConection);
        pConection.setLayout(pConectionLayout);
        pConectionLayout.setHorizontalGroup(
            pConectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pConectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pConectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tfPort, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lTitle, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(tfIP)
                    .addGroup(pConectionLayout.createSequentialGroup()
                        .addGroup(pConectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lIP, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPort))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bConection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pConectionLayout.setVerticalGroup(
            pConectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pConectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitle, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lIP)
                .addGap(3, 3, 3)
                .addComponent(tfIP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lPort)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPort, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bConection, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        GroupLayout pConectionlayout = new GroupLayout(this);
        this.setLayout(pConectionlayout);
        pConectionlayout.setHorizontalGroup(
            pConectionlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pConection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pConectionlayout.setVerticalGroup(
            pConectionlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pConection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pConection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pConection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
    }// </editor-fold>                                                               
          
}
