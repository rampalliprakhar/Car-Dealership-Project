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
	public void initialize() {  // is 40 a good length limit for the strings?
		
		// using giving customer ID, search database for the rest of the information 
		
		
		
		
		// test data
		firstName.setText("Triny");
		lastName.setText("Nguyen");
		phoneNumber.setText("8038239936");
//		customerID.setText("Y");
		streetAddress.setText("502 Manchester Dr");
		city.setText("Manning");
		state.setText("SC");
		zipCode.setText("29102");
	    
		// can names have numbers and special characters other than dashes and apostrophe????
		
		// only allows alphabetical characters, dash, and apostrophe
		firstName.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getControlNewText().length() == 1) {
		    	change.setText(change.getText().toUpperCase());
			}
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
			}
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
		})); // should we allow them to type dashes and parenthesis?, 
			// if so then add input validation to make sure dashes are in correct spot and there are 2 of them
			// add dashes automatically if none are typed
			
			
//		// only allows a capital letters or numbers of up to 16
		customerID.setTextFormatter(new TextFormatter<> (change -> {
		    	change.setText(change.getText().toUpperCase());					
			if ((change.getControlNewText().length() > 16) ||
				(change.getText().matches("[^A-Z0-9]"))) {
						
				return null;
			}
					
			return change;
		})); // change length limit?
//			// automatically add dashes?
		
		// only allows numbers and regular characters up to 40
		streetAddress.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
			(change.getText().matches("[^A-Za-z0-9\\s]"))) {
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
//    change info in database
//    if success print out success through updateSuccessful Text field
//    if not, print out not successful
    }
}
