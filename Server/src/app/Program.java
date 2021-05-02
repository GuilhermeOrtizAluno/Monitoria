package app;

import controllers.ConnectionController;
import controllers.ServerController;
import controllers.UsersController;

public class Program  {
    
    public static ServerController serverController;
    public static ConnectionController connectionController;
    public static UsersController usersController;
    
    public static void main(String[] args) {
        serverController = new ServerController();
        connectionController = new ConnectionController();
        usersController = new UsersController();
        serverController.start();
    }
    
}
