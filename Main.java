package application;
	
import java.sql.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
    private static Stage stg;
    private static String view = "SampleSalesperson.fxml";
    // This variable will either be SalespersonView.fxml or ManagerView.fxml
    
    
    @Override
	public void start(Stage primaryStage) {
		try {
		    stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("CarLogin.fxml"));
			Scene scene = new Scene(root,1920,1080);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public void changeScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root);
    }
    
    public void changeScene(String fxml, Parent root) throws IOException {
        stg.getScene().setRoot(root);
    } // method helps with carrying over textfield info from one UI to the other
    
	public static void main(String[] args) throws Exception {
		launch(args);
		System.out.println(getGoogleCloudDBConnection());
	}
	
	public static String getView() {
	    return view;
	} // Method to get the view variable
	
	public static void setView(boolean hasManagerRights) {
	    if (hasManagerRights) {
	        view = "ManagerViewUISample.fxml";
	    } else if (!hasManagerRights) {
	        view = "SampleSalesperson.fxml";
	    }
	} // Method to set the view variable

	public static Connection getGoogleCloudDBConnection() throws Exception {

        //Load the MySQL JDBC driver.
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;

        try {
            //IP of connection
            String url = "jdbc:mysql://34.138.111.221/car-lot-database";
            //Assigned username of database.
            String user = "teamaccount";
            //Assigned password to username
            String pass = "475843aoa!!";
            //The getConnection() method is provided by the DriverManager class, which is responsible for managing and creating database connections.
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("connected");

           //If connection fails MySQL throws an exception
        } catch (SQLException ex) {
            //handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return conn;
    }
	
}
