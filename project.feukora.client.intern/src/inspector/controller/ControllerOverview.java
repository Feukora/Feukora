package inspector.controller;

import java.rmi.RemoteException;

/**
 * Sample Skeleton for 'inspectorOverview.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Users;

public class ControllerOverview {

    @FXML // fx:id="overviewDeleteInspector"
    private Button overviewDeleteInspector; // Value injected by FXMLLoader

    @FXML // fx:id="overviewRefreshInspector"
    private Button overviewRefreshInspector; // Value injected by FXMLLoader

    @FXML // fx:id="overviewTableInspector"
    private TableView<Users> overviewTableInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnUsernameInspector"
    private TableColumn<Users, String> columnUsernameInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnNameInspector"
    private TableColumn<Users, String> columnNameInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnFirstnameInspector"
    private TableColumn<Users, String> columnFirstnameInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnZIPInspector"
    private TableColumn<Users, String> columnZIPInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnAddressInspector"
    private TableColumn<Users, String> columnAddressInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnPhoneInspector"
    private TableColumn<Users, String> columnPhoneInspector; // Value injected by FXMLLoader

    @FXML // fx:id="columnEmailInspector"
    private TableColumn<Users, String> columnEmailInspector; // Value injected by FXMLLoader

    @FXML // Methode für die Tabelle
    void ActionOverviewTableInspector(ActionEvent event) {

    }

    @FXML
    void ActionOverviewDeleteInspector(ActionEvent event) {
    	ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
	    	Users entity = overviewTableInspector.getSelectionModel().getSelectedItem();
	    	feukora.deleteUser(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void ActionOverviewRefreshInspector(ActionEvent event) {

    }

}


