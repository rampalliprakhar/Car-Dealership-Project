package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;

public class PurchaseVehicle2Controller {

    @FXML
    private TextField yearField;
    @FXML
    private TextField makeField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField colorField;
    @FXML
    private TextField mileageField;
    @FXML
    private TextField VINField;
    @FXML
    private TextField bodyConField;
    @FXML
    private TextField mechConField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField customerNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNoField;
    @FXML
    private Button confirmButton;    
    @FXML
    private Button backToSearchButton;
    @FXML
    private Button ReturnButton;
    
    private String previousPage = "MainPage.fxml";
    // The search page is stored for the backToSearch method
    private String searchPage = "PurchaseVehicle1.fxml";
    
    public void confirm(ActionEvent event) throws IOException {
        
        // NOT DONE
        
    } // end confirm
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
    
    public void backToSearch(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(searchPage);
        
    } // end backToSearch
    
}
