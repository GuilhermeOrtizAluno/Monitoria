/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import static app.Program.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import org.json.JSONArray;

/**
 *
 * @author gui_o
 */
public class TCPServer{
      
    private final int serverPort;
    private ServerSocket listenSocket;
    private Socket clientSocket;
    private ManagerServer managerServer;
    public static ArrayList<PrintWriter> listPw;
    public static JSONArray usuariosAtivos;

    public TCPServer(int serverPort) {
        this.serverPort = serverPort;
    }
    
    public void StartConnection()  {
        try{
            listenSocket = new ServerSocket(serverPort);
            listPw = new ArrayList<>();
            usuariosAtivos = new JSONArray();
            
            while(true) {
                clientSocket = listenSocket.accept();
                String client = "Endereço "+clientSocket.getInetAddress()+" Conectado";
                //serverController.includeLog(client);
                managerServer = new ManagerServer(clientSocket);
                managerServer.Connection();
            }
            
        } catch(IOException e) {
            System.out.println("Listen :"+e.getMessage());
        }
    }
}

