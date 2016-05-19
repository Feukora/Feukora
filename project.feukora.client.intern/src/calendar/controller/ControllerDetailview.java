package calendar.controller;

/**
 * Sample Skeleton for 'calendarDetailview.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControllerDetailview {

    @FXML // fx:id="detailviewCancelAppointment"
    private Button detailviewCancelAppointment; // Value injected by FXMLLoader
    
    @FXML // fx:id="detailviewSaveAppointment"
    private Button detailviewSaveAppointment; // Value injected by FXMLLoader
    
    @FXML // fx:id="customerAddressField"
    private TextField customerAddressField; // Value injected by FXMLLoader

    @FXML // fx:id="customerNumberField"
    private TextField customerNumberField; // Value injected by FXMLLoader

    @FXML // fx:id="customerFirstNameField"
    private TextField customerFirstNameField; // Value injected by FXMLLoader

    @FXML // fx:id="appointmentInspectorField"
    private TextField appointmentInspectorField; // Value injected by FXMLLoader

    @FXML // fx:id="appointmentPhoneField"
    private TextField appointmentPhoneField; // Value injected by FXMLLoader

    @FXML // fx:id="appointmentEmailField"
    private TextField appointmentEmailField; // Value injected by FXMLLoader

    @FXML // fx:id="customerNameField"
    private TextField customerNameField; // Value injected by FXMLLoader

    @FXML // fx:id="appointmentDateField"
    private TextField appointmentDateField; // Value injected by FXMLLoader

    @FXML // fx:id="customerZipField"
    private TextField customerZipField; // Value injected by FXMLLoader

    @FXML // fx:id="customerMunicipalyField"
    private TextField customerMunicipalyField; // Value injected by FXMLLoader

    @FXML // fx:id="customerEmailField"
    private TextField customerEmailField; // Value injected by FXMLLoader

    @FXML // fx:id="appointmentTypistField"
    private TextField appointmentTypistField; // Value injected by FXMLLoader

    @FXML
    void ActionCustomerZipField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerMunicipalyField(ActionEvent event) {

    }

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
    void ActionCustomerEmailField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerNumberField(ActionEvent event) {

    }

    @FXML
    void ActionAppointmentDateField(ActionEvent event) {

    }

    @FXML
    void ActionAppointmentTypistField(ActionEvent event) {

    }

    @FXML
    void ActionAppointmentInspectorField(ActionEvent event) {

    }

    @FXML
    void ActionAppointmentPhoneField(ActionEvent event) {

    }

    @FXML
    void ActionAppointmentEmailField(ActionEvent event) {

    }

    @FXML
    void ActionDetailviewCancelAppointment(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try { // Funktioniert noch nicht
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/MainViewAdministration.fxml"));

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
    	detailviewCancelAppointment.getScene().setRoot(pane);
    }
    
    @FXML
    void ActionDetailviewSaveAppointment(ActionEvent event) {

    }

}

