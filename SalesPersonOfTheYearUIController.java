package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

public class SalesPersonOfTheYearUIController {
	@FXML
	private Button closeButton;
	@FXML
	private TextField salespersonNameTF;
	@FXML
	private Button calculateButton;

	@FXML
	public void close(ActionEvent event) throws IOException {
        //  goes back to the page.
       	if(event.getSource() == closeButton) {
       	    Main m = new Main();
        //  m.changeScene("SetDiscountsUI.fxml");
       	}	
    }
	
	@FXML
	public void salespersonName(ActionEvent event) throws IOException {
	    //  Displays the salesperson name.
		
	}
	
	@FXML
	public void calculate(ActionEvent event) throws IOException {
		//  Calculates the salesperson of the year.
		
	}
}
