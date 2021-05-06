package dice;

import entites.Route;
import static app.Program.*;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *Gerenciador do Cliente
 *
 * @author Guilherme Ortiz 
 * 
 * Consumir Json 
 * Tomar Desição
 */
public class ManagerClient extends Thread{
    private InputStreamReader in;
    private OutputStreamWriter ou;
    private PrintWriter pr;
    private BufferedReader bf;
    private Color legend;
    private boolean bRoute;
    
    public void startReceived() throws IOException{
        in = new InputStreamReader(socket.getInputStream());
        ou = new OutputStreamWriter(socket.getOutputStream());
        bf = new BufferedReader(in);
        pr = new PrintWriter(ou);  
        
        // Opens screen Login
        clientController.pContentAdd("login");

        this.start();
    }
    
    @Override
    public void run(){
        try { // an echo server
            while (true) {
                
                //Read String
                String sRoute = bf.readLine();
                
                // Convert Json String to Route Object
                Gson gson = new Gson();
                Route rRoute = gson.fromJson(sRoute, Route.class);
                
                if("false".equals(rRoute.getErro()))
                {
                    bRoute = true;
                    legend = Color.GREEN;
                }
                else{ 
                    bRoute = false;
                    legend = Color.ORANGE;
                }
                
                // <editor-fold defaultstate="collapsed" desc="Cases">
                switch (rRoute.getRota()) {
                    case "login.login" ->
                    {    
                        clientController.showReceived(sRoute, legend);
                        login(rRoute.getTipo_usuario());
                    }
                    case "login.logout" ->
                    {
                        clientController.showReceived(sRoute, legend);
                        logout();
                    }
                    case "login.registro" ->
                    {
                        clientController.showReceived(sRoute, legend);
                        register();
                    }
                    case "login.update" -> 
                    {
                        clientController.showReceived(sRoute, legend);
                        update();
                    }
                    case "usuario.delete" ->
                    {
                        clientController.showReceived(sRoute, legend);
                        delete();
                    }
                    case "cliente.usuarios-ativos" -> {
                        users(sRoute, true);
                    }
                    case "cliente.usuarios" -> {
                        users(sRoute, false);
                        if(admin)
                            monitores(sRoute);
                    }
                    case "mensagem.mesagem" -> 
                    {
                        clientController.showReceived(sRoute, legend);
                        mensagem();
                    }
                    case "monitoria.listar-monitor" ->{
                        clientController.showReceived(sRoute, legend);
                    }
                    case "monitoria.registro" ->{
                        clientController.showReceived(sRoute, legend);
                    }
                    case "monitoria.update" ->{
                        clientController.showReceived(sRoute, legend);
                    }
                    case "monitoria.listar" ->{
                        clientController.showReceived(sRoute, legend);
                    }
                    case "monitoria.listar-aluno" ->{
                        clientController.showReceived(sRoute, legend);
                    }
                    case "aluno-monitoria.inscrever" -> {
                        clientController.showReceived(sRoute, legend);
                    }
                    case "aluno-monitoria.delete" -> {
                        clientController.showReceived(sRoute, legend);
                    }
                    default -> 
                    {
                        clientController.showReceived(sRoute, Color.RED);
                        errorRoute();
                    }
                } // </editor-fold> 

            }
        } catch(EOFException e) {
             System.out.println("EOF:"+e.getMessage());
        } catch(IOException e) {
             System.out.println("IO:"+e.getMessage());
             //clientController("");
        } catch(JsonSyntaxException e){
            System.out.println(e);
        } catch (JSONException ex) {
            Logger.getLogger(ManagerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{ 
           try {
               socket.close();
           }catch (IOException e){
               /*close failed*/
           }
        }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Function">
    private void login(String sTypeUser) throws IOException, JSONException {

        //Valid Login
        if(!bRoute) {
            JOptionPane.showMessageDialog(
                null, 
                "User invalid", 
                "Login", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        clientController.pContentClear();
        clientController.pExit.add(clientController.bExit);
        switch(sTypeUser){
            case "admin"    -> 
            {
                admin = true;
                clientController.pContentAdd("registerMonitor");
                clientController.pContentAdd("managementMonitor");
                
                JSONObject route = new JSONObject();
                route.put("rota", "cliente.usuarios");
                
                clientController.showSend(route.toString());
                
                // Send
                pr.println(route);
                pr.flush();
                
            }
            case "monitor"  ->{
            }
            case "aluno"    ->{
                admin = false;
                clientController.pContentAdd("updateStudent");
                //clientController.pContentAdd("");
            }
        }
            //clientController.pContentAdd("login");
        
    }

    private void logout() throws IOException {
        clientController.pExit.remove(clientController.bExit);
        clientController.pContentClear();
        clientController.pContentAdd("login");
    }

    private void register() throws IOException {

        if(!bRoute){ 
            JOptionPane.showMessageDialog(
                null, 
                "Failed to register", 
                "Register User", 
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        JOptionPane.showMessageDialog(
            null, 
            "Registration Success", 
            "Register User", 
            JOptionPane.INFORMATION_MESSAGE
        );
        
        if (!admin){
            clientController.pContentClear();
            clientController.pContentAdd("login");
        }else{
            registerMonitorController.cleanFields();
        }

    }

    private void update() throws IOException, JSONException {
        if(bRoute){ 
            JOptionPane.showMessageDialog(
                null, 
                "Update Success", 
                "Manager User", 
                JOptionPane.INFORMATION_MESSAGE
            );
            if(!admin){
                clientController.pContentClear();
                clientController.pContentAdd("login");
            }else {
                managementMonitorController.cleanFields();
                
                JSONObject route = new JSONObject();
                route.put("rota", "cliente.usuarios");
                clientController.showSend(route.toString());
                // Send
                pr.println(route);
                pr.flush();
            }
        }else JOptionPane.showMessageDialog(
                null, 
                "Error when trying to edit user", 
                "Manager User", 
                JOptionPane.WARNING_MESSAGE
            );
    }

    private void delete() throws IOException, JSONException {
        if(bRoute){ 
            JOptionPane.showMessageDialog(
                null, 
                "Delete Success", 
                "Manager User", 
                JOptionPane.INFORMATION_MESSAGE
            );
            if(!admin){
                clientController.pContentClear();
                clientController.pContentAdd("login");
            }else {
                managementMonitorController.cleanFields();
                
                JSONObject route = new JSONObject();
                route.put("rota", "cliente.usuarios");
                clientController.showSend(route.toString());
                // Send
                pr.println(route);
                pr.flush();
            }
        }else JOptionPane.showMessageDialog(
                null, 
                "Error when trying to edit user", 
                "Manager User", 
                JOptionPane.WARNING_MESSAGE
            );

    }
    
    private void monitores(String sUser) throws JSONException{
        
        JSONObject joUsers = new JSONObject(sUser);
        
        JSONArray users = joUsers.getJSONArray("usuarios");
        
        String[] monitors = new String[users.length()];
        
        for(int i = 0; i < users.length(); i++){
            JSONObject joMonitor = users.getJSONObject(i);
            if("monitor".equals(joMonitor.getString("tipo_usuario"))){
                monitors[i] = joMonitor.getString("usuario");
                monitorsAll.put(joMonitor);
            }
            //monitors[i] = usuarios.getString(i);
        }
        
        
        managementMonitorController.cbMonitor.setModel(new javax.swing.DefaultComboBoxModel<>(monitors));
    }

    private void users(String sRoute, boolean broadcast) throws IOException, JSONException {
        legend = Color.GREEN;
        clientController.includeLogUsers(new JSONObject(sRoute), broadcast);
    }

    private void mensagem() {

    }

    private void errorRoute() {
        JOptionPane.showMessageDialog(
            null, 
            "No route found", 
            "Route error", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    // </editor-fold> 
}
