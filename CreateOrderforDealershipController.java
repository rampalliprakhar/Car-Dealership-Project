package application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;
public class CreateOrderforDealershipController {

private String previousPage = Main.getView();
    @FXML
    private Button ClearButton;
    @FXML
    private Button SendButton;
    @FXML
    private Button ReturnButton;
    @FXML
    private ChoiceBox<String> MakeCar;

	final private ObservableList<String> makeList = FXCollections.observableArrayList("Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Buick", 
           "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Ferrari", "Fiat", "Ford", "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia", 
           "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Maserati", "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", "Ram", 
           "Rolls-Royce", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo");
	 
    @FXML
    private TextField ModelCar;
	 
    @FXML
    private ChoiceBox<String> bodyCondition;
    	final private ObservableList<String> bodyconditionList = FXCollections.observableArrayList("New", "Excellent", "Good", "Average", "Fair", "Poor", "Broken");
	 
    @FXML
    private ChoiceBox<String> mechCondition;
        final private ObservableList<String> mechconditionList = FXCollections.observableArrayList("New", "Excellent", "Good", "Average", "Fair", "Poor", "Broken");
	 
    @FXML
    private TextField dealershipEntry;
	 
    @FXML
    private TextField orderNumber;
	 
    @FXML
    private TextField mileageText;
	 
    @FXML
    private TextField Year;
	 
    @FXML
    private TextField Color;
	
    @FXML
    private Label invalidPrompt;
	 
    protected String successPrompt = String.format("-fx-text-fill: GREEN;"); // correct input with green font
    protected String failurePrompt = String.format("-fx-text-fill: RED;"); // incorrect input with red font
	 
    @FXML
    private void initialize() {
 	MakeCar.setValue("Select a Make");
        MakeCar.getItems().addAll(makeList);
        
        bodyCondition.setValue("Select condition");
        bodyCondition.getItems().addAll(bodyconditionList);
        
        mechCondition.setValue("Select condition");
        mechCondition.getItems().addAll(mechconditionList);   
    } // end initialize method
 	
    public static boolean YearValidator(String yearinput) {
        if(yearinput.length() > 4){ // checks whether the input is greater than 4
            System.out.println("Invalid year format"); // prints invalid year format
        }
        return yearinput.matches("^(19|20)[0-9][0-9]$"); // yearinput matches with regular expression
    }
	
    public void clear(ActionEvent event) {
	dealershipEntry.clear();
	orderNumber.clear();
	Year.clear();
	Color.clear();
	mileageText.clear();
	MakeCar.setValue("Select a Make");
	ModelCar.clear();
	bodyCondition.setValue("Select condition");
	mechCondition.setValue("Select condition");
    }
	
    public void send(ActionEvent event) throws IOException {
	String dealership = dealershipEntry.getText();
	String order = orderNumber.getText();
	String mileage = mileageText.getText();
	String year = Year.getText();
	String model = ModelCar.getText();
	String color = Color.getText();
	// checks to see if any field is blank/empty
	if(dealership.isBlank() || order.isBlank() || mileage.isBlank() || year.isBlank() || model.isBlank() || color.isBlank()) 
	{
		invalidPrompt.setText("Input fields required");
		dealershipEntry.setStyle(failurePrompt);
		orderNumber.setStyle(failurePrompt);
		mileageText.setStyle(failurePrompt);
		Year.setStyle(failurePrompt);
		ModelCar.setStyle(failurePrompt);
		Color.setStyle(failurePrompt);
	}
	else 
	{
		// checks to see if everthing is true and matches the pattern
		if(YearValidator(year) == true && model.matches("^[a-zA-Z]{0,40}$") && color.matches("^[A-Za-z]{0,40}$") && dealership.matches("^[A-Za-z]{0,40}$") && order.matches("^[0-9]{4}$") && mileage.matches("^[0-9]{0,8}$")) {
			Main m = new Main();
			m.changeScene(Main.getView());
		}	
		// Accepts alphabetical characters upto 40 characters allowed
		if(!dealership.matches("^[A-Za-z]{0,40}$")) {
			dealershipEntry.setStyle(failurePrompt);
			dealershipEntry.clear();
		}
		if(YearValidator(year) == false) {
			Year.setStyle(failurePrompt);
		}
		// Accepts alphabetical characters upto 40 characters allowed
		if(!model.matches("^[a-zA-Z]{0,40}$")) { //"^[a-zA-Z]{0,40}$"
			ModelCar.setStyle(failurePrompt);
			ModelCar.clear();
		}
		// Accepts numbers between 0 to 9 and digits length between 0 to 8 only
		if(!mileage.matches("^[0-9]{0,8}$")) {
			mileageText.setStyle(failurePrompt);
			mileageText.clear();
		}
		// Accepts alphabetical characters upto 40 characters allowed
		if(!color.matches("^[A-Za-z]{0,40}$")) {
			Color.setStyle(failurePrompt);
			Color.clear();
		}
		// Accepts numbers between 0 to 9 and 4 digits length only
		if(!order.matches("^[0-9]{4}$")) {
			orderNumber.setStyle(failurePrompt);
			orderNumber.clear();
		}
	}
    }
	 
    public void returnPage(ActionEvent event) throws IOException {
	// returns back to the main page
	Main m = new Main();
	m.changeScene(previousPage);
    }
}
