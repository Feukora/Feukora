package blower.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.rmi.BlowerRMIImpl;

public class ControllerDetailview {

    @FXML
    private Button detailviewSaveBlower;

    @FXML
    private TextField blowerYearManufactureField;

    @FXML
    private TextField blowerTypeField;

    @FXML
    private TextField blowerNameField;

    @FXML
    private TextField blowerModellField;

    @FXML
    void ActionBlowerNameField(ActionEvent event) {

    }

    @FXML
    void ActionBlowerModellField(ActionEvent event) {

    }

    @FXML
    void ActionBlowerTypeField(ActionEvent event) {

    }

    @FXML
    void ActionBlowerYearManufactureField(ActionEvent event) {

    }

    @FXML
    void ActionDetailviewSaveBlower(ActionEvent event) {
    	String manufactureYear = blowerYearManufactureField.getText();
    	String blowerModel = blowerModellField.getText();
        String blowerType = blowerTypeField.getText();
        String blowerName = blowerNameField.getText();
        
        Blowertype bt;
        bt.setName(blowerType);
        
        Fuel bm;
        bm.setName(blowerModel);
        
 		ClientInternRMI test = new ClientInternRMI();
    }
}
