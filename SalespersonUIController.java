package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class SalespersonUIController {
	
    @FXML
    private Button CreateOrderDealership;

    @FXML
    private Button CreateOrderManufacturer;

    @FXML
    private Button EnterPurchase;

    @FXML
    private Button RecordNewArrival;

    @FXML
    private Button RegisterCustomer;

    @FXML
    private Button SignOut;

    @FXML
    private Button VerifyTradeValue;
    
    @FXML
    private ImageView CreateOrderManufacturerIcon;

    @FXML
    private ImageView CreateOrderOtherDealershipIcon;

    @FXML
    private ImageView EnterPurchaseIcon;

    @FXML
    private ImageView OriginalCarArt;

    @FXML
    private ImageView ProfileIcon;

    @FXML
    private ImageView RecordNewArrivalIcon;

    @FXML
    private ImageView SignOutIcon;

    @FXML
    private ImageView VerifyTradeInValueIcon;

    @FXML
    void btnCreOrdManuClicked(ActionEvent event) throws IOException {
    	// goes to Create Order for Manufacturer page.
	if(event.getSource() == CreateOrderManufacturer) {
	    Main m = new Main();
	    m.changeScene("CreateOrderforManufacturer.fxml");
        } 
    }

    @FXML
    void btnCreOrderDealClicked(ActionEvent event) throws IOException {
    	// goes to Create Order for Other Dealership page.
    	if(event.getSource() == CreateOrderDealership) {
    	    Main m = new Main();
    	    m.changeScene("CreateOrderforOtherDealership.fxml");
    	}
    }

    @FXML
    void btnEntPurchClicked(ActionEvent event) throws IOException {
        // goes to Enter Purchase page.
       	if(event.getSource() == EnterPurchase) {
       	    Main m = new Main();
       	    m.changeScene("PurchaseVehicle1.fxml");
       	}
       	
    }

    @FXML
    void btnRecNewArrivClicked(ActionEvent event) throws IOException {
    	// goes to Record New Arrival page.
    	if(event.getSource() == RecordNewArrival) {
    	    Main m = new Main();
    	    m.changeScene("RecordVehicleUI.fxml");
    	}
    }

    @FXML
    void btnRegCustClicked(ActionEvent event) throws IOException {
    	// goes to Register Customer page.
    	if(event.getSource() == RegisterCustomer) {
    	    Main m = new Main();
            m.changeScene("RegCustomerUI.fxml");
    	}
    }

    @FXML
    void btnSignOutClicked(ActionEvent event) throws IOException {
    	// goes to Sign Out page.
    	if(event.getSource() == SignOut) {
    	    Main m = new Main();
    	    m.changeScene("CarLogout.fxml");
    	}
    }

    @FXML
    void btnVerTradValClicked(ActionEvent event) throws IOException {
    	// goes to Verify Trade-In Value page.
    	// Had to change the names in the original files.
    	if(event.getSource() == VerifyTradeValue) {
    	    Main m = new Main();
    	    m.changeScene("VerifyTradeInUI.fxml");
    	}
    }
}
