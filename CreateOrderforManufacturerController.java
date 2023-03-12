package application;

import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Parent;
import javafx.scene.control.*;
//import javafx.scene.*;
//import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateOrderforManufacturerController implements Initializable {

	 @FXML
	 private ChoiceBox<String> MakeCar;
	 final private ObservableList<String> makeList = FXCollections.observableArrayList("Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Buick", 
	            "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Ferrari", "Fiat", "Ford", "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia", 
	            "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Maserati", "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", "Ram", 
	            "Rolls-Royce", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo");
	 
	 @FXML
	 private ChoiceBox<String> ModelCar;
	 final private ObservableList<String> modelList = FXCollections.observableArrayList("Integra", "Giulia", "Vantage", "Q5", "Bentayga Hybrid", "X1", "Encore", 
			    "Escalade", "Camaro", "Pacifica", "Charger", "Roma", "500X", "Ranger", "G80", "Terrain", "Civic", "Elantra", "Q60", "XF", "Wrangler", "Sportage", 
			    "Urus", "Range Rover", "GX", "Aviator", "Grecale", "Tribute Hybrid", "720S", "A-Class", "Cooper", "Outlander", "Pathfinder", "Boxster", "ProMaster City", 
			    "Phantom", "Ascent", "Model Y", "Camry", "Tiguan", "XC40");
	 
	 @FXML
	 private Button ReturnButton;
	 
	 @FXML
	 private Button SendButton;
	 
	 @FXML
	 private Button ClearButton;
	 
	 @FXML
	 private TextField OrderID;
	 
	 @FXML
	 private TextField Year;
	 
	 @FXML
	 private TextField Color;
	 
	 private String previousPage = "SalespersonView.fxml";
	 
	 public void clear(ActionEvent event) {
		// checks the functionality of the button and resets the input field
		if(event.getSource() == ClearButton) {
			 OrderID.setText("");
			 Year.setText("");
			 Color.setText("");
			 MakeCar.setValue("Select a Make");
			 ModelCar.setValue("Select a Model");
		}
	 }
	 
	 public void send(ActionEvent event) throws IOException {
		 // send the filled information to the VerifyTradeInUI
		 MakeCar.getValue();
		 ModelCar.getValue();
		 Main m = new Main();
		 m.changeScene("VerifyTradeIn.fxml");
	 }
	 
	 public void returnPage(ActionEvent event) throws IOException {
		 // returns back to the main page
		 if(event.getSource() == ReturnButton) {
			 Main m = new Main();
			 m.changeScene(previousPage);
		 }
	 }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        MakeCar.setValue("Select a Make");
        MakeCar.getItems().addAll(makeList);
        
        ModelCar.setValue("Select a Model");
        ModelCar.getItems().addAll(modelList);
	}
}
