package clientServe;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.json.simple.JSONObject;



public class Client{
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", Server.PORT);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nome", "Allan");
        jsonObject.put("sobrenome", "Romanato");
        jsonObject.put("pais", "Brasil");
        jsonObject.put("estado", "SP");
        PrintWriter pr = new PrintWriter(s.getOutputStream());  
        pr.println(jsonObject);
        pr.flush();
        
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        Gson gson = new Gson(); 
        /*Pessoa pessoa = gson.fromJson(str, Pessoa.class);
        System.out.println(pessoa);*/
        
        s.close();
    }
}