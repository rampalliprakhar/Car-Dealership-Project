// this page can only be seen by a manager

package application;

import java.time.LocalDate;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;


public class VehicleInformationController {

    @FXML
    private TextField ValueField, VINField, YearField, ModelField, MileageField, ColorField, customerID, custFirstName, custLastName;
    
    @FXML
    private Text nullError, updateSuccessful;
    
    @FXML
    private Button returnButton, purchaseVehicle, saveChanges;
    
    @FXML
    private DatePicker datePutOnLot, salesDate; // time on lot calculated from date put on lot 

    @FXML
    private ChoiceBox<String> MakeDropdown, BodyConDropdown, MechConDropdown, paymentMethod;
    
    @FXML
    private Button SaveButton, ReturnButton;   
    
    final private ObservableList<String> conditionList = FXCollections.observableArrayList("New", "Excellent", "Good", "Average", "Fair", "Poor", "Broken");
    final private ObservableList<String> makeList = FXCollections.observableArrayList("Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Buick", 
            "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Ferrari", "Fiat", "Ford", "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia", 
            "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Maserati", "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", "Ram", 
            "Rolls-Royce", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo");
    
//    private String previousPage = Main.getView();
    
    @FXML
    private void initialize() {
        
		// using giving VIN, search database for the rest of the information 
    	
    	
    	
    	
    	// test data
    	ModelField.setText("model");
    	YearField.setText("2019");
    	ColorField.setText("White");
    	MileageField.setText("1000");

    	
    	
    	
    	

        /* This method is called automatically, and initializes the dropdown
         * boxes with the values of the source ObservableLists*/
        
        MakeDropdown.setItems(makeList);
        BodyConDropdown.setItems(conditionList);
        MechConDropdown.setItems(conditionList);
        datePutOnLot.setValue(LocalDate.now());

        // only allows alphabetical characters up to 40
        ModelField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z]"))) {
        		return null;
        	}
        	return change;
        })); // add length limit
        
        // only allows alphabetical characters up to 40
		ColorField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z]"))) {
				return null;
			}
			return change;
		})); // add length limit

        // only allows numbers up to 4
		YearField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 4) ||
				(change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		}));
		
        // only allows numbers and periods up to 20
		ValueField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 20) ||
				(change.getText().matches("[^0-9.]"))) {
				return null;
			}
			return change;
		}));
		
        // only allows alphabetical characters and numbers up to 17
		VINField.setTextFormatter(new TextFormatter<> (change -> {
	    	change.setText(change.getText().toUpperCase());
			if ((change.getControlNewText().length() > 17) ||
				(change.getText().matches("[^0-9A-Z]"))) {
				return null;
			}
			return change;
		})); 
		
        // only allows numbers up to 20
		MileageField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 20) ||
				(change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		})); 
        
    } // end initialize method // NOT COMPLETE
    
    public void pageReturn(ActionEvent event) throws IOException {
        
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchVehicleUI.fxml"));
    	Parent root = loader.load();
    	
    	SearchVehicleController searchVehController = loader.getController();
    	searchVehController.showInformation(MakeDropdown.getValue(), ModelField.getText(), YearField.getText(), ColorField.getText(), 
    	BodyConDropdown.getValue(), MechConDropdown.getValue());
    	
    	Main m = new Main();
    	m.changeScene("SearchVehicleUI.fxml", root);
        
    } // end pageReturn	
    
        
    public void saveChanges(ActionEvent event) throws IOException {
    	// input validation
    	
    	// if any fields are empty print out error message
    	if (ModelField.getText().length() == 0 || MakeDropdown.getValue() == null || YearField.getText().length() == 0 || 
    			ColorField.getText().length() == 0 || VINField.getText().length() == 0 || ValueField.getText().length() == 0 || 
    			MileageField.getText().length() == 0 || datePutOnLot.getValue() == null || 
    			BodyConDropdown.getValue() == null || MechConDropdown.getValue() == null) {
        	
    		updateSuccessful.setText(null);
    		nullError.setText("*Error: Please fill out all input fields*");
    		return;
    	}
    		
    		
    	// if year is not between current year and year when cars were invented print out error message
    	else if (yearIsValid() == false) {
        	updateSuccessful.setText(null);
    		nullError.setText("*Error: Please input a valid year*");
    		return;
    	}
    	
    	// if price has more than 2 decimal places print out error message
    	if (!ValueField.getText().matches("^\\d+\\.\\d{0,2}$") && !ValueField.getText().matches("[0-9]*$")) {
        	updateSuccessful.setText(null);
    		nullError.setText("*Error: Please input a valid price*");
    		return;
    	}
    	
    	// validation for date
    	
    	// end input validation
    	
    	
    	
    	
    	
//  	  update info in database

    	
    	
    	
    	
    	// confirmation message
    	nullError.setText(null);
    	updateSuccessful.setText("Changes Saved");
    } // not complete
    
	// receives customer information from search vehicle UI
    public void showInformation(String VIN, String cusID, String first, String last, String paymentMethod, LocalDate salesDate) {
    	VINField.setText(VIN);
    	customerID.setText(cusID);
    	custFirstName.setText(first);
    	custLastName.setText(last);
    	this.paymentMethod.setValue(paymentMethod);
    	this.salesDate.setValue(salesDate);
    }
    
	@FXML
	// sends customer information to record of sale UI and switches to record of sale page
	public void purchaseVeh(ActionEvent event) throws IOException {		
		
		
		// send error if changes were made and it wasn't saved
		
		
		
		
		
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordOfSaleUI.fxml"));
		   	Parent root = loader.load();
		   	
		   	RecordOfSaleController recSaleController = loader.getController();

		   	recSaleController.showInformation(custFirstName.getText(), custLastName.getText(), customerID.getText(), YearField.getText(), MakeDropdown.getValue(), ModelField.getText(), 
		   			VINField.getText(), ValueField.getText(), paymentMethod.getValue(), salesDate.getValue());
		   	
	    	Main m = new Main();
	    	m.changeScene("RecordOfSaleUI.fxml", root);
		
	} // not complete
	
	// returns true if year is greater than 1889 (year cars were invented)
	public boolean yearIsValid() {
		int year = Integer.valueOf(YearField.getText());
		if (year > LocalDate.now().getYear() || year < 1889)
			return false;
		
		else return true;
	}
}
