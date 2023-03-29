package application;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;
import java.time.LocalDate;

public class RecordOfSaleController {
	    
    @FXML
    private TextField valueField, VINField, yearField, modelField;
    
    @FXML
    private ChoiceBox<String> makeDropdown, paymentMethod;
    
    @FXML
    private DatePicker salesDate;
//    is sales date needed or will it just be the day the order on the UI was made
    
	@FXML
	private TextField firstName, lastName, customerID;
//	employeeID, employeeFirstName, employeeLastName, commissionValue;
    
    @FXML
    private Button saveButton, clearButton, returnButton, addCusToSale, addVehToSale; 
    
    private String previousPage = Main.getView();
    
    final private ObservableList<String> paymentList = FXCollections.observableArrayList("Debit", "Credit", "Cash", "Check", "Other");
    
    public void initialize() {
    	salesDate.setValue(LocalDate.now());
        makeDropdown.setValue("Select a Make");
        paymentMethod.setValue("Select a Payment Method");
        paymentMethod.setItems(paymentList);
    }

    public void showCusInformation(String firstName, String lastName, String cusID) {
    	this.firstName.setText(firstName);
    	this.lastName.setText(lastName);
    	customerID.setText(cusID);
    } // initializes page with these selected customer values if previous page was search customer
    
    public void showVehInformation(String make, String model, String year, String value, String VIN) {
    	makeDropdown.setValue(make);
    	modelField.setText(model);
    	yearField.setText(year);
    	valueField.setText(value);
    	VINField.setText(VIN);
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
    
    public void addCusTOSale(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchCustomerUI.fxml"));
    	Parent root = loader.load();
    	
    	SearchCustomerController controller = loader.getController();
    	controller.showInformation(yearField.getText(), makeDropdown.getValue(), modelField.getText(), VINField.getText(), valueField.getText(), paymentMethod.getValue(), salesDate.getValue());

    	Main m = new Main();
    	m.changeScene("SearchCustomerUI.fxml", root);    
    }

    public void addVehToSale(ActionEvent event) throws IOException{
    	
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchVehicleUI.fxml"));
    	Parent root = loader.load();
    	
    	SearchVehicleController controller = loader.getController();
    	controller.showInformation(customerID.getText(), firstName.getText(), lastName.getText(), paymentMethod.getValue(), salesDate.getValue());

    	Main m = new Main();
    	m.changeScene("SearchVehicleUI.fxml", root);    	
    	}
    
    public void pageReturn(ActionEvent event) throws IOException{
    	Main m = new Main();
    	m.changeScene(previousPage);
    	// goes to main menu
    }
    
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
    }    
    
    public void save(ActionEvent event) throws IOException{
    	
    }
    
    public void requestApproval(ActionEvent event) throws IOException{
    	
    }
    
    // print method?
    
    // request approval method??
}
