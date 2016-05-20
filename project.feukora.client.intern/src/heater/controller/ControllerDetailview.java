package heater.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ControllerDetailview {

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
			e.printStackTrace();
		}	
		
    	detailviewCancelHeater.getScene().setRoot(pane);
    }

}
