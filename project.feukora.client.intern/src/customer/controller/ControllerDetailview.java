package customer.controller;

import application.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Customer;

public class ControllerDetailview {

	final ToggleGroup group = new ToggleGroup();
	
    @FXML
    private Button detailviewSaveCustomer;
    
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
			e.printStackTrace();
		}

    }

    @FXML
    void ActionCustomerEmailField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerNumberField(ActionEvent event) {

    }
    
    public void initialize() {
    	radioButtonOwner.setToggleGroup(group);
    	radioButtonAdministration.setToggleGroup(group);
    	radioButtonOwner.setSelected(true);
    	
    	if(Context.getCustomerName().isEmpty() == false){
	    	customerNameField.setText(Context.getCustomerName());
	    	customerFirstNameField.setText(Context.getCustomerFirstname());
	    	customerAddressField.setText(Context.getCustomerAdress());
	    	customerNumberField.setText(Context.getCustomerPhone());
	    	customerEmailField.setText(Context.getCustomerEmail());
	    	customerZipField.setText(Context.getCustomerTown());
	    	customerNameField.setText(Context.getCustomerName());
	    	if(Context.getCustomerCustomerfunction() == "Verwaltung"){
	    		radioButtonOwner.setSelected(false);
    	}
    	}

    	
    }

    @FXML
    void ActionDetailviewSaveCustomer(ActionEvent event) {
    	
    	String lastname = customerNameField.getText();
    	String adress = customerAddressField.getText();
    	String phone = customerNumberField.getText();
    	String plz = customerZipField.getText();
    	String firstname = customerFirstNameField.getText();
    	String email = customerEmailField.getText();
    	Integer zip = Integer.parseInt(plz);
    	Boolean isOwner = false;
    	if(radioButtonOwner.isSelected()) {
    		isOwner = true;
    	} else if(radioButtonAdministration.isSelected()) {
    		isOwner = false;
    	}
    	
    	try {
			ClientInternRMI feukora = new ClientInternRMI();
			feukora.saveCustomer(lastname, adress, phone, zip, firstname, email, isOwner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	customerNameField.clear();
    	customerAddressField.clear();
    	customerNumberField.clear();
    	customerZipField.clear();
    	customerMunicipalityField.clear();
    	customerFirstNameField.clear();
    	customerEmailField.clear();
    	radioButtonOwner.setSelected(true);
    	radioButtonAdministration.setSelected(false);
    	
    	
    }
    
    @FXML
    void ActionDetailviewCancelCustomer(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
    	detailviewCancelCustomer.getScene().setRoot(pane);
    }
    
    @FXML
    void ActionRadioButtonOwner(ActionEvent event) {
    	

    }

    @FXML
    void ActionRadioButtonAdministration(ActionEvent event) {

    }
}
