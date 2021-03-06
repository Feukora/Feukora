package application;

import org.apache.log4j.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	private static final Logger logger = Logger
			.getLogger(Main.class);
	
	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Feukora");
		
		try {
			final  BorderPane root =  FXMLLoader.load(getClass().getClassLoader().getResource("login/view/loginPane.fxml"));

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			logger.error("Fehler bei Applikationsstart \'",
					e);
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
