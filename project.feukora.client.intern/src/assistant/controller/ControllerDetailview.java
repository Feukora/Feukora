package assistant.controller;

import org.apache.log4j.Logger;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

    @FXML
    private Button detailviewSaveAssistant;
    
    @FXML
    private Button detailviewCancelAssistant;
    
    @FXML
    private TextField assistantAddressField;

    @FXML
    private TextField assistantEmailField;

    @FXML
    private TextField assistantZipField;
    
    @FXML
    private TextField assistantPasswordField;

    @FXML
    private TextField assistantPhoneField;
    
    @FXML
    private TextField assistantFirstNameField;

    @FXML
    private TextField assistantMunicipalityField;

    @FXML
    private TextField assistantNameField;

    @FXML
    private TextField assistantUsernameField;
    
    @FXML
    void ActionDetailviewSaveAssistant(ActionEvent event) {

//    	String name = assistantUsernameField.getText()
    }
    
    @FXML
    void ActionDetailviewCancelAssistant(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	detailviewCancelAssistant.getScene().setRoot(pane);
    }

    @FXML
    void ActionAssistantZipField(ActionEvent event) {

    }

    @FXML
    void ActionAssistantMunicipalityField(ActionEvent event) {

    }

    @FXML
    void ActionAssistantNameField(ActionEvent event) {

    }

    @FXML
    void ActionAssistantFirstNameField(ActionEvent event) {

    }

    @FXML
    void ActionAssistantAddressField(ActionEvent event) {

    }

    @FXML
    void ActionAssistantEmailField(ActionEvent event) {

    }

    @FXML
    void ActionAssistantUsernameField(ActionEvent event) {

    }
    
    @FXML
    void ActionAssistantPasswordField(ActionEvent event) {

    }
    
    @FXML
    void ActionAssistantPhoneField(ActionEvent event) {

    }

}
