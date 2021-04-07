package app;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author gui_o
 */
public class Program extends Application {
   
    
    @Override
    public void start(Stage primaryStage) throws IOException {
           Pane root =  FXMLLoader.load(getClass().getResource("../Screens/Login.fxml"));
           
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
