package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchCustomerController {
    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private Button clearButton;
    
    @FXML
    private Button returnButton;
    
    @FXML
    private Button registerNewCus;
    
    private String previousPage = Main.getView();
    
    public void searchCus(ActionEvent event) throws IOException {
    	// searchCus();
    	
    	
    	
    	
    	
    	
    }
    
    public void registerNewCus(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("registerNewCustomerUI.fxml");
    }
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
    
    public void clear(ActionEvent event) {
        
        /* This method clears all of the fields.*/
        
        firstName.clear();
        lastName.clear();
        
    } // end clear
    
    
}



