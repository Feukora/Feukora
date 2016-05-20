package blower.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Sample Skeleton for 'blowerOverview.fxml' Controller Class
 */

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
import projekt.feukora.server.model.Users;

public class ControllerOverview {
	
	
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
    private TableColumn<Blower, String> columnTypeBlower; // Value injected by FXMLLoader


    @FXML // fx:id="columnYearOfManufacturBlower"
    private TableColumn<Blower, String> columnYearOfManufacturBlower; // Value injected by FXMLLoader

    @FXML
	public void initialize() {
		try {
			ClientInternRMI feukora = new ClientInternRMI();
			ObservableList<Blower> blowers = feukora.getBlowers();

			columnNameBlower.setCellValueFactory(
					new PropertyValueFactory<Blower, String>("name")
			);

			columnTypeBlower.setCellValueFactory(
					new PropertyValueFactory<Blower, String>("type")
			);
			
			columnYearOfManufacturBlower.setCellValueFactory(
					new PropertyValueFactory<Blower, String>("bloweryear"));
			
			overviewTableBlower.setItems(blowers);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @FXML // Methode für die Tabelle
    void ActionOverviewTableBlower(ActionEvent event) {

    }

    @FXML
    void ActionOverviewDeleteBlower(ActionEvent event) {
    	ClientInternRMI feukora;
    	try{
    		feukora = new ClientInternRMI();
    		Blower entity = overviewTableBlower.getSelectionModel().getSelectedItem();
    		feukora.deleteBlower(entity);
    	}catch(Exception e){
    		e.printStackTrace();
    	}

    }

    @FXML
    void ActionOverviewRefreshBlower(ActionEvent event) {
    	initialize();

    }
    
    @FXML
    void ActionOverviewUpdateBlower(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerDetailview.fxml"));

			// mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
    	overviewUpdateBlower.getScene().setRoot(pane);
    }

}
