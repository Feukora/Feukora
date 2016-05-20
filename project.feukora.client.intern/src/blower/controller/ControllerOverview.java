package blower.controller;


/**
 * Sample Skeleton for 'blowerOverview.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ControllerOverview {

    @FXML // fx:id="overviewTableBlower"
    private TableView<?> overviewTableBlower; // Value injected by FXMLLoader
  
    @FXML // fx:id="overviewDeleteBlower"
    private Button overviewDeleteBlower; // Value injected by FXMLLoader

    @FXML // fx:id="overviewRefreshBlower"
    private Button overviewRefreshBlower; // Value injected by FXMLLoader
    
    @FXML // fx:id="overviewUpdateBlower"
    private Button overviewUpdateBlower; // Value injected by FXMLLoader
    
    @FXML // fx:id="columnNameBlower"
    private TableColumn<?, ?> columnNameBlower; // Value injected by FXMLLoader

    @FXML // fx:id="columnTypeBlower"
    private TableColumn<?, ?> columnTypeBlower; // Value injected by FXMLLoader


    @FXML // fx:id="columnYearOfManufacturBlower"
    private TableColumn<?, ?> columnYearOfManufacturBlower; // Value injected by FXMLLoader

    @FXML // Methode für die Tabelle
    void ActionOverviewTableBlower(ActionEvent event) {

    }

    @FXML
    void ActionOverviewDeleteBlower(ActionEvent event) {

    }

    @FXML
    void ActionOverviewRefreshBlower(ActionEvent event) {

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
