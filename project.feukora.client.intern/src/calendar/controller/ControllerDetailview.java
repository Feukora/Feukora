package calendar.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.log4j.Logger;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.User;

public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

    @FXML
    private Button detailviewSaveAppointment;

    @FXML
    private Button detailviewCancelAppointment;
    
    @FXML
    private Button detailviewDeleteAppointment;

    @FXML
    private TextField appointmentDateField;
    
    @FXML
    private TextField appointmentInspectorField;

    @FXML
    private TextField appointmentCreatedByField;

    @FXML
    private ComboBox<?> appointmentClientcomboBox;

    @FXML
    private TextArea appointmentCommentsField;

    @FXML
    private ComboBox<?> appointmentHeatercomboBox;

    private Appointment appointment;
    private User inspector;
    private Calendar cal;

    @FXML
    void ActionAppointmentDateField(ActionEvent event) {

    }
    
    @FXML
    void ActionAppointmentInspectorField(ActionEvent event) {

    }

    @FXML
    void ActionAppointmentCreatedByField(ActionEvent event) {

    }

    @FXML
    void ActionAppointmentCommentsField(ActionEvent event) {

    }

    @FXML
    void ActionDetailviewCancelAppointment(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
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

    @FXML
    void ActionAppointmentClientcomboBox(ActionEvent event) {

    }

    @FXML
    void ActionAppointmentHeatercomboBox(ActionEvent event) {

    }
    
    public void initData ( ObservableMap<Object, Object> properties )
    {
    	this.appointment = appointment;
    	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    	cal = (Calendar) properties.get("date");
    	inspector = (User) properties.get("user");
    	
    	appointmentInspectorField.setText( inspector.toString() );
    	appointmentDateField.setText( sdf.format( cal.getTime() ) );
    	
    }
    
    @FXML
    void ActionDetailviewDeleteAppointment(ActionEvent event) {

    }
}
