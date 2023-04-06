package application;

import java.io.IOException;
import java.time.LocalDate;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.application.Application;

public class SearchCustomerController {
    @FXML
    private ChoiceBox<String> makeDropdown, paymentMethod;
    
    @FXML
    private DatePicker salesDate;

	
	private CustomerProfile selectedCus;
	
    @FXML
    private TextField firstName, lastName, VINField, yearField, modelField, valueField, tempFirst, tempLast, tempID, realCusID;
    
    @FXML
    private Button searchButton, clearButton, returnButton, registerNewCustomer;
    
//    private String previousPage = Main.getView();

    
//    @FXML
//    private MenuItem selectButton;
    
    @FXML
    private ListView<String> listView;
    
    @FXML
    public void initialize() {    	
    	
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
    }
        
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/
        
        firstName.clear();
        lastName.clear();
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordOfSaleUI.fxml"));
    	Parent root = loader.load();
    	
    	RecordOfSaleController controller = loader.getController();
    	controller.showInformation(tempFirst.getText(), tempLast.getText(), tempID.getText(), yearField.getText(), makeDropdown.getValue(), modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());
    	
    	Main m = new Main();
    	m.changeScene("RecordOfSaleUI.fxml", root);
    } // end pageReturn
    
    public void searchCus(ActionEvent event) throws IOException {    	
    	
    	// listView.setItems(list); make list of all customer from database with inputed name?
    	
    	// database needed: search database and get name, DOB, and ID
    	
    	
    	// test data
    	String fullName = firstName.getText() + " " + lastName.getText();
    	String DOB = "08/23/2003";
    	int customerID = 5092; // should ID be string to allow a 0 in the front ex: 0873

      for (int i = 0; i < 4; i++) {
      	listView.getItems().addAll("Name:    " + fullName +"\n" + 
      							   "DOB:      " + DOB + "\n" + 
      							   "ID:          " + customerID);

      	
//      ObservableList<String> list = FXCollections.observableArrayList("Mark Zuckerburg \n10/09/2000", "Tom Clancy\n02/06/1999", "Jack Sparrow\n03/18/1989"); 
    	 
//    	listView.setItems(list);
      }
      
    } // not complete

    
	@FXML
    // sends vehicle information to customer profile UI
    public void openCusProfile(MouseEvent event) throws IOException{
		// test data
		realCusID.setText("123456789"); // should get id of selected customer
		
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerProfileUI.fxml"));
    	Parent root = loader.load();
    	
    	CustomerProfileController controller = loader.getController();
    	controller.showInformation(realCusID.getText(), yearField.getText(), makeDropdown.getValue(), modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());
    	
    	Main m = new Main();
    	m.changeScene("CustomerProfileUI.fxml", root);
    } // end openCusProfile
	
	// sends first and last name to register customer page
    public void registerNewCus(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterCustomerUI.fxml"));
    	Parent root = loader.load();
    	
    	RegisterCustomerController regCusController = loader.getController();
    	regCusController.showInformation(firstName.getText(), lastName.getText());
    	
    	Main m = new Main();
    	m.changeScene("RegisterCustomerUI.fxml", root);
    } // end registerNewCus
    
    // receives first and last name from customer profile UI
    public void showInformation(String firstName, String lastName) {
    	this.firstName.setText(firstName);
    	this.lastName.setText(lastName);
    }
    
    // receives car information from record of sales UI
    public void showInformation(String first, String last, String cusID, String year, String make, String model, String VIN, String price, String paymentMethod, LocalDate salesDate) {
    	tempFirst.setText(first);
    	tempLast.setText(last);
    	tempID.setText(cusID);
    	yearField.setText(year);
    	makeDropdown.setValue(make);
    	modelField.setText(model);
    	VINField.setText(VIN);
    	valueField.setText(price);
    	this.paymentMethod.setValue(paymentMethod);
    	this.salesDate.setValue(salesDate);
    }    
}
