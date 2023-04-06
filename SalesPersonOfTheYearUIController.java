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
    private String SOTY = "No Salesperson Chosen";
    // Default value is No Salesperson Chose, will be overwritten in calculate method

    @FXML
    public void close(ActionEvent event) throws IOException {
        //  goes back to the page.
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
