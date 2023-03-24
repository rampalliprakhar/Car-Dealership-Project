package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.*;
import java.time.LocalDate;

public class CustomerProfileController {
	
	@FXML
	private TextField firstName, lastName, phoneNumber, customerID, streetAddress, city, state, zipCode, VINField;
	
	@FXML
	private DatePicker birthDate;
	
	@FXML
	private Text updateSuccessful;
	
	@FXML
	private Button addCusToSale, returnButton, updateProfile;
	
	@FXML
	public void initialize() {
		// test data
		// should get information from database from given Customer ID from searchCustomerController
		firstName.setText("Triny");
		lastName.setText("Nguyen");
		birthDate.setValue(LocalDate.of(2003,8,23));
		phoneNumber.setText("803");
		customerID.setText("675");
		streetAddress.setText("502 Manchester Dr");
		city.setText("Manning");
		state.setText("SC");
		zipCode.setText("29102");
		
		
		// change name requirements bc they can have numbers and symbols
		// only allows alphabetical characters
		firstName.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getText().matches("[^a-zA-Z'-]")) {
				return null;
			}
			return change;
		})); // add length limit
		
		// only allows alphabetical characters
		lastName.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getText().matches("[^a-zA-Z'-]")) {
				return null;
			}
			return change;
		})); // add length limit
		
		
		
		// birthdate
		
		
		
		// only allows numbers, parenthesis, and dashes
		phoneNumber.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getText().matches("[^0-9-()]")) {
				return null;
			}
			return change;
		})); // not correct
		
		
		
		// customer ID
		
		// street
		
		
		
		
		// only allows alphabetical characters
		city.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getText().matches("[^a-zA-Z]")) {
				return null;
			}
			return change;
		})); // add length limit
		
		// only allows alphabetical characters
		state.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getText().matches("[^a-zA-Z]")) {
				return null;
			}
			return change;
		})); // add length limit, not correct
		
		// only allows numbers
		zipCode.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getText().matches("[^0-9]")) {
				return null;
			}
			return change;
		})); // add 5 digit limit

		
//		firstName.setTextFormatter();
//		firstName.setInputMethodRequests(null);
	}
	
    public void pageReturn(ActionEvent event) throws IOException {
        
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchCustomerUI.fxml"));
    	Parent root = loader.load();
    	
    	SearchCustomerController searchCusController = loader.getController();
    	searchCusController.showInformation(firstName.getText(), lastName.getText());

    	Main m = new Main();
    	m.changeScene("SearchCustomerUI.fxml", root);
        
    } // end pageReturn	
    
    public void addCusToSale(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordOfSaleUI.fxml"));
    	Parent root = loader.load();
    	
    	RecordOfSaleController recSaleController = loader.getController();
    	recSaleController.showInformation(firstName.getText(), lastName.getText(), customerID.getText(), VINField.getText());

    	Main m = new Main();
    	m.changeScene("RecordOfSaleUI.fxml", root);
    }
    
    public void showInformation(String VIN) {
    	VINField.setText(VIN);
    }
    
    public void updateProfile(ActionEvent event) throws IOException {
//    change info in database
//    if success print out success through updateSuccessful Text field
//    if not, print out not successful
    }
}
