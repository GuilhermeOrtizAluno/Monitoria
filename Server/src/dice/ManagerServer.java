package dice;

import static app.Program.*;
import entities.Route;
import entities.User;
import com.google.gson.Gson;
import crud.MonitoringDAO;
import crud.UserDAO;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import static dice.TCPServer.listPw;
import static dice.TCPServer.usuariosAtivos;
import entities.Monitoring;
import java.awt.Color;

/**
 * Gerenciador do Servidor
 *
 * @author Guilherme Ortiz 
 * 
 * Consumir Json 
 * Tomar Desição 
 * Retorna Json
 */
public class ManagerServer extends Thread {

    private InputStreamReader in;
    private BufferedReader bf;
    private PrintWriter pr;
    private final Socket clientSocket;
    private User user;
    private Color legend;

    public ManagerServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void Connection() {
        try {
            in = new InputStreamReader(clientSocket.getInputStream());
            bf = new BufferedReader(in);
            pr = new PrintWriter(clientSocket.getOutputStream());
            listPw.add(pr);

            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    @Override
    public void run() {
        try { // an echo server
            while (true) {

                //Read String
                String sRoute = bf.readLine();

                // Color legend show logs
                legend = Color.GREEN;

                // Convert Json String to Route Object
                Gson gson = new Gson();
                Route rRoute = gson.fromJson(sRoute, Route.class);

                // <editor-fold defaultstate="collapsed" desc="Cases">
                switch (rRoute.getRota()) {
                    //Login
                    case "login.login" -> {
                        //Shows what came
                        showReceived(sRoute);

                        login(sRoute);
                    }
                    case "login.logout" -> {
                        //Shows what came
                        showReceived(sRoute);

                        logout();
                    }
                    case "login.registro" -> {
                        //Shows what came
                        showReceived(sRoute);

                        register(sRoute);
                    }
                    case "login.update" -> {
                        //Shows what came
                        showReceived(sRoute);

                        update(sRoute);
                    }
                    //Users
                    case "usuario.delete" -> {
                        //Shows what came
                        showReceived(sRoute);

                        delete(sRoute);
                    }
                    //mensagem
                    case "mensagem.mensagem" -> {
                        //Shows what came
                        showReceived(sRoute);

                        mensagem();
                    }
                    //Client
                    case "cliente.usuarios-ativos" -> {
                        //Shows what came
                        showReceived(sRoute);

                        //usersOn();
                        //monitores();
                    }
                    case "cliente.usuarios" -> {
                        //Shows what came
                        showReceived(sRoute);

                        usersAll();
                    }
                    // Monitoring
                    case "monitoria.registro" -> {
                        showReceived(sRoute);

                        registerdaoMonitoring(sRoute);
                    }
                    case "monitoria.update" -> {
                        showReceived(sRoute);

                        updateMonitoring(sRoute);
                    }
                    case "monitoria.listar" -> {
                        showReceived(sRoute);

                        monitorings();
                    }
                    case "monitoria.listar-monitor" -> {
                        showReceived(sRoute);

                        monitors();
                    }
                    case "monitoria.listar-aluno" -> {
                        showReceived(sRoute);

                        students();
                    }
                    //Student
                    case "aluno-monitoria.inscrever" -> {
                        showReceived(sRoute);
                        studentRegister();
                    }
                    case "aluno-monitoria.delete" -> {
                        showReceived(sRoute);
                        studentDelete();
                    }
                    default -> {
                        legend = Color.RED;
                        //Shows what came
                        showReceived(sRoute);

                        errorRoute();
                    }
                }// </editor-fold>  
            }
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } catch (JSONException ex) {
            Logger.getLogger(ManagerServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                /*close failed*/
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Functions">

    //pronto
    private void login(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();

        // Convert Json String to User Object
        user = gson.fromJson(string, User.class);

        // Search for user in the bank
        user = dUser.search(user);

        boolean bUser = user.getUsuario() != null;

        JSONObject route = new JSONObject();
        JSONObject joUser = new JSONObject();
        route.put("rota", "login.login");

        // Valid user
        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Usuario ou Senha invalido");
        } else {
            legend = Color.BLACK;
            
            String sTypeUser = user.isIs_admin() ? "admin" : user.isIs_monitor() ? "monitor" : "aluno";
            route.put("erro", "false");
            route.put("tipo_usuario", sTypeUser);
            
            joUser.put("usuario", user.getUsuario());
            joUser.put("nome", user.getNome());
            joUser.put("tipo_usuario", sTypeUser);
            usuariosAtivos.put(joUser);
            
            // show client on
            usersController.includeClient(user.getUsuario());
        }

        //Send User
        String str = gson.toJson(user);

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
        
        if(bUser) usersOn();
    }

    //pronto
    private void logout() throws IOException, JSONException {
        JSONObject route = new JSONObject();
        route.put("rota", "login.logout");
        route.put("erro", "false");

        legend = Color.BLACK;

        // Shows what will be sent
        showSend(route.toString());
        int i = 0;

        for (; i < usuariosAtivos.length(); i++) {
            if (usuariosAtivos.getString(i).equals(user.getNome())) {
                break;
            }
        }
        usuariosAtivos.remove(i);

        // Send
        pr.println(route);
        pr.flush();

        usersOn();
        //pr.close();
    }

    //pronto
    private void register(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();

        // Convert Json String to User Object
        user = gson.fromJson(string, User.class);

        JSONObject route = new JSONObject();
        route.put("rota", "login.registro");

        // Create User in the bank
        boolean bUser = dUser.create(user);

        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Cadastro não efetuado!");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
        //pr.close();
    }

    //pronto
    private void update(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
        User rUser = gson.fromJson(string, User.class);

        user.setSenha(rUser.getSenha());
        user.setNome(rUser.getNome());
        user.setUsuario(rUser.getUsuario());
        user.setNovo_usuario(rUser.getNovo_usuario());
        

        // Search for user in the bank
        boolean bUser = dUser.update(rUser);

        JSONObject route = new JSONObject();
        route.put("rota", "login.update");

        // Valid user
        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Alteração nao realizada");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
        }

        // Shows what will be sent
        showSend(route.toString());

        // Send
        pr.println(route);
        pr.flush();
        //pr.close();
    }

    //pronto
    private void delete(String string) throws IOException, JSONException {
        UserDAO dUser = new UserDAO();
        boolean bUser;

        if (user.isIs_admin()) {
            User userD = new Gson().fromJson(string, User.class);
            bUser = dUser.delete(userD);
        } else {
            bUser = dUser.delete(user);
        }

        JSONObject route = new JSONObject();
        route.put("rota", "usuario.delete");

        // Valid user
        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Usuario nao deletado");
        } else {
            legend = Color.BLACK;

            if (user.isIs_admin()) {
                int i = 0, j = 0;
                for (; i < usuariosAtivos.length(); i++) {
                    if (usuariosAtivos.getString(i).equals(user.getNome())) {
                        j = 1;
                        break;
                    }
                }
                if (j == 1) {
                    usuariosAtivos.remove(i);
                }
            } else {
                int i = 0;

                for (; i < usuariosAtivos.length(); i++) {
                    if (usuariosAtivos.getString(i).equals(user.getNome())) {
                        break;
                    }
                }
                usuariosAtivos.remove(i);
            }

            route.put("erro", "false");

        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();

        usersOn();

        //pr.close();
    }

    private void mensagem() {

    }

    //NÃO MEXI
    private void errorRoute() throws JSONException, IOException {
        JOptionPane.showMessageDialog(
                null,
                "No route found",
                "Route error",
                JOptionPane.ERROR_MESSAGE
        );
        JSONObject route = new JSONObject();
        route.put("rota", "erro");
        route.put("erro", "mesagem_fora_do_padrao");
        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();

    }

    //mostrar monitores cadastrados APARENTEMENTE NAO VAI USAR
    private void monitors() throws JSONException, IOException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();

        // Search for user in the bank
        var monitores = dUser.read();

        boolean bUser = monitores != null;

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.listar-monitor");

        // Valid user
        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Nenhum monitor encontrado");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
            route.put("monitores", monitores);
        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();

    }
    //NAO MEXI
    private void registerdaoMonitoring(String sMonitoring) throws JSONException, IOException {
        Gson gson = new Gson();
        MonitoringDAO daoMonitoring = new MonitoringDAO();

        // Convert Json String to User Object
        var monitoria = gson.fromJson(sMonitoring, Monitoring.class);

        boolean bMonitoring = daoMonitoring.create(monitoria);

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.registro");

        if (!bMonitoring) {
            legend = Color.RED;
            route.put("erro", "Algo deu errado");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
            //route.put("monitores", monitores);
        }

        // Shows what will be sent
        //showSend(route.toString());
        // Send
        //pr.println(route);
        //pr.flush();
    }
    //NAO MEXI
    private void updateMonitoring(String sMonitoring) throws JSONException, IOException {
        Gson gson = new Gson();
        MonitoringDAO daoMonitoring = new MonitoringDAO();

        // Convert Json String to User Object
        var monitoria = gson.fromJson(sMonitoring, Monitoring.class);

        boolean bMonitoring = daoMonitoring.update(monitoria);

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.update");

        if (!bMonitoring) {
            legend = Color.RED;
            route.put("erro", "Algo deu errado");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
            //route.put("monitores", monitores);
        }

        // Shows what will be sent
        //showSend(route.toString());
        // Send
        //pr.println(route);
        //pr.flush();
    }

    //APARENTEMENTE NÃO VAI UTILIZAR
    private void monitorings() throws JSONException, IOException {
        MonitoringDAO daoMonitoring = new MonitoringDAO();

        var monitorings = daoMonitoring.read();

        boolean bMonitoring = monitorings != null;

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.listar");

        if (!bMonitoring) {
            legend = Color.RED;
            route.put("erro", "Algo deu errado");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
            route.put("monitores", monitorings);
        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
    }
    //NAO MEXI
    private void students() {
    }
    //NAO MEXI
    private void studentRegister() {
    }
    //NAO MEXI
    private void studentDelete() {
    }
    
    private void usersAll() throws JSONException, IOException{
        UserDAO dUser = new UserDAO();

        // Search for user in the bank
        var users = dUser.read();
        
        boolean bUser = users != null;

        JSONObject route = new JSONObject();
        route.put("rota", "cliente.usuarios");

        // Valid user
        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Nenhum usuario encontrado");
             showSend(route.toString());
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
            route.put("usuarios", users);
            serverController.includeLogUsers(route, false);
            System.out.println("Send -> " + route);
        }
       
        // Send
        pr.println(route);
        pr.flush();
    }
            
    private void usersOn() throws JSONException, IOException {
        JSONObject route = new JSONObject();
        route.put("rota", "cliente.usuarios-ativos");
        route.put("usuarios", usuariosAtivos);

        System.out.println("Send -> " + route);

        //Iterface Log
        serverController.includeLogUsers(route ,true);
        
        for (PrintWriter pw : listPw) {
            pw.println(route);
            pw.flush();
        }
    }

    // Shows what will be sent
    private void showSend(String send) throws IOException {
        //Terminal
        System.out.println("Send -> " + send);

        //Iterface Log
        serverController.includeLog("Send -> " + send, legend, Color.BLUE);

        //Log txt
        File fLog = new File("log.txt");
        try (FileWriter fwLog = new FileWriter(fLog, true)) {
            fwLog.write("Send -> " + send + "\n");
            fwLog.flush();
        }
    }

    //Shows what came
    private void showReceived(String received) throws IOException {
        //Terminal
        System.out.println("Received <- " + received);

        //Iterface Log
        serverController.includeLog("Received <- " + received, legend, Color.cyan);

        //Log txt
        File fLog = new File("log.txt");
        try (FileWriter fwLog = new FileWriter(fLog, true)) {
            fwLog.write("Received <- " + received + "\n");
            fwLog.flush();
        }
    }
    

    // </editor-fold>  
}
