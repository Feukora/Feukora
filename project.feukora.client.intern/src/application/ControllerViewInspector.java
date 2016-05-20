package application;

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

public class ControllerViewInspector {


    @FXML
    private BorderPane mainRoot;
    
    @FXML
    private Button rapportWelcome;

    @FXML
    private Button rapportNewWelcome;

    @FXML
    private Button calendarWelcome;

    @FXML
    private Button exitWelcome;

    @FXML
    private MenuBar mBar;

    @FXML
    private MenuItem calenderMenuBar;

    @FXML
    private MenuItem loginWelcome;

    @FXML
    private MenuItem customerMenuBar;

    @FXML
    private MenuItem customerNewMenuItem;

    @FXML
    private MenuItem inspectorMenuBar;
    
    @FXML
    private MenuItem inspectorNewMenuItem;

    @FXML
    private MenuItem heaterMenuBar;

    @FXML
    private MenuItem heaterNewMenuItem;

    @FXML
    private MenuItem rapportMenuBar;
    
    @FXML
    private MenuItem rapportNewMenuItem;

    @FXML
    private MenuItem blowerMenuBar;

    @FXML
    private MenuItem blowerNewMenuItem;

    @FXML
    private MenuItem closeWelcome;

    @FXML
    void ActionExitWelcome(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void ActionRapportWelcome(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/rapportOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    	rapportWelcome.getScene().setRoot(pane);
    }

    @FXML
    void ActionRapportNewWelcome(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/Main.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    	rapportWelcome.getScene().setRoot(pane);
    }

    @FXML
    void ActionCalendarWelcome(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/calendarPane.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
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
    void ActionCalenderMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("calendar/view/calendarPane.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void ActionInspectorMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void ActionCustomerMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

    @FXML
    void ActionBlowerMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

    @FXML
    void ActionHeaterMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
    

    @FXML
    void ActionRapportMenuBar(ActionEvent event) {
		AnchorPane pane = new AnchorPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/rapportOverview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
    
    @FXML
    void ActionCustomerNewMenuItem(ActionEvent event) {
	    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("customer/view/customerDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    
    }

    @FXML
    void ActionHeaterNewMenuItem(ActionEvent event) {
		
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("heater/view/heaterDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
    
    @FXML
    void ActionBlowerNewMenuItem(ActionEvent event) {
    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("blower/view/blowerDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
    
    @FXML
    void ActionInspectorNewMenuItem(ActionEvent event) {
    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("inspector/view/inspectorDetailview.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void ActionRapportNewMenuItem(ActionEvent event) {
    	
    	try {
			final Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("rapport/view/Main.fxml"));

			mainRoot.setCenter(pane);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    }


}
