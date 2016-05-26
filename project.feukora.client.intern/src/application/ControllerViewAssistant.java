package application;

import org.apache.log4j.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControllerViewAssistant {

	private static final Logger logger = Logger
			.getLogger(ControllerViewAssistant.class);

    @FXML
	public BorderPane mainRoot;

    @FXML
    private MenuBar mBar;

    @FXML
    private MenuItem closeWelcome;
    
    @FXML
    private MenuItem calenderMenuBar;
    
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
    private Button heaterWelcome;

    @FXML
    private Button customerWelcome;
    
    @FXML
    private Button blowerWelcome;
    
    @FXML
    private Button rapportWelcome;
    
    @FXML
    private Button calendarWelcome;
    
    @FXML
    private Button inspectorWelcome;

    @FXML
    private Button exitWelcome;

    @FXML
    void ActionExitWelcome(ActionEvent event) {
       	Platform.exit();
    }
    
    @FXML
    void ActionInspectorWelcome(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	inspectorWelcome.getScene().setRoot(pane);
    }

    @FXML
    void ActionCustomerWelcome(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
		customerWelcome.getScene().setRoot(pane);
    }

    @FXML
    void ActionRapportWelcome(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/rapportOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
    	rapportWelcome.getScene().setRoot(pane);
    }

    @FXML
    void ActionHeaterWelcome(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
		heaterWelcome.getScene().setRoot(pane);
    }
    
    @FXML
    void ActionCalendarWelcome(ActionEvent event) {
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
    void ActionBlowerWelcome(ActionEvent event) {
    	
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
		blowerWelcome.getScene().setRoot(pane);
		}
    
    @FXML
    void ActionCloseMenuBar(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void ActionCalenderMenuBar(ActionEvent event) {
    	BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/calendarPane.fxml"));

			mainRoot.setCenter(pane);

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
			logger.error("Aktion konnte nicht durchgeführt werden\'",
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
			logger.error("Aktion konnte nicht durchgeführt werden\'",
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
			logger.error("Aktion konnte nicht durchgeführt werden\'",
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
			logger.error("Aktion konnte nicht durchgeführt werden\'",
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
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
	}
    
    @FXML
    void ActionCustomerNewMenuItem(ActionEvent event) {
	    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
    }
    
    @FXML
    void ActionRapportNewMenuItem(ActionEvent event) {
		
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/Main.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
    }

    @FXML
    void ActionHeaterNewMenuItem(ActionEvent event) {
		
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
    }
    
    @FXML
    void ActionBlowerNewMenuItem(ActionEvent event) {
    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
    }
    
    @FXML
    void ActionInspectorNewMenuItem(ActionEvent event) {
    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
    }
}
