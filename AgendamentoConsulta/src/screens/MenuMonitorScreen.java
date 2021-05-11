
package screens;

/**
 *
 * @author Guilherme Ortiz
 */
public class MenuMonitorScreen extends javax.swing.JPanel {
    
    public javax.swing.JButton bChat;
    public javax.swing.JButton bHors;
    public javax.swing.JButton bMonitoring;    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {

        bHors = new javax.swing.JButton();
        bMonitoring = new javax.swing.JButton();
        bChat = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 0, 204));

        bHors.setText("Horarios");

        bMonitoring.setText("Monitoria");

        bChat.setText("Chat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bHors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bMonitoring, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(bChat, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(bHors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bMonitoring)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bChat)
                .addContainerGap(191, Short.MAX_VALUE))
        );
    }// </editor-fold>                        
                               
}

