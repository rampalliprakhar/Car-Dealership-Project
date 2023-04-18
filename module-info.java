/* --------------------------------------------------- 
 *  Author: Team 3 Car Dealership
 *  Written: 2/15/23
 *  Last Updated: 4/18/2023
 *  
 *  Eclipse requires this text to be inserted for the IDE to work with JavaFX & mySQL
 ---------------------------------------------------*/

module CarDealershipUI {

	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
