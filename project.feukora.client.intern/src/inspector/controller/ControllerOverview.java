package inspector.controller;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import application.Context;
import javafx.collections.ObservableList;

/**
 * Sample Skeleton for 'inspectorOverview.fxml' Controller Class
 */

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
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Users;

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
    private TableView<Users> overviewTableInspector; // Value injected by FXMLLoader
    
    @FXML // fx:id="columnCompanyIdInspector"
    private TableColumn<Users, String> columnCompanyIdInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnUsernameInspector"
    private TableColumn<Users, String> columnUsernameInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnNameInspector"
    private TableColumn<Users, String> columnNameInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnFirstnameInspector"
    private TableColumn<Users, String> columnFirstnameInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnZIPInspector"
    private TableColumn<Users, String> columnZIPInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnAddressInspector"
    private TableColumn<Users, String> columnAddressInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnPhoneInspector"
    private TableColumn<Users, String> columnPhoneInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnEmailInspector"
    private TableColumn<Users, String> columnEmailInspector; // Value injected by FXMLLoader

    @FXML // Methode für die Tabelle
    void ActionOverviewTableInspector(ActionEvent event) {

    }

    @FXML
	public void initialize() {
		 try {
				ClientInternRMI feukora = new ClientInternRMI();
				ObservableList<Users> users = feukora.getUsers();
				
				columnUsernameInspector.setCellValueFactory(
						new PropertyValueFactory<Users, String>("username")
				);
				
				columnNameInspector.setCellValueFactory(
						new PropertyValueFactory<Users, String>("lastname")
				);
				columnFirstnameInspector.setCellValueFactory(
						new PropertyValueFactory<Users, String>("firstname")
				);
				columnZIPInspector.setCellValueFactory(
						new PropertyValueFactory<Users, String>("town")
				);
				columnAddressInspector.setCellValueFactory(
						new PropertyValueFactory<Users, String>("adress")
				);
				columnPhoneInspector.setCellValueFactory(
						new PropertyValueFactory<Users, String>("phone")
				);
				columnEmailInspector.setCellValueFactory(
						new PropertyValueFactory<Users, String>("email")
				);
				
				overviewTableInspector.setItems(users);
				
				//overviewTableCustomer.getSelectionModel().get
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Aktion konnte nicht durchgeführt werden\'",
						e);
			}
	}
    @FXML
    void ActionOverviewDeleteInspector(ActionEvent event) {
    	ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
	    	Users entity = overviewTableInspector.getSelectionModel().getSelectedItem();
	    	feukora.deleteUser(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
    }

    @FXML
    void ActionOverviewRefreshInspector(ActionEvent event) {
    	initialize();
    }
    
    
    @FXML
    void ActionOverviewUpdateInspector(ActionEvent event) {
    	try {
    		ClientInternRMI feukora = new ClientInternRMI();
			Users inspector = overviewTableInspector.getSelectionModel().getSelectedItem();
			if(inspector != null){
				AnchorPane pane = new AnchorPane();
				Context.setUser(inspector);
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorDetailview.fxml"));
				overviewUpdateInspector.getScene().setRoot(pane);
			}else{
				String titleBar = "Nichts ausgewählt";
				String headerMessage = "Wählen Sie einen Benutzer aus";
				String infoMessage = "";
				Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle(titleBar);
		        alert.setHeaderText(headerMessage);
		        alert.setContentText(infoMessage);
		        alert.showAndWait();
			}
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);	
		}	
	}	

}


