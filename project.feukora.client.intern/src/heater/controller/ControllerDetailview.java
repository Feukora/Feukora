package heater.controller;

import org.apache.log4j.Logger;
import application.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Heater;

/**
 * Controller for the heaters detailview.
 * @author Pascal
 * @version 1.5
 *
 */
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

	public void initialize() {

		if(Context.getHeater() != null) {
			Update();
		} else {

		}
	}

	/**
	 * method to save a record
	 * @param event
	 */
	@FXML
	void ActionDetailviewSaveHeater(ActionEvent event) {
		Heater heater = Context.getHeater();
		String heatername = heaterNameField.getText();
		try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(heatername.isEmpty() == false){
				if(heater == null) {
					Heater entity = new Heater(heatername);
					feukora.saveHeater(entity);
				} else {
					heater.setName(heatername);
					feukora.updateHeater(heater);
				}

				heaterNameField.clear();

			} else {
				errorInfoNeu();
			}
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}    
	}



	/**
	 * method to get the data of the chosen record
	 */
	public void Update(){
		heaterNameField.setText(Context.getHeaterName());
		Context.setNull();	
	}

	/**
	 * method to cancel the action
	 * @param event
	 */
	@FXML
	void ActionDetailviewCancelHeater(ActionEvent event) {
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

		detailviewCancelHeater.getScene().setRoot(pane);
	}

	/**
	 * method to show error message
	 */
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
}
