package screens;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Guilherme Ortiz
 */
public class LogScreen extends javax.swing.JPanel {

public JPanel pLog;
    public JPanel pContentLog;
    public JScrollPane spLog;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {
;
        spLog = new javax.swing.JScrollPane();
        pLog = new javax.swing.JPanel();
        pContentLog = new JPanel();

        setMinimumSize(new java.awt.Dimension(900, 180));

        pLog.setBackground(new java.awt.Color(214, 180, 240));
        pLog.setBorder(new EmptyBorder(10, 10, 10, 10));
        pLog.setLayout(new BoxLayout(pLog, BoxLayout.Y_AXIS));
        
        pContentLog.setBackground(new java.awt.Color(214, 180, 240));
        pContentLog.add(pLog);

        spLog.setMinimumSize(null);
        spLog.setName(""); // NOI18N
        spLog.setRequestFocusEnabled(false);
        spLog.setViewportView(pContentLog);
        spLog.setMinimumSize(new java.awt.Dimension(900, 180));
        spLog.setPreferredSize(new java.awt.Dimension(900, 180));

        spLog.setViewportView(pContentLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spLog, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spLog, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

    }// </editor-fold>                        
             
}
