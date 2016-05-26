package calendar.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.management.remote.rmi.RMIServer;

import org.apache.log4j.Logger;
import application.Context;
import calendar.util.CalendarConstants;
import javafx.collections.FXCollections;
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
import projekt.feukora.server.model.Customerheater;
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
	private ComboBox<Customerheater> appointmentHeatercomboBox;

	private Appointment appointment;
	private User inspector;
	private Calendar cal;
	private ClientInternRMI cirmi;

	@FXML
	void ActionAppointmentDateField(ActionEvent event) {
		//do nothing
	}

	@FXML
	void ActionAppointmentInspectorField(ActionEvent event) {
		//do nothing
	}
	
	@FXML
	void ActionAppointmentCommentsField(ActionEvent event) {
		//do nothing
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
			if ( appointment == null )
			{
				appointment = new Appointment( ClientInternRMI.currLoggedInUser );
			}
			appointment.setAppointmentdate( (GregorianCalendar) cal );
			appointment.setComments( appointmentCommentsField.getText() );
			appointment.setUser( inspector );
			appointment.setCustomerHeater( appointmentHeatercomboBox.getValue() );
			
			cirmi.saveAppointment( appointment );
			ActionDetailviewCancelAppointment(event);
			
		}

		@FXML
		void ActionAppointmentClientcomboBox(ActionEvent event) {
			fillCustomerHeaterComboBox( appointmentClientcomboBox.getValue() );
			appointmentHeatercomboBox.getSelectionModel().select( 0 );
		}

		@FXML
		void ActionAppointmentHeatercomboBox(ActionEvent event) {
			//do nothing
		}

		public void initData ( ObservableMap<Object, Object> properties )
		{
			try {
				cirmi = new ClientInternRMI();
				appointmentClientcomboBox.setItems(cirmi.getCustomers());

				SimpleDateFormat sdf = new SimpleDateFormat( CalendarConstants.DATEFORMAT_DDMMYYHHMM );
				
				appointment = (Appointment) properties.get( CalendarConstants.PROPERTYNAME_APPOINTMENT );
				Customer customer;
				
				if ( appointment == null )
				{
					//no appointment exists, create a new one
					appointmentClientcomboBox.getSelectionModel().select( 0 );
					customer = appointmentClientcomboBox.getValue();
					
					fillCustomerHeaterComboBox( customer );
					appointmentHeatercomboBox.getSelectionModel().select( 0 );
					
					cal = (Calendar) properties.get( CalendarConstants.PROPERTYNAME_DATE );
					inspector = (User) properties.get( CalendarConstants.PROPERTYNAME_INSPECTOR );
		
					appointmentInspectorField.setText( inspector.toString() );
					appointmentDateField.setText( sdf.format( cal.getTime() ) );
					appointmentDateField.getProperties().put( CalendarConstants.PROPERTYNAME_DATE, cal );
					
					detailviewDeleteAppointment.setDisable(true);
				}
				else
				{
					//appointment exists, fill gui fields with data
					Customerheater customerHeater = appointment.getCustomerHeater();
					customer = customerHeater.getCustomer();
					
					inspector = appointment.getUser();
					cal = appointment.getAppointmentdate();
					
					appointmentInspectorField.setText( inspector.toString() );
					appointmentDateField.setText( sdf.format( cal.getTime() ) );
					appointmentCommentsField.setText( appointment.getComments() );
					appointmentClientcomboBox.getSelectionModel().select( customer );
					
					fillCustomerHeaterComboBox( customer );
					appointmentHeatercomboBox.getSelectionModel().select( customerHeater );
					
				}
			} catch (Exception e) {
				logger.error("Fehler beim Erstellen der RMI Verbindung", e);
			}
		}

		@FXML
		void ActionDetailviewDeleteAppointment(ActionEvent event) {
			if ( appointment != null )
			{
				cirmi.deleteAppointment( appointment );
				ActionDetailviewCancelAppointment( event );
			}
		}
		
		/**
		 * Fills the data for the {@link Customerheater} combobox, featured in this GUI
		 * 
		 * @param customer
		 */
		private void fillCustomerHeaterComboBox ( Customer customer )
		{
			ObservableList<Customerheater> cmbCustomerHeaters = FXCollections.observableArrayList();
			cmbCustomerHeaters.addAll( cirmi.getCustomerHeaters( customer ) );
			appointmentHeatercomboBox.setItems(cmbCustomerHeaters);
		}
	}
