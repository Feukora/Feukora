package heater.controller;

import org.apache.log4j.Logger;

import customer.controller.ControllerOverview;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

    @FXML
    private Button detailviewSaveHeater;
    
    @FXML
    private Button detailviewCancelHeater;
    
    @FXML
    private TextField heaterModellField;

    @FXML
    private TextField heaterYearManufacturField;

    @FXML
    private TextField heaterTypeField;

    @FXML
    private TextField heaterNameField;

    @FXML
    void ActionHeaterNameField(ActionEvent event) {

    }

    @FXML
    void ActionHeaterModellField(ActionEvent event) {

    }

    @FXML
    void ActionHeaterTypeField(ActionEvent event) {

    }

    @FXML
    void ActionHeaterYearManufacturField(ActionEvent event) {

    }

    @FXML
    void ActionDetailviewSaveHeater(ActionEvent event) {

    }
    
    @FXML
    void ActionDetailviewCancelHeater(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	detailviewCancelHeater.getScene().setRoot(pane);
    }

}
