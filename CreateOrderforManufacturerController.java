package application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.*;
//import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
	private TextField ModelCar;
	 
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
	 
	@FXML
	private Label invalidInput;
	 
	protected String successPrompt = String.format("-fx-text-fill: GREEN;"); // correct input with green font
	protected String failurePrompt = String.format("-fx-text-fill: RED;"); // incorrect input with red font

	private String previousPage = "SampleSalesperson.fxml";

  	public static boolean YearValidator(String yearinput) {
        return yearinput.matches("^(19|20)[0-9][0-9]$"); // yearinput matches with regular expression
	}
	
	public void clear(ActionEvent event) {
		// checks the functionality of the button and resets the input field
		 OrderID.clear();
		 Year.clear();
		 Color.clear();
		 MakeCar.setValue("Select a Make");
		 ModelCar.clear();
	}
	 
	public void send(ActionEvent event) throws IOException {
		// send the filled information to the VerifyTradeInUI
		String order = OrderID.getText();
		String year = Year.getText();
		String model = ModelCar.getText();
		String color = Color.getText();
		if(order.isBlank() && year.isBlank() && model.isBlank() && color.isBlank()) {
			invalidInput.setText("Login fields required!");
			OrderID.setStyle(failurePrompt);
			Year.setStyle(failurePrompt);
			ModelCar.setStyle(failurePrompt);
			Color.setStyle(failurePrompt);
		}
		else 
		{   // if orderNumber is blank
			if(order.isBlank()) 
			{
				OrderID.setStyle(failurePrompt);
				invalidInput.setText("Password required!");
				OrderID.setStyle(successPrompt);
			}
			else 
			{
				if(model.isBlank()) {
					ModelCar.setStyle(failurePrompt);
					invalidInput.setText("Model required!");
				}
				if(YearValidator(year) == true) {
	 		 	    if(year.length() > 4){ // checks whether the input is greater than 4
	 		 	        invalidInput.setText("Year not greater than 4 digits!");
	 		 	    	Year.setStyle(failurePrompt);
	 		 	    }
	 			}		
		 		if(!color.matches("^[a-zA-Z]$") && !order.matches("^[0-9]{4}$")){
		 			invalidInput.setStyle(failurePrompt);
		 			invalidInput.setText("Wrong input");
		 		}
		 		if(!model.matches("^[a-zA-z0-9]$")) {
		 			invalidInput.setText("Wrong input");
		 		}
		    }
			Main m = new Main();
			m.changeScene(Main.getView());
		}
	}
	 
	public void returnPage(ActionEvent event) throws IOException {
	 // returns back to the main page
		Main m = new Main();
	 	m.changeScene(previousPage);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        MakeCar.setValue("Select a Make");
        MakeCar.getItems().addAll(makeList);
	}
}
