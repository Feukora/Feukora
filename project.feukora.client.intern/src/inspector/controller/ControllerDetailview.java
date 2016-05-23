package inspector.controller;

import org.apache.log4j.Logger;

import application.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Users;

public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

	private Users inspector;
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
    private TextField inspectorCompanyIdField;

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
    void ActionInspectorCompanyIdField(ActionEvent event) {

    }

 public void initialize() {
    	
    	if(Context.getUser() != null) {
    		Update();
    	} else {
	}
    	
    	
    
    }
    
    public void Update(){
    
    		inspector = Context.getUser();
    		inspectorCompanyIdField.setText("");
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
    	Users inspector1 = Context.getUser();
    	String companyname = inspectorCompanyIdField.getText();
    	String lastname = inspectorNameField.getText();
    	String adress = inspectorAddressField.getText();
    	String phone = inspectorPhoneField.getText();
    	String plz = inspectorZipField.getText();
    	String firstname = inspectorFirstNameField.getText();
    	String email = inspectorEmailField.getText();
    	String username = inspectorUsernameField.getText();
    	String password = inspectorPasswordField.getText();
    	Integer zip = Integer.parseInt(plz);
    	
    	try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(inspector == null) {
//				inspector.setFirstname(firstname);
//				inspector.setLastname(lastname);
//				inspector.setAdress(adress);
//				inspector.setPhone(phone);
//				inspector.setEmail(email);
//				inspector.setUsername(username);
//				inspector.setPassword(password);
				feukora.saveUser(inspector1, zip, companyname, firstname, lastname, adress, phone, email, username, password);
			} else {
				feukora.updateUser(inspector1, zip, companyname, firstname, lastname, adress, phone, email, username, password);
			}
			
//	    	feukora.deleteCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
    	
    	inspectorCompanyIdField.clear();
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
