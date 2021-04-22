/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import org.json.JSONArray;
import screens.Log;

/**
 *
 * @author gui_o
 */
public class TCPServer {
      
    private int serverPort;
    private ServerSocket listenSocket;
    private Socket clientSocket;
    private ManagerServer managerServer;
    public static ArrayList<PrintWriter> listPw = new ArrayList();
    public static JSONArray usuariosAtivos = new JSONArray();
    
    private Log log;
    
    public void StartConnection()  {
        try{
            listenSocket = new ServerSocket(serverPort);
            
            log = new Log();
            log.startLog();
            
            while(true) {
                clientSocket = listenSocket.accept();
                String client = "Endereço "+clientSocket.getInetAddress()+" Conectado";
                log.includeLog(client, Color.GREEN);
                managerServer = new ManagerServer(clientSocket, log);
                managerServer.Connection();
            }
            
        } catch(IOException e) {
            System.out.println("Listen :"+e.getMessage());
        }
    }
   
    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

}

