/**
 * Sample Skeleton for 'heaterOverview.fxml' Controller Class
 */

package heater.controller;

import org.apache.log4j.Logger;

import application.Context;
import javafx.collections.FXCollections;
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
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Heater;

public class ControllerOverview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerOverview.class);
	

    @FXML // fx:id="overviewRefreshHeater"
    private Button overviewRefreshHeater; // Value injected by FXMLLoader
    
    @FXML // fx:id="overviewUpdateHeater"
    private Button overviewUpdateHeater; // Value injected by FXMLLoader

    @FXML // fx:id="overviewDeleteHeater"
    private Button overviewDeleteHeater; // Value injected by FXMLLoader

    @FXML // fx:id="overviewTableHeater"
    private TableView<Heater> overviewTableHeater; // Value injected by FXMLLoader

    @FXML // fx:id="columnTypeHeater"
    private TableColumn<Heater, String> columnTypeHeater; // Value injected by FXMLLoader

    @FXML // fx:id="columnYearOfManifactureHeater"
    private TableColumn<Heater, String> columnYearOfManifactureHeater; // Value injected by FXMLLoader

    @FXML // fx:id="columnNameHeater"
    private TableColumn<Heater, String> columnNameHeater; // Value injected by FXMLLoader
    
    @FXML
    public void initialize(){
    	try{
    		ClientInternRMI feukora = new ClientInternRMI();
    		ObservableList<Heater> heaters = feukora.getHeaters();
    		
    		columnNameHeater.setCellValueFactory(
    				new PropertyValueFactory<Heater,String>("name")
    		);
    		
    		overviewTableHeater.setItems(heaters);
    			
    	}catch(Exception e){
    		logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
    	}
    }

    @FXML // Methode für die Tabelle
    void ActionOverviewTableHeater(ActionEvent event) {

    }
    
    @FXML
    void ActionOverviewDeleteHeater(ActionEvent event) {
    	ClientInternRMI feukora;
    	try{
    		feukora = new ClientInternRMI();
    		Heater entity = overviewTableHeater.getSelectionModel().getSelectedItem();
    		feukora.deleteHeater(entity);
    	}catch(Exception e){
    		logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
    	}
    	initialize();

    }

    @FXML
    void ActionOverviewRefreshHeater(ActionEvent event) {
    	initialize();
    	
    }
    
    @FXML
    void ActionOverviewUpdateHeater(ActionEvent event) {
    	try {
    		ClientInternRMI feukora = new ClientInternRMI();
			Heater heater = overviewTableHeater.getSelectionModel().getSelectedItem();
			if(heater != null){
				AnchorPane pane = new AnchorPane();
				Context.setHeater(heater);
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterDetailview.fxml"));
				overviewUpdateHeater.getScene().setRoot(pane);
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
		
    	//overviewUpdateHeater.getScene().setRoot(pane);
    }

}
