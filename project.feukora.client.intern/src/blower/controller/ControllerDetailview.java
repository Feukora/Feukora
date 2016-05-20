package blower.controller;

import org.apache.log4j.Logger;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.rmi.BlowerRMIImpl;

public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

    @FXML
    private Button detailviewSaveBlower;
    
    @FXML
    private Button detailviewCancelBlower;

    @FXML
    private TextField blowerYearManufactureField;

    @FXML
    private TextField blowerTypeField;

    @FXML
    private TextField blowerNameField;

    @FXML
    private TextField blowerModellField;

    @FXML
    void ActionBlowerNameField(ActionEvent event) {

    }

    @FXML
    void ActionBlowerModellField(ActionEvent event) {

    }

    @FXML
    void ActionBlowerTypeField(ActionEvent event) {

    }

    @FXML
    void ActionBlowerYearManufactureField(ActionEvent event) {

    }

    @FXML
    void ActionDetailviewSaveBlower(ActionEvent event) {
    	String manufactureYear = blowerYearManufactureField.getText();
    	String blowerModel = blowerModellField.getText();
        String blowerType = blowerTypeField.getText();
        String blowerName = blowerNameField.getText();
        
        Blowertype bt;
        bt.setName(blowerType);
        
        Fuel bm;
        bm.setName(blowerModel);
        
 		try {
			ClientInternRMI test = new ClientInternRMI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
    }
    
    @FXML
    void ActionDetailviewCancelBlower(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	detailviewCancelBlower.getScene().setRoot(pane);
    }
}
