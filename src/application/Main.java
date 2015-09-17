package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
			Scene scene = new Scene(root,600,600);
			
			//Extractor ex = new Extractor(LocalDate.now(), LocalDate.now());
			Control.primaryStage = primaryStage;
			FilteredControl.primaryStage = primaryStage;
			FilteredControl.scene= scene;
			TableEntry.host = getHostServices();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
