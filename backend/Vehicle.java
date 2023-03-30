package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import backend.Vehicle;
import java.util.Date;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class SetDiscountsController {
    
    @FXML
    private Button ReturnButton;
    
    private String previousPage = Main.getView();
    
    @FXML
    private AnchorPane discountPane;
    @FXML
    private TextField percentDiscount;
    @FXML
    private TextField regularPrice;
    @FXML
    private TextField newDiscountPrice;
    @FXML
    private Vehicle carForDiscount;
    @FXML
    private Button saveButton;
    @FXML
    private Button clearButton;
    
    private Vehicle testCar1 = new Vehicle("123456789", new Double(15000.00), new Integer(1996), "Ford", "Fiesta", "New", "Broken", "Grey", new Double(120000.00), new Date(System.currentTimeMillis()));
    private Vehicle testCar2 = new Vehicle("987654321", new Double(17000.00), new Integer(2018), "Honda", "Acura", "New", "Broken", "Blue", new Double(1500.00), new Date(System.currentTimeMillis()));
    private Vehicle testCar3 = new Vehicle();
    
    private Vehicle vehicle1 = null;
    private Vehicle vehicle2 = null;
    private Vehicle vehicle3 = null;
    // Expand to 7
    
    @FXML
    TabPane tabPane = new TabPane();
    @FXML
    Tab v1 = new Tab("Vehicle 1");
    @FXML
    Tab v2 = new Tab("Vehicle 2");
    @FXML
    Tab v3 = new Tab("Vehicle 3");
     
    @FXML
    private TextField v1TimeLot;
    @FXML
    private TextField v1ValueField;
    @FXML
    private TextField v1VINField;
    @FXML
    private TextField v1YearField;
    @FXML
    private TextField v1Make;
    @FXML
    private TextField v1ModelField;
    @FXML
    private TextField v1MileageField;
    @FXML
    private TextField v1ColorField;
    @FXML
    private TextField v1BodyCon;
    @FXML
    private TextField v1MechCon;
    @FXML
    private Button v1Mark;
    
    @FXML
    private TextField v1TimeLot1;
    @FXML
    private TextField v1ValueField1;
    @FXML
    private TextField v1VINField1;
    @FXML
    private TextField v1YearField1;
    @FXML
    private TextField v1Make1;
    @FXML
    private TextField v1ModelField1;
    @FXML
    private TextField v1MileageField1;
    @FXML
    private TextField v1ColorField1;
    @FXML
    private TextField v1BodyCon1;
    @FXML
    private TextField v1MechCon1;
    @FXML
    private Button v1Mark1;
    
    @FXML
    private TextField v1TimeLot2;
    @FXML
    private TextField v1ValueField2;
    @FXML
    private TextField v1VINField2;
    @FXML
    private TextField v1YearField2;
    @FXML
    private TextField v1Make2;
    @FXML
    private TextField v1ModelField2;
    @FXML
    private TextField v1MileageField2;
    @FXML
    private TextField v1ColorField2;
    @FXML
    private TextField v1BodyCon2;
    @FXML
    private TextField v1MechCon2;
    @FXML
    private Button v1Mark2;
    
    // Once this is okayed, I'll expand to 7 vehicles
    
    @FXML
    private void initialize() {
        
        discountPane.setVisible(false);
        setVehicles();
        
        if (vehicle1 != null) {
            v1TimeLot.setText(vehicle1.getTimeOnLot().toString());
            v1ValueField.setText(vehicle1.getValue().toString());
            v1VINField.setText(vehicle1.getVIN());
            v1YearField.setText(vehicle1.getYear().toString());
            v1Make.setText(vehicle1.getMake());
            v1ModelField.setText(vehicle1.getModel());
            v1MileageField.setText(vehicle1.getMileage().toString());
            v1ColorField.setText(vehicle1.getColor());
            v1BodyCon.setText(vehicle1.getBodyCondition());
            v1MechCon.setText(vehicle1.getMechCondition());
        }
        
        if (vehicle2 != null) {
            v1TimeLot1.setText(vehicle2.getTimeOnLot().toString());
            v1ValueField1.setText(vehicle2.getValue().toString());
            v1VINField1.setText(vehicle2.getVIN());
            v1YearField1.setText(vehicle2.getYear().toString());
            v1Make1.setText(vehicle2.getMake());
            v1ModelField1.setText(vehicle2.getModel());
            v1MileageField1.setText(vehicle2.getMileage().toString());
            v1ColorField1.setText(vehicle2.getColor());
            v1BodyCon1.setText(vehicle2.getBodyCondition());
            v1MechCon1.setText(vehicle2.getMechCondition());
        }
        
        if (vehicle3 != null) {
            v1TimeLot2.setText(vehicle3.getTimeOnLot().toString());
            v1ValueField2.setText(vehicle3.getValue().toString());
            v1VINField2.setText(vehicle3.getVIN());
            v1YearField2.setText(vehicle3.getYear().toString());
            v1Make2.setText(vehicle3.getMake());
            v1ModelField2.setText(vehicle3.getModel());
            v1MileageField2.setText(vehicle3.getMileage().toString());
            v1ColorField2.setText(vehicle3.getColor());
            v1BodyCon2.setText(vehicle3.getBodyCondition());
            v1MechCon2.setText(vehicle3.getMechCondition());
            
        }
       
    }
    
    private void setVehicles() {
        System.out.println(testCar1.getValue() + testCar1.getVIN() + testCar1.getYear() + testCar1.getMake() + testCar1.getModel() + testCar1.getMileage() + testCar1.getColor() + testCar1.getBodyCondition() + testCar1.getMechCondition());
        
        // DEBUG
        this.vehicle1 = this.testCar1;
        this.vehicle2 = this.testCar2;
    }
    
    public void pageReturn(ActionEvent event) throws IOException {
        
        Main m = new Main();
        m.changeScene(previousPage);
        
    } // end pageReturn
    
    public void v1Save(ActionEvent event) throws IOException {
        tabPane.setVisible(false);
        discountPane.setVisible(true);
        this.regularPrice.setText(vehicle1.getValue().toString());
        carForDiscount = this.vehicle1;
    }
    
    public void v2Save(ActionEvent event) throws IOException {
        tabPane.setVisible(false);
        discountPane.setVisible(true);
        this.regularPrice.setText(vehicle2.getValue().toString());
        carForDiscount = this.vehicle2;
    }
    
    public void v3Save(ActionEvent event) throws IOException {
        tabPane.setVisible(false);
        discountPane.setVisible(true);
        this.regularPrice.setText(vehicle3.getValue().toString());
        carForDiscount = this.vehicle3;
    }
    
    public void discountSave(ActionEvent event) throws IOException {
        if (percentDiscount.getText() != "") {
            try {
                Float percentDis = new Float(percentDiscount.getText());
                this.carForDiscount.setDiscount(percentDis);
                discountCancel(new ActionEvent());
                return;
            } catch (NumberFormatException e) {
                System.out.println("Error in 1");
                return;
            }
        }
        
        if (newDiscountPrice.getText() != "") {
            try {
                Double priceAfterFlatDis = new Double(newDiscountPrice.getText());
                Double flatDis = carForDiscount.getValue() - priceAfterFlatDis;
                this.carForDiscount.setDiscount(flatDis);
                discountCancel(new ActionEvent());
                return;
            } catch (NumberFormatException e) {
                System.out.println("Error in 2");
                return;
            }
        }
    }
    
    public void discountCancel(ActionEvent event) throws IOException {
        this.percentDiscount.clear();
        this.newDiscountPrice.clear();
        this.regularPrice.clear();
        
        discountPane.setVisible(false);
        tabPane.setVisible(true);
    }
}
