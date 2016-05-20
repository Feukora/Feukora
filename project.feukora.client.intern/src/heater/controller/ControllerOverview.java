/**
 * Sample Skeleton for 'heaterOverview.fxml' Controller Class
 */

package heater.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ControllerOverview {

    @FXML // fx:id="overviewRefreshHeater"
    private Button overviewRefreshHeater; // Value injected by FXMLLoader
    
    @FXML // fx:id="overviewUpdateHeater"
    private Button overviewUpdateHeater; // Value injected by FXMLLoader

    @FXML // fx:id="overviewDeleteHeater"
    private Button overviewDeleteHeater; // Value injected by FXMLLoader

    @FXML // fx:id="overviewTableHeater"
    private TableView<?> overviewTableHeater; // Value injected by FXMLLoader

    @FXML // fx:id="columnTypeHeater"
    private TableColumn<?, ?> columnTypeHeater; // Value injected by FXMLLoader

    @FXML // fx:id="columnYearOfManifactureHeater"
    private TableColumn<?, ?> columnYearOfManifactureHeater; // Value injected by FXMLLoader

    @FXML // fx:id="columnNameHeater"
    private TableColumn<?, ?> columnNameHeater; // Value injected by FXMLLoader

    @FXML // Methode für die Tabelle
    void ActionOverviewTableHeater(ActionEvent event) {

    }
    
    @FXML
    void ActionOverviewDeleteHeater(ActionEvent event) {

    }

    @FXML
    void ActionOverviewRefreshHeater(ActionEvent event) {

    }
    
    @FXML
    void ActionOverviewUpdateHeater(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterDetailview.fxml"));

			// mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
    	overviewUpdateHeater.getScene().setRoot(pane);
    }

}
