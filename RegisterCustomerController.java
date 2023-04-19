/* --------------------------------------------------- 
 *  Author: Team 3 Car Dealership
 *  Written: 1/30/23
 *  Last Updated: 4/18/2023
 *  
 *  Compilation: javac RegisterCustomerController.java
 *  Execution: java RegisterCustomerController
 *  
 *  Handles registering a new customer
 *  Corresponding fxml file is RegCustomerUI.fxml
 ---------------------------------------------------*/

package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import dao.CustomerDao;
import backend.Address;
import backend.CustomerProfile;
import javafx.scene.control.TextFormatter;

public class RegisterCustomerController {
    
    
    // Declare UI Fields
    @FXML
    private TextField FirstNameField;
    @FXML
    private TextField LastNameField;
    @FXML
    private TextField AddressField;
    @FXML
    private TextField CityField;
    @FXML
    private TextField StateField;
    @FXML
    private TextField ZIPField;
    @FXML
    private TextField PhoneField;
    @FXML
    private TextField DriversLicenseField;
    @FXML
    private Button SaveButton;
    @FXML
    private Button ClearButton;
    @FXML
    private Button ReturnButton;
    
    private String previousPage = Main.getView();
    
    @FXML
    public void initialize() {


        // Length limit of 40
		// only allows alphabetical characters, dash, and apostrophe of up to 40 characters
		FirstNameField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		}));
		
		// only allows alphabetical characters, dash, and apostrophe of up to 40 characters
		LastNameField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		})); 
		
		// only allows numbers, parenthesis, and dashes
		PhoneField.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getText().matches("[^0-9-()]")) {
				return null;
			}
			return change;
		})); // not correct, add length limit
			
			
		// only allows numbers and uppercase characters up to 12
		DriversLicenseField.setTextFormatter(new TextFormatter<> (change -> {
				if ((change.getControlNewText().length() > 12) ||
				(change.getText().matches("[^A-Z1-9]"))) {
				return null;
			}
			return change;
		})); // change length limit NOWWWWW
		
		// only allows numbers and regular characters up to 40
		AddressField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
			(change.getText().matches("[^A-Za-z1-9\\s]"))) {
			return null;
		}
		return change;
	}));

		// only allows alphabetical characters and up to 40 characters
		CityField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z\\s]"))) {
				return null;
			}
			return change;
		}));
		
		// only allows alphabetical characters and up to 40 characters
		StateField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z\\s]"))) {
				return null;
			}
			return change;
		}));
		
		// only allows numbers and up to 5 digits
		ZIPField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 5) ||
				(change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		}));

    }
    
    public void save(ActionEvent event) throws IOException {
        
        /* This method will also need to save all of the inputs to the
         * newly created Customer object.*/
        
        Address custAddress = new Address(AddressField.getText(), CityField.getText(), StateField.getText(), ZIPField.getText(), "");
        
        custAddress.printAddress();
        
        /* Creates a new Customer with the information and a new DAO class.
         * Utilizes the DAO class to save the customer to the DB
         */
        CustomerProfile customer = new CustomerProfile(DriversLicenseField.getText(), FirstNameField.getText(), LastNameField.getText(), PhoneField.getText(), custAddress);
        CustomerDao dao = new CustomerDao();
        
        System.out.println(customer.toString());
        
        try {
            dao.saveCustomer(customer);
        } catch (Exception e) {
            System.out.println("Error in RegisterCustomerController.java");
        }
        
        // Sends user back to main screen once save is completed
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end save
    
    public void clear(ActionEvent event) throws IOException {
        
        // Clears and resets all data fields.
        
        FirstNameField.clear();
        LastNameField.clear();
        AddressField.clear();
        CityField.clear();
        StateField.clear();
        ZIPField.clear();
        PhoneField.clear();
        DriversLicenseField.clear();
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
        // Takes users back to previous page       
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
    
}
