package application;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
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
	private Text updateSuccessful, nullError;
	
	@FXML
	private Button addCusToSale, returnButton, updateProfile;
	    
	@FXML
	public void initialize() {  // is 40 a good length limit for the strings?
		
		// using giving customer ID, search database for the rest of the information 
		
		
		
		
		
		
		
		
		
		// test data
		firstName.setText("Triny");
		lastName.setText("Nguyen");
		phoneNumber.setText("8038239936");
		streetAddress.setText("502 Manchester Dr");
		city.setText("Manning");
		state.setText("SC");
		zipCode.setText("29102");
	    
		
		
		
		// note: customer ID length limit might be incorrect
		
		// input validation through text formatters
		
		// only allows alphabetical characters, dash, and apostrophe
		firstName.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getControlNewText().length() == 1) {
		    	change.setText(change.getText().toUpperCase());
			} // automatically turns first character into upper case
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		}));
		
		// only allows alphabetical characters, dash, and apostrophe
		lastName.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getControlNewText().length() == 1) {
		    	change.setText(change.getText().toUpperCase());
			} // automatically turns first character into upper case
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		})); 	
		
		// only allows numbers of up to 10 
		phoneNumber.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 10) ||
				(change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		}));	
			
		// only allows a capital letters or numbers of up to 16
		customerID.setTextFormatter(new TextFormatter<> (change -> {
		    	change.setText(change.getText().toUpperCase());					
			if ((change.getControlNewText().length() > 16) ||
				(change.getText().matches("[^A-Z0-9]"))) {
						
				return null;
			}
					
			return change;
		}));
		
		// only allows numbers and regular characters up to 40
		streetAddress.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
			(change.getText().matches("[^A-Za-z0-9\\s]"))) {
			return null;
		}
		return change;
	}));
		
		// only allows alphabetical characters and up to 40 characters
		city.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z\\s]"))) {
				return null;
			}
			return change;
		})); 
		
		// only allows alphabetical characters and up to 40 characters
		state.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z\\s]"))) {
				return null;
			}
			return change;
		}));
		
		// only allows numbers and up to 5 digits
		zipCode.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 5) ||
				(change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		}));
	}
	
	// switches and passes first and last name to search customer UI
    public void pageReturn(ActionEvent event) throws IOException {
        
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchCustomerUI.fxml"));
    	Parent root = loader.load();
    	
    	SearchCustomerController searchCusController = loader.getController();
    	searchCusController.showInformation(firstName.getText(), lastName.getText());

    	Main m = new Main();
    	m.changeScene("SearchCustomerUI.fxml", root);
        
    } // end pageReturn	
    
    // switches and passes information to record of sale UI 
    public void addCusToSale(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordOfSaleUI.fxml"));
    	Parent root = loader.load();
    	
    	RecordOfSaleController recSaleController = loader.getController();
    	recSaleController.showInformation(firstName.getText(), lastName.getText(), customerID.getText(), yearField.getText(), makeDropdown.getValue(), 
    	modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());

    	Main m = new Main();
    	m.changeScene("RecordOfSaleUI.fxml", root);
    } 
    
    // receives information from search customer UI
    public void showInformation(String ID, String year, String make, String model, String VIN, String price, String paymentMethod, LocalDate salesDate) {
    	customerID.setText(ID);
    	yearField.setText(year);
    	makeDropdown.setValue(make);
    	modelField.setText(model);
    	VINField.setText(VIN);
    	valueField.setText(price);
    	this.paymentMethod.setValue(paymentMethod);
    	this.salesDate.setValue(salesDate);
    }
    
    public void updateProfile(ActionEvent event) throws IOException {
    	
    	// input validation
    	
    	// if any fields are empty return and print out error message
    	if (customerID.getText().length() == 0 || firstName.getText().length() == 0 || 
    			lastName.getText().length() == 0 || phoneNumber.getText().length() == 0 || 
    			streetAddress.getText().length() == 0 || city.getText().length() == 0 || 
    			state.getText().length() == 0 || zipCode.getText().length() == 0) {
        	
    		updateSuccessful.setText(null);
    		nullError.setText("*Error: Please fill out all input fields*");
    		return;
    	}
    	
    	// if zip is less than 5 digits print out error message
    	if (zipCode.getText().length() < 5) {
    		updateSuccessful.setText(null);
    		nullError.setText("*Error: Please input a valid zip code*");
    		return;	
    	}

    	// if phone number is less than 10 or a series of a repeating number print out error message
    	if (phoneNumber.getText().length() < 10 || validPhoneNum() == false) {
    		updateSuccessful.setText(null);
    		nullError.setText("*Error: Please input a valid phone number*");
    		return;	
    	}
    	
    	
    	// validate city, state, address? 
    	
    	// end input validation
    	
    	
    	
    	
    	
//      update info in database

    	
    	
    	
    	
    	
    	
    	// confirmation message
		nullError.setText(null);
		updateSuccessful.setText("Changes Saved");
    }
    
    // input validation: returns false if phone number is series of repeating number
    public boolean validPhoneNum() {
    	char a = phoneNumber.getText().charAt(0);
    	for (int i = 1; i < phoneNumber.getText().length(); i++) {
    	if (phoneNumber.getText().charAt(i) != a)
    		return true;
    	}
    	return false;
    }
}
