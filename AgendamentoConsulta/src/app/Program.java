package app;

import controllers.ClientController;
import controllers.ConnectionController;
import controllers.HomeController;
import controllers.LoginController;
import controllers.RegisterController;
import dice.ManagerClient;
import java.net.Socket;

/**
 *
 * @author gui_o
 */
public class Program  {
    
    public static Socket socket;
    public static ManagerClient managerClient;
    public static ClientController clientController;
    public static ConnectionController connectionController;
    public static LoginController loginController;
    public static RegisterController registerController;
    public static HomeController homeController;

    public static void main(String[] args) {
        socket = null;
        clientController = new ClientController();
        connectionController = new ConnectionController();
        loginController = new LoginController();
        managerClient = new ManagerClient();
        registerController = new RegisterController();
        homeController = new HomeController();
        clientController.start();
    }
    
}
