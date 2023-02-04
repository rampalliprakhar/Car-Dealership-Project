package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;

public class RecordVehicleController {
    
    @FXML
    private TextField ValueField;
    @FXML
    private TextField VINField;
    @FXML
    private TextField Year;
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
    private String previousPage = "MainPage.fxml";
    
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
        
    } // end initialize method
    
    public void save(ActionEvent event) throws IOException {
        
        /* This method will also need to save all of the inputs to the
         * newly created Customer object.*/
        
        Main m = new Main();
        m.changeScene("TESTSaveConfirm.fxml");
        // Note to self: change this to MainPage.fxml when that code is received
        
    } // end save
    
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/
        
        ValueField.clear();
        VINField.clear();
        Year.clear();
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
