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
	
	// customerID refers to the driver's license number
	
	@FXML
	private TextField firstName, lastName, phoneNumber, customerID, streetAddress, city, state, zipCode, VINField, yearField, modelField, valueField;
	
	@FXML
    private ChoiceBox<String> makeDropdown, paymentMethod;
	
    @FXML
    private DatePicker salesDate;
	
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
		phoneNumber.setText("803");
		customerID.setText("675");
		streetAddress.setText("502 Manchester Dr");
		city.setText("Manning");
		state.setText("SC");
		zipCode.setText("29102");
		
		
		// change name requirements bc they can have numbers and symbols????
		// only allows alphabetical characters, dash, and apostrophe
		firstName.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		})); // change length limit?
		
		// only allows alphabetical characters, dash, and apostrophe
		lastName.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		})); // change length limit?		
		
		// only allows numbers, parenthesis, and dashes
		phoneNumber.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getText().matches("[^0-9-()]")) {
				return null;
			}
			return change;
		})); // not correct
			
			
		// only allows numbers and uppercase characters up to 12
		customerID.setTextFormatter(new TextFormatter<> (change -> {
				if ((change.getControlNewText().length() > 12) ||
				(change.getText().matches("[^A-Z1-9]"))) {
				return null;
			}
			return change;
		})); // change length limit NOWWWWW
		
		// only allows numbers and regular characters up to 40
		streetAddress.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
			(change.getText().matches("[^A-Za-z1-9\\s]"))) {
			return null;
		}
		return change;
	})); // change length limit?
		
		// only allows alphabetical characters and up to 40 characters
		city.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z\\s]"))) {
				return null;
			}
			return change;
		})); // add length limit
		
		// only allows alphabetical characters and up to 40 characters
		state.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z\\s]"))) {
				return null;
			}
			return change;
		})); // add length limit, not correct
		
		// only allows numbers and up to 5 digits
		zipCode.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 5) ||
				(change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		}));
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
    	recSaleController.showInformation(firstName.getText(), lastName.getText(), customerID.getText(), yearField.getText(), makeDropdown.getValue(), modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());

    	Main m = new Main();
    	m.changeScene("RecordOfSaleUI.fxml", root);
    }
    
    public void showInformation(String year, String make, String model, String VIN, String price, String paymentMethod, LocalDate salesDate) {
    	yearField.setText(year);
    	makeDropdown.setValue(make);
    	modelField.setText(model);
    	VINField.setText(VIN);
    	valueField.setText(price);
    	this.paymentMethod.setValue(paymentMethod);
    	this.salesDate.setValue(salesDate);
    }
    
    public void updateProfile(ActionEvent event) throws IOException {
//    change info in database
//    if success print out success through updateSuccessful Text field
//    if not, print out not successful
    }
}
