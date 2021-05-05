/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import screens.UsersScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class UsersController extends UsersScreen{
    
    private JLabel lClient;
    private JPanel pType;
    private JPanel client;
    private int x, y;

    public UsersController() {
        x = 5;
        y = 5;
        initComponents();
    }
    
    public void includeClient(String sClient){
        lClient = new JLabel();
        lClient.setText(sClient);
        
        pType = new JPanel();
        pType.setSize(20, 20);
        pType.setBackground(Color.GREEN);
                
        client = new JPanel();
        client.setSize(300,35);
        client.setLocation(x, y);
        client.add(pType);
        client.add(lClient);
        
        y += 40;
        
        pUsers.add(client);
        pUsers.add(Box.createRigidArea(new Dimension(0,5)));
        pUsers.repaint();
        pUsers.validate();
        
        revalidate();
    }
    
}
