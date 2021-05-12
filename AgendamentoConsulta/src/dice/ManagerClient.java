package dice;

import entites.Route;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import controllers.ClientController;
import controllers.ConnectionController;
import controllers.HomeController;
import controllers.LogController;
import controllers.LoginRegisterController;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;
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
    
    public final ClientController clientController; 
    private InputStreamReader in;
    private OutputStreamWriter ou;
    private PrintWriter pr;
    private BufferedReader bf;
    private Color legend;
    private boolean bRoute;
    
    public static ConnectionController connectionController;
    public static LoginRegisterController loginRegisterController;
    public static LogController logController;
    public static HomeController homeController;
    public static Socket socket;
    public static JSONArray monitorsAll;
    public static JSONArray monitoringsAll;
    public static JSONArray monitoringsStudetns;
    public static String stUser;
    public static String usernameON;

    public ManagerClient() {
        connectionController = new ConnectionController();
        clientController = new ClientController();
        loginRegisterController = new LoginRegisterController();
        logController = new LogController();
        homeController = new HomeController();
        stUser = "";
        socket = new Socket();
        monitorsAll = new JSONArray();
        monitoringsAll = new JSONArray();
        monitoringsStudetns = new JSONArray();
    }
    
    public void socketClient() throws IOException{
        in = new InputStreamReader(socket.getInputStream());
        ou = new OutputStreamWriter(socket.getOutputStream());
        bf = new BufferedReader(in);
        pr = new PrintWriter(ou);
    }
    
    public void startProgram(){
        connectionController.start();
    }
    
    public void startClient() throws IOException{
        socketClient();
        connectionController.close();
        startReceived();
        clientController.start();
    }
    
    public void startReceived(){
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
                        logController.showReceived(sRoute, legend);
                        login(rRoute.getTipo_usuario());
                    }
                    case "login.logout" ->
                    {
                        logController.showReceived(sRoute, legend);
                        logout();
                    }
                    case "login.registro" ->
                    {
                        logController.showReceived(sRoute, legend);
                        register();
                    }
                    case "login.update" -> 
                    {
                        logController.showReceived(sRoute, legend);
                        manager();
                    }
                    case "usuario.delete" ->
                    {
                        logController.showReceived(sRoute, legend);
                        manager();
                    }
                    case "cliente.usuarios-ativos" -> {
                        users(sRoute);
                        usersLog(sRoute, true);
                    }
                    case "cliente.usuarios" -> {
                        usersLog(sRoute, false);
                        if("admin".equals(stUser))
                            monitors(sRoute);
                    }
                    case "monitoria.listar-monitor" ->{
                        monitoringsLog(sRoute);
                        monitorings(sRoute);
                    }
                    case "monitoria.registro" ->{
                        logController.showReceived(sRoute, legend);
                        notification();
                        monitoringsRequest();
                    }
                    case "monitoria.update" ->{
                        logController.showReceived(sRoute, legend);
                        notification();
                        monitoringsRequest();
                    }
                    case "monitoria.delete"->{
                        logController.showReceived(sRoute, legend);
                        notification();
                        monitoringsRequest();
                    }
                    case "monitoria.listar" ->{
                        monitoringsLog(sRoute);
                        monitorings(sRoute);
                    }
                    case "monitoria.listar-aluno" ->{
                        logController.showReceived(sRoute, legend);
                        students(sRoute);
                    }
                    case "aluno-monitoria.inscrever" -> {
                        logController.showReceived(sRoute, legend);
                        notification();
                    }
                    case "aluno-monitoria.delete" -> {
                        logController.showReceived(sRoute, legend);
                        notification();        
                    }
                    case "chat.mensagem-recebida" ->{
                        logController.showReceived(sRoute, legend);
                        messageReceveid(sRoute);
                    }
                    case "chat.mensagem-enviar" ->{
                        logController.showReceived(sRoute, legend);
                        messageSend();
                    }
                    default -> 
                    {
                        logController.showReceived(sRoute, Color.RED);
                        errorRoute();
                    }
                } // </editor-fold> 
                if(bRoute) homeController.cleanFields();
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
    // <editor-fold defaultstate="collapsed" desc="Functions">
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
        clientController.pContentAdd("home");
        stUser = sTypeUser;
        usersRequest();
        monitoringsRequest();
        switch(sTypeUser){
            case "admin"    -> 
            {
                clientController.pContentAdd("admin");
            }
            case "monitor" ->{
                clientController.pContentAdd("monitor");
                JSONObject route = new JSONObject();
                route.put("rota", "monitoria.listar-monitor");
                route.put("usuario_monitor", usernameON);
                logController.showSend(route.toString());
                // Send
                pr.println(route);
                pr.flush();
            }
            case "aluno"   ->{
                clientController.pContentAdd("student");
                JSONObject route = new JSONObject();
                route.put("rota", "monitoria.listar-aluno");
                route.put("usuario_aluno", usernameON);
                logController.showSend(route.toString());
                // Send
                pr.println(route);
                pr.flush();
            }
        }
        
    }

    private void logout() throws IOException {
        clientController.pContentClear();
        clientController.pContentAdd("loginRegister");
        stUser = "";
    }

    private void register() throws IOException, JSONException {

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
        
        if ("admin".equals(stUser)){
            usersRequest();
        } else loginRegisterController.cleanFields();

    }

    private void manager() throws IOException, JSONException {
        if(bRoute){ 
            JOptionPane.showMessageDialog(
                null, 
                "Success", 
                "Manager User", 
                JOptionPane.INFORMATION_MESSAGE
            );
            if(!"admin".equals(stUser)){
                clientController.pContentClear();
                clientController.pContentAdd("loginRegister");
            }else {
                usersRequest();
            }
        }else JOptionPane.showMessageDialog(
                null, 
                "Error when trying to manager user", 
                "Manager User", 
                JOptionPane.WARNING_MESSAGE
           );
    }
    
    private void students(String sMonitorings) throws JSONException{
        JSONObject joMonitorings = new JSONObject(sMonitorings);
        
        JSONArray jaMonitorings = joMonitorings.getJSONArray("monitorias");
        
        Vector<String> monitorings = new Vector<>();
        monitorings.add("");
        
        for(int i = 0; i < jaMonitorings.length(); i++){
            JSONObject joMonitoring = jaMonitorings.getJSONObject(i);
            monitorings.add(joMonitoring.getString("nome"));
            monitoringsStudetns.put(joMonitoring);
        }
        homeController.initCBMonitorings1(monitorings);
    }
    
    private void monitors(String sUser) throws JSONException{
        JSONObject joUsers = new JSONObject(sUser);
        
        JSONArray users = joUsers.getJSONArray("usuarios");
        
        //String[] monitors;
        Vector<String> monitors = new Vector<>();
        monitors.add("");
        
        for(int i = 0; i < users.length(); i++){
            JSONObject joMonitor = users.getJSONObject(i);
            if("monitor".equals(joMonitor.getString("tipo_usuario"))){
                monitors.add(joMonitor.getString("usuario"));
                monitorsAll.put(joMonitor);
            }
            //monitors[i] = usuarios.getString(i);
        }
        homeController.initCBMonitors(monitors);
    }
    
    private void users(String sUser) throws JSONException{
        
        JSONObject joUsers = new JSONObject(sUser);
        
        JSONArray jaUsers = joUsers.getJSONArray("usuarios");
        
        //String[] monitors;
        Vector<String> users = new Vector<>();
        users.add("");
        
        for(int i = 0; i < jaUsers.length(); i++){
            JSONObject joUser = jaUsers.getJSONObject(i);
            if(!joUser.getString("usuario").equals(usernameON))
                users.add(joUser.getString("usuario"));
            //monitors[i] = usuarios.getString(i);
        }
        homeController.initCBUsers(users);
    }
    
    private void monitorings(String sMonitorings)throws JSONException{
        
        JSONObject joMonitorings = new JSONObject(sMonitorings);
        
        JSONArray jaMonitorings = joMonitorings.getJSONArray("monitorias");
        
        Vector<String> monitorings = new Vector<>();
        monitorings.add("");
        
        for(int i = 0; i < jaMonitorings.length(); i++){
            JSONObject joMonitoring = jaMonitorings.getJSONObject(i);
            monitorings.add(joMonitoring.getString("nome"));
            monitoringsAll.put(joMonitoring);
        }
        homeController.initCBMonitorings(monitorings);
    }

    private void usersLog(String sRoute, boolean broadcast) throws IOException, JSONException {
        System.out.println("Received <- "+sRoute);
        legend = Color.GREEN;
        logController.includeLogUsers(new JSONObject(sRoute), broadcast);
    }
    
    private void monitoringsLog(String sRoute) throws IOException, JSONException {
        System.out.println("Received <- "+sRoute);
        legend = Color.GREEN;
        logController.includeLogMonitorings(new JSONObject(sRoute));
    }
    
    private void notification() throws JSONException, IOException{
        if(bRoute){ 
            JOptionPane.showMessageDialog(
                null, 
                "Success", 
                "Message", 
                JOptionPane.INFORMATION_MESSAGE
            );
            
            switch(stUser){
            case "monitor" ->{
                JSONObject route = new JSONObject();
                route.put("rota", "monitoria.listar-monitor");
                route.put("usuario_monitor", usernameON);
                logController.showSend(route.toString());
                // Send
                pr.println(route);
                pr.flush();
            }
            case "aluno"   ->{
                JSONObject route = new JSONObject();
                route.put("rota", "monitoria.listar-aluno");
                route.put("usuario_aluno", usernameON);
                logController.showSend(route.toString());
                // Send
                pr.println(route);
                pr.flush();
            }
        }
        }else JOptionPane.showMessageDialog(
                null, 
                "Something went wrong!", 
                "Error", 
                JOptionPane.WARNING_MESSAGE
           );
    }

    private void errorRoute() {
        JOptionPane.showMessageDialog(
            null, 
            "No route found", 
            "Route error", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    private void usersRequest() throws JSONException, IOException{
        JSONObject route = new JSONObject();
        route.put("rota", "cliente.usuarios");
        logController.showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
    }
    
    private void monitoringsRequest() throws JSONException, IOException{
        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.listar");
        logController.showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
    }
    
    private void messageReceveid(String sMessage) throws JSONException{
        homeController.chatMessageReceveid(sMessage);
    }
    
    private void messageSend() throws JSONException, IOException{
        JSONObject route = new JSONObject();
        route.put("rota", "chat.mensagem-recebida");
        route.put("erro", "false");
        logController.showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
    }
    // </editor-fold> 

}
