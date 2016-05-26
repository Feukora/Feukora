package login.controller;

import org.apache.log4j.Logger;


import application.Context;
import inspector.controller.ControllerDetailview;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;

/**
 * Controller for the login.
 * @author Pascal
 * @version 1.7
 *
 */
public class ControllerLogin {

	private static final Logger logger = Logger
			.getLogger(ControllerLogin.class);

	@FXML
	private TextField usernameLoginTextfield;

	@FXML
	private PasswordField passwordLoginTextfield;

	@FXML
	private Button loginLogin;

	@FXML
	private Button passwordForgetLogin;

	@FXML
	void ActionUsernameLoginTextfield(ActionEvent event) {

	}

	/**
	 * method to check username and password
	 * @param event
	 */
	@FXML
	void ActionPasswordLoginTextfield(ActionEvent event) {
		BorderPane pane = new BorderPane();

		String username = usernameLoginTextfield.getText();
		String password = passwordLoginTextfield.getText();

		try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(username.isEmpty() == false && password.isEmpty() == false){

				Boolean successfull = feukora.login(username, password);

				if(successfull == true){
					String role = feukora.authentication(username);
					Context.setRole(role);
					if(role.equals("Administrator")) {
						pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));
					} else if (role.equals("Feuerungskontrolleur")) {
						pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewInspector.fxml"));
					} else if (role.equals("Sachbearbeiter")) {
						pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAssistant.fxml"));
					}

				}else{
					pane = FXMLLoader.load(getClass().getClassLoader().getResource("login/view/loginPane.fxml"));
					usernameLoginTextfield.clear();
					passwordLoginTextfield.clear();
					String titleBar = "Uups!! Passwort falsch";
					String headerMessage = "Passwort oder Benutzename ist falsch";
					String infoMessage = "-";
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(titleBar);
					alert.setHeaderText(headerMessage);
					alert.setContentText(infoMessage);
					alert.showAndWait();
				}
			}else{
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("login/view/loginPane.fxml"));
				usernameLoginTextfield.clear();
				passwordLoginTextfield.clear();
				String titleBar = "Nichts eingegeben";
				String headerMessage = "Passwort und Benutzername eingeben";
				String infoMessage = "-";
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(titleBar);
				alert.setHeaderText(headerMessage);
				alert.setContentText(infoMessage);
				alert.showAndWait();
			}
		} catch (Exception e) {
			logger.error("Login fehlgeschlagen\'",
					e);
		}


		loginLogin.getScene().setRoot(pane);
	}

	/**
	 * button to start the method that varifies the username and password
	 * @param event
	 */
	@FXML
	void ActionLoginLogin(ActionEvent event) {
		BorderPane pane = new BorderPane();

		String username = usernameLoginTextfield.getText();
		String password = passwordLoginTextfield.getText();

		try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(username.isEmpty() == false && password.isEmpty() == false){
				
				Boolean successfull = feukora.login(username, password);

				if(successfull == true){
					pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));
				}else{
					pane = FXMLLoader.load(getClass().getClassLoader().getResource("login/view/loginPane.fxml"));
					usernameLoginTextfield.clear();
					passwordLoginTextfield.clear();
					String titleBar = "Uups!! Passwort falsch";
					String headerMessage = "Passwort oder Benutzename ist falsch";
					String infoMessage = "-";
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(titleBar);
					alert.setHeaderText(headerMessage);
					alert.setContentText(infoMessage);
					alert.showAndWait();
				}
			}else{
				pane = FXMLLoader.load(getClass().getClassLoader().getResource("login/view/loginPane.fxml"));
				usernameLoginTextfield.clear();
				passwordLoginTextfield.clear();
				String titleBar = "Nichts eingegeben";
				String headerMessage = "Passwort und Benutzername eingeben";
				String infoMessage = "-";
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(titleBar);
				alert.setHeaderText(headerMessage);
				alert.setContentText(infoMessage);
				alert.showAndWait();
			}
		} catch (Exception e) {
			logger.error("Login fehlgeschlagen\'",
					e);
		}	

		loginLogin.getScene().setRoot(pane);
	}

	/**
	 * method when the user forgets the password
	 * @param event
	 */
	@FXML
	void ActionPasswordForgetLogin(ActionEvent event) {
		String titleBar = "Passwort vergessen?";
		String headerMessage = "Melden Sie sich fürs Zurücksetzen beim Administrator:";
		String infoMessage = "Telefon: 081 407 11 11 Email: admin@test.ch";
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}
}