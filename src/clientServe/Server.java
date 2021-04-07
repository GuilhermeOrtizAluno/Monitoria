package clientServe;

import dice.Login;
import com.google.gson.Gson;
import crud.UserDAO;
import dice.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
    
     public static final int PORT = 4999;
    
    public static void main(String[] args) throws IOException {
        
        try (ServerSocket ss = new ServerSocket(PORT)) {
            
            Socket s = ss.accept();
            InputStreamReader in =  new InputStreamReader(s.getInputStream()); 
            BufferedReader  bf = new BufferedReader(in);
            String string = bf.readLine(); 
            Gson gson = new Gson(); 
            Login login = gson.fromJson(string, Login.class);
            System.out.println(login);
            
            User user = new User();
            user.setUsuario(login.getUsuario());
            
            UserDAO userDao = new UserDAO();
            
            int search = userDao.search(user);
            
            System.out.println(search);
            
            /*PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println(string);
            pr.flush();*/
        }catch(Exception ex){
        }
    }
    
}
