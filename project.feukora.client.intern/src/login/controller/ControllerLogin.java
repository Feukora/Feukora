package login.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

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

    }

    @FXML
    void ActionLoginLogin(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewInspector.fxml"));

			} catch (Exception e) {
			e.printStackTrace();
		}	
    	
    	loginLogin.getScene().setRoot(pane);
    }

    @FXML
    void ActionPasswordForgetLogin(ActionEvent event) {

    }

}
