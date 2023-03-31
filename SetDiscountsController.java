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
    private Vehicle vehicle4 = null;
    private Vehicle vehicle5 = null;
    private Vehicle vehicle6 = null;
    private Vehicle vehicle7 = null;
    
    @FXML
    TabPane tabPane = new TabPane();
    @FXML
    Tab v1 = new Tab("Vehicle 1");
    @FXML
    Tab v2 = new Tab("Vehicle 2");
    @FXML
    Tab v3 = new Tab("Vehicle 3");
    @FXML
    Tab v4 = new Tab("Vehicle 4");
    @FXML
    Tab v5 = new Tab("Vehicle 5");
    @FXML
    Tab v6 = new Tab("Vehicle 6");
    @FXML
    Tab v7 = new Tab("Vehicle 7");
     
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
    
    @FXML
    private TextField v1TimeLot3;
    @FXML
    private TextField v1ValueField3;
    @FXML
    private TextField v1VINField3;
    @FXML
    private TextField v1YearField3;
    @FXML
    private TextField v1Make3;
    @FXML
    private TextField v1ModelField3;
    @FXML
    private TextField v1MileageField3;
    @FXML
    private TextField v1ColorField3;
    @FXML
    private TextField v1BodyCon3;
    @FXML
    private TextField v1MechCon3;
    @FXML
    private Button v1Mark3;
    
    @FXML
    private TextField v1TimeLot4;
    @FXML
    private TextField v1ValueField4;
    @FXML
    private TextField v1VINField4;
    @FXML
    private TextField v1YearField4;
    @FXML
    private TextField v1Make4;
    @FXML
    private TextField v1ModelField4;
    @FXML
    private TextField v1MileageField4;
    @FXML
    private TextField v1ColorField4;
    @FXML
    private TextField v1BodyCon4;
    @FXML
    private TextField v1MechCon4;
    @FXML
    private Button v1Mark4;
    
    @FXML
    private TextField v1TimeLot5;
    @FXML
    private TextField v1ValueField5;
    @FXML
    private TextField v1VINField5;
    @FXML
    private TextField v1YearField5;
    @FXML
    private TextField v1Make5;
    @FXML
    private TextField v1ModelField5;
    @FXML
    private TextField v1MileageField5;
    @FXML
    private TextField v1ColorField5;
    @FXML
    private TextField v1BodyCon5;
    @FXML
    private TextField v1MechCon5;
    @FXML
    private Button v1Mark5;
    
    @FXML
    private TextField v1TimeLot6;
    @FXML
    private TextField v1ValueField6;
    @FXML
    private TextField v1VINField6;
    @FXML
    private TextField v1YearField6;
    @FXML
    private TextField v1Make6;
    @FXML
    private TextField v1ModelField6;
    @FXML
    private TextField v1MileageField6;
    @FXML
    private TextField v1ColorField6;
    @FXML
    private TextField v1BodyCon6;
    @FXML
    private TextField v1MechCon6;
    @FXML
    private Button v1Mark6;
    
    
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
        
        if (vehicle4 != null) {
            v1TimeLot3.setText(vehicle4.getTimeOnLot().toString());
            v1ValueField3.setText(vehicle4.getValue().toString());
            v1VINField3.setText(vehicle4.getVIN());
            v1YearField3.setText(vehicle4.getYear().toString());
            v1Make3.setText(vehicle4.getMake());
            v1ModelField3.setText(vehicle4.getModel());
            v1MileageField3.setText(vehicle4.getMileage().toString());
            v1ColorField3.setText(vehicle4.getColor());
            v1BodyCon3.setText(vehicle4.getBodyCondition());
            v1MechCon3.setText(vehicle4.getMechCondition());
            
        }
       
        if (vehicle5 != null) {
            v1TimeLot4.setText(vehicle5.getTimeOnLot().toString());
            v1ValueField4.setText(vehicle5.getValue().toString());
            v1VINField4.setText(vehicle5.getVIN());
            v1YearField4.setText(vehicle5.getYear().toString());
            v1Make4.setText(vehicle5.getMake());
            v1ModelField4.setText(vehicle5.getModel());
            v1MileageField4.setText(vehicle5.getMileage().toString());
            v1ColorField4.setText(vehicle5.getColor());
            v1BodyCon4.setText(vehicle5.getBodyCondition());
            v1MechCon4.setText(vehicle5.getMechCondition());
        }
        
        if (vehicle6 != null) {
            v1TimeLot5.setText(vehicle6.getTimeOnLot().toString());
            v1ValueField5.setText(vehicle6.getValue().toString());
            v1VINField5.setText(vehicle6.getVIN());
            v1YearField5.setText(vehicle6.getYear().toString());
            v1Make5.setText(vehicle6.getMake());
            v1ModelField5.setText(vehicle6.getModel());
            v1MileageField5.setText(vehicle6.getMileage().toString());
            v1ColorField5.setText(vehicle6.getColor());
            v1BodyCon5.setText(vehicle6.getBodyCondition());
            v1MechCon5.setText(vehicle6.getMechCondition());
        }
        
        if (vehicle7 != null) {
            v1TimeLot6.setText(vehicle7.getTimeOnLot().toString());
            v1ValueField6.setText(vehicle7.getValue().toString());
            v1VINField6.setText(vehicle7.getVIN());
            v1YearField6.setText(vehicle7.getYear().toString());
            v1Make6.setText(vehicle7.getMake());
            v1ModelField6.setText(vehicle7.getModel());
            v1MileageField6.setText(vehicle7.getMileage().toString());
            v1ColorField6.setText(vehicle7.getColor());
            v1BodyCon6.setText(vehicle7.getBodyCondition());
            v1MechCon6.setText(vehicle7.getMechCondition());
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
    
    public void v4Save(ActionEvent event) throws IOException {
        tabPane.setVisible(false);
        discountPane.setVisible(true);
        this.regularPrice.setText(vehicle4.getValue().toString());
        carForDiscount = this.vehicle4;
    }

    public void v5Save(ActionEvent event) throws IOException {
        tabPane.setVisible(false);
        discountPane.setVisible(true);
        this.regularPrice.setText(vehicle5.getValue().toString());
        carForDiscount = this.vehicle5;
    }

    
    public void v6Save(ActionEvent event) throws IOException {
        tabPane.setVisible(false);
        discountPane.setVisible(true);
        this.regularPrice.setText(vehicle6.getValue().toString());
        carForDiscount = this.vehicle6;
    }

    public void v7Save(ActionEvent event) throws IOException {
        tabPane.setVisible(false);
        discountPane.setVisible(true);
        this.regularPrice.setText(vehicle7.getValue().toString());
        carForDiscount = this.vehicle7;
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
