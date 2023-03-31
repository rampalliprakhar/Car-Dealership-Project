package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

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
//    private ChoiceBox<String> StateField;
    @FXML
    private TextField ZIPField;
    @FXML
    private TextField PhoneField;
    @FXML
    private TextField DriversLicenseField;
    @FXML
    private DatePicker DOBPicker;
    @FXML
    private Button SaveButton;
    @FXML
    private Button ClearButton;
    @FXML
    private Button ReturnButton;
    
    private String previousPage = Main.getView();
    
    @FXML
    public void intitialize() {

		// change name requirements bc they can have numbers and symbols????
		// only allows alphabetical characters, dash, and apostrophe
		FirstNameField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		})); // change length limit?
		
		// only allows alphabetical characters, dash, and apostrophe
		LastNameField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z'-]"))) {
				return null;
			}
			return change;
		})); // change length limit?		
		
		// only allows numbers, parenthesis, and dashes
		PhoneField.setTextFormatter(new TextFormatter<> (change -> {
			if (change.getText().matches("[^0-9-()]")) {
				return null;
			}
			return change;
		})); // not correct
			
			
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
	})); // change length limit?

		// only allows alphabetical characters and up to 40 characters
		CityField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z\\s]"))) {
				return null;
			}
			return change;
		})); // change length limit?
		
		// only allows alphabetical characters and up to 40 characters
		StateField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z\\s]"))) {
				return null;
			}
			return change;
		})); // change length limit?
		
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
        
        CustomerProfile customer = new CustomerProfile(FirstNameField.getText(), LastNameField.getText(), PhoneField.getText(), DOBPicker.getValue(), custAddress);
        // Future code: Save customer to database.
        
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
    
    
    
    public void showInformation(String firstName, String lastName) {
    	FirstNameField.setText(firstName);
    	LastNameField.setText(lastName);
    }
    
}
