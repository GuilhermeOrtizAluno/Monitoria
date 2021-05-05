
package screens;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
    public JPanel pLogContent;
    public JScrollPane spLog;
                      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components"> 
    public void initComponents() {

        lTitle = new JLabel();
        pServer = new JPanel();
        pTitle = new JPanel();
        pContent = new JPanel();
        pLog = new JPanel();
        spLog = new JScrollPane();
        pLogContent = new JPanel();

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
        pContent.setSize(250, GroupLayout.DEFAULT_SIZE);

        pLog.setBackground(new Color(204, 0, 204));
        pLog.setBorder(new EmptyBorder(10, 10, 10, 10));
        pLog.setLayout(new BoxLayout(pLog, BoxLayout.Y_AXIS));
        
        pLogContent.setBackground(new Color(204, 0, 204));
        pLogContent.add(pLog);

        /*GroupLayout pLogLayout = new GroupLayout(pLogContent);
        pLogContent.setLayout(pLogLayout);
        pLogLayout.setHorizontalGroup(
            pLogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        pLogLayout.setVerticalGroup(
            pLogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );*/

        
        spLog.setBackground(new Color(204, 0, 204));
        spLog.setViewportView(pLogContent);

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
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Server");
        pack();
    } // </editor-fold>                    
               
}
