package calendar.controller;

import java.util.List;

import org.apache.log4j.Logger;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.User;

public class ControllerCalendarPane {
	
	private static final Logger logger = Logger
			.getLogger(ControllerCalendarPane.class);
	
	@FXML
	private GridPane calendarPane;
	
    @FXML
    private Button btnApp_sat1315;

    @FXML
    private Button btnApp_mon1517;

    @FXML
    private Button btnApp_fri1315;

    @FXML
    private Button btnApp_thur1315;

    @FXML
    private Button btnApp_mon1315;

    @FXML
    private Button btnApp_thur1012;

    @FXML
    private Button btnApp_fri1517;

    @FXML
    private Button btnApp_sat1012;

    @FXML
    private Button btnApp_wed0810;

    @FXML
    private Button printCalendar;

    @FXML
    private Button btnApp_thur1517;

    @FXML
    private Button btnApp_tues0810;

    @FXML
    private Button btnApp_wed1517;

    @FXML
    private Button btnApp_mon1012;

    @FXML
    private Button btnApp_sat1517;

    @FXML
    private Button btnApp_sat0810;

    @FXML
    private Button btnApp_wed1012;

    @FXML
    private Button btnApp_mon0810;

    @FXML
    private Button btnApp_fri0810;

    @FXML
    private Button btnApp_tues1012;

    @FXML
    private Button btnApp_wed1315;

    @FXML
    private Button btnApp_thur0810;

    @FXML
    private ComboBox<User> comboBoxSelectCalendar;

    @FXML
    private Button btnApp_tues1315;

    @FXML
    private Button btnApp_fri1012;

    @FXML
    private Button btnApp_tues1517;

    @FXML
    void ActionSetAppointment(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("calendar/view/calendarDetailview.fxml"));
		Button origin = (Button) event.getSource();
    	try {
    		User targetUser = comboBoxSelectCalendar.getValue();
    		//ControllerDetailview calendarController = loader.<ControllerDetailview>getController();
    		//calendarController.initData(appointmentId);
    		
    		origin.getScene().setRoot(loader.load());
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
    	
    }

    @FXML
    void ActionComboBoxSelectCalendar(ActionEvent event) {
    	/*String activeUser = comboBoxSelectCalendar.getSelectionModel().getSelectedItem();
    	initializeNew(activeUser);*/
    	
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
			ObservableList<User> users = feukora.getUsers();
			comboBoxSelectCalendar.setItems(users);
			initButtons();
			
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
    
    private void initButtons()
    {
    	for ( Node node : calendarPane.getChildren() )
    	{
    		if ( node instanceof Button )
    		{
	    		Button btn = (Button) node;
	    		btn.setText("Hallo");
    		}
    	}
    }

}

