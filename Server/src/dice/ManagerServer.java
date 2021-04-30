/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import entities.Route;
import entities.User;
import com.google.gson.Gson;
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

/**
 *
 * @author gui_o
 */
public class ManagerServer extends Thread {

    private InputStreamReader in;
    private BufferedReader bf;
    private PrintWriter pr;
    private final Socket clientSocket;
    private User user;

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

                //Shows what came
                showReceived(sRoute);

                // Convert Json String to Route Object
                Gson gson = new Gson();
                Route rRoute = gson.fromJson(sRoute, Route.class);
                switch (rRoute.getRota()) {
                    case "login.login" ->
                        login(sRoute);
                    case "login.logout" ->
                        logout();
                    case "login.registro" ->
                        register(sRoute);
                    case "login.update" ->
                        update(sRoute);
                    case "usuario.delete" ->
                        delete();
                    case "mensagem.mesagem" ->
                        mensagem();
                    default ->
                        errorRoute();
                }
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

    private void login(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();

        // Convert Json String to User Object
        user = gson.fromJson(string, User.class);

        // Search for user in the bank
        user = dUser.search(user);

        JSONObject route = new JSONObject();
        route.put("rota", "login.login");

        // Valid user
        if (user.getUsuario() == null) {
            route.put("erro", "Usuario ou Senha invalido");
        } else {
            usuariosAtivos.put(user.getUsuario());
            route.put("erro", "false");
        }

        //Send User
        String str = gson.toJson(user);

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();

        if ("false".equals(route.getString("erro"))) {

            sendToAll();
        }
        //pr.close();
    }

    private void logout() throws IOException, JSONException {
        JSONObject route = new JSONObject();
        route.put("rota", "login.logout");
        route.put("erro", "false");

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

        sendToAll();

        //pr.close();
    }

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
            route.put("erro", "Cadastro não efetuado!");
        } else {
            route.put("erro", "false");
        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
        //pr.close();
    }

    private void update(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
        User rUser = gson.fromJson(string, User.class);

        user.setSenha(rUser.getSenha());

        // Search for user in the bank
        boolean bUser = dUser.update(user);

        JSONObject route = new JSONObject();
        route.put("rota", "login.update");

        // Valid user
        if (!bUser) {
            route.put("erro", "Alteração nao realizada");
        } else {
            route.put("erro", "false");
        }

        String str = gson.toJson(user);

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
        //pr.close();
    }

    private void delete() throws IOException, JSONException {
        UserDAO dUser = new UserDAO();

        // Search for user in the bank
        boolean bool = dUser.delete(user);

        JSONObject route = new JSONObject();
        route.put("rota", "usuario.delete");

        // Valid user
        if (!bool) {
            route.put("erro", "Usuario nao deletado");
        } else {
            int i=0;
            
            for(; i < usuariosAtivos.length(); i++){
                if(usuariosAtivos.getString(i).equals(user.getNome())){
                    break;
                }
            }
            usuariosAtivos.remove(i);

            route.put("erro", "false");

        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
        
        sendToAll();

        //pr.close();
    }

    // Shows what will be sent
    private void showSend(String send) throws IOException {
        //Terminal
        System.out.println("Send -> " + send);

        //Iterface Log
        //logController.includeLog("Send -> "+send);
        
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
        //logController.includeLog("Received <- "+received);
        
        //Log txt
        File fLog = new File("log.txt");
        try (FileWriter fwLog = new FileWriter(fLog, true)) {
            fwLog.write("Received <- " + received + "\n");
            fwLog.flush();
        }
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

    private void sendToAll() throws JSONException, IOException {
        JSONObject route = new JSONObject();
        route.put("rota", "cliente.usuarios-ativos");
        route.put("usuarios", usuariosAtivos);
        
        System.out.println("Send -> " + route);

        //Iterface Log
        //logController.includeLog("Send -> "+route.toString());

        for (PrintWriter pw : listPw) {
            pw.println(route);
            pw.flush();
        }
    }
}
