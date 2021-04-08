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
import org.json.JSONException;
import org.json.JSONObject;

public class Server {

    public static final int PORT = 4999;

    private static Socket s;

    public static void main(String[] args) throws IOException {

        try (ServerSocket ss = new ServerSocket(PORT)) {
            System.out.println("Server running in Port: " + PORT);
            while (true) {
                s = ss.accept();

                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);

                String string = bf.readLine();

                Gson gson = new Gson();
                Route route = gson.fromJson(string, Route.class);

                switch (route.getRota()) {
                    case "login.login": {
                        login(string);
                        break;
                    }
                    case "login.logout":
                        PrintWriter pr = new PrintWriter(s.getOutputStream());
                        pr.println("Desconectado do servidor!");
                        pr.flush();
                        break;
                }
            }

        } catch (Exception ex) {
        }

    }

    private static void login(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        User user = gson.fromJson(string, User.class);

        UserDAO userDao = new UserDAO();

        user = userDao.search(user);
        
        JSONObject jsonObject = new JSONObject();
        
       // validaçao login e senha
       /* if(user.getPk_usuario() == 0){
            jsonObject.put("rota", "login.login"); 
            jsonObject.put("erro", "Login ou senha invalidos");
        }else{
            System.out.println("usuario y:"+user);
            jsonObject.put("rota", "login.login");
            jsonObject.put("nome", user.getNome());
            jsonObject.put("pk_usuario", user.getPk_usuario());
            jsonObject.put("usuario", user.getUsuario());
            jsonObject.put("is_admin", user.isIs_admin());
            jsonObject.put("is_monitor", user.isIs_monitor());
        }*/

        String str = gson.toJson(user);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(str);
        pr.flush();

    }

}
