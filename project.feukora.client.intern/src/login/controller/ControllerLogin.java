package login.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;

public class ControllerLogin {

    @FXML
    private TextField usernameLoginTextfield;

    @FXML
    private TextField passwordLoginTextfield;

    @FXML
    private Button loginLogin;

    @FXML
    private Button passwordForgetLogin;

    @FXML
    void ActionUsernameLoginTextfield(ActionEvent event) {

    }

    @FXML
    void ActionPasswordLoginTextfield(ActionEvent event) {
    	BorderPane pane = new BorderPane();
    	
		String username = usernameLoginTextfield.getText();
		String password = passwordLoginTextfield.getText();
		
		

    	try {
    		ClientInternRMI feukora = new ClientInternRMI();
    		Boolean successfull = feukora.login(username, password);
    		
    		if(successfull == true){
    			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));
    		}else{
    			pane = FXMLLoader.load(getClass().getClassLoader().getResource("login/view/loginPane.fxml"));
    			usernameLoginTextfield.clear();
    			passwordLoginTextfield.clear();
    		}
    		
			} catch (Exception e) {
			e.printStackTrace();
		}	
    	
    	loginLogin.getScene().setRoot(pane);
    }

    @FXML
    void ActionLoginLogin(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
		String username = usernameLoginTextfield.getText();
		String password = passwordLoginTextfield.getText();
		
		

    	try {
    		ClientInternRMI feukora = new ClientInternRMI();
    		Boolean successfull = feukora.login(username, password);
    		
    		if(successfull == true){
    			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));
    		}else{
    			pane = FXMLLoader.load(getClass().getClassLoader().getResource("login/view/loginPane.fxml"));
    			usernameLoginTextfield.clear();
    			passwordLoginTextfield.clear();
    		}
    		
			} catch (Exception e) {
			e.printStackTrace();
		}	
    	
    	loginLogin.getScene().setRoot(pane);
    }
    
    @FXML
    void ActionPasswordForgetLogin(ActionEvent event) {
		String titleBar = "Passwort vergessen?";
		String headerMessage = "Melden Sie sich f�rs Zur�cksetzen beim Administrator:";
		String infoMessage = "Telefon: 081 407 11 11 Email: admin@test.ch";
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
}
