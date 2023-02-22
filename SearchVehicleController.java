package application;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class SearchVehicleController {
	
    @FXML
    private TextField yearField;
    
    @FXML
    private ChoiceBox<String> makeDropdown;
    
    @FXML
    private TextField modelField;
    
    @FXML
    private TextField mileageField; // needed?
    
    @FXML
    private TextField colorField;
    @FXML
    private ChoiceBox<String> bodyConDropdown;
    
    @FXML
    private ChoiceBox<String> mechConDropdown;
    
    @FXML
    private Button saveButton;    
    
    @FXML
    private Button clearButton;
    
    @FXML
    private Button returnButton;
    
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
        
        makeDropdown.setValue("Select a Make");
        makeDropdown.setItems(makeList);
        
        bodyConDropdown.setValue("Select a Condition");
        bodyConDropdown.setItems(conditionList);
        mechConDropdown.setValue("Select a Condition");
        mechConDropdown.setItems(conditionList);
        
    } // end initialize method
    
    
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/
        
        yearField.clear();
        makeDropdown.setValue("Select a Make");
        modelField.clear();
        mileageField.clear();
        colorField.clear();
        bodyConDropdown.setValue("Select a Condition");
        mechConDropdown.setValue("Select a Condition");
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
    
    public void searchVehicle(ActionEvent event) throws IOException {
        

        
    }
    
} // end RecordVehicleController
