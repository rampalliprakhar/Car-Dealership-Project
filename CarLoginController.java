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
	
	int login_attempt = 0; // set login attempts to 0
	
    public static boolean isValidUsername(String userinput){
        if(userinput.length() > 8){ // if username input length is greater than 8
            //System.out.println("Invalid Username"); // print invalid username
        }
        return userinput.matches("^[0-9]{8}$"); // input size is 8, only has numbers 0-9
    }
    public static boolean isValidPassword(String passkey){
        if(passkey.length() > 11){ // if input length is greater than 11
            System.out.println("Invalid password"); // print invalid password
        }
        // input size between 0-11, all alphabets small and capital, numbers allowed
        String password = "^[a-zA-Z0-9][^!&]{0,11}$"; 
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
				 if(login_attempt < 3 && isValidUsername(userEntry) == true && isValidPassword(password) == true) {
					 Main m = new Main();
					 m.changeScene("ManagerViewUISample.fxml");
				 }
				 // if either username or password is incorrect, it denies and shows the login attempts made
				 else if(login_attempt == 4 && !isValidUsername(userEntry) == true || !isValidPassword(password) == true){
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