package screens;

import java.awt.Color;


/**
 *
 * @author Guilherme Ortiz
 */
public class ChatScreen extends javax.swing.JPanel {

    public javax.swing.JButton bSend;
    public javax.swing.JComboBox<String> cbUser;
    public javax.swing.JPanel pPosts;
    public javax.swing.JScrollPane spPosts;
    public javax.swing.JTextField tfMessage;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {

        tfMessage = new javax.swing.JTextField();
        cbUser = new javax.swing.JComboBox<>();
        bSend = new javax.swing.JButton();
        spPosts = new javax.swing.JScrollPane();
        pPosts = new javax.swing.JPanel();

        bSend.setText("Enviar");
        
        pPosts.setBackground(Color.WHITE);

        spPosts.setViewportView(pPosts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spPosts)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bSend, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spPosts, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMessage)
                    .addComponent(cbUser)
                    .addComponent(bSend, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>                        

                
}
