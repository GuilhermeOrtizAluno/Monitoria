package app;

import controllers.ClientController;
import controllers.ConnectionController;
import controllers.LoginController;
import controllers.ManagementMonitorController;
import controllers.RegisterStudentController;
import controllers.RegisterMonitorController;
import controllers.UpdateStudentController;
import dice.ManagerClient;
import java.net.Socket;
import org.json.JSONArray;

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
    public static ManagementMonitorController managementMonitorController;
    public static UpdateStudentController updateStudentController;
    public static JSONArray monitorsAll;
    public static boolean admin;
    public static String screen;
    public static String usernameON;

    public static void main(String[] args) {
        socket = null;
        admin = false;
        monitorsAll = new JSONArray();
        clientController = new ClientController();
        connectionController = new ConnectionController();
        loginController = new LoginController();
        managerClient = new ManagerClient();
        registerStudentController = new RegisterStudentController();
        registerMonitorController = new RegisterMonitorController();
        managementMonitorController = new ManagementMonitorController();
        updateStudentController = new UpdateStudentController();
        clientController.start();
    }
    
}
