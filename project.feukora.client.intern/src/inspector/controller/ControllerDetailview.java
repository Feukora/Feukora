package inspector.controller;

import org.apache.log4j.Logger;


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
    private Button detailviewSaveInspector;
    
    @FXML
    private Button detailviewCancelInspector;

    @FXML
    private TextField inspectorNameField;

    @FXML
    private TextField inspectorFirstNameField;

    @FXML
    private TextField inspectorAddressField;

    @FXML
    private TextField inspectorZipField;

    @FXML
    private TextField inspectorMunicipalityField;

    @FXML
    private TextField inspectorEmailField;

    @FXML
    private TextField inspectorUsernameField;

    @FXML
    void ActionInspectorZipField(ActionEvent event) {

    }

    @FXML
    void ActionInspectorMunicipalityField(ActionEvent event) {

    }

    @FXML
    void ActionInspectorNameField(ActionEvent event) {

    }

    @FXML
    void ActionInspectorFirstNameField(ActionEvent event) {

    }

    @FXML
    void ActionInspectorAddressField(ActionEvent event) {

    }

    @FXML
    void ActionInspectorEmailField(ActionEvent event) {

    }

    @FXML
    void ActionInspectorUsernameField(ActionEvent event) {

    }

    @FXML
    void ActionDetailviewSaveInspector(ActionEvent event) {

    }
    
    @FXML
    void ActionDetailviewCancelInspector(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	detailviewCancelInspector.getScene().setRoot(pane);
    }

}
