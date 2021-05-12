package controllers;

import static dice.ManagerClient.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import screens.ChatScreen;

/**
 *
 * @author Guilherme Ortiz
 */
public class ChatController extends ChatScreen{

    public ChatController() {
        initComponents();
        continuationInitComponents();
    }
    
     private void continuationInitComponents(){
        bSend.addActionListener((ActionEvent evt) -> {
            try {
                sendMessage();
            } catch (JSONException | IOException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
    }
     
     private void sendMessage() throws JSONException, IOException{
        String message = tfMessage.getText();
        String userSend = cbUser.getSelectedItem() == null ? "" : cbUser.getSelectedItem().toString();
        
        if("".equals(userSend)){
                JOptionPane.showMessageDialog(
                    null, 
                    "Invalid fields, please try again", 
                    "Invalid field", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
        if("".equals(message))return;

        JSONObject route = new JSONObject();
        route.put("rota", "chat.mensagem-enviar");
        route.put("usuario_destino", userSend);
        route.put("mensagem", message);
        
        includeMessageSend(message);

        // Shows what will be sent
        logController.showSend(route.toString());

        // Send
        PrintWriter pr = new PrintWriter(socket.getOutputStream());  
        pr.println(route);
        pr.flush();
     }
     
     public void includeMessageSend(String sMessage){
        JLabel lMessage = new JLabel();
        lMessage.setText("Send -> "+sMessage);
        
        pPosts.add(lMessage);
        pPosts.repaint();
        pPosts.validate();
        
        tfMessage.setText("");
        
        revalidate();
     }
    
}
