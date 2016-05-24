package inspector.controller;

import org.apache.log4j.Logger;

import application.Context;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.User;

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

	@FXML
	void ActionInspectorZipField(ActionEvent event) {
		String plz = inspectorZipField.getText();
		Integer zip = Integer.parseInt(plz);

		try {
			ClientInternRMI feukora = new ClientInternRMI();
			String town = feukora.getTown(zip);
			inspectorMunicipalityField.setText(town);

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Context.getUser() != null) {
			Update();
		} else {
		}
	}

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
		Integer zip = Integer.parseInt(plz);
		String company = inspectorCompanyFieldCombo.getValue();

		try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(inspector == null) {
				feukora.saveInspectorUser(zip, company, firstname, lastname, adress, phone, email, username, password);
			} else {
				feukora.updateInspectorUser(inspector, zip, company, firstname, lastname, adress, phone, email, username, password);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}

		inspectorCompanyFieldCombo.getSelectionModel().clearSelection();
		inspectorNameField.clear();
		inspectorAddressField.clear();
		inspectorPhoneField.clear();
		inspectorZipField.clear();
		inspectorMunicipalityField.clear();
		inspectorFirstNameField.clear();
		inspectorEmailField.clear();
		inspectorUsernameField.clear();
		inspectorPasswordField.clear();

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
