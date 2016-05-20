package assistant.controller;

import org.apache.log4j.Logger;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * Sample Skeleton for 'assistantOverview.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Users;

public class ControllerOverview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerOverview.class);

	public ObservableList<Users> users = FXCollections.observableArrayList();

	@FXML // fx:id="overviewDeleteAssistant"
	private Button overviewDeleteAssistant; // Value injected by FXMLLoader

	@FXML // fx:id="overviewRefreshAssistant"
	private Button overviewRefreshAssistant; // Value injected by FXMLLoader

	@FXML // fx:id="overviewUpdateAssistant"
	private Button overviewUpdateAssistant; // Value injected by FXMLLoader

	@FXML // fx:id="overviewTableAssistant"
	private TableView<?> overviewTableAssistant; // Value injected by FXMLLoader

	@FXML // fx:id="columnEmailAssistant"
	private TableColumn<?, ?> columnEmailAssistant; // Value injected by
													// FXMLLoader

	@FXML // fx:id="columnUsernameAssistant"
	private TableColumn<?, ?> columnUsernameAssistant; // Value injected by
														// FXMLLoader

	@FXML // fx:id="columnPhoneAssistant"
	private TableColumn<?, ?> columnPhoneAssistant; // Value injected by
													// FXMLLoader

	@FXML // fx:id="columnFirstnameAssistant"
	private TableColumn<?, ?> columnFirstnameAssistant; // Value injected by
														// FXMLLoader

	@FXML // fx:id="columnZIPAssistant"
	private TableColumn<?, ?> columnZIPAssistant; // Value injected by
													// FXMLLoader

	@FXML // fx:id="columnNameAssistant"
	private TableColumn<?, ?> columnNameAssistant; // Value injected by
													// FXMLLoader

	@FXML // fx:id="columnAddressAssistant"
	private TableColumn<?, ?> columnAddressAssistant; // Value injected by
														// FXMLLoader

	@FXML
	public void initialize() {
		try {
			ClientInternRMI feukora = new ClientInternRMI();
			users = feukora.getUsers();

			columnEmailAssistant.setCellValueFactory(
					new PropertyValueFactory<Users, String>("email")
			);

			columnUsernameAssistant.setCellValueFactory(
					new PropertyValueFactory<Users, String>("username")
			);

			columnPhoneAssistant.setCellValueFactory(
					new PropertyValueFactory<Users, String>("phone")
			);

			columnFirstnameAssistant.setCellValueFactory(
					new PropertyValueFactory<Users, String>("firstname")
			);

			columnZIPAssistant.setCellValueFactory(
					new PropertyValueFactory<Users, String>("town")
			);

			columnNameAssistant.setCellValueFactory(
					new PropertyValueFactory<Users, String>("name")
			);

			columnAddressAssistant.setCellValueFactory(
					new PropertyValueFactory<Users, String>("adress")
			);
			
			overviewTableAssistant.setItems(users);
			
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}

	@FXML // Methode für die Tabelle
	void ActionOverviewTableAssistant(ActionEvent event) {
		
	}

	@FXML
	void ActionOverviewDeleteAssistant(ActionEvent event) {
		ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
			Users entity = overviewTableAssistant.getSelectionModel().getSelectedItem();
			feukora.deleteUser(entity);
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}

	}

	@FXML
	void ActionOverviewRefreshAssistant(ActionEvent event) {
		initialize();

	}

	@FXML
	void ActionOverviewUpdateAssistant(ActionEvent event) {
		AnchorPane pane = new AnchorPane();

		try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("assistant/view/assistantDetailview.fxml"));

			// mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}

		overviewUpdateAssistant.getScene().setRoot(pane);
	}

}
