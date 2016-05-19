package inspector.controller;

/**
 * Sample Skeleton for 'inspectorOverview.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControllerOverview {

    @FXML // fx:id="overviewDeleteInspector"
    private Button overviewDeleteInspector; // Value injected by FXMLLoader

    @FXML // fx:id="overviewRefreshInspector"
    private Button overviewRefreshInspector; // Value injected by FXMLLoader

    @FXML // fx:id="overviewTableInspector"
    private TableView<?> overviewTableInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnUsernameInspector"
    private TableColumn<?, ?> columnUsernameInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnNameInspector"
    private TableColumn<?, ?> columnNameInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnFirstnameInspector"
    private TableColumn<?, ?> columnFirstnameInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnZIPInspector"
    private TableColumn<?, ?> columnZIPInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnAddressInspector"
    private TableColumn<?, ?> columnAddressInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnPhoneInspector"
    private TableColumn<?, ?> columnPhoneInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnEmailInspector"
    private TableColumn<?, ?> columnEmailInspector; // Value injected by FXMLLoader

    @FXML // Methode für die Tabelle
    void ActionOverviewTableInspector(ActionEvent event) {

    }

    @FXML
    void ActionOverviewDeleteInspector(ActionEvent event) {

    }

    @FXML
    void ActionOverviewRefreshInspector(ActionEvent event) {

    }

}
