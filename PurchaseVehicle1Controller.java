package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;

public class PurchaseVehicle1Controller {

    @FXML
    private TableView<Object> ResultsTable; // The type will need to be changed
//    @FXML
//    private TableColumn<Object> testColumn;
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
    private Button SaveButton;    
    @FXML
    private Button ClearButton;
    @FXML
    private Button ReturnButton;
    
    private String previousPage = "MainPage.fxml";
    
    @FXML
    private void initialize() {
        
        /* This method is called automatically, and initializes the dropdown
         * boxes with the values of the source ObservableLists*/
        

    }
    
    public void search(ActionEvent event) throws IOException {
        
        // NOT DONE
        
    } // end search method
    
    public void purchase(ActionEvent event) throws IOException {
        
        /* This method will also need to save all of the inputs to the
         * newly created Customer object.*/
        
        Main m = new Main();
        m.changeScene("PurchaseVehicle2.fxml");
        
    } // end save
    
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/

        YearField.clear();
        MakeDropdown.setValue("Select a Make");
        ModelField.clear();
        MileageField.clear();
        ColorField.clear();

    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
}
