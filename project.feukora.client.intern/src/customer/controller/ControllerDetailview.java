package customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Town;

public class ControllerDetailview {

    @FXML
    private Button detailviewSaveCustomer;

    @FXML
    private TextField customerNameField;

    @FXML
    private TextField customerAddressField;

    @FXML
    private TextField customerNumberField;

    @FXML
    private TextField customerZipField;

    @FXML
    private TextField customerFirstNameField;

    @FXML
    private TextField customerEmailField;



    @FXML
    void ActionCustomerNameField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerFirstNameField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerAddressField(ActionEvent event) {

    }
    
    @FXML
    void ActionCustomerZipField(ActionEvent event) {
    	
//    	Bringt nichts, wenn ich das Feld daneben nicht ansprechen kann.
//    	String plz = customerZipField.getText();
//    	Integer zip = Integer.parseInt(plz);
//    	
//    	try {
//			ClientInternRMI feukora = new ClientInternRMI();
//			String town = feukora.getTown(zip);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

    }

    @FXML
    void ActionCustomerEmailField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerNumberField(ActionEvent event) {

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
    	
    	try {
			ClientInternRMI feukora = new ClientInternRMI();
			feukora.saveCustomer(lastname, adress, phone, zip, firstname, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	customerNameField.clear();
    	customerAddressField.clear();
    	customerNumberField.clear();
    	customerZipField.clear();
    	customerFirstNameField.clear();
    	customerEmailField.clear();
    }
}
