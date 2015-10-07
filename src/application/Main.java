package application;
	
import java.util.Scanner;

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
			primaryStage.setTitle("PhD Admissions Admin Portal");
			primaryStage.show();
			Scanner in=new Scanner(System.in);
			while(true)
			{
				System.out.println("Want to read from CSV Database? (Y/N)");
				String input=in.nextLine();
				if(input.equals("Y"))
				{
					csvReader x=new csvReader(); //Loading data
					break;					
				}
				else if(input.equals("N"))
				{
					//Read from already-present data
					break;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
