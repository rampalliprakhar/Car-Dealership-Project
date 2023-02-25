package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.*;
import java.time.LocalDate;

public class CustomerProfileController {
	
	@FXML
	private TextField firstName, lastName, phoneNumber, customerID, streetAddress, city, state, zipCode;
	
	@FXML
	private DatePicker birthDate;
	
	@FXML
	private Text updateSuccessful;
	
//	@FXML
//	private Button updateProfile;
	
	@FXML
	private Button addCusToSale, returnButton, updateProfile;
	
	@FXML
	public void initialize() {
		// test data
		// should get information from database from given Customer ID from searchCustomerController
		LocalDate date = LocalDate.now();
		firstName.setText("Triny");
		lastName.setText("Nguyen");
		birthDate.setValue(date);
		phoneNumber.setText("803");
		customerID.setText("675");
		streetAddress.setText("502 Manchester Dr");
		city.setText("Manning");
		state.setText("SC");
		zipCode.setText("29102");
		
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
    	
//    	Main m = new Main();
//    	m.changeScene("RecordOfSaleUI.fxml");
    }
    
//    public void updateProfile(ActionEvent event) throws IOException {
//
////		firstName.getSelectedText();
//
//    	// change info in database
    
    
    
    
    

//    if success print out success through updateSuccessful Text field
//    if not, print out not successful
//    }

}
