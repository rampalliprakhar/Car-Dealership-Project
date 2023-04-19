/* --------------------------------------------------- 
 *  Author: Team 3 Car Dealership
 *  Written: 2/13/23
 *  Last Updated: 4/18/2023
 *  
 *  Compilation: javac SalesPersonOfTheYearUIController.java
 *  Execution: java SalesPersonOfTheYearUIController
 *  
 *  Handles calculating Salesperson of the Year
 *  If we had more time, it would also be the weekly reports screen.
 *  Corresponding fxml file: SalesPersonOfTheYearUI.fxml
 ---------------------------------------------------*/

package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.event.ActionEvent;

public class SalesPersonOfTheYearUIController {
    
    // Declare UI Fields
    @FXML
    private Button closeButton;
    @FXML
    private TextField salespersonNameTF;
    @FXML
    private Button calculateButton;
    @FXML
    private String SOTY = "No Salesperson Chosen";
    // Default value is No Salesperson Chose, will be overwritten in calculate method

    @FXML
    public void close(ActionEvent event) throws IOException {
        //  goes back to the last page.
        if(event.getSource() == closeButton) {
            Main m = new Main();
            m.changeScene(Main.getView());
        }   
    }
    
    @FXML
    public void calculate(ActionEvent event) throws IOException {
        // Code for calculating SOTY
        // SOTY = that result
        
        this.salespersonNameTF.setText(SOTY);
        
    }
}
