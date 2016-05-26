package assistant.controller;

import org.apache.log4j.Logger;
import application.Context;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.User;

/**
 * 
 * Controller for the assistants Detailview
 * @author Sandro
 * @version 1.7
 *
 */
public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

	private User assistant;
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
	private ComboBox<String> assistantCompanyFieldCombo;
    
    public void errorInfoNeu(){
		String titleBar = "Achtung";
		String headerMessage = "Bitte alle Daten eingeben";
		String infoMessage = "Eingabe nicht vollständig";
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}
    
    @FXML
    void ActionDetailviewSaveAssistant(ActionEvent event) {

    	User assistant = Context.getUser();
		String lastname = assistantNameField.getText();
		String adress = assistantAddressField.getText();
		String phone = assistantPhoneField.getText();
		String plz = assistantZipField.getText();
		String firstname = assistantFirstNameField.getText();
		String email = assistantEmailField.getText();
		String username = assistantUsernameField.getText();
		String password = assistantPasswordField.getText();
		String company = assistantCompanyFieldCombo.getValue();
		Integer zip = null;
		if (!plz.isEmpty()) {
			zip = Integer.parseInt(plz);
		}
		
		try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(!lastname.isEmpty() && !adress.isEmpty() && !phone.isEmpty() && zip != null && !firstname.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !company.isEmpty()) {
				if(assistant == null) {
					feukora.saveAssistantUser(zip, company, firstname, lastname, adress, phone, email, username, password);
				} else {
					feukora.updateAssistantUser(assistant, zip, company, firstname, lastname, adress, phone, email, username, password);
				}

				assistantCompanyFieldCombo.getSelectionModel().clearSelection();
				assistantNameField.clear();
				assistantAddressField.clear();
				assistantPhoneField.clear();
				assistantZipField.clear();
				assistantMunicipalityField.clear();
				assistantFirstNameField.clear();
				assistantEmailField.clear();
				assistantUsernameField.clear();
				assistantPasswordField.clear();

			} else {
				errorInfoNeu();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
    }
    
    @FXML
    void ActionDetailviewCancelAssistant(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			if(Context.getRole().equals("Administrator")) {
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));
			} else if (Context.getRole().equals("Sachbearbeiter")) {
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAssistant.fxml"));
			}
			
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	detailviewCancelAssistant.getScene().setRoot(pane);
    }

    @FXML
    void ActionAssistantZipField(ActionEvent event) {
		String plz = assistantZipField.getText();
		Integer zip = Integer.parseInt(plz);

		try {
			ClientInternRMI feukora = new ClientInternRMI();
			String town = feukora.getTown(zip);
			assistantMunicipalityField.setText(town);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
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
    
	@FXML
	void ActionAssistantCompanyFieldCombo(ActionEvent event) {

	}

	public void initialize() {
		ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
			ObservableList<String> companyNames = FXCollections.observableArrayList();
			ObservableList<Company> companies = feukora.getCompanies();
			int i = 0;
			while (i < companies.size()) {
				companyNames.add(companies.get(i).getName());
				i++;
			}
			assistantCompanyFieldCombo.setItems(companyNames);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Context.getUser() != null && Context.getName().isEmpty() == false) {
			Update();
		} else {
		}
	}
	
	public void Update(){

		assistant = Context.getUser();
		assistantCompanyFieldCombo.setValue(assistant.getCompany());
		assistantNameField.setText(assistant.getLastname());
		assistantFirstNameField.setText(assistant.getFirstname());
		assistantAddressField.setText(assistant.getAdress());
		assistantPhoneField.setText(assistant.getPhone());
		assistantEmailField.setText(assistant.getEmail());
		assistantZipField.setText(assistant.getTown().substring(0, 4));
		assistantMunicipalityField.setText(assistant.getTown().substring(5));
		assistantUsernameField.setText(assistant.getUsername());
		assistantPasswordField.setText(assistant.getPassword());

		Context.setNull();
	}
}
