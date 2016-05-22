package calendar.controller;

import org.apache.log4j.Logger;

import blower.controller.ControllerOverview;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Users;

public class ControllerCalendarPane {
	
	private static final Logger logger = Logger
			.getLogger(ControllerCalendarPane.class);

    @FXML
    private Button sat1315;

    @FXML
    private Button mon1517;

    @FXML
    private Button fri1315;

    @FXML
    private Button thur1315;

    @FXML
    private Button mon1315;

    @FXML
    private Button thur1012;

    @FXML
    private Button fri1517;

    @FXML
    private Button sat1012;

    @FXML
    private Button wed0810;

    @FXML
    private Button printCalendar;

    @FXML
    private Button thur1517;

    @FXML
    private Button tues0810;

    @FXML
    private Button wed1517;

    @FXML
    private Button mon1012;

    @FXML
    private Button sat1517;

    @FXML
    private Button sat0810;

    @FXML
    private Button wed1012;

    @FXML
    private Button mon0810;

    @FXML
    private Button fri0810;

    @FXML
    private Button tues1012;

    @FXML
    private Button wed1315;

    @FXML
    private Button thur0810;

    @FXML
    private ComboBox<String> comboBoxSelectCalendar;

    @FXML
    private Button tues1315;

    @FXML
    private Button fri1012;

    @FXML
    private Button tues1517;

    @FXML
    void ActionSetAppointment(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/calendarDetailview.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
    	tues1517.getScene().setRoot(pane);
    }

    @FXML
    void ActionComboBoxSelectCalendar(ActionEvent event) {
    	String activeUser = comboBoxSelectCalendar.getSelectionModel().getSelectedItem();
    	initializeNew(activeUser);
    	
    }

    @FXML
    void ActionPrintCalendar(ActionEvent event) {
    	   PrinterJob printerJob = PrinterJob.createPrinterJob();
    	   printerJob.showPrintDialog(null);
    	   printerJob.endJob();
    }
    
    public void initialize(){
    	ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
			ObservableList<String> usernames = FXCollections.observableArrayList();
			ObservableList<Users> users = feukora.getUsers();
			int i = 0;
			while (i < users.size()) {
				usernames.add(users.get(i).getUsername());
				i++;
			}
			comboBoxSelectCalendar.setItems(usernames);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    // Hier wird bei einer änderung des Activen users in der Combobox der Kalender neu geladen
    public void initializeNew(String activeUser){
    	ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
			//Kalenderdaten des activeUser 
			feukora.getCalendarData(activeUser);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}

