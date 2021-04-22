package app;

import dice.ManagerClient;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import screens.Log;

/**
 *
 * @author gui_o
 */
public class Program extends Application {
    
    public static Socket socket = null;
    public static Log log;
    public static ManagerClient managerClient;
    public Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        try{
            stage = new Stage();
            Pane root = FXMLLoader.load(getClass().getResource("../screens/ClientConection.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            primaryStage.setOnCloseRequest(eh->{
                System.exit(0);
            });
            stage.showAndWait();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            managerClient = new ManagerClient();
            managerClient.startReceived();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
