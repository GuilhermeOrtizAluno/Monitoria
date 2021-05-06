/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import static app.Program.*;
import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/**
 * Gerenciador de Cliente
 * @author gui_o
 * Receptor de conexão
 * Encaminha para o serviço do servidor
 */
public class TCPServer extends Thread{
      
    private final int serverPort;
    private ServerSocket listenSocket;
    private Socket clientSocket;
    private ManagerServer managerServer;
    public static ArrayList<PrintWriter> listPw;
    public static JSONArray usuariosAtivos;

    public TCPServer(int serverPort) {
        this.serverPort = serverPort;
    }
    
    public void StartConnection() throws IOException  {
        listenSocket = new ServerSocket(serverPort);
        listPw = new ArrayList<>();
        usuariosAtivos = new JSONArray();
        start();
    }
    
    @Override
    public void run() {
        serverController.includeLog("Aguardado primeira conexão...", Color.BLACK, Color.WHITE);
        while(true) {
            try {
                clientSocket = listenSocket.accept();
                String client = "Endereço "+clientSocket.getInetAddress()+" Conectado";
                serverController.includeLog(client, Color.BLACK, new Color(204, 0, 204));
                managerServer = new ManagerServer(clientSocket);
                managerServer.Connection();
            } catch (IOException ex) {
                Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
    }
}

