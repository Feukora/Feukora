package inspector.controller;

import org.apache.log4j.Logger;
import application.Context;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.User;

/**
 * Controller for the inspectors overview. 
 * @author Pascal
 * @version 1.5
 *
 */
public class ControllerOverview {

	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

	@FXML // fx:id="overviewDeleteInspector"
	private Button overviewDeleteInspector; // Value injected by FXMLLoader

	@FXML // fx:id="overviewUpdateInspector"
	private Button overviewUpdateInspector; // Value injected by FXMLLoader

	@FXML // fx:id="overviewRefreshInspector"
	private Button overviewRefreshInspector; // Value injected by FXMLLoader

	@FXML // fx:id="overviewTableInspector"
	private TableView<User> overviewTableInspector; // Value injected by FXMLLoader

	@FXML // fx:id="columnCompanyIdInspector"
	private TableColumn<User, String> columnCompanyIdInspector; // Value injected by FXMLLoader

	@FXML // fx:id="columnUsernameInspector"
	private TableColumn<User, String> columnUsernameInspector; // Value injected by FXMLLoader

	@FXML // fx:id="columnNameInspector"
	private TableColumn<User, String> columnNameInspector; // Value injected by FXMLLoader

	@FXML // fx:id="columnFirstnameInspector"
	private TableColumn<User, String> columnFirstnameInspector; // Value injected by FXMLLoader

	@FXML // fx:id="columnZIPInspector"
	private TableColumn<User, String> columnZIPInspector; // Value injected by FXMLLoader

	@FXML // fx:id="columnAddressInspector"
	private TableColumn<User, String> columnAddressInspector; // Value injected by FXMLLoader

	@FXML // fx:id="columnPhoneInspector"
	private TableColumn<User, String> columnPhoneInspector; // Value injected by FXMLLoader

	@FXML // fx:id="columnEmailInspector"
	private TableColumn<User, String> columnEmailInspector; // Value injected by FXMLLoader

	@FXML // Methode f�r die Tabelle
	void ActionOverviewTableInspector(ActionEvent event) {

	}

	@FXML
	public void initialize() {
		try {
			ClientInternRMI feukora = new ClientInternRMI();
			ObservableList<User> users = feukora.getInspectors();

			columnCompanyIdInspector.setCellValueFactory(
					new PropertyValueFactory<User, String>("company")
					);

			columnUsernameInspector.setCellValueFactory(
					new PropertyValueFactory<User, String>("username")
					);

			columnNameInspector.setCellValueFactory(
					new PropertyValueFactory<User, String>("lastname")
					);
			columnFirstnameInspector.setCellValueFactory(
					new PropertyValueFactory<User, String>("firstname")
					);
			columnZIPInspector.setCellValueFactory(
					new PropertyValueFactory<User, String>("town")
					);
			columnAddressInspector.setCellValueFactory(
					new PropertyValueFactory<User, String>("adress")
					);
			columnPhoneInspector.setCellValueFactory(
					new PropertyValueFactory<User, String>("phone")
					);
			columnEmailInspector.setCellValueFactory(
					new PropertyValueFactory<User, String>("email")
					);

			overviewTableInspector.setItems(users);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
	}

	/**
	 * method to refresh the overview
	 * @param event
	 */
	@FXML
	void ActionOverviewRefreshInspector(ActionEvent event) {
		initialize();
	}

	/**
	 * method to open the detailview for the selected record
	 * @param event
	 */
	@FXML
	void ActionOverviewUpdateInspector(ActionEvent event) {
		try {
			ClientInternRMI feukora = new ClientInternRMI();
			User inspector = overviewTableInspector.getSelectionModel().getSelectedItem();
			if(inspector != null){
				AnchorPane pane = new AnchorPane();
				Context.setUser(inspector);
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorDetailview.fxml"));
				overviewUpdateInspector.getScene().setRoot(pane);
			}else{
				String titleBar = "Nichts ausgew�hlt";
				String headerMessage = "W�hlen Sie einen Benutzer aus";
				String infoMessage = "";
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(titleBar);
				alert.setHeaderText(headerMessage);
				alert.setContentText(infoMessage);
				alert.showAndWait();
			}
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);	
		}	
	}

	/**
	 * method to delete the selected record
	 * @param event
	 */
	@FXML
	void ActionOverviewDeleteInspector(ActionEvent event) {
		ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
			User entity = overviewTableInspector.getSelectionModel().getSelectedItem();
			feukora.deleteUser(entity);
		} catch (Exception e) {
			String titleBar = "Achtung";
			String headerMessage = "Feuerungskkontrolleur kann nicht gel�scht werden";
			String infoMessage = "Es bestehen noch Verbindungen diesem Feuerungskontrolleur";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titleBar);
			alert.setHeaderText(headerMessage);
			alert.setContentText(infoMessage);
			alert.showAndWait();
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
		initialize();
	}	
}