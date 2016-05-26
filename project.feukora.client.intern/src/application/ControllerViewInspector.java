package application;

import org.apache.log4j.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * 
 * Controller for Inspectorview
 * @author Pascal
 * @version 1.7
 *
 */
public class ControllerViewInspector {

	private static final Logger logger = Logger
			.getLogger(ControllerViewInspector.class);

    @FXML
    private BorderPane mainRoot;
    
    @FXML
    private Button rapportWelcome;

    @FXML
    private Button rapportNewWelcome;

    @FXML
    private Button calendarWelcome;

    @FXML
    private Button exitWelcome;

    @FXML
    private MenuBar mBar;

    @FXML
    private MenuItem calenderMenuBar;

    @FXML
    private MenuItem rapportMenuBar;
    
    @FXML
    private MenuItem rapportNewMenuItem;

    @FXML
    private MenuItem closeWelcome;

    @FXML
    void ActionExitWelcome(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void ActionRapportWelcome(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/rapportOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}	
    	rapportWelcome.getScene().setRoot(pane);
    }

    @FXML
    void ActionRapportNewWelcome(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/Main.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}	
    	rapportWelcome.getScene().setRoot(pane);
    }

    @FXML
    void ActionCalendarWelcome(ActionEvent event) {
    	BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/calendarPane.fxml"));

			mainRoot.setTop(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
    }
    
    @FXML
    void ActionCloseMenuBar(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void ActionCalenderMenuBar(ActionEvent event) {
    	BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/calendarPane.fxml"));

			mainRoot.setTop(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
    }

    @FXML
    void ActionInspectorMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}	
    }

    @FXML
    void ActionRapportMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/rapportOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}	
    }

    @FXML
    void ActionInspectorNewMenuItem(ActionEvent event) {
    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}	
    }

    @FXML
    void ActionRapportNewMenuItem(ActionEvent event) {
    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/Main.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}	
    }
}
