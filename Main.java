package application;
	
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
			Parent root = FXMLLoader.load(getClass().getResource(view));
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
    
	public static void main(String[] args) {
		launch(args);
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
}
