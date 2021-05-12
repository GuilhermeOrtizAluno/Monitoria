package screens;

/**
 *
 * @author Guilherme Ortiz
 */
public class MenuStudentScreen extends javax.swing.JPanel {

    public javax.swing.JButton bChat;
    public javax.swing.JButton bHors;
    public javax.swing.JButton bStudent;
    public javax.swing.JButton bDelete;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

        bHors = new javax.swing.JButton();
        bStudent = new javax.swing.JButton();
        bChat = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 0, 204));

        bHors.setText("Horarios");

        bStudent.setText("Inicial");

        bChat.setText("Chat");

        bDelete.setBackground(new java.awt.Color(204, 0, 51));
        bDelete.setText("Deletar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bHors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(bChat, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(bDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(bStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bHors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bChat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(bDelete)
                .addContainerGap())
        );
    }// </editor-fold>                        

               
}
