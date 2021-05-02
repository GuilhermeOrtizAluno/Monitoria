
package screenold;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Guilherme Ortiz
 */
public class ClientScreen extends JFrame {
    
    public JLabel lTitle;
    public JPanel pContent;
    public JPanel pLog;
    public JPanel pServer;
    public JPanel pHeader;
    public JScrollPane spLog;
    public JButton bExit;
                      
    public void initComponents() {

        pServer = new JPanel();
        pHeader = new JPanel();
        lTitle = new JLabel();
        pContent = new JPanel();
        spLog = new JScrollPane();
        pLog = new JPanel();
        bExit = new JButton();
        
        bExit.setBackground(Color.WHITE);
        bExit.setText("Sair");

        pServer.setBackground(new Color(255, 255, 255));

        pHeader.setBackground(new java.awt.Color(204, 0, 204));

        lTitle.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        lTitle.setForeground(new java.awt.Color(255, 255, 255));
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Client");

        bExit.setBackground(new java.awt.Color(255, 255, 255));
        bExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bExit.setSize(60, 30);
        //bExit.set
        bExit.setText("Sair");

        javax.swing.GroupLayout pHeaderLayout = new javax.swing.GroupLayout(pHeader);
        pHeader.setLayout(pHeaderLayout);
        pHeaderLayout.setHorizontalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeaderLayout.createSequentialGroup()
                .addGap(443, 443, 443)
                .addComponent(lTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            )
        );
        pHeaderLayout.setVerticalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
            )
        );

        pContent.setBackground(new Color(255, 255, 255));

        pContent.setSize(250, GroupLayout.DEFAULT_SIZE);

        spLog.setBackground(new Color(204, 0, 204));

        pLog.setBackground(new Color(204, 0, 204));

        GroupLayout pLogLayout = new GroupLayout(pLog);
        pLog.setLayout(pLogLayout);
        pLogLayout.setHorizontalGroup(
            pLogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        pLogLayout.setVerticalGroup(
            pLogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        spLog.setViewportView(pLog);

        GroupLayout pServerLayout = new GroupLayout(pServer);
        pServer.setLayout(pServerLayout);
        pServerLayout.setHorizontalGroup(
            pServerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, pServerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pContent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spLog, GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addContainerGap())
        );
        pServerLayout.setVerticalGroup(
            pServerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pServerLayout.createSequentialGroup()
                .addComponent(pHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pServerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pContent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spLog, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pServer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pServer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Client");
        pack();
    }                       
               
}
