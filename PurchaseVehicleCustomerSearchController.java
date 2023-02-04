package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class PurchaseVehicleCustomerSearchController {
    
    @FXML
    private TableView<Object> ResultsTable; // The type will need to be changed
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private Button searchButton;
    @FXML
    private Button clearButton;
    
    private String previousPage = "MainPage.fxml";
    // The search page is stored for the backToSearch method
    private String searchPage = "PurchaseVehicle2.fxml";
    
    
    public void search(ActionEvent event) {
        
        // NOT DONE
        
    } // end search
    
    public void clear(ActionEvent event) {
        
        firstNameField.clear();
        lastNameField.clear();
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
    
    public void returnToVehicleSearch(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(searchPage);
        
    }
}
