/**
 * Sample Skeleton for 'heaterOverview.fxml' Controller Class
 */

package heater.controller;

import org.apache.log4j.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Blower;
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
    		
    		columnTypeHeater.setCellValueFactory(
    				new PropertyValueFactory<Heater, String>("heatertype")
    		);
    		columnYearOfManifactureHeater.setCellValueFactory(
    				new PropertyValueFactory<Heater,String>("heateryear")
    		);
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

    }

    @FXML
    void ActionOverviewRefreshHeater(ActionEvent event) {
    	initialize();
    	
    }
    
    @FXML
    void ActionOverviewUpdateHeater(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterDetailview.fxml"));

			// mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	overviewUpdateHeater.getScene().setRoot(pane);
    }

}
