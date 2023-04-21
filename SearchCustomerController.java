package application;

import java.io.IOException;
import dao.CustomerDao;
import java.time.LocalDate;
import backend.CustomerProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;


public class SearchCustomerController {
	
	private CustomerProfile customer;

    @FXML
    private Text errorText;
    
    @FXML
    private ChoiceBox<String> makeDropdown, paymentMethod;
    
    @FXML
    private DatePicker salesDate;
	
    @FXML
    private TextField customerID, VINField, yearField, modelField, valueField, tempFirst, tempLast, tempID, actualCusID;
    
    @FXML
    private Button searchButton, clearButton, returnButton, registerNewCustomer;
        
    @FXML
    public void initialize() {    	
    	
    	// Text Formatter Input Validation
		// only allows numbers and uppercase characters up to 16
		customerID.setTextFormatter(new TextFormatter<> (change -> {
			change.setText(change.getText().toUpperCase());					
			if ((change.getControlNewText().length() > 16) ||
			(change.getText().matches("[^A-Z0-9]"))) {
			return null;
		}
		return change;
	})); // length limit correct?	
    }
        
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/
        
        customerID.clear();
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
    	
        /* This method returns to the record of sale UI while retaining the information of the filled data.*/

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordOfSaleUI.fxml"));
    	Parent root = loader.load();
    	
    	RecordOfSaleController controller = loader.getController();
    	controller.showInformation(tempFirst.getText(), tempLast.getText(), tempID.getText(), yearField.getText(), makeDropdown.getValue(), modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());
    	
    	Main m = new Main();
    	m.changeScene("RecordOfSaleUI.fxml", root);
    } // end pageReturn
    
    public void searchCus(ActionEvent event) throws IOException {   
    	
    	// if nothing is typed, return and print message to the user
    	if (customerID.getText().isBlank()) {
    		errorText.setText("*Please input a driver's license number*");
    		return;
    	}
    	
        try {
        	// searches database for customer with inputed customer ID and sets it to this.customer
            CustomerDao dao = new CustomerDao();            
            this.customer = dao.retriveCustomer(customerID.getText());
            
            // if customer is found open customer profile UI while passing customer ID and other additional information
            if (customer.getLicenseNum() != null) {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerProfileUI.fxml"));
        	Parent root = loader.load();
        	
        	CustomerProfileController controller = loader.getController();
        	controller.showInformation(customer.getLicenseNum(), yearField.getText(), makeDropdown.getValue(), modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());
        	
        	Main m = new Main();
        	m.changeScene("CustomerProfileUI.fxml", root);
        	        	
            }
            
            // if customer if not found, print error message and prompt user to register customer
            else { 
            	errorText.setText("Customer Not Found, Please Register");
            }
            
        } catch (Exception e) {
    		System.out.println("Error in SearchCustomerController.java");
        	return;
        }
      
    } // needs testing
	
	// opens RegisterCustomerUI and passes inputed customer ID
    public void registerNewCus(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterCustomerUI.fxml"));
    	Parent root = loader.load();
    	
    	RegisterCustomerController regCusController = loader.getController();
    	regCusController.showInformation(customerID.getText());
    	
    	Main m = new Main();
    	m.changeScene("RegisterCustomerUI.fxml", root);
    } // end registerNewCus
    
    // receives customer ID from customer profile UI
    public void showInformation(String customerID) {
    	this.customerID.setText(customerID);
    }
    
    // receives recorded sale information from record of sales UI
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
