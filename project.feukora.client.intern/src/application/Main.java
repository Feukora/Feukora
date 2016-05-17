package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

//singleton
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Feukora");

		try {
			final  Pane root =  FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

// application/MainView.fxml
