
package screens;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Guilherme Ortiz
 */
public class ServerScreen extends JFrame {
    
    public JLabel lTitle;
    public JPanel pContent;
    public JPanel pLog;
    public JPanel pServer;
    public JPanel pTitle;
    public JScrollPane spLog;
                      
    public void initComponents() {

        pServer = new JPanel();
        pTitle = new JPanel();
        lTitle = new JLabel();
        pContent = new JPanel();
        spLog = new JScrollPane();
        pLog = new JPanel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pServer.setBackground(new Color(255, 255, 255));

        pTitle.setBackground(new Color(204, 0, 204));

        lTitle.setFont(new Font("MV Boli", 1, 24)); // NOI18N
        lTitle.setForeground(new Color(255, 255, 255));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lTitle.setText("Server");

        GroupLayout pTitleLayout = new GroupLayout(pTitle);
        pTitle.setLayout(pTitleLayout);
        pTitleLayout.setHorizontalGroup(
            pTitleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(lTitle, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pTitleLayout.setVerticalGroup(
            pTitleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(lTitle, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );

        pContent.setBackground(new Color(255, 255, 255));

        

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
            .addComponent(pTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(pTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
       

        pack();
    }                       
               
}
