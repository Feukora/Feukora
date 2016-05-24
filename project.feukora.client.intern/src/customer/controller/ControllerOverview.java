package customer.controller;

import org.apache.log4j.Logger;

import application.Context;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Customer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


/**
 * Sample Skeleton for 'customerOverview.fxml' Controller Class
 */

public class ControllerOverview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerOverview.class);

	public ObservableList<Customer> customers = FXCollections.observableArrayList();
	
    @FXML // fx:id="overviewRefreshCustomer"
    private Button overviewRefreshCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="overviewDeleteCustomer"
    private Button overviewDeleteCustomer; // Value injected by FXMLLoader
    
    @FXML // fx:id="overviewUpdateCustomer"
    private Button overviewUpdateCustomer; // Value injected by FXMLLoader
    
    @FXML // fx:id="overviewTableCustomer"
    public TableView<Customer> overviewTableCustomer; // Value injected by FXMLLoader
    
	@FXML // fx:id="columnCompanynameCustomer"
    private TableColumn<Customer, String> columnCompanynameCustomer; // Value injected by FXMLLoader
	
	@FXML // fx:id="columnCCustomerfunctionCustomer"
    private TableColumn<Customer, String> columnCustomerFunctionCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnEmailCustomer"
    private TableColumn<Customer, String> columnEmailCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnPhoneCustomer"
    private TableColumn<Customer, String> columnPhoneCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnNameCustomer"
    private TableColumn<Customer, String> columnNameCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnAddressCustomer"
    private TableColumn<Customer, String> columnAddressCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnZIPCustomer"
    private TableColumn<Customer, String> columnZIPCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnFirstnameCustomer"
    private TableColumn<Customer, String> columnFirstnameCustomer; // Value injected by FXMLLoader

    @FXML // Methode für die Tabelle
    void ActionOverviewTableCustomer(ActionEvent event) {

    }
    
	@FXML
	public void initialize() {
		 try {
				ClientInternRMI feukora = new ClientInternRMI();
				customers = feukora.getCustomers();
				
				columnCompanynameCustomer.setCellValueFactory(
						new PropertyValueFactory<Customer, String>("companyname")
				);
				
				columnCustomerFunctionCustomer.setCellValueFactory(
						new PropertyValueFactory<Customer, String>("customerfunction")
				);
				
				columnEmailCustomer.setCellValueFactory(
						new PropertyValueFactory<Customer, String>("email")
				);
				columnPhoneCustomer.setCellValueFactory(
						new PropertyValueFactory<Customer, String>("phone")
				);
				columnNameCustomer.setCellValueFactory(
						new PropertyValueFactory<Customer, String>("lastname")
				);
				columnAddressCustomer.setCellValueFactory(
						new PropertyValueFactory<Customer, String>("adress")
				);
				columnZIPCustomer.setCellValueFactory(
						new PropertyValueFactory<Customer, String>("town")
				);
				columnFirstnameCustomer.setCellValueFactory(
						new PropertyValueFactory<Customer, String>("firstname")
				);
				
				
				overviewTableCustomer.setItems(customers);
				
				//overviewTableCustomer.getSelectionModel().get
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Aktion konnte nicht durchgeführt werden\'",
						e);
			}
	}

    @FXML
    void ActionOverviewDeleteCustomer(ActionEvent event) {
    	ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
	    	Customer entity = overviewTableCustomer.getSelectionModel().getSelectedItem();
	    	feukora.deleteCustomer(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
		initialize();
    	
    }

    @FXML
    void ActionOverviewRefreshCustomer(ActionEvent event) {
    	initialize();
    }
    
    @FXML
    void ActionOverviewUpdateCustomer(ActionEvent event) {
    	try {
			Customer customer = overviewTableCustomer.getSelectionModel().getSelectedItem();
			if(customer != null){
				AnchorPane pane = new AnchorPane();
				Context.setCustomer(customer);
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerDetailview.fxml"));
				overviewUpdateCustomer.getScene().setRoot(pane);
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


