// this page can only be seen by a manager

package application;

import java.time.LocalDate;
import java.util.regex.Pattern;
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
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import java.util.regex.*;
import javafx.beans.value.ObservableValue;

public class VehicleInformationController {

    @FXML
    private TextField ValueField, VINField, YearField, ModelField, MileageField, ColorField, customerID, custFirstName, custLastName;
    
    @FXML
    private Button returnButton, purchaseVehicle;
    
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
        
        /* This method is called automatically, and initializes the dropdown
         * boxes with the values of the source ObservableLists*/
        
        MakeDropdown.setItems(makeList);
        BodyConDropdown.setItems(conditionList);
        MechConDropdown.setItems(conditionList);
        datePutOnLot.setValue(LocalDate.now());

        ModelField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z]"))) {
        		return null;
        	}
        	return change;
        })); // add length limit
        
        
		ColorField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z]"))) {
				return null;
			}
			return change;
		})); // add length limit

		
		YearField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 4) ||
				(change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		})); // add only 4 digits
		
//		ValueField.setTextFormatter(new TextFormatter<> (change -> {
//			if (change.getText().matches("^\\\\$(\\\\d{1, 3}(\\\\, \\\\d{3})*|(\\\\d+))(\\\\.\\\\d{2})?$")) {
//				return change;
//			}
//			return null;
//		}));
		
		ValueField.setTextFormatter(new TextFormatter<> (change -> {
		if ((change.getControlNewText().length() > 20) ||
			(change.getText().matches("[^0-9,]"))) {
			return null;
		}
		return change;
	})); // is WRONGGGGG
		
		VINField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 20) ||
				(change.getText().matches("[^0-9A-Z]"))) {
				return null;
			}
			return change;
		})); 
		
		MileageField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		})); // add length limit?
		
		

//        
//        
//        
//        ValueField.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, 
//                String newValue) {
//                if (!newValue.matches("\\d*")) {
//                    ValueField.setText(newValue.replaceAll("[^\\d]", ""));
//                }
//            }
//        });


//if (Pattern.matches("[a-zA-Z]*]", change.getText())) {


        // get info from database

        
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
//    	if (isValid() == true) {
//    		save changes
//    	}

    	
//	  change info in database
//    if success print out success through updateSuccessful Text field
//    if not, print out not successful
    }
    
//    public boolean isValid() {
//    	if (ModelField.getText().length() > 20) {
//		// print out error
//    		return false;
//	}
//    	
//    	
//    	return true;
//    }
    
	// receives customer information from search vehicle UI
    public void showInformation(String cusID, String first, String last, String paymentMethod, LocalDate salesDate) {
    	customerID.setText(cusID);
    	custFirstName.setText(first);
    	custLastName.setText(last);
    	this.paymentMethod.setValue(paymentMethod);
    	this.salesDate.setValue(salesDate);
    }
    
	@FXML
	// sends customer information to record of sale UI
	public void purchaseVeh(ActionEvent event) throws IOException {		
		
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordOfSaleUI.fxml"));
		   	Parent root = loader.load();
		   	
		   	RecordOfSaleController recSaleController = loader.getController();

		   	// need to ensure they save before sending info to record of sale
		   	recSaleController.showInformation(custFirstName.getText(), custLastName.getText(), customerID.getText(), YearField.getText(), MakeDropdown.getValue(), ModelField.getText(), 
		   			VINField.getText(), ValueField.getText(), paymentMethod.getValue(), salesDate.getValue());
		   	
	    	Main m = new Main();
	    	m.changeScene("RecordOfSaleUI.fxml", root);
		
	} // not complete
    
    
}
