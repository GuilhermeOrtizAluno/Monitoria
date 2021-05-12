package controllers;

import static dice.ManagerClient.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import screens.HorsScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class HorsController extends HorsScreen{

    public HorsController() {
        initComponents();
        continuationInitComponents();   
    }
    
    private void continuationInitComponents(){
        bBuscar.addActionListener((ActionEvent evt) -> {
            try {
                hundleShowHors();
            } catch (JSONException ex) {
                Logger.getLogger(HorsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void hundleShowHors() throws JSONException{
        
        pHors.removeAll();
        
        String monitoria = cbMonitoring.getSelectedItem() == null ? "" : cbMonitoring.getSelectedItem().toString();
        
        if("".equals(monitoria)){
            JOptionPane.showMessageDialog(
                null, 
                "Invalid fields, please try again", 
                "Invalid field", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        String monitoring = "1";
        
        for(var i = 0; i < monitoringsAll.length(); i++){
            JSONObject joMonitoring = monitoringsAll.getJSONObject(i);
            if(joMonitoring.getString("nome").equals(monitoria)){
                monitoring = joMonitoring.getString("id");
                hors(joMonitoring);
            }
        } 
    }
    
    private void hors(JSONObject joMonitoring) throws JSONException{
        String nome = joMonitoring.getString("nome");
        String hors = joMonitoring.getString("horarios");
        
        JLabel lNome = new JLabel();
        lNome.setText("Disciplina: "+nome);
        includeHors(lNome);
        
        if("aluno".equals(stUser)){
        
            String monitor = joMonitoring.getString("nome_monitor");

            JLabel lMonitor = new JLabel();
            lMonitor.setText("Monitor: "+ monitor);
            includeHors(lMonitor);

        }else{
            String alunos = joMonitoring.getString("alunos");

            JLabel lMonitor = new JLabel();
            lMonitor.setText("Alunos: "+ alunos);
            includeHors(lMonitor);
        }
        
        JLabel lHors = new JLabel();
        lHors.setText("Horarios: "+ hors);
        includeHors(lHors);
   }
    
    private void includeHors(JLabel info){
        pHors.add(info);
        pHors.validate();
        pHors.repaint();
        
        revalidate();
    }
       
}
