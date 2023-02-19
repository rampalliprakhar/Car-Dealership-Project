package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Parent;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class CarLoginController {
	private Stage stage;
	private Scene scene;
	@FXML
	private TextField EmployeeField;
	
	@FXML
	private PasswordField PasswordField;
	
	@FXML
	private Button LoginButton;
	
 
	 public void LogIn(ActionEvent event) throws IOException {
	  if(event.getSource() == LoginButton) {
		  Parent root = FXMLLoader.load(getClass().getResource("SalespersonView.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show(); 
	  }
	 }
}
