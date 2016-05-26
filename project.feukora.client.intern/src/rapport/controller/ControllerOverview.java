package rapport.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.log4j.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
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
	private TableColumn<Rapport, Boolean> overviewTableResult = new TableColumn<>("results");

	@FXML
	private TableColumn<Rapport, String> overviewTableCustomer;

	@FXML
	private TableColumn<Rapport, String> overviewTableInspector;

	@FXML
	private TableColumn<Rapport, Calendar> overviewTableDate = new TableColumn<>("measuringdate");

	@FXML
	public TableView<Rapport> overviewTableRapport; // Value injected by FXMLLoader
    
	@FXML
	public void initialize() {
		 try {
				ClientInternRMI feukora = new ClientInternRMI();
				rapport = feukora.getRapports();
				
				overviewTableCustomer.setCellValueFactory(
						new PropertyValueFactory<Rapport, String>("customerheater")
				);
				
				overviewTableDate.setCellValueFactory(
						new PropertyValueFactory<Rapport, Calendar>("measuringdate")
				);
				
				final DateFormat dateFormat = DateFormat.getDateInstance();
				overviewTableDate.setCellFactory(col -> new TableCell<Rapport, Calendar>(){
							@Override
							public void updateItem(Calendar item, boolean empty) {
							super.updateItem(item, empty);
							if (item == null) {
								setText(null);
							} else {
								setText(dateFormat.format(item.getTime()));
							}
						}	
						});

				overviewTableControlltype.setCellValueFactory(
						new PropertyValueFactory<Rapport, String>("controltype")
				);
				
				overviewTableResult.setCellValueFactory(
						new PropertyValueFactory<Rapport, Boolean>("results")
				);
				
				overviewTableResult.setCellFactory(col -> new TableCell<Rapport, Boolean>(){
					@Override
					public void updateItem(Boolean result, boolean empty) {
					super.updateItem(result, empty);
					if (result == null) {
						setText(null);
					} else if(result == true) {
						setText("Bestanden");
					} else {
						setText("Nicht bestanden");
					}
				}	
				});

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
		ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
	    	Rapport entity = overviewTableRapport.getSelectionModel().getSelectedItem();
	    	feukora.deleteRapport(entity);
		} catch (Exception e) {
			String titleBar = "Achtung";
			String headerMessage = "Benutzer kann nicht gelöscht werden";
			String infoMessage = "Es bestehen noch Verbindungen dieses Benutzer";
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle(titleBar);
	        alert.setHeaderText(headerMessage);
	        alert.setContentText(infoMessage);
	        alert.showAndWait();
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
		initialize();
	}

	@FXML
	void ActionOverviewRefreshRapport(ActionEvent event) {
		initialize();
	}

	@FXML
	void ActionOverviewUpdateRapport(ActionEvent event) {

	}

}
