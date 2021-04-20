/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author gui_o
 */
public class TCPServer {
      
   private int serverPort;
   private ServerSocket listenSocket;
   private Socket clientSocket;
   private ManagerServer c;
    
   public void StartConnection()  {
    try{
         listenSocket = new ServerSocket(serverPort);
         while(true) {
             clientSocket = listenSocket.accept();
             c = new ManagerServer(clientSocket);
             c.Connection();
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

