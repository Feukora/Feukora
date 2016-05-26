package blower.controller;

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

/**
 * 
 * Controller for Blower overview
 * @author Sandro
 * @version 1.6
 *
 */
public class ControllerOverview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerOverview.class);
	
	public ObservableList<Blower> blowers = FXCollections.observableArrayList();
	
	
    @FXML // fx:id="overviewTableBlower"
    private TableView<Blower> overviewTableBlower; // Value injected by FXMLLoader
  
    @FXML // fx:id="overviewDeleteBlower"
    private Button overviewDeleteBlower; // Value injected by FXMLLoader

    @FXML // fx:id="overviewRefreshBlower"
    private Button overviewRefreshBlower; // Value injected by FXMLLoader
    
    @FXML // fx:id="overviewUpdateBlower"
    private Button overviewUpdateBlower; // Value injected by FXMLLoader
    
    @FXML // fx:id="columnNameBlower"
    private TableColumn<Blower, String> columnNameBlower; // Value injected by FXMLLoader

    @FXML // fx:id="columnTypeBlower"
    private TableColumn<Blower, String> columnBlowerBlower; // Value injected by FXMLLoader


    @FXML // fx:id="columnYearOfManufacturBlower"
    private TableColumn<Blower, String> columnFuelBlower; // Value injected by FXMLLoader

    @FXML
	public void initialize() {
		try {
			ClientInternRMI feukora = new ClientInternRMI();
			blowers = feukora.getBlowers();

			columnNameBlower.setCellValueFactory(
					new PropertyValueFactory<Blower, String>("name")
			);	
			
			columnBlowerBlower.setCellValueFactory(
					new PropertyValueFactory<Blower, String>("blowertype")
			);
			
			columnFuelBlower.setCellValueFactory(
					new PropertyValueFactory<Blower, String>("fuel")
			);
			overviewTableBlower.setItems(blowers);
			
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}
    
    @FXML // Methode für die Tabelle
    void ActionOverviewTableBlower(ActionEvent event) {

    }
    
    /**
     * method to delete the selected record
     * @param event
     */
    @FXML
    void ActionOverviewDeleteBlower(ActionEvent event) {
    	ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
	    	Blower entity = overviewTableBlower.getSelectionModel().getSelectedItem();
	    	feukora.deleteBlower(entity);
		} catch (Exception e) {
			String titleBar = "Achtung";
			String headerMessage = "Brenner kann nicht gelöscht werden";
			String infoMessage = "Es bestehen noch Verbindungen diesem Brenner";
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle(titleBar);
	        alert.setHeaderText(headerMessage);
	        alert.setContentText(infoMessage);
	        alert.showAndWait();
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
		initialize();
    }

    /**
     * method to refresh the overview
     * @param event
     */
    @FXML
    void ActionOverviewRefreshBlower(ActionEvent event) {
    	initialize();
    }
    
    /**
     * method to get the detailview of the selected record
     * @param event
     */
    @FXML
    void ActionOverviewUpdateBlower(ActionEvent event) {
    	
    	try {
    		Blower blower = overviewTableBlower.getSelectionModel().getSelectedItem();
    		if(blower != null) {
    			AnchorPane pane = new AnchorPane();
    			Context.setBlower(blower);
    			pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerDetailview.fxml"));
    			overviewUpdateBlower.getScene().setRoot(pane);
    		} else {
    			String titleBar = "Nichts ausgewählt";
				String headerMessage = "Wählen Sie einen Brenner aus";
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
