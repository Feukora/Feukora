package rapport.controller;

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Rapport;


public class ControllerOverview {

	private static final Logger logger = Logger
			.getLogger(ControllerOverview.class);
	
	public ObservableList<Rapport> rapport = FXCollections.observableArrayList();
	
	@FXML
	private Button overviewDeleteRapport;

	@FXML
	private Button overviewUpdateRapport;

	@FXML
	private Button overviewRefreshRapport;

	@FXML
	private TableColumn<Rapport, String> overviewTableControlltype;

	@FXML
	private TableColumn<Rapport, Boolean> overviewTableResult;

	@FXML
	private TableColumn<Rapport, String> overviewTableCustomer;

	@FXML
	private TableColumn<Rapport, String> overviewTableInspector;

	@FXML
	private TableColumn<Rapport, String> overviewTableDate;

	@FXML
	public TableView<Rapport> overviewTableRapport; // Value injected by FXMLLoader
    
	@FXML
	public void initialize() {
		 try {
				ClientInternRMI feukora = new ClientInternRMI();
				rapport = feukora.getRapports();
				
				overviewTableCustomer.setCellValueFactory(
						new PropertyValueFactory<Rapport, String>("customer")
				);
				
				overviewTableDate.setCellValueFactory(
						new PropertyValueFactory<Rapport, String>("date")
				);
				
				overviewTableControlltype.setCellValueFactory(
						new PropertyValueFactory<Rapport, String>("controltype")
				);
				
				overviewTableResult.setCellValueFactory(
						new PropertyValueFactory<Rapport, Boolean>("results")
				);

				overviewTableInspector.setCellValueFactory(
						new PropertyValueFactory<Rapport, String>("inspector")
				);

				
				overviewTableRapport.setItems(rapport);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Aktion konnte nicht durchgeführt werden\'",
						e);
			}
	}

	@FXML
	void ActionOverviewTableRapport(ActionEvent event) {

	}
	
	@FXML
	void ActionOverviewDeleteRapport(ActionEvent event) {

	}

	@FXML
	void ActionOverviewRefreshRapport(ActionEvent event) {

	}

	@FXML
	void ActionOverviewUpdateRapport(ActionEvent event) {

	}

}
