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
    public static boolean admin;
    public static String usernameON;

    public ManagerClient() {
        connectionController = new ConnectionController();
        clientController = new ClientController();
        loginRegisterController = new LoginRegisterController();
        logController = new LogController();
        homeController = new HomeController();
        admin = false;
        socket = new Socket();
        monitorsAll = new JSONArray();
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
                        update();
                    }
                    case "usuario.delete" ->
                    {
                        logController.showReceived(sRoute, legend);
                        delete();
                    }
                    case "cliente.usuarios-ativos" -> {
                        users(sRoute, true);
                    }
                    case "cliente.usuarios" -> {
                        users(sRoute, false);
                        if(admin)
                            monitors(sRoute);
                    }
                    case "mensagem.mensagem" -> 
                    {
                        logController.showReceived(sRoute, legend);
                        mensagem();
                    }
                    case "monitoria.listar-monitor" ->{
                        logController.showReceived(sRoute, legend);
                    }
                    case "monitoria.registro" ->{
                        logController.showReceived(sRoute, legend);
                    }
                    case "monitoria.update" ->{
                        logController.showReceived(sRoute, legend);
                    }
                    case "monitoria.listar" ->{
                        logController.showReceived(sRoute, legend);
                        if(admin)
                            monitorings(sRoute);
                    }
                    case "monitoria.listar-aluno" ->{
                        logController.showReceived(sRoute, legend);
                    }
                    case "aluno-monitoria.inscrever" -> {
                        logController.showReceived(sRoute, legend);
                    }
                    case "aluno-monitoria.delete" -> {
                        logController.showReceived(sRoute, legend);
                    }
                    default -> 
                    {
                        logController.showReceived(sRoute, Color.RED);
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
        switch(sTypeUser){
            case "admin"    -> 
            {
                clientController.pContentAdd("admin");
                admin = true;
                usersAll();
                monitoringsAll();
            }
            case "monitor" ->{
            }
            case "aluno"   ->{
                admin = false;
                clientController.pContentAdd("updateStudent");
            }
        }
        
    }

    private void logout() throws IOException {
        clientController.pContentClear();
        clientController.pContentAdd("loginRegister");
        admin = false;
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
        
        if (admin){
            usersAll();
            homeController.adminClear(true);
        } else loginRegisterController.cleanFields();

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
                clientController.pContentAdd("loginRegister");
            }else {
                homeController.adminClear(false);
                usersAll();
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
                clientController.pContentAdd("loginRegister");
            }else {
                homeController.adminClear(false);
                homeController.adminClear(true);
                usersAll();
            }
        }else JOptionPane.showMessageDialog(
                null, 
                "Error when trying to edit user", 
                "Manager User", 
                JOptionPane.WARNING_MESSAGE
            );

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

    private void users(String sRoute, boolean broadcast) throws IOException, JSONException {
        legend = Color.GREEN;
        logController.includeLogUsers(new JSONObject(sRoute), broadcast);
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
    
    private void usersAll() throws JSONException, IOException{
        JSONObject route = new JSONObject();
        route.put("rota", "cliente.usuarios");
        logController.showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
    }
    
    private void monitoringsAll() throws JSONException, IOException{
        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.listar");
        logController.showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
    }
    // </editor-fold> 

}
