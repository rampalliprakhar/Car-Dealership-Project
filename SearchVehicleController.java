package application;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class SearchVehicleController {
	
	private Vehicle selectedVehicle;
	
	@FXML
	private ListView<String> listView;
	
    @FXML
    private TextField yearField, modelField, colorField, VINField, mileageField, valueField;
    
    @FXML
    private ComboBox<String> makeDropdown, bodyConDropdown, mechConDropdown;
    
    @FXML
    private Button searchButton, clearButton, returnButton;    
    
    @FXML
    private ImageView imageView;
    
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
        
        makeDropdown.setValue("Select a Make");
        makeDropdown.setItems(makeList);
        
        bodyConDropdown.setValue("Select a Condition");
        bodyConDropdown.setItems(conditionList);
        mechConDropdown.setValue("Select a Condition");
        mechConDropdown.setItems(conditionList);
      
      // test data
      ObservableList<String> list = FXCollections.observableArrayList("Dodge Charger"); 
    	listView.setItems(list);
        
    } // end initialize method
    
   
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/
        
        colorField.clear();

        makeDropdown.setValue("Select a Make");
        bodyConDropdown.setValue("Select a Condition");
        mechConDropdown.setValue("Select a Condition");
        yearField.clear();
        modelField.clear();
        mileageField.clear();
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene("SalespersonView.fxml"); // change this to previous page
        
    } // end pageReturn
    
    public void searchVehicle(ActionEvent event) throws IOException {

    	// database needed

      }
    
	@FXML
    public void openVehInfo(MouseEvent event) throws IOException{
		
		// database needed 
		
    	Main m = new Main();    	
    	m.changeScene("VehicleInformationUI.fxml");
	}
    
    public void showInformation(String make, String model, String year, String color, String bodyCon, String mechCon) {
    	makeDropdown.setValue(make);
    	modelField.setText(model);
    	yearField.setText(year);
    	colorField.setText(color);
    	bodyConDropdown.setValue(bodyCon);
    	mechConDropdown.setValue(mechCon);
    }
    
} // end RecordVehicleController
