package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class RegisterCustomerController {
    
    @FXML
    private TextField FirstNameField;
    @FXML
    private TextField LastNameField;
    @FXML
    private TextField AddressField;
    @FXML
    private TextField CityField;
    @FXML
    private TextField StateField;
    @FXML
    private TextField ZIPField;
    @FXML
    private TextField PhoneField;
    @FXML
    private Button SaveButton;
    @FXML
    private Button ClearButton;
    @FXML
    private Button ReturnButton;
    
    private String previousPage = "MainPage.fxml";
    
    
    public void save(ActionEvent event) throws IOException {
        
        /* This method will also need to save all of the inputs to the
         * newly created Customer object.*/
        
        Main m = new Main();
        m.changeScene("TESTSaveConfirm.fxml");
        // Note to self: change this to MainPage.fxml when that code is received
        
    } // end save
    
    public void clear(ActionEvent event) throws IOException {
        
        FirstNameField.clear();
        LastNameField.clear();
        AddressField.clear();
        CityField.clear();
        StateField.clear();
        ZIPField.clear();
        PhoneField.clear();
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
    
}
