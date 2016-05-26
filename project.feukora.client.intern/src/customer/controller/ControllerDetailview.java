package customer.controller;

import org.apache.log4j.Logger;
import application.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Customer;

/**
 * Controller for the customers detailview.
 * @author Sandro
 * @version 1.6
 *
 */
public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

	final ToggleGroup group = new ToggleGroup();
	
	private Customer customer;
	
    @FXML
    private Button detailviewSaveCustomer;
    
    @FXML
    private Button detailviewDeleteAppointment;
    
    @FXML
    private Button detailviewCancelCustomer;
    
    @FXML
    private RadioButton radioButtonOwner;

    @FXML
    private RadioButton radioButtonAdministration;

    @FXML
    private TextField customerCompanyNameField;
    
    @FXML
    private TextField customerNameField;

    @FXML
    private TextField customerAddressField;

    @FXML
    private TextField customerNumberField;

    @FXML
    private TextField customerZipField;
    
    @FXML
    private TextField customerMunicipalityField;

    @FXML
    private TextField customerFirstNameField;

    @FXML
    private TextField customerEmailField;
    
    /**
     * method to show error message
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

    @FXML
    void ActionCustomerCompanyNameField(ActionEvent event) {

    }
    
    @FXML
    void ActionCustomerNameField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerFirstNameField(ActionEvent event) {

    }
    
    @FXML
    void ActionCustomerMunicipalityField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerAddressField(ActionEvent event) {

    }
    
    /**
     * method to get the cityname to the zip
     * @param event
     */
    @FXML
    void ActionCustomerZipField(ActionEvent event) {
    	String plz = customerZipField.getText();
    	Integer zip = Integer.parseInt(plz);
    	
    	try {
			ClientInternRMI feukora = new ClientInternRMI();
			String town = feukora.getTown(zip);
			customerMunicipalityField.setText(town);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
    }

    @FXML
    void ActionCustomerEmailField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerNumberField(ActionEvent event) {

    }
    
    public void initialize() {
    	setToggleGroup();
    	if(Context.getCustomerName() != null) {
    		Update();
    	} else {
    		
    	}
    }
    
    /**
     * method to bind a group of radiobuttons
     */
    public void setToggleGroup() {
    	radioButtonOwner.setToggleGroup(group);
    	radioButtonAdministration.setToggleGroup(group);
    	radioButtonOwner.setSelected(false);
    	radioButtonAdministration.setSelected(false);
    }
    
    /**
	 * method to get the data of the chosen record
	 */
    public void Update(){
    
    		customer = Context.getCustomer();
    		customerCompanyNameField.setText(Context.getCustomerCompanyName());
	    	customerNameField.setText(Context.getCustomerName());
	    	customerFirstNameField.setText(Context.getCustomerFirstname());
	    	customerAddressField.setText(Context.getCustomerAdress());
	    	customerNumberField.setText(Context.getCustomerPhone());
	    	customerEmailField.setText(Context.getCustomerEmail());
	    	customerZipField.setText(Context.getCustomerTown().substring(0, 4));
	    	customerMunicipalityField.setText(Context.getCustomerTown().substring(5));
	    	if(Context.getCustomerCustomerfunction().toString().equals("Eigentümer")){
	    		radioButtonOwner.setSelected(true);
	    	}else{
	    		radioButtonAdministration.setSelected(true);
	    	}
	    	Context.setNull();	
    }

    /**
     * method to save the record
     * @param event
     */
    @FXML
    void ActionDetailviewSaveCustomer(ActionEvent event) {
    	
    	Customer customer = Context.getCustomer();
    	String companyname = customerCompanyNameField.getText();
    	String lastname = customerNameField.getText();
    	String adress = customerAddressField.getText();
    	String phone = customerNumberField.getText();
    	String plz = customerZipField.getText();
    	String firstname = customerFirstNameField.getText();
    	String email = customerEmailField.getText();
    	Integer zip = null;
    	if (plz.isEmpty() == false) {
    		zip = Integer.parseInt(plz);
    	}
    	Boolean isOwner = false;
    	if(radioButtonOwner.isSelected()) {
    		isOwner = true;
    	} else if(radioButtonAdministration.isSelected()) {
    		isOwner = false;
    	}
    	
    	try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(companyname.isEmpty() == false && lastname.isEmpty() == false && adress.isEmpty() == false && phone.isEmpty() == false && zip != null && firstname.isEmpty() == false && email.isEmpty() == false) {
				if(customer == null){
				feukora.saveCustomer(companyname, lastname, adress, phone, zip, firstname, email, isOwner);
			} else {
				feukora.updateCustomer(customer, companyname, lastname, adress, phone, zip, firstname, email, isOwner);
			}
			
	    	customerCompanyNameField.clear();
	    	customerNameField.clear();
	    	customerAddressField.clear();
	    	customerNumberField.clear();
	    	customerZipField.clear();
	    	customerMunicipalityField.clear();
	    	customerFirstNameField.clear();
	    	customerEmailField.clear();
	    	radioButtonOwner.setSelected(false);
	    	radioButtonAdministration.setSelected(false);
	    	
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
    void ActionDetailviewCancelCustomer(ActionEvent event) {
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
		
    	detailviewCancelCustomer.getScene().setRoot(pane);
    }
    
    /**
     * method to delete the selected appointment
     * @param event
     */
    @FXML
    void ActionDetailviewDeleteAppointment(ActionEvent event) {

    }
    
    @FXML
    void ActionRadioButtonOwner(ActionEvent event) {
    	
    }

    @FXML
    void ActionRadioButtonAdministration(ActionEvent event) {

    }
}