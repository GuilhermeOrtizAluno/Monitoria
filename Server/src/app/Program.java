package app;

import com.google.gson.Gson;
import crud.StudentDAO;
import crud.UserDAO;
import dice.Route;
import dice.Student;
import dice.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

public class Program {

    public static final int PORT = 4999;

    private static Socket s;

    public static void main(String[] args) throws IOException {

        try (ServerSocket ss = new ServerSocket(PORT)) {
           
            File fLog = new File("log.txt"); 
            fLog.createNewFile();
            FileWriter fwLog = new FileWriter(fLog); 
            fwLog.write("conectado\n");
            fwLog.flush();
            fwLog.close();
            
            
            // Accept connection
            s = ss.accept();
            while (true) {
            
                // Receive string
                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                //Read String
                String sRoute = bf.readLine();
                //Shows what came
                System.out.println(sRoute);
                fwLog = new FileWriter(fLog, true); 
                fwLog.write(sRoute+"\n");
                fwLog.flush();
                fwLog.close();

                // Convert Json String to Route Object
                Gson gson = new Gson();
                Route rRoute = gson.fromJson(sRoute, Route.class);

                switch (rRoute.getRota()) {
                    case "login.login"  -> login(sRoute);
                    case "login.logout" -> logout();
                    case "login.registro" -> register(sRoute);
                    case "login.update" -> update(sRoute);
                    case "usuario.delete" -> delete(sRoute);
                }
            }

        } catch (Exception ex) {
        }

    }

    private static void login(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 
        
        // Convert Json String to User Object
        User user = gson.fromJson(string, User.class);
        
        // Search for user in the bank
        user = dUser.search(user);
        
        JSONObject route = new JSONObject();
        route.put("rota", "login.login"); 
       
        // Valid user
        if(user.getUsuario() == null)
           route.put("erro", "Usuario ou Senha invalido");
        else route.put("erro", "false");
        
        /* String str = gson.toJson(user); */

        // Shows what will be sent
        fwLog.write(route.toString()+"\n");
        fwLog.flush();
        fwLog.close();
        // Send
        System.out.println(route);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
    }
    
    private static void logout() throws IOException, JSONException{
        JSONObject route = new JSONObject();
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 
        
        route.put("rota", "login.logout");
        route.put("erro", "false");
        
        // Shows what will be sent
        System.out.println(route);
        fwLog.write(route.toString()+"\n");
        fwLog.flush();
        fwLog.close();
        // Send
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
    }
    
    private static void register(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 

        // Convert Json String to User Object
        User user = gson.fromJson(string, User.class);

        JSONObject route = new JSONObject();
        route.put("rota", "login.registro"); 
        
        // Create User in the bank
        
        boolean q = dUser.create(user);
        
        if(q != true){
            route.put("erro", "Cadastro não efetuado!");
        }else{
            route.put("erro", "false");
        }

        // Shows what will be sent
        System.out.println(route);
        fwLog.write(route.toString()+"\n");
        fwLog.flush();
        fwLog.close();
        // Send
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
     }
    
    private static void update(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 
        
        // Convert Json String to User Object
        User user = gson.fromJson(string, User.class);
        
        // Search for user in the bank
        boolean bool = dUser.update(user);
        
        JSONObject route = new JSONObject();
        route.put("rota", "login.update"); 
       
        // Valid user
        if(!bool)
            route.put("erro", "Alteração nao realizada");
        else 
            route.put("erro", "false");
        
        /* String str = gson.toJson(user); */

        // Shows what will be sent
        fwLog.write(route.toString()+"\n");
        fwLog.flush();
        fwLog.close();
        // Send
        System.out.println(route);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
    }
    private static void delete(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
        File fLog = new File("log.txt");
        FileWriter fwLog = new FileWriter(fLog, true); 
        
        // Convert Json String to User Object
        User user = gson.fromJson(string, User.class);
        
        // Search for user in the bank
        boolean bool = dUser.delete(user);
        
        JSONObject route = new JSONObject();
        route.put("rota", "usario.delete"); 
       
        // Valid user
        if(!bool)
            route.put("erro", "Usuario nao deletado");
        else 
            route.put("erro", "false");
        
        /* String str = gson.toJson(user); */

        // Shows what will be sent
        fwLog.write(route.toString()+"s\n");
        fwLog.flush();
        fwLog.close();
        // Send
        System.out.println(route);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(route);
        pr.flush();
        //pr.close();
    }

}
