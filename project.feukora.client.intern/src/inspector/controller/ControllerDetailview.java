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
    	
    	if(Context.getInspector != null) {
    		Update();
    	} else {
	}
    	
    	
    
    }
    
    public void Update(){
    
    		inspector = Context.getInspector();
    		inspectorCompanyIdField.setText(Context.getCustomerCompanyName());
	    	inspectorNameField.setText(Context.getCustomerName());
	    	inspectorFirstNameField.setText(Context.getCustomerFirstname());
	    	inspectorAddressField.setText(Context.getCustomerAdress());
	    	inspectorPhoneField.setText(Context.getCustomerPhone());
	    	inspectorEmailField.setText(Context.getCustomerEmail());
	    	inspectorZipField.setText(Context.getCustomerTown().substring(0, 4));
	    	inspectorMunicipalityField.setText(Context.getCustomerTown().substring(5));
	    	inspectorNameField.setText(Context.getCustomerName());

	    	Context.setNull();
	
    }
    
    @FXML
    void ActionDetailviewSaveInspector(ActionEvent event) {
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
    	
    	inspector = Context.getUser();
    	
    	try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(inspector == null) {
				feukora.savUsers();
			} else {
				feukora.updateInspector(companyname, lastname, adress, phone, zip, firstname, email, username, password);
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
