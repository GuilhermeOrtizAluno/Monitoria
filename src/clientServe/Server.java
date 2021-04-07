package clientServe;

import com.google.gson.Gson;
import crud.UserDAO;
import dice.Route;
import dice.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.simple.JSONObject;



public class Server {
    
    public static final int PORT = 4999;
    
    private static Socket s;
    
    public static void main(String[] args) throws IOException {
        
        try (ServerSocket ss = new ServerSocket(PORT)) {
            
            s = ss.accept();
            InputStreamReader in =  new InputStreamReader(s.getInputStream()); 
            BufferedReader  bf = new BufferedReader(in);
            String string = bf.readLine(); 
            Gson gson = new Gson(); 
            Route route = gson.fromJson(string, Route.class);
            
            switch(route.getRota()){
                case "login.login": login(string); break;
            }
            
            
        }catch(Exception ex){
        }
    }
    
    private static void login(String string) throws IOException{
        Gson gson = new Gson(); 
        User user = gson.fromJson(string, User.class);

        UserDAO userDao = new UserDAO();

        user = userDao.search(user);
        
        String str = gson.toJson(user);
        
        PrintWriter pr = new PrintWriter(s.getOutputStream());  
        pr.println(str);
        pr.flush();

    }
    
}

