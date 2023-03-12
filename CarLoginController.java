package application;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.io.IOException;

public class CarLoginController {
	@FXML
	private TextField EmployeeField;
	
	@FXML
	private PasswordField PasswordField;
	
	@FXML
	private Button LoginButton;
	
	@FXML
	private Label invalidInformation; // label keeping track of wrong input
	
	protected String successPrompt = String.format("-fx-text-fill: GREEN;"); // correct input with green font
	protected String failurePrompt = String.format("-fx-text-fill: RED;"); // incorrect input with red font
	
	String userID = "197654325"; // temporary user id
	String Passkey = "password123"; // temporary password
	int login_attempt = 3; // number of login attempts
	
	public boolean isUsernameValid(String userinput) {
		return userinput.matches("^[0-9]{8}$"); // any number from 0 - 9 with total length of 9
	}
	public boolean isPasswordValid(String passkey) {
		// any small, big alphabet with numbers 0-9 including special characters ! or & with
		// total length of 13
		String password = "^[a-zA-Z0-9][!|&]{12}$"; 
		return passkey.matches(password);
	}
	

	public void LogIn(ActionEvent event) throws IOException 
	{
	// if username or password is blank
	 if(EmployeeField.getText().isBlank() && PasswordField.getText().isBlank()) 
	 {
		 invalidInformation.setText("Login fields required");
		 EmployeeField.setStyle(failurePrompt);
		 PasswordField.setStyle(failurePrompt);
	 }
	 else 
	 {   // if username itself is blank
		 if(EmployeeField.getText().isBlank())
		 {
			 EmployeeField.setStyle(failurePrompt);
			 invalidInformation.setText("Username required!");
			 EmployeeField.setStyle(successPrompt);
		 }
		 else 
		 {	 // if password is blank
			 if(PasswordField.getText().isBlank()) 
			 {
				 PasswordField.setStyle(failurePrompt);
				 invalidInformation.setText("Password required!");
				 PasswordField.setStyle(successPrompt);
			 }
			 else 
			 {
				 String userEntry = EmployeeField.getText();
				 String password = PasswordField.getText();
				 // check to see if login attempts is less than 3 and both username and 
				 // password matches the given key
				 if(login_attempt < 3 && userEntry.equals(userID) && password.equals(Passkey)){
				 	Main m  = new Main(); // if matches, then move Manager View page
				 	m.changeScene("ManagerViewUISample.fxml");
				 }
				 // if username is correct 
//				 if(EmployeeField.getText().equals(userID) || !PasswordField.getText().equals(Passkey)) {
//				 	PasswordField.clear();
//				 } // checking to see if login attempts is 4, and userEntry or password does not match given key
				 else if(login_attempt == 4 && !userEntry.equals(userID) && !password.equals(Passkey)){
				 	invalidInformation.setText("denied " + login_attempt); // label stating denied with login attempt
				 }
				 else{
					 // if exceeds login attempts, then clear password field
				 	invalidInformation.setText("Maximum attempt done! " + login_attempt);
				 	PasswordField.clear();
				 }
				 login_attempt++; // increment with button clicked
		    }
		}
	}
   }
}