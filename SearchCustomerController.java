package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.application.Application;

public class SearchCustomerController {
	
	private CustomerProfile selectedCus;
	
    @FXML
    private TextField firstName, lastName;
    
    @FXML
    private Button searchButton, clearButton, returnButton, registerNewCustomer, openProfileButton;
    
    @FXML
    private MenuItem selectButton;
    
    @FXML
    private ListView<String> listView;
        
    public void initialize() {
    }
    
    public void searchCus(ActionEvent event) throws IOException {    	
    	
    	// listView.setItems(list); make list of all customer from database with inputed name?
    	
    	// database needed: search database and get name, DOB, and ID
    	
    	
    	// test data
    	String fullName = firstName.getText() + " " + lastName.getText();
    	String DOB = "08/23/2003";
    	int customerID = 5092; // should ID be string to allow a 0 in the front ex: 0873

      for (int i = 0; i < 4; i++) {
      	listView.getItems().addAll("Name:    " + fullName +"\n" + 
      							   "DOB:      " + DOB + "\n" + 
      							   "ID:          " + customerID);

      	
//      ObservableList<String> list = FXCollections.observableArrayList("Mark Zuckerburg \n10/09/2000", "Tom Clancy\n02/06/1999", "Jack Sparrow\n03/18/1989"); 
    	 
//    	listView.setItems(list);
      }
    }
    
    public void openCusProfile(ActionEvent event) throws IOException{
    	
    	
    	Main m = new Main();
    	// open customer profile of selected customer by searching database
    	m.changeScene("CustomerProfileUI.fxml");
    	
    } // end openCusProfile DOESNT WORK YET

	
	@FXML
    public void openCusProfile(MouseEvent event) throws IOException{
    	Main m = new Main();
//    	selectedCus = listView.getSelectionModel().getSelectedItem());
    	
    	m.changeScene("CustomerProfileUI.fxml");
    	
    } // end openCusProfile DOESNT WORK YET
	
//  public void selectedCus(CustomerProfile cus) {
//	selectedCus = cus;
//	listView.getItems().addAll(Launch.getCus());
//	updateGUI();
//}
	
    public void registerNewCus(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterCustomerUI.fxml"));
    	Parent root = loader.load();
    	
    	RegisterCustomerController regCusController = loader.getController();
    	regCusController.showInformation(firstName.getText(), lastName.getText());

    	
    	Main m = new Main();
    	m.changeScene("RegisterCustomerUI.fxml", root);
    } // end registerNewCus
    
    public void showInformation(String firstName, String lastName) {
    	this.firstName.setText(firstName);
    	this.lastName.setText(lastName);
    }
	
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/
        
        firstName.clear();
        lastName.clear();
        
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene("SalespersonView.fxml");
    } // end pageReturn
}
