package application;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;
public class CreateOrderforDealershipController {

	 private String previousPage = "SalespersonView.fxml";
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
	 private ChoiceBox<String> ModelCar;
	 final private ObservableList<String> modelList = FXCollections.observableArrayList("Integra", "Giulia", "Vantage", "Q5", "Bentayga Hybrid", "X1", "Encore", 
	    "Escalade", "Camaro", "Pacifica", "Charger", "Roma", "500X", "Ranger", "G80", "Terrain", "Civic", "Elantra", "Q60", "XF", "Wrangler", "Sportage", 
	    "Urus", "Range Rover", "GX", "Aviator", "Grecale", "Tribute Hybrid", "720S", "A-Class", "Cooper", "Outlander", "Pathfinder", "Boxster", "ProMaster City", 
	    "Phantom", "Ascent", "Model Y", "Camry", "Tiguan", "XC40");
	 
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
        
        ModelCar.setValue("Select a Model");
        ModelCar.getItems().addAll(modelList);
        
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
	     ModelCar.setValue("Select a Model");
	     bodyCondition.setValue("Select condition");
	     mechCondition.setValue("Select condition");
	}
	
	public void send(ActionEvent event) throws IOException {
		 String dealership = dealershipEntry.getText();
		 String order = orderNumber.getText();
		 String mileage = mileageText.getText();
		 String year = Year.getText();
		 String color = Color.getText();
		// After filling information, it goes to the next page,
		// where different information are filled
		if(dealership.isBlank() && order.isBlank() && mileage.isBlank() && year.isBlank() && color.isBlank()) 
		 {
			 invalidPrompt.setText("Login fields required");
			 dealershipEntry.setStyle(failurePrompt);
			 orderNumber.setStyle(failurePrompt);
			 mileageText.setStyle(failurePrompt);
			 Year.setStyle(failurePrompt);
			 Color.setStyle(failurePrompt);
		 }
		 else 
		 {   // if dealershipEntry is blank
			 if(dealership.isBlank())
			 {
				 dealershipEntry.setStyle(failurePrompt);
				 invalidPrompt.setText("Username required!");
				 dealershipEntry.setStyle(successPrompt);
			 }
			 else 
			 {	 // if orderNumber is blank
				 if(order.isBlank()) 
				 {
					 orderNumber.setStyle(failurePrompt);
					 invalidPrompt.setText("Password required!");
					 orderNumber.setStyle(successPrompt);
				 }
				 else 
				 {
			 		if(YearValidator(year) == true) {
		 				Main m = new Main();
		 				m.changeScene(Main.getView());
		 			}		
			 		if(!color.matches("^[a-zA-Z]$") && !dealership.matches("^[a-zA-Z]$")){
			 			invalidPrompt.setText("Wrong input");
			 		}
			 		if(!mileage.matches("^[0-9]{6}$")) {
			 			invalidPrompt.setText("Wrong input");
			 			mileageText.setStyle(failurePrompt);
			 			if(mileage.length() > 6) {
				 			invalidPrompt.setText("Number should be 6 digits long");
				 			mileageText.setStyle(failurePrompt);
			 			}
			 		}
			 		
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