package inspector.controller;

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
 * Controller for the inspectors detailview. 
 * @author Sandro
 * @version 1.7
 *
 */
public class ControllerDetailview {

	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

	private User inspector;
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
	private TextField inspectorPhoneField;

	@FXML
	private TextField inspectorPasswordField;

	@FXML
	private ComboBox<String> inspectorCompanyFieldCombo;

	@FXML
	private TextField inspectorMunicipalityField;

	@FXML
	private TextField inspectorEmailField;

	@FXML
	private TextField inspectorUsernameField;
	
	/**
	 * method to show an error message
	 */
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

	/**
	 * method to get the cityname to the zip
	 * @param event
	 */
	@FXML
	void ActionInspectorZipField(ActionEvent event) {
		String plz = inspectorZipField.getText();
		Integer zip = Integer.parseInt(plz);

		try {
			ClientInternRMI feukora = new ClientInternRMI();
			String town = feukora.getTown(zip);
			inspectorMunicipalityField.setText(town);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
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
	void ActionInspectorPasswordField(ActionEvent event) {

	}

	@FXML
	void ActionInspectorPhoneField(ActionEvent event) {

	}

	@FXML
	void ActionInspectorCompanyFieldCombo(ActionEvent event) {

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
			inspectorCompanyFieldCombo.setItems(companyNames);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(Context.getUser() != null && Context.getName().isEmpty() == false) {
			Update();
		} else {
		}
		
	}

	/**
	 * method to get the data of the selected record
	 */
	public void Update(){

		inspector = Context.getUser();
		inspectorCompanyFieldCombo.setValue(inspector.getCompany());
		inspectorNameField.setText(inspector.getLastname());
		inspectorFirstNameField.setText(inspector.getFirstname());
		inspectorAddressField.setText(inspector.getAdress());
		inspectorPhoneField.setText(inspector.getPhone());
		inspectorEmailField.setText(inspector.getEmail());
		inspectorZipField.setText(inspector.getTown().substring(0, 4));
		inspectorMunicipalityField.setText(inspector.getTown().substring(5));
		inspectorUsernameField.setText(inspector.getUsername());
		inspectorPasswordField.setText(inspector.getPassword());
		Context.setNull();
	}

	/**
	 * method to save the record
	 * @param event
	 */
	@FXML
	void ActionDetailviewSaveInspector(ActionEvent event) {
		User inspector = Context.getUser();
		String lastname = inspectorNameField.getText();
		String adress = inspectorAddressField.getText();
		String phone = inspectorPhoneField.getText();
		String plz = inspectorZipField.getText();
		String firstname = inspectorFirstNameField.getText();
		String email = inspectorEmailField.getText();
		String username = inspectorUsernameField.getText();
		String password = inspectorPasswordField.getText();
		String company = inspectorCompanyFieldCombo.getValue();
		Integer zip = null;
		if (plz.isEmpty() == false) {
			zip = Integer.parseInt(plz);
		}

		try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(lastname.isEmpty() == false && adress.isEmpty() == false && phone.isEmpty() == false && zip != null && firstname.isEmpty() == false && email.isEmpty() == false && username.isEmpty() == false && password.isEmpty() == false && company.isEmpty() == false) {
				if(inspector == null) {
				feukora.saveInspectorUser(zip, company, firstname, lastname, adress, phone, email, username, password);
			} else {
				feukora.updateInspectorUser(inspector, zip, company, firstname, lastname, adress, phone, email, username, password);
			}
			
				inspectorNameField.clear();
				inspectorAddressField.clear();
				inspectorPhoneField.clear();
				inspectorZipField.clear();
				inspectorFirstNameField.clear();
				inspectorEmailField.clear();
				inspectorUsernameField.clear();
				inspectorPasswordField.clear();
				inspectorCompanyFieldCombo.getSelectionModel().clearSelection();
				inspectorMunicipalityField.clear();
				
			} else {
				errorInfoNeu();
			}
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}

	/**
	 * method to cancel the action
	 * @param event
	 */
	@FXML
	void ActionDetailviewCancelInspector(ActionEvent event) {
		
		
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

		detailviewCancelInspector.getScene().setRoot(pane);
	}
}