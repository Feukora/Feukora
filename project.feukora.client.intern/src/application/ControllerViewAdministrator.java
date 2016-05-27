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
 * Controller for Administratorview
 * @author Sandro
 * @version 1.7
 *
 */
public class ControllerViewAdministrator {

	private static final Logger logger = Logger
			.getLogger(ControllerViewAdministrator.class);

	@FXML
	private BorderPane mainRoot;

	@FXML
	private MenuBar mBar;

	@FXML
	private MenuItem calendarMenuBar;

	@FXML
	private MenuItem closeWelcome;

	@FXML
	private MenuItem inspectorMenuBar;

	@FXML
	private MenuItem inspectorNewMenuItem;

	@FXML
	private MenuItem assistantMenuBar;

	@FXML
	private MenuItem assistantNewMenuItem;

	@FXML
	private MenuItem blowerMenuBar;

	@FXML
	private MenuItem blowerNewMenuItem;

	@FXML
	private MenuItem customerMenuBar;

	@FXML
	private MenuItem customerNewMenuItem;

	@FXML
	private MenuItem heaterMenuBar;

	@FXML
	private MenuItem heaterNewMenuItem;

	@FXML
	private MenuItem rapportMenuBar;

	@FXML
	private MenuItem rapportNewMenuItem;

	@FXML
	private Button assistantWelcome;

	@FXML
	private Button blowerWelcome;

	@FXML
	private Button calendarWelcome;

	@FXML
	private Button heaterWelcome;

	@FXML
	private Button customerWelcome;

	@FXML
	private Button exitWelcome;

	@FXML
	private Button rapportWelcome;

	@FXML
	private Button inspectorWelcome;

	/**
	 * method for the exit button of the welcome panel
	 * @param event
	 */
	 @FXML
	 void ActionExitWelcome(ActionEvent event) {
		 Platform.exit();
	 }

	 /**
	  * button on the welcome panel to load the the inspector overview
	  * @param event
	  */
	 @FXML
	 void ActionInspectorWelcome(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * button on the welcome panel to load the the customer overview
	  * @param event
	  */
	 @FXML
	 void ActionCustomerWelcome(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * button on the welcome panel to load the the rapport overview
	  * @param event
	  */
	 @FXML
	 void ActionRapportWelcome(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/rapportOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * button on the welcome panel to load the the heater overview
	  * @param event
	  */
	 @FXML
	 void ActionHeaterWelcome(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }
	 }

	 /**
	  * button on the welcome panel to load the the calendar overview
	  * @param event
	  */
	 @FXML
	 void ActionCalendarWelcome(ActionEvent event) {
		 BorderPane pane = new BorderPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/calendarPane.fxml"));

			 mainRoot.setTop(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * button on the welcome panel to load the the assistent overview
	  * @param event
	  */
	 @FXML
	 void ActionAssistantWelcome(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("assistant/view/assistantOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * button on the welcome panel to load the the blower overview
	  * @param event
	  */
	 @FXML
	 void ActionBlowerWelcome(ActionEvent event) {

		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }


	 @FXML
	 void ActionLoginMenuBar(ActionEvent event) {
		 Platform.exit();
		 Main.main(null);
	 }

	 @FXML
	 void ActionCloseMenuBar(ActionEvent event) {
		 Platform.exit();
	 }

	 /**
	  * method to load the calendar overview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionCalendarMenuBar(ActionEvent event) {
		 BorderPane pane = new BorderPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/calendarPane.fxml"));

			 mainRoot.setTop(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }
	 }

	 /**
	  * method to load the inspector overview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionInspectorMenuBar(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the customer overview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionCustomerMenuBar(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the blower overview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionBlowerMenuBar(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the rapport overview through the menubar
	  * @param event
	  */
	 @FXML
	 public void ActionRapportMenuBar(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/rapportOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the heater overview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionHeaterMenuBar(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the customer detailview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionCustomerNewMenuItem(ActionEvent event) {

		 try {
			 final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerDetailview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the rapport detailview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionRapportNewMenuItem(ActionEvent event) {

		 try {
			 final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/Main.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the heater detailview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionHeaterNewMenuItem(ActionEvent event) {

		 try {
			 final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterDetailview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the blower detailview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionBlowerNewMenuItem(ActionEvent event) {

		 try {
			 final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerDetailview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the inspector detailview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionInspectorNewMenuItem(ActionEvent event) {
		 try {
			 final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorDetailview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }

	 /**
	  * method to load the assistant overview through the menubar
	  * @param event
	  */
	 @FXML
	 public void ActionAssistantMenuBar(ActionEvent event) {
		 AnchorPane pane = new AnchorPane();

		 try {
			 pane = FXMLLoader.load(getClass().getClassLoader().getResource("assistant/view/assistantOverview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }
	 }

	 /**
	  * method to load the assistant detailview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionAssistantNewMenuItem(ActionEvent event) {
		 try {
			 final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("assistant/view/assistantDetailview.fxml"));

			 mainRoot.setCenter(pane);

		 } catch (Exception e) {
			 logger.error("Aktion konnte nicht durchgeführt werden\'",
					 e);
		 }	
	 }
}
