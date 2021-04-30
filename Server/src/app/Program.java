package app;

import controllers.ConnectionController;
import controllers.ServerController;

public class Program  {
    
    public static ServerController serverController;
    public static ConnectionController connectionController;
    
    public static void main(String[] args) {
        serverController = new ServerController();
        connectionController = new ConnectionController();
    }
    
}
