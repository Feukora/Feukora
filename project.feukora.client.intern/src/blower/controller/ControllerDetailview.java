package blower.controller;

import org.apache.log4j.Logger;

import application.Context;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.rmi.BlowerRMIImpl;

public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);
	
	final ToggleGroup fuel = new ToggleGroup();
	final ToggleGroup blowertype = new ToggleGroup();
	
	private Blower blower1;

    @FXML
    private Button detailviewSaveBlower;
    
    @FXML
    private Button detailviewCancelBlower;

    @FXML
    private TextField blowerNameField;
    
    @FXML
    private RadioButton radioButtonOil;

    @FXML
    private RadioButton radioButtonAtmospheric;

    @FXML
    private RadioButton radioButtonLiquidGas;

    @FXML
    private RadioButton radioButtonBlowers;

    @FXML
    private RadioButton radioButtonGas;
    
    @FXML
    private RadioButton radioButtonEvaporator;

    @FXML
    void ActionBlowerNameField(ActionEvent event) {

    }

    
    public void initialize() {
    	if(Context.getBlowername() != null){
    		Update();
    	} else {
    		radioButtonOil.setToggleGroup(fuel);
    		radioButtonGas.setToggleGroup(fuel);
    		radioButtonLiquidGas.setToggleGroup(fuel);
    		
    		radioButtonBlowers.setToggleGroup(blowertype);
    		radioButtonAtmospheric.setToggleGroup(blowertype);
    		radioButtonEvaporator.setToggleGroup(blowertype);
    		
    		radioButtonOil.setSelected(false);
    		radioButtonGas.setSelected(false);
    		radioButtonLiquidGas.setSelected(false);
    		
    		radioButtonBlowers.setSelected(false);
    		radioButtonAtmospheric.setSelected(false);
    		radioButtonEvaporator.setSelected(false);
    	}
    }
    
    public void Update() {
    	blower1 = Context.getBlower();
    	blowerNameField.setText(Context.getBlowername());
    	if(Context.getBlowerType().toString().equals("Gebl�se")) {
    		radioButtonBlowers.setSelected(true);
    	} else if (Context.getBlowerType().toString().equals("atmosph�risch")) {
    		radioButtonAtmospheric.setSelected(true);
    	} else {
    		radioButtonEvaporator.setSelected(true);
    	}
    	if(Context.getFuel().toString().equals("�l")) {
    		radioButtonOil.setSelected(true);
    	} else if (Context.getFuel().toString().equals("Gas")) {
    		radioButtonGas.setSelected(true);
    	} else {
    		radioButtonLiquidGas.setSelected(true);
    	}
    }

    @FXML
    void ActionDetailviewSaveBlower(ActionEvent event) {
        String blowerName = blowerNameField.getText();
        Boolean blower = false;
        Boolean atmospheric = false;
        Boolean evaporator = false;
        
        Boolean oil = false;
        Boolean gas = false;
        Boolean liquidGas = false;
        
        if(radioButtonBlowers.isSelected()) {
        	blower = true;
        } else if (radioButtonAtmospheric.isSelected()) {
        	atmospheric = true;
        } else if (radioButtonEvaporator.isSelected()) {
        	evaporator = true;
        }
        
        if (radioButtonOil.isSelected()) {
        	oil = true;
        } else if(radioButtonGas.isSelected()) {
        	gas = true; 
        } else if (radioButtonLiquidGas.isSelected()) {
        	liquidGas = true;
        }
        
 		try {
			ClientInternRMI feukora = new ClientInternRMI();
			if (blower1 == null) {
				feukora.saveBlower(blowerName, oil, gas, liquidGas, blower, atmospheric, evaporator);
			} else {
				feukora.updateBlower(blowerName, oil, gas, liquidGas, blower, atmospheric, evaporator);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
    }
    
    @FXML
    void ActionDetailviewCancelBlower(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}	
		
    	detailviewCancelBlower.getScene().setRoot(pane);
    }
    

    @FXML
    void ActionRadioButtonLiquidGas(ActionEvent event) {

    }

    @FXML
    void ActionRadioButtonGas(ActionEvent event) {

    }

    @FXML
    void ActionRadioButtonOil(ActionEvent event) {

    }

    @FXML
    void ActionRadioButtonAtmospheric(ActionEvent event) {

    }

    @FXML
    void ActionRadioButtonBlowers(ActionEvent event) {

    }

    @FXML
    void ActionRadioButtonEvaporator(ActionEvent event) {

    }
}
