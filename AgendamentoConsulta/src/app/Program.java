package app;
import dice.ManagerClient;

/**
 *
 * @author Guilherme Ortiz
 */
public class Program  {
    
    public static ManagerClient managerClient;

    public static void main(String[] args) {
        managerClient = new ManagerClient();
        managerClient.startProgram();
    }
    
}
