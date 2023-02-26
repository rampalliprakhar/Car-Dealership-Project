package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.*;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.time.LocalDate;

public class RecordOfSaleController {
    
    @FXML
    private TextField ValueField, VINField, YearField, ModelField;
    
    @FXML
    private ChoiceBox<String> MakeDropdown;
    
    @FXML
    private DatePicker salesDate;
    
	@FXML
	private TextField firstName, lastName, customerID, employeeID, employeeFirstName, employeeLastName, commissionValue, paymentMethod;
    
    @FXML
    private Button SaveButton, ClearButton, ReturnButton, addCusToSale, addVehToSale; 
    
    private String previousPage = Main.getView();
    
    final private ObservableList<String> makeList = FXCollections.observableArrayList("Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Buick", 
            "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Ferrari", "Fiat", "Ford", "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia", 
            "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Maserati", "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", "Ram", 
            "Rolls-Royce", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo");
    
    public void initialize() {
    	salesDate.setValue(LocalDate.now());
        MakeDropdown.setValue("Select a Make");
        MakeDropdown.setItems(makeList);
    }
    
    public void showVehInformation(String make, String model, String year, String value, String VIN) {
    	MakeDropdown.setValue(make);
    	ModelField.setText(model);
    	YearField.setText(year);
    	ValueField.setText(value);
    	VINField.setText(VIN);
    	previousPage = "SearchVehicleUI.fxml";
    } // initializes page with these selected vehicle values if previous page was search vehicle
    
    public void showCusInformation(String firstName, String lastName, String cusID) {
    	this.firstName.setText(firstName);
    	this.lastName.setText(lastName);
    	customerID.setText(cusID);
    	previousPage = "SearchCustomerUI.fxml";
    } // initializes page with these selected customer values if previous page was search customer
    
    public void addCusTOSale(ActionEvent event) throws IOException{
    	Main m = new Main();
    	m.changeScene("SearchCustomerUI.fxml");
    }

    public void addVehToSale(ActionEvent event) throws IOException{
    	Main m = new Main();
    	m.changeScene("SearchVehicleUI.fxml");
    }
    
    public void pageReturn(ActionEvent event) throws IOException{
    	Main m = new Main();
    	m.changeScene(previousPage);
    }
    
    public void clear(ActionEvent event) throws IOException{
    	ValueField.clear();
    	VINField.clear();
    	YearField.clear();
    	ModelField.clear();
        MakeDropdown.setValue("Select a Make");
    	salesDate.setValue(LocalDate.now());
    	firstName.clear();
    	lastName.clear();
    	customerID.clear();
    	employeeID.clear();
    	employeeFirstName.clear();
    	employeeLastName.clear();
    	commissionValue.clear();
    	paymentMethod.clear();
    }    
    
    public void save(ActionEvent event) throws IOException{
    	
    }
}