package rapport.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;

public class ControllerMain implements Initializable{

	private Button rapportstartweiter;
	private Button waermeerzeugerzurueck;
	private Button waermeerzeugerweiter;
	private Button messergebnissezurueck;
	private Button messergebnisseweiter;
	private Button beurteilungzurueck;
	private Button beurteilungspeichern;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

	@FXML
    void ActionRapportStartWeiter(ActionEvent event) {
    }
	
	void ActionWaermeerzeugerZurueck(ActionEvent event) {

    }
	
	void ActionWaermeerzeugerWeiter(ActionEvent event) {
    }
	
	void ActionMessergebnisseZurueck(ActionEvent event) {
    }
	
	void ActionMessergebnisseWeiter(ActionEvent event) {
    }
	
	void ActionBeurteilungZurueck(ActionEvent event) {
    }
	
	void ActionBeurteilungSpeichern(ActionEvent event) {
    }
	
	
	
}
