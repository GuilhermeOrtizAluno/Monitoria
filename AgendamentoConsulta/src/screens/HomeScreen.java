package screens;

/**
 *
 * @author Guilherme Ortiz
 */
public class HomeScreen extends javax.swing.JPanel {

    public javax.swing.JButton bLogout;
    private javax.swing.JPanel pHome;
    private javax.swing.JPanel pLogout;
    public javax.swing.JPanel pContent;
    public javax.swing.JPanel pMenu;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Components">                          
    public void initComponents() {

        pHome = new javax.swing.JPanel();
        pMenu = new javax.swing.JPanel();
        pLogout = new javax.swing.JPanel();
        bLogout = new javax.swing.JButton();
        pContent = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(900, 470));

        pHome.setBackground(new java.awt.Color(255, 255, 255));
        pHome.setMaximumSize(new java.awt.Dimension(150, 470));
        pHome.setLayout(new java.awt.BorderLayout());

        pMenu.setBackground(new java.awt.Color(204, 0, 204));
        pMenu.setMaximumSize(new java.awt.Dimension(150, 470));
        pMenu.setMinimumSize(new java.awt.Dimension(150, 470));
        pMenu.setPreferredSize(new java.awt.Dimension(150, 470));
        pMenu.setLayout(new java.awt.BorderLayout());

        pLogout.setBackground(new java.awt.Color(204, 0, 204));
        pLogout.setPreferredSize(new java.awt.Dimension(150, 30));

        bLogout.setText("Sair");

        javax.swing.GroupLayout pLogoutLayout = new javax.swing.GroupLayout(pLogout);
        pLogout.setLayout(pLogoutLayout);
        pLogoutLayout.setHorizontalGroup(
            pLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        pLogoutLayout.setVerticalGroup(
            pLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLogoutLayout.createSequentialGroup()
                .addComponent(bLogout)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pMenu.add(pLogout, java.awt.BorderLayout.PAGE_END);

        pHome.add(pMenu, java.awt.BorderLayout.LINE_START);

        pContent.setBackground(new java.awt.Color(255, 255, 255));
        pContent.setLayout(new java.awt.BorderLayout());
        pHome.add(pContent, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

                   
}
