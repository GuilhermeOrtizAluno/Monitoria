/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import screens.ManagementMonitorScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class ManagementMonitorController extends ManagementMonitorScreen{

    public ManagementMonitorController() {
        initComponents();
        cleanFields();
    }
    
     public void cleanFields(){
        tfUser.setText("");
        tfPass.setText("");
        tfName.setText("");
        revalidate();
    } 
}
