package assistant.controller;

import javafx.event.ActionEvent;

/**
 * Sample Skeleton for 'assistantOverview.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControllerOverview {

    @FXML // fx:id="overviewDeleteAssistant"
    private Button overviewDeleteAssistant; // Value injected by FXMLLoader
    
    @FXML // fx:id="overviewRefreshAssistant"
    private Button overviewRefreshAssistant; // Value injected by FXMLLoader
    
    @FXML // fx:id="overviewTableAssistant"
    private TableView<?> overviewTableAssistant; // Value injected by FXMLLoader

    @FXML // fx:id="columnEmailAssistant"
    private TableColumn<?, ?> columnEmailAssistant; // Value injected by FXMLLoader

    @FXML // fx:id="columnUsernameAssistant"
    private TableColumn<?, ?> columnUsernameAssistant; // Value injected by FXMLLoader

    @FXML // fx:id="columnPhoneAssistant"
    private TableColumn<?, ?> columnPhoneAssistant; // Value injected by FXMLLoader

    @FXML // fx:id="columnFirstnameAssistant"
    private TableColumn<?, ?> columnFirstnameAssistant; // Value injected by FXMLLoader

    @FXML // fx:id="columnZIPAssistant"
    private TableColumn<?, ?> columnZIPAssistant; // Value injected by FXMLLoader

    @FXML // fx:id="columnNameAssistant"
    private TableColumn<?, ?> columnNameAssistant; // Value injected by FXMLLoader

    @FXML // fx:id="columnAddressAssistant"
    private TableColumn<?, ?> columnAddressAssistant; // Value injected by FXMLLoader

    @FXML // Methode für die Tabelle
    void ActionOverviewTableAssistant(ActionEvent event) {

    }

    @FXML
    void ActionOverviewDeleteAssistant(ActionEvent event) {

    }

    @FXML
    void ActionOverviewRefreshAssistant(ActionEvent event) {

    }

}
