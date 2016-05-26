package blower.controller;

import org.apache.log4j.Logger;
import application.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Blower;

/**
 * 
 * Controller for Blower Detailview
 * @author Pascal
 * @version 1.5
 *
 */
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
		setToggleGroup();
		if(Context.getBlowername() != null){
			Update();
		} else {

		}
	}

	/**
	 * method to bind radiobuttons together
	 */
	public void setToggleGroup() {
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

	public void errorInfoNeu(){
		String titleBar = "Achtung";
		String headerMessage = "Bitte alle Daten eingeben";
		String infoMessage = "Eingabe nicht vollständig";
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}

	/**
	 * method to get the data of the chosen record
	 */
	public void Update() {
		blower1 = Context.getBlower();
		blowerNameField.setText(Context.getBlowername());
		if(Context.getBlowerType().toString().equals("Gebläse")) {
			radioButtonBlowers.setSelected(true);
		} else if (Context.getBlowerType().toString().equals("Athmosphärisch")) {
			radioButtonAtmospheric.setSelected(true);
		} else if (Context.getBlowerType().toString().equals("Verdampfer")){
			radioButtonEvaporator.setSelected(true);
		} 
		if(Context.getFuel().toString().equals("Öl")) {
			radioButtonOil.setSelected(true);
		} else if (Context.getFuel().toString().equals("Erdgas")) {
			radioButtonGas.setSelected(true);
		} else if (Context.getFuel().toString().equals("Flüssiggas")){
			radioButtonLiquidGas.setSelected(true);
		}
		Context.setNull();
	}

	/**
	 * method to update the the selected record
	 * @param event
	 */
	@FXML
	void ActionDetailviewSaveBlower(ActionEvent event) {
		String blowerName = blowerNameField.getText();
		Blower blower = Context.getBlower();
		Boolean bblower = false;
		Boolean atmospheric = false;
		Boolean evaporator = false;

		Boolean oil = false;
		Boolean gas = false;
		Boolean liquidGas = false;

		if(radioButtonBlowers.isSelected()) {
			bblower = true;
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
			if(bblower == true | atmospheric == true | evaporator == true && oil == true | gas == true | liquidGas == true && blowerName.isEmpty() == false){
				if (blower1 == null) {
					feukora.saveBlower(blowerName, oil, gas, liquidGas, bblower, atmospheric, evaporator);
				} else {
					feukora.updateBlower(blower, blowerName, oil, gas, liquidGas, bblower, atmospheric, evaporator);
				}
				blowerNameField.clear();
				radioButtonBlowers.setSelected(false);
				radioButtonAtmospheric.setSelected(false);
				radioButtonEvaporator.setSelected(false);
				radioButtonOil.setSelected(false);
				radioButtonGas.setSelected(false);
				radioButtonLiquidGas.setSelected(false);
			}else{
				errorInfoNeu();
			}

		} catch (Exception e) {
			errorInfoNeu();
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}

	/**
	 * method to cancel the action
	 * @param event
	 */
	@FXML
	void ActionDetailviewCancelBlower(ActionEvent event) {
		BorderPane pane = new BorderPane();

		try {
			if(Context.getRole().equals("Administrator")) {
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));
			} else if (Context.getRole().equals("Sachbearbeiter")) {
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAssistant.fxml"));
			}

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
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
