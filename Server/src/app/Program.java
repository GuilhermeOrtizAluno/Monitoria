package app;

import com.google.gson.Gson;
import crud.StudentDAO;
import crud.UserDAO;
import dice.Route;
import dice.Student;
import dice.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Program extends Application {
    
    public static Socket socket;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("../Screens/Log.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
