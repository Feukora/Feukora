package calendar.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import javafx.collections.ObservableMap;

/**
 * Sample Skeleton for 'calendarDetailview.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.User;

public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

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

    private Appointment appointment;
    private User inspector;
    private Calendar cal;
    
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
		BorderPane pane = new BorderPane();
    	
    	try { // Funktioniert noch nicht
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	detailviewCancelAppointment.getScene().setRoot(pane);
    }
    
    @FXML
    void ActionDetailviewSaveAppointment(ActionEvent event) {
//    	String lastname = customerNameField.getText();
//    	String adress = customerAddressField.getText();
//    	String phone = customerNumberField.getText();
//    	String plz = customerZipField.getText();
//    	String firstname = customerFirstNameField.getText();
//    	String email = customerEmailField.getText();
//    	Integer zip = Integer.parseInt(plz);
//    	
//    	String datum = appointmentDateField.getText();
//    	String user = appointmentInspectorField.getText();
//    	String creator = appointmentTypistField.getText();
//    	String emailuser = appointmentEmailField.getText();
//    	String phoneuser = appointmentPhoneField.getText();
//    	
//    	
//    	try {
//			ClientInternRMI feukora = new ClientInternRMI();
//			feukora.saveAppointment(lastname, adress, phone, zip, firstname, email);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			logger.error("Aktion konnte nicht durchgeführt werden\'",
//					e);
//	}
//    	
//    	customerNameField.clear();
//    	customerAddressField.clear();
//    	customerNumberField.clear();
//    	customerZipField.clear();
//    	customerFirstNameField.clear();
//    	customerEmailField.clear();
    }
    
    public void initData ( ObservableMap<Object, Object> properties )
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    	cal = (Calendar) properties.get("date");
    	inspector = (User) properties.get("user");
    	
    	appointmentInspectorField.setText( inspector.toString() );
    	appointmentDateField.setText( sdf.format( cal.getTime() ) );
    	
    	
    }

}

