package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;
import java.util.Date;

import backend.Vehicle;

public class RecordVehicleController {
    
    @FXML
    private TextField ValueField;
    @FXML
    private TextField VINField;
    @FXML
    private TextField YearField;
    @FXML
    private ChoiceBox<String> MakeDropdown;
    @FXML
    private TextField ModelField;
    @FXML
    private TextField MileageField;
    @FXML
    private TextField ColorField;
    @FXML
    private ChoiceBox<String> BodyConDropdown;
    @FXML
    private ChoiceBox<String> MechConDropdown;
    @FXML
    private Button SaveButton;    
    @FXML
    private Button ClearButton;
    @FXML
    private Button ReturnButton;
    
    final private ObservableList<String> conditionList = FXCollections.observableArrayList("New", "Excellent", "Good", "Average", "Fair", "Poor", "Broken");
    final private ObservableList<String> makeList = FXCollections.observableArrayList("Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Buick", 
            "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Ferrari", "Fiat", "Ford", "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia", 
            "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Maserati", "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", "Ram", 
            "Rolls-Royce", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo");
    
    private String previousPage = Main.getView();
    
    
    @FXML
    private void initialize() {
        
        /* This method is called automatically, and initializes the dropdown
         * boxes with the values of the source ObservableLists*/
        
        MakeDropdown.setValue("Select a Make");
        MakeDropdown.setItems(makeList);
        
        BodyConDropdown.setValue("Select a Condition");
        BodyConDropdown.setItems(conditionList);
        MechConDropdown.setValue("Select a Condition");
        MechConDropdown.setItems(conditionList);
        
        
         // text formatters
        // only allows alphabetical characters up to 40
        ModelField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z]"))) {
        		return null;
        	}
        	return change;
        }));
        
        // only allows alphabetical characters up to 40
		ColorField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z]"))) {
				return null;
			}
			return change;
		}));

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
        
    } // end initialize method
    
    public void save(ActionEvent event) throws IOException {
        
        Vehicle vehicle = new Vehicle(VINField.getText(), new Double(ValueField.getText()), new Integer(YearField.getText()), MakeDropdown.getValue(),
                ModelField.getText(), BodyConDropdown.getValue(), MechConDropdown.getValue(), ColorField.getText(), new Double(MileageField.getText()), new Date());
        
        // Debug statement to test the save method
        System.out.println(vehicle.getVIN() + " " + vehicle.getValue() + " " + vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + " " +vehicle.getBodyCondition() + " " + vehicle.getMechCondition() + " " + vehicle.getColor() +
        " " + vehicle.getMileage() + " " + vehicle.getDatePutOnLot());
        
        /* Insert code to save the newly created vehicle to the database*/
        
        Main m = new Main();
        m.changeScene(Main.getView());
        
    } // end save
    
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/
        
        ValueField.clear();
        VINField.clear();
        YearField.clear();
        MakeDropdown.setValue("Select a Make");
        ModelField.clear();
        MileageField.clear();
        ColorField.clear();
        BodyConDropdown.setValue("Select a Condition");
        MechConDropdown.setValue("Select a Condition");
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
    
} // end RecordVehicleController
