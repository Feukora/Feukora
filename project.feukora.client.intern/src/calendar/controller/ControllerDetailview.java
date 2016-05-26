package calendar.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.management.remote.rmi.RMIServer;

import org.apache.log4j.Logger;

import application.Context;
import calendar.util.CalendarConstants;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.Customer;
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
    private ComboBox<Customer> appointmentClientcomboBox;

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
    	
    	try { // Funktioniert noch nicht
    		if(Context.getRole().equals("Administrator")) {
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));
			} else if (Context.getRole().equals("Feuerungskontrolleur")) {
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewInspector.fxml"));
			} else if (Context.getRole().equals("Sachbearbeiter")) {
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAssistant.fxml"));
			}

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	detailviewCancelAppointment.getScene().setRoot(pane);
    }
    
    @FXML
    void ActionDetailviewSaveAppointment(ActionEvent event) {
    	
    }

    @FXML
    void ActionAppointmentClientcomboBox(ActionEvent event) {

    }

    @FXML
    void ActionAppointmentHeatercomboBox(ActionEvent event) {

    }
    
    public void initData ( ObservableMap<Object, Object> properties )
    {	
    	ClientInternRMI cirmi;
    	try {
			cirmi = new ClientInternRMI();
			appointmentClientcomboBox.setItems(cirmi.getCustomers());
			appointmentClientcomboBox.getSelectionModel().select(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	SimpleDateFormat sdf = new SimpleDateFormat( CalendarConstants.DATEFORMAT_DDMMYYHHMM );
    	cal = (Calendar) properties.get( CalendarConstants.PROPERTYNAME_DATE );
    	inspector = (User) properties.get( CalendarConstants.PROPERTYNAME_INSPECTOR );
    	
    	appointmentInspectorField.setText( inspector.toString() );
    	appointmentDateField.setText( sdf.format( cal.getTime() ) );
    	
    	
    }
    
    @FXML
    void ActionDetailviewDeleteAppointment(ActionEvent event) {

    }

}
