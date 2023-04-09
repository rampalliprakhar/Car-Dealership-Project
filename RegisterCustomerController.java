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
import javafx.scene.text.Text;

public class RegisterCustomerController {
    
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
	@FXML
	private Text updateSuccessful, nullError;
    
    private String previousPage = Main.getView();
    
	@FXML
    public void initialize() {
    	
		// change name requirements bc they can have numbers and symbols????
        // is 40 a good length limit?
	    
		// only allows alphabetical characters, dash, and apostrophe
		FirstNameField.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getControlNewText().length() == 1) {
		    	change.setText(change.getText().toUpperCase());
			}
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		})); 
		
		// only allows alphabetical characters, dash, and apostrophe of up to 40 characters
		LastNameField.setTextFormatter(new TextFormatter<> (change -> {
			 // guarentees first letter is capital
			if (change.getControlNewText().length() == 1) {
		    	change.setText(change.getText().toUpperCase());
			}
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		})); 
		
		// only allows numbers, parenthesis, and dashes
		PhoneField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 10) ||
				(change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		}));
				
		// only allows numbers and uppercase characters up to 16
		DriversLicenseField.setTextFormatter(new TextFormatter<> (change -> {
				change.setText(change.getText().toUpperCase());					
				if ((change.getControlNewText().length() > 16) ||
				(change.getText().matches("[^A-Z0-9]"))) {
				return null;
			}
			return change;
		})); // length limit correct?
		
		// only allows numbers and regular characters up to 40
		AddressField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
			(change.getText().matches("[^A-Za-z0-9\\s]"))) {
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
    	
    	// input validation
    	
    	// if any fields are empty return and print out error message
    	if (DriversLicenseField.getText().length() == 0 || FirstNameField.getText().length() == 0 || 
    			LastNameField.getText().length() == 0 || PhoneField.getText().length() == 0 || 
    			AddressField.getText().length() == 0 || CityField.getText().length() == 0 || 
    			StateField.getText().length() == 0 || ZIPField.getText().length() == 0) {
        	
    		updateSuccessful.setText(null);
    		nullError.setText("*Error: Please fill out all input fields*");
    		return;
    	}
    	
    	// if zip is less than 5 digits print out error message
    	if (ZIPField.getText().length() < 5) {
    		updateSuccessful.setText(null);
    		nullError.setText("*Error: Please input a valid zip code*");
    		return;	
    	}

    	// if phone number is less than 10 or a series of a repeating number print out error message
    	if (PhoneField.getText().length() < 10 || validPhoneNum() == false) {
    		updateSuccessful.setText(null);
    		nullError.setText("*Error: Please input a valid phone number*");
    		return;	
    	}
    	    	
    	// end input validation
    	        
        Address custAddress = new Address(AddressField.getText(), CityField.getText(), StateField.getText(), ZIPField.getText(), "");
        
        custAddress.printAddress(); // DEBUG
        
        String licenseAsString = DriversLicenseField.getText();
        Long licenseNum = null;
        if (licenseAsString != null && licenseAsString.length() > 0) licenseNum = Long.decode(licenseAsString);
        
        CustomerProfile customer = new CustomerProfile(licenseNum, FirstNameField.getText(), LastNameField.getText(), PhoneField.getText(), custAddress);
        CustomerDao dao = new CustomerDao();
        
        System.out.println(customer.toString());
        
        try {
            dao.saveCustomer(customer);
        } catch (Exception e) {
            System.out.println("Error in RegisterCustomerController.java");
        }
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end save
    
    public void clear(ActionEvent event) throws IOException {
        
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
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
	
    // receives information from the search customer UI
    public void showInformation(String firstName, String lastName) {
    	FirstNameField.setText(firstName);
    	LastNameField.setText(lastName);
    }
    
    // input validation: returns false if phone number is series of repeating number
    public boolean validPhoneNum() {
    	char a = PhoneField.getText().charAt(0);
    	for (int i = 1; i < PhoneField.getText().length(); i++) {
    	if (PhoneField.getText().charAt(i) != a)
    		return true;
    	}
    	return false;
    }
    
}
