package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import java.io.IOException;
public class CarLogOutController {
     @ FXML
     private Button LogoutButton;
     private Stage stage;
     private Scene scene;
     private Parent root;
    
     public void LogOut(ActionEvent event) throws IOException {
         Platform.exit();
         
         
         
//         try {
//            root = FXMLLoader.load(getClass().getResource("CarLogout.fxml"));
//            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();   
//            LogoutButton.setOnAction(e -> {
//              e.consume();
//            }); 
//         } catch(Exception e) {
//            e.printStackTrace();
//        }
    }
 
}
