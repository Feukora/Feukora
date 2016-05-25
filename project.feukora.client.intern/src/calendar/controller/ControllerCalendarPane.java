package calendar.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.User;

public class ControllerCalendarPane {
	
	private static final Logger logger = Logger
			.getLogger(ControllerCalendarPane.class);
	
   @FXML
	public BorderPane mainRoot;

    @FXML
    private MenuBar mBar;
    
    @FXML
    private Label calendarWeek;

    @FXML
    private MenuItem loginWelcome;

    @FXML
    private MenuItem assistantMenuBar;

    @FXML
    private MenuItem assistantNewMenuItem;
    
    @FXML
    private MenuItem closeWelcome;
    
    @FXML
    private MenuItem calendarMenuBar;
    
    @FXML
    private MenuItem customerMenuBar;
    
    @FXML
    private MenuItem customerNewMenuItem;
    
    @FXML
    private MenuItem rapportMenuBar;
    
    @FXML
    private MenuItem rapportNewMenuItem;

    @FXML
    private MenuItem inspectorMenuBar;
    
    @FXML
    private MenuItem inspectorNewMenuItem;
    
    @FXML
    private MenuItem blowerMenuBar;

    @FXML
    private MenuItem blowerNewMenuItem;

    @FXML
    private MenuItem heaterMenuBar;
    
    @FXML
    private MenuItem heaterNewMenuItem;

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
    private Button moveLeft;
    
    @FXML
    private Button moveRight;

    private ClientInternRMI feukora;
    private static int weekScroller = 0;
    private List<Button> buttons = new ArrayList<Button>();

    @FXML
    void ActionSetAppointment(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("calendar/view/calendarDetailview.fxml"));
		Button origin = (Button) event.getSource();
    	try {
    		origin.getProperties().put("user", comboBoxSelectCalendar.getValue());
    		origin.getScene().setRoot(loader.load());
    		ControllerDetailview calendarController = loader.<ControllerDetailview>getController();
    		calendarController.initData( origin.getProperties() );
    		
    		
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
    	
    }

    @FXML
    void ActionComboBoxSelectCalendar(ActionEvent event) {
    	fillAppointments();
    }

    @FXML
    void ActionPrintCalendar(ActionEvent event) {
    	   PrinterJob printerJob = PrinterJob.createPrinterJob();
    	   printerJob.showPrintDialog(null);
    	   printerJob.endJob();
    }
    
    public void initialize()
    {
		try {
			feukora = new ClientInternRMI();
			ObservableList<User> users = feukora.getUsers();
			comboBoxSelectCalendar.setItems(users);
			comboBoxSelectCalendar.getSelectionModel().select(0);
			
			Calendar cal = Calendar.getInstance();
			cal.setMinimalDaysInFirstWeek(7);
			cal.add(Calendar.WEEK_OF_YEAR, weekScroller);
	    	cal.set( Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
	    	
	    	calendarWeek.setText("Kalenderwoche " + cal.get(Calendar.WEEK_OF_YEAR));
			initNodes( cal );
			
			fillAppointments();
			
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ", e);
		}
    }
    
	private void initNodes( Calendar cal )
    {
    	SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");
        fmt.setCalendar(cal);
    	for ( Node node : calendarPane.getChildren() )
    	{
            
    		if ( calendarPane.getColumnIndex(node) != null )
    		{
				int colIndex = calendarPane.getColumnIndex(node);
	    		cal.set( Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + colIndex);
    		}
    		
    		//init labels
    		if( node instanceof Label && node.getId() != null && node.getId().startsWith( "lbl" ) )
    		{
				Label lbl = (Label) node;
				lbl.setText( lbl.getText().substring(0, 2) + " " + fmt.format( cal.getTime() ) );
    		}
    		
    		//init buttons
    		if ( node instanceof Button )
    		{
    			Button btn = (Button) node;
	    		Calendar btnCal = Calendar.getInstance();
	    		btnCal.setTimeInMillis( cal.getTimeInMillis() );
	    		btnCal.set(Calendar.MINUTE, 0);
	    		btnCal.set(Calendar.SECOND, 0);
	    		btnCal.set(Calendar.MILLISECOND, 0);
	    		if ( btn.getId().endsWith( "10" ) )
	    		{
	    			btnCal.set(Calendar.HOUR_OF_DAY, 8);
	    		}
	    		else if ( btn.getId().endsWith("12") )
	    		{
	    			btnCal.set(Calendar.HOUR_OF_DAY, 10);
	    		}
	    		else if ( btn.getId().endsWith( "15" ) )
	    		{
	    			btnCal.set(Calendar.HOUR_OF_DAY, 13);
	    		}
	    		else if ( btn.getId().endsWith( "17" ) )
	    		{
	    			btnCal.set(Calendar.HOUR_OF_DAY, 15);
	    		}
	    		btn.getProperties().put("date", btnCal);
	    		buttons.add(btn);
    		}
    	}
    }
    
    @FXML
    void ActionLoginMenuBar(ActionEvent event) {
    	
    }
    
    @FXML
    void ActionCloseMenuBar(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void ActionCalendarMenuBar(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/calendarPane.fxml"));

			mainRoot.setTop(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
    }

    @FXML
    void ActionInspectorMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
    }

    @FXML
    void ActionCustomerMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
	}

    @FXML
    void ActionBlowerMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
	}
    
    @FXML
    void ActionRapportMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/rapportOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
	}

    @FXML
    void ActionHeaterMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
	}
    
    @FXML
    void ActionCustomerNewMenuItem(ActionEvent event) {
	    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
    
    }
    
    @FXML
    void ActionRapportNewMenuItem(ActionEvent event) {
		
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/Main.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
    }

    @FXML
    void ActionHeaterNewMenuItem(ActionEvent event) {
		
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
    }
    
    @FXML
    void ActionBlowerNewMenuItem(ActionEvent event) {
    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
    }
    
    @FXML
    void ActionInspectorNewMenuItem(ActionEvent event) {
    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
    }
    
    @FXML
    public void ActionAssistantMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("assistant/view/assistantOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}
    }

    @FXML
    void ActionAssistantNewMenuItem(ActionEvent event) {
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("assistant/view/assistantDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}	
    }
    
    @FXML
    void ActionMoveLeft(ActionEvent event) {
    	BorderPane pane = new BorderPane();
    	
    	try {
    		weekScroller--;
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/CalendarPane.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
    	
    	moveLeft.getScene().setRoot(pane);
    }

    @FXML
    void ActionMoveRight(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
    		weekScroller++;
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/CalendarPane.fxml"));

    	} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden ",
					e);
		}
    	
    	moveRight.getScene().setRoot(pane);
    }
    
    private void fillAppointments ()
    {
    	List<Appointment> appointments;
		try {
			appointments = feukora.getAppointments(comboBoxSelectCalendar.getValue());
		
	    	for ( Appointment app : appointments )
	    	{
	    		for( Button btn : buttons )
	    		{
	    			//reset all appointments
	    			btn.getProperties().remove("appointment");
	    			btn.setText("");
	    			
	    			Calendar cal = (Calendar) btn.getProperties().get( "date" );
	    			Calendar appDate = app.getAppointmentdate();
	
	    			if( cal.equals(appDate) )
	    			{
	    				btn.setText(app.toString());
	    				btn.getProperties().put("appointment", app);
	    			}
	    		}
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

