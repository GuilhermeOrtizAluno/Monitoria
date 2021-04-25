package app;

import controllers.LogController;
import dice.TCPServer;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class Program extends Application {
    
    public Stage stage;
    public static Stage connectionServe;
    public static int door;
    public static LogController logController;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        LogController logController = new LogController();
        logController.main();
        
        
        
        TCPServer tcps = new TCPServer(door);
        tcps.StartConnection();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
