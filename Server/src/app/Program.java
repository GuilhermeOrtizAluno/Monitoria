package app;

import controllers.LogController;
import dice.TCPServer;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Program extends Application {
    
    public Stage stage;
    public static Stage connectionServe;
    public static int door;
    public static LogController logController;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../screens/Log.fxml"));
        Pane root = loader.load();
        logController = loader.getController();
        stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setOnCloseRequest(eh->{
            System.exit(0);
        });
        stage.show();
        connectionServe = new Stage();
        connectionServe.showAndWait();
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
