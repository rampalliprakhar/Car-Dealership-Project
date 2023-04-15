package application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;

public class CreateOrderforManufacturerController {

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

	private String previousPage = Main.getView();

  	public static boolean YearValidator(String yearinput) {
  		return yearinput.matches("^(19|20)[0-9][0-9]$"); // yearinput matches with regular expression
  	}

	public void initialize() throws IOException {
		MakeCar.setValue("Select a Make");
        MakeCar.getItems().addAll(makeList);
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
		String order = OrderID.getText();
		String year = Year.getText();
		String model = ModelCar.getText();
		String color = Color.getText();
		// checks to see if any field is blank/empty
		if(order.isBlank() || year.isBlank() || model.isBlank() || color.isBlank()) {
			invalidInput.setText("Input fields required!");
			OrderID.setStyle(failurePrompt);
			Year.setStyle(failurePrompt);
			ModelCar.setStyle(failurePrompt);
			Color.setStyle(failurePrompt);
		}
		else 
		{   
			// checks to see if everthing is true and matches the pattern
			if(YearValidator(year) == true && model.matches("^[a-zA-Z]{0,40}$") && order.matches("^[0-9]{4}$") && color.matches("^[A-Za-z]{0,40}$")) {
				Main m = new Main();
				m.changeScene(Main.getView());
			}
			else {
				if(YearValidator(year) != true) {
	 		 	    if(year.length() > 4){ // checks whether the input is greater than 4
	 		 	        invalidInput.setText("Year not greater than 4 digits!");
	 		 	    	Year.setStyle(failurePrompt);
	 		 	    }
	 			}
				// Accepts alphabetical characters upto 40 characters allowed
		 		if(!color.matches("^[A-Za-z]{0,40}$")){
		 			Color.setStyle(failurePrompt);
		 			Color.clear();
		 		}
		 		// Accepts numbers between 0 to 9 and 4 digits length only
		 		if(!order.matches("^[0-9]{4}$")) {
		 			OrderID.setStyle(failurePrompt);
		 			OrderID.clear();
		 		}
		 		// Accepts alphabetical characters upto 40 characters allowed
		 		if(!model.matches("^[a-zA-Z]{0,40}$")){
		 			ModelCar.setStyle(failurePrompt);
		 			ModelCar.clear();
		 		}
			}
		}
	}
	
	public void returnPage(ActionEvent event) throws IOException {
	 // returns back to the main page
		Main m = new Main();
	 	m.changeScene(previousPage);
	}
}
