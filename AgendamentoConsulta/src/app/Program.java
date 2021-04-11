package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author gui_o
 */
public class Program extends Application {
   
    public static Socket s;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Client(primaryStage);
    }
    
    private void Client(Stage primaryStage) throws IOException{
        try {
            s = new Socket("localhost", 4999);
            File fLog = new File("log.txt"); 
            fLog.createNewFile();
            FileWriter fwLog = new FileWriter(fLog); 
            fwLog.write("conectado\n");
            fwLog.flush();
            fwLog.close();
        } catch (IOException ex) {
            int answerDialog = JOptionPane.showConfirmDialog(null, "Try to connect again", "Error Server", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if(answerDialog == JOptionPane.YES_OPTION)
                Client(primaryStage);
            else System.exit(0);
        } finally{
            Pane root = FXMLLoader.load(getClass().getResource("../Screens/Login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
