package application;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.util.ResourceBundle;
import java.net.URL;
import java.time.LocalDate;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.regex.*;


public class SearchVehicleController {
	
	private Vehicle selectedVeh;
	
	@FXML
	private ListView<Vehicle> listView;
	
    @FXML
    private TextField yearField, modelField, colorField
    
    , VINField, mileageField, valueField, customerID, custFirstName, custLastName;// not needed?
    
    @FXML
    private ComboBox<String> makeDropdown, bodyConDropdown, mechConDropdown;
    
    @FXML
    private ChoiceBox<String> paymentMethod;
    
    @FXML
    private DatePicker salesDate;
    
    @FXML
    private Button searchButton, clearButton, returnButton, purchaseVehButton, openVehInfo;    
    
    @FXML
    private Text vehInfo;
    
    private String previousPage = Main.getView();
    
    final private ObservableList<String> conditionList = FXCollections.observableArrayList("New", "Excellent", "Good", "Average", "Fair", "Poor", "Broken");
    final private ObservableList<String> makeList = FXCollections.observableArrayList("Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Buick", 
            "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Ferrari", "Fiat", "Ford", "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia", 
            "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Maserati", "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", "Ram", 
            "Rolls-Royce", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo");
        
    @FXML
    private void initialize() {
        
        /* This method is called automatically, and initializes the dropdown
         * boxes with the values of the source ObservableLists*/
        
        makeDropdown.setValue("Select a Make");
        makeDropdown.setItems(makeList);
        
        bodyConDropdown.setValue("Select a Condition");
        bodyConDropdown.setItems(conditionList);
        mechConDropdown.setValue("Select a Condition");
        mechConDropdown.setItems(conditionList);
        
        modelField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z]"))) {
        		return null;
        	}
        	return change;
        })); // change length limit?
        

		colorField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 40) ||
				(change.getText().matches("[^a-zA-Z]"))) {
				return null;
			}
			return change;
		})); // change length limit?

		
		yearField.setTextFormatter(new TextFormatter<> (change -> {
			if ((change.getControlNewText().length() > 4) ||
			   (change.getText().matches("[^0-9]"))) {
				return null;
			}
			return change;
		}));
		
      
      // test data
//      ObservableList<String> list = FXCollections.observableArrayList("Dodge Charger"); 
//    	listView.setItems(list);
        
        
    } // end initialize method
    
   
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/
        
        colorField.clear();
        makeDropdown.setValue("Select a Make");
        bodyConDropdown.setValue("Select a Condition");
        mechConDropdown.setValue("Select a Condition");
        yearField.clear();
        modelField.clear();
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene("RecordOfSaleUI.fxml");

    } // end pageReturn
    
    public void searchVehicle(ActionEvent event) throws IOException {

    	// database needed

      } // not complete
        	
    public void openVehInfo(ActionEvent event) throws IOException{
		
		// database needed // 		selectedVeh
//		
//    	Main m = new Main();    	
//    	m.changeScene("VehicleInformationUI.fxml");

    	
    	
    	
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("VehicleInformationUI.fxml"));
    	Parent root = loader.load();
    	
    	VehicleInformationController controller = loader.getController();
    	controller.showInformation(custFirstName.getText(), custLastName.getText(), customerID.getText(), paymentMethod.getValue(), salesDate.getValue());
    	
    	Main m = new Main();
    	m.changeScene("VehicleInformationUI.fxml", root);
    	
	} // not complete
	
	@FXML
	// sends customer information to record of sale UI
	public void purchaseVeh(ActionEvent event) throws IOException {		
		
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordOfSaleUI.fxml"));
		   	Parent root = loader.load();
		   	
		   	RecordOfSaleController recSaleController = loader.getController();
//		   	recSaleController.showInformation(makeDropdown.getValue(), modelField.getText(), 
//		   			yearField.getText(),valueField.getText(), VINField.getText(), customerID.getText());
		   	// not right, needs to be information of selected vehicle (selectedVeh)
		   	// database needed
		   	
		   	// test data
		   	recSaleController.showInformation(custFirstName.getText(), custLastName.getText(), customerID.getText(), "Nissan", "Sentra", 
		   			"2019","$12345", "54324", paymentMethod.getValue(), salesDate.getValue());
	    	
		   	
	    	Main m = new Main();
	    	m.changeScene("RecordOfSaleUI.fxml", root);
		
	} // not complete
	
	// recieves customer information from record of sale UI
    public void showInformation(String cusID, String first, String last, String paymentMethod, LocalDate salesDate) {
    	customerID.setText(cusID);
    	custFirstName.setText(first);
    	custLastName.setText(last);
    	this.paymentMethod.setValue(paymentMethod);
    	this.salesDate.setValue(salesDate);
    }

    // receives car information from vehicle information UI
    public void showInformation (String make, String model, String year, String color, String bodyCon, String mechCon) {
    	makeDropdown.setValue(make);
    	modelField.setText(model);
    	yearField.setText(year);
    	colorField.setText(color);
    	bodyConDropdown.setValue(bodyCon);
    	mechConDropdown.setValue(mechCon);
    }
    
    
    
    
    
    
    
    
    
    
    

    

    public void listViewSelectedVeh() {
    	selectedVeh = listView.getSelectionModel().getSelectedItem();
    	updateGUI();
    }
    
    
    public void selectedVeh(Vehicle veh) {
    	selectedVeh = veh;
//    	listView.getItems().addAll( array list of vehicles );
// 		database needed
    	updateGUI();
    }
    
    public void updateGUI() {
//    	imageView.setImage(selectedVeh.getImage());
//    	vehInfo.setText(selectedVeh.toString());
    	vehInfo.setText("	\r\n"
    			+ "	2019 Dodge Charger\r\n"
    			+ "	Color: White\r\n"
    			+ "	Body Condition: New\r\n"
    			+ "	Mechanical Condition: New\r\n"
    			+ "	Mileage: 0\r\n"
    			+ "	Price: $100,000\r\n"
    			+ "	VIN: 123456543");
    }
    
    
    
} // end RecordVehicleController
