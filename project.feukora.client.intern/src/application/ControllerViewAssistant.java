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
 * Controller for Assistantview
 * @author Pascal
 * @version 1.6
 *
 */
public class ControllerViewAssistant {

	private static final Logger logger = Logger
			.getLogger(ControllerViewAssistant.class);

	@FXML
	public BorderPane mainRoot;

	@FXML
	private MenuBar mBar;

	@FXML
	private MenuItem closeWelcome;

	@FXML
	private MenuItem calenderMenuBar;

	@FXML
	private MenuItem customerMenuBar;

	@FXML
	private MenuItem customerNewMenuItem;

	@FXML
	private MenuItem rapportMenuBar;

	@FXML
	private MenuItem rapportNewMenuItem;

	@FXML
	private MenuItem inspectorMenuBar;

	@FXML
	private MenuItem inspectorNewMenuItem;

	@FXML
	private MenuItem blowerMenuBar;

	@FXML
	private MenuItem blowerNewMenuItem;

	@FXML
	private MenuItem heaterMenuBar;

	@FXML
	private MenuItem heaterNewMenuItem;

	@FXML
	private Button heaterWelcome;

	@FXML
	private Button customerWelcome;

	@FXML
	private Button blowerWelcome;

	@FXML
	private Button rapportWelcome;

	@FXML
	private Button calendarWelcome;

	@FXML
	private Button inspectorWelcome;

	@FXML
	private Button exitWelcome;

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

		 inspectorWelcome.getScene().setRoot(pane);
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
		 customerWelcome.getScene().setRoot(pane);
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
		 rapportWelcome.getScene().setRoot(pane);
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
		 heaterWelcome.getScene().setRoot(pane);
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
		 blowerWelcome.getScene().setRoot(pane);
	 }

	 /**
	  * exit button to close the panel
	  * @param event
	  */
	 @FXML
	 void ActionCloseMenuBar(ActionEvent event) {
		 Platform.exit();
	 }

	 /**
	  * method to load the calendar overview through the menubar
	  * @param event
	  */
	 @FXML
	 void ActionCalenderMenuBar(ActionEvent event) {
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
	 void ActionRapportMenuBar(ActionEvent event) {
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
}
