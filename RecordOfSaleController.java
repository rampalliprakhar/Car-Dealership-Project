/* --------------------------------------------------------------------------------- 
 *  Author: Team 3 Car Dealership
 *  
 *  Written: 3/6/2023
 *  Last Updated: 4/20/2023
 *  
 *  Compilation: javac RecordOfSaleController.java
 *  Execution: java RecordOfSaleController
 *  
 *  Controller class of the record of sales UI. The record of sales is where the 
 *  customer and vehicle of a sale will be recorded. As well as the payment method
 *  and the date of the sale.
 *  
 *  Corresponding fxml file is RecordOfSaleUI.fxml
 ---------------------------------------------------------------------------------*/

package application;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.text.Text;
import backend.*;
import dao.*;

public class RecordOfSaleController {
	    
	// Declare UI fields

    @FXML
    private TextField valueField, VINField, yearField, modelField;
    
    @FXML
    private ChoiceBox<String> makeDropdown, paymentMethod;
    
    @FXML
    private Text updateSuccessful, nullError;
    
    @FXML
    private DatePicker salesDate;
    
	@FXML
	private TextField firstName, lastName, customerID;
    
    @FXML
    private Button saveButton, clearButton, returnButton, addCusToSale, addVehToSale; 
    
    private String previousPage = Main.getView();
    
    final private ObservableList<String> paymentList = FXCollections.observableArrayList("Debit", "Credit", "Cash", "Check", "Other");
    
    // Triggers when the screen is loaded
    // creates payment method drop down choices and sets sales date to current date
    public void initialize() {
    	salesDate.setValue(LocalDate.now());
        makeDropdown.setValue("Select a Make");
        paymentMethod.setValue("Select a Payment Method");
        paymentMethod.setItems(paymentList);
    } // end initialize method
    
    // switches scene to Search Customer UI 
    public void addCusTOSale(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchCustomerUI.fxml"));
    	Parent root = loader.load();
    	
    	SearchCustomerController controller = loader.getController();
    	
        // sends any filled information to the search customer UI
    	controller.showInformation(firstName.getText(), lastName.getText(), customerID.getText(), yearField.getText(), makeDropdown.getValue(), modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());

    	Main m = new Main();
    	m.changeScene("SearchCustomerUI.fxml", root);    
    } // end addCusToSale method
    
    // switches scene to Search Vehicle UI 
    public void addVehToSale(ActionEvent event) throws IOException{
    	
    	// if the user is a manager, open search UI that includes buttons for recording new vehicle and updating vehicle
    	if (Main.getCurrentUser().hasManagerRights()) {
    		
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchVehicleUI.fxml"));
    	Parent root = loader.load();
    	
    	SearchVehicleController controller = loader.getController();
    	
        // sends any filled information to the search vehicle UI
    	controller.showInformation(firstName.getText(), lastName.getText(), customerID.getText(), yearField.getText(), makeDropdown.getValue(), modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());

    	Main m = new Main();
    	m.changeScene("SearchVehicleUI.fxml", root);   
    	}
    	
    	else {

        	FXMLLoader loader = new FXMLLoader(getClass().getResource("SalespersonViewSearchVehicleUI.fxml"));
        	Parent root = loader.load();
        	
        	SearchVehicleController controller = loader.getController();
        	
            // sends any filled information to the search vehicle UI
        	controller.showInformation(firstName.getText(), lastName.getText(), customerID.getText(), yearField.getText(), makeDropdown.getValue(), modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());

        	Main m = new Main();
        	m.changeScene("SalespersonViewSearchVehicleUI.fxml", root);   
    	}
    } // end addVehToSale method
    
    // switches scene to main menu
    public void pageReturn(ActionEvent event) throws IOException{
    	Main m = new Main();
    	m.changeScene(previousPage);
    } // end pageReturn method
    
    // clears all fields
    public void clear(ActionEvent event) throws IOException{
    	valueField.clear();
    	VINField.clear();
    	yearField.clear();
    	modelField.clear();
        makeDropdown.setValue("Select a Make");
    	salesDate.setValue(LocalDate.now());
    	firstName.clear();
    	lastName.clear();
    	customerID.clear();
    	paymentMethod.setValue("Select a Payment Method");
    } // end clear method
    
    public void save(ActionEvent event) throws IOException{
    	// input validation
    	
    	// if any fields are empty return and print out error message
    	if (valueField.getText().isBlank() || makeDropdown.getValue() == null || yearField.getText().isBlank() || 
    			paymentMethod.getValue() == null || paymentMethod.getValue() == "Select a Payment Method" ||
    			VINField.getText().isBlank() || salesDate.getValue() == null || 
    			firstName.getText().isBlank() || lastName.getText().isBlank() || 
    			customerID.getText().isBlank() || valueField.getText().isBlank()) {
        	
    		updateSuccessful.setText(null);
    		nullError.setText("*Error: Please fill out all input fields*");
    		return;
    	}
    	
    	// end input validation 

        
        try {
        	
        	// Create new DAOs
            CustomerDao cDAO = new CustomerDao();
            VehicleDao vDAO = new VehicleDao();
//            RecordOfSale rDAO = new RecordOfSaleDao();

            // Creates a new record of sale with the retrieved customer and vehicle, and the current employee user        	
            RecordOfSale record = new RecordOfSale(vDAO.retriveVehicle(VINField.toString()), Main.getCurrentUser(), cDAO.retriveCustomer(customerID.toString()));
        } catch (Exception e) {
            
        }
    	
    	
    	// database needed
    	
    	
    	
    	
    	
    	
    	// confirmation message
		nullError.setText(null);
    	updateSuccessful.setText("Save Succesful");
    }
    
    // receives information from customer profile UI, vehicle information UI, or search vehicle UI
    public void showInformation(String firstName, String lastName, String cusID, String year, String make, String model, String VIN, String price, String paymentMethod, LocalDate salesDate) {
    	this.firstName.setText(firstName);
    	this.lastName.setText(lastName);
    	customerID.setText(cusID);
    	yearField.setText(year);
    	makeDropdown.setValue(make);
    	modelField.setText(model);
    	VINField.setText(VIN);
    	valueField.setText(price);
    	this.paymentMethod.setValue(paymentMethod);
    	this.salesDate.setValue(salesDate);
    }
}
