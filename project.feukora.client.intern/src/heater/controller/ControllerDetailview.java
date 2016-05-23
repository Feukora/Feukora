package heater.controller;

import org.apache.log4j.Logger;

import application.Context;
import customer.controller.ControllerOverview;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Heater;

public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

	private Heater heater;
    @FXML
    private Button detailviewSaveHeater;
    
    @FXML
    private Button detailviewCancelHeater;

    @FXML
    private TextField heaterNameField;

    @FXML
    void ActionHeaterNameField(ActionEvent event) {

    }

    @FXML
    void ActionDetailviewSaveHeater(ActionEvent event) {
    	String heatername = heaterNameField.getText();
    	Heater heater = Context.getHeater();
    	
    	try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(heater == null) {
				
				feukora.saveHeater(heater);
			} else {
		    	heater.setName(heatername);
				feukora.updateHeater(heater);
			}
			
//	    	feukora.deleteCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
    	heaterNameField.clear();
    }
    
    public void initialize() {
    	
    	if(Context.getHeater() != null) {
    		NewOrUpdate();
    	} else {
    		
    	}
    	
    	
    
    }
    
    public void NewOrUpdate(){
    		heaterNameField.setText(Context.getHeaterName());
	    	Context.setNull();
    	
    }
    
    @FXML
    void ActionDetailviewCancelHeater(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}	
		
    	detailviewCancelHeater.getScene().setRoot(pane);
    }

}
