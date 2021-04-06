package clientServe;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.simple.parser.ParseException;



public class Server {
    
     public static final int PORT = 4999;
    
    public static void main(String[] args) throws IOException, ParseException {
        
        try (ServerSocket ss = new ServerSocket(PORT)) {
            
            Socket s = ss.accept();
            InputStreamReader in =  new InputStreamReader(s.getInputStream()); 
            BufferedReader  bf = new BufferedReader(in);
            String string = bf.readLine(); 
            Gson gson = new Gson(); 
            /*Pessoa pessoa = gson.fromJson(string, Pessoa.class);
            System.out.println(pessoa);*/
            
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println(string);
            pr.flush();
        }catch(Exception ex){
        }
    }
    
}
