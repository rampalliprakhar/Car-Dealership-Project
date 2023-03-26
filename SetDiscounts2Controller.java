package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class SetDiscounts2Controller {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField newDiscountPrice;

    @FXML
    private TextField percentDiscount;

    @FXML
    private TextField regularPrice;

    @FXML
    private Button saveButton;

    
    @FXML
    void cancel(ActionEvent event) throws IOException {
        // goes back to the set discounts page.
       	if(event.getSource() == cancelButton) {
       	    Main m = new Main();
       	    m.changeScene("SetDiscountsUI.fxml");
       	}
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        // saves the input, then takes user back to the set discounts page.
    	// not done.
       	if(event.getSource() == saveButton) {
       	    Main m = new Main();
       	    m.changeScene("SetDiscountsUI.fxml");
       	}
    }
}