package app;

import controllers.ClientController;
import controllers.ConnectionController;
import controllers.HomeController;
import controllers.LoginController;
import controllers.RegisterStudentController;
import controllers.RegisterMonitorController;
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
    public static RegisterStudentController registerStudentController;
    public static RegisterMonitorController registerMonitorController;
    public static boolean admin;
    
    public static String screen;

    public static void main(String[] args) {
        socket = null;
        admin = false;
        clientController = new ClientController();
        connectionController = new ConnectionController();
        loginController = new LoginController();
        managerClient = new ManagerClient();
        registerStudentController = new RegisterStudentController();
        registerMonitorController = new RegisterMonitorController();
        clientController.start();
    }
    
}
