package rapport.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.log4j.Logger;
import application.Context;
import customer.controller.ControllerDetailview;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.model.Measuringresult;
import projekt.feukora.server.model.Rapport;

/**
 * Mainmenu for the rapport. 
 * @author Sandro and Pascal
 * @version 1.3
 *
 */
public class ControllerMain {

	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

	private Rapport rapport = null;
	private Customerheater customerheater;
	private Customer customer;
	private Facilitymanager facilitymanager;
	private Controltype type;
	private Measuringresult measuringresult;

	//Togglegroup for tab: Start
	final ToggleGroup start = new ToggleGroup();

	//Togglegroup for tab: Heater/Blower
	final ToggleGroup heaterfuel = new ToggleGroup();
	final ToggleGroup controltype = new ToggleGroup();
	final ToggleGroup blowertype = new ToggleGroup();
	final ToggleGroup oilpart1 = new ToggleGroup();
	final ToggleGroup oilpart2 = new ToggleGroup();
	final ToggleGroup oilpart3 = new ToggleGroup();
	final ToggleGroup oilpart4 = new ToggleGroup();
	final ToggleGroup result = new ToggleGroup();
	final ToggleGroup additionalsteps = new ToggleGroup();

	@FXML
	private TextField textfieldCanton;

	@FXML
	private TextField textfieldaddress;

	@FXML
	private TextField textfieldfacilitymanager;

	@FXML
	private ComboBox<String> comboboxOwnerAdministration;

	@FXML
	private TextField textfieldheateryear;

	@FXML
	private TextField textfieldbloweryear;

	@FXML
	private TextField textfieldheatinput;

	@FXML
	private ComboBox<String> comboboxheatertype;

	@FXML
	private RadioButton radioroutinecontrol;

	@FXML
	private RadioButton radioacceptanceinspection;

	@FXML
	private ComboBox<String> comboboxblowertype;

	@FXML
	private DatePicker measuringdate;

	@FXML
	private TextField textfieldsmokenumber1;

	@FXML
	private TextField textfieldsmokenumber2;

	@FXML
	private TextField textfieldsmokenumber3;

	@FXML
	private TextField textfieldsmokenumber4;

	@FXML
	private TextField textfielcarbonmonoxide1;

	@FXML
	private TextField textfielcarbonmonoxide2;

	@FXML
	private TextField textfielcarbonmonoxide3;

	@FXML
	private TextField textfielcarbonmonoxide4;

	@FXML
	private TextField textfieldnitrogendioxide1;

	@FXML
	private RadioButton radiooilpartno1;

	@FXML
	private RadioButton radiooilpartno2;

	@FXML
	private RadioButton radiooilpartno3;

	@FXML
	private RadioButton radiooilpartno4;

	@FXML
	private RadioButton radiooilpartyes1;

	@FXML
	private RadioButton radiooilpartyes2;

	@FXML
	private RadioButton radiooilpartyes3;

	@FXML
	private RadioButton radiooilpartyes4;

	@FXML
	private TextField textfieldnitrogendioxide2;

	@FXML
	private TextField textfieldnitrogendioxide3;

	@FXML
	private TextField textfieldnitrogendioxide4;

	@FXML
	private TextField textfieldexhaustgastemp1;

	@FXML
	private TextField textfieldexhaustgastemp2;

	@FXML
	private TextField textfieldexhaustgastemp3;

	@FXML
	private TextField textfieldexhaustgastemp4;

	@FXML
	private TextField textfieldheatertemp1;

	@FXML
	private TextField textfieldheatertemp2;

	@FXML
	private TextField textfieldheatertemp3;

	@FXML
	private TextField textfieldheatertemp4;

	@FXML
	private TextField textfieldblowertemp1;

	@FXML
	private TextField textfieldblowertemp2;

	@FXML
	private TextField textfieldblowertemp3;

	@FXML
	private TextField textfieldblowertemp4;

	@FXML
	private TextField textfieldoxygen1;

	@FXML
	private TextField textfieldoxygen2;

	@FXML
	private TextField textfieldoxygen3;

	@FXML
	private TextField textfieldoxygen4;

	@FXML
	private TextField textfieldexhaustgasloss1;

	@FXML
	private TextField textfieldexhaustgasloss2;

	@FXML
	private TextField textfieldexhaustgasloss3;

	@FXML
	private TextField textfieldexhaustgasloss4;

	@FXML
	private RadioButton radionotransgression;

	@FXML
	private RadioButton radiotransgression;

	@FXML
	private CheckBox checkboxsmokenumbertransgression;

	@FXML
	private CheckBox checkbockoilparttransgression;

	@FXML
	private CheckBox checkboxcarbonmonoxidetransgression;

	@FXML
	private CheckBox checkboxnitrogendioxidetransgression;

	@FXML
	private CheckBox checkboxexhaustlosstransgression;

	@FXML
	private RadioButton radioadditionalstepsno;

	@FXML
	private RadioButton radioadditionalstepsyes;

	@FXML
	private TextField textfieldpersonalcode;

	@FXML
	private TextArea textareacomments;

	@FXML
	private Button rapportsave;

	public void initialize() {

		//Togglegroup handling for: Heater/Blower (Controltype)
		radioroutinecontrol.setToggleGroup(controltype);
		radioacceptanceinspection.setToggleGroup(controltype);
		radioroutinecontrol.setSelected(false);
		radioacceptanceinspection.setSelected(false);

		//Togglegroup handling for: Oilpart measuring Step 1
		radiooilpartyes1.setToggleGroup(oilpart1);
		radiooilpartno1.setToggleGroup(oilpart1);
		radiooilpartyes1.setSelected(false);
		radiooilpartno1.setSelected(false);

		//Togglegroup handling for: Oilpart measuring Step 2
		radiooilpartyes2.setToggleGroup(oilpart2);
		radiooilpartno2.setToggleGroup(oilpart2);
		radiooilpartyes2.setSelected(false);
		radiooilpartno2.setSelected(false);

		//Togglegroup handling for: Oilpart measuring Step 3
		radiooilpartyes3.setToggleGroup(oilpart3);
		radiooilpartno3.setToggleGroup(oilpart3);
		radiooilpartyes3.setSelected(false);
		radiooilpartno3.setSelected(false);

		//Togglegroup handling for: Oilpart measuring Step 4
		radiooilpartyes4.setToggleGroup(oilpart4);
		radiooilpartno4.setToggleGroup(oilpart4);
		radiooilpartyes4.setSelected(false);
		radiooilpartno4.setSelected(false);

		//Togglegroup handling for: Results
		radiotransgression.setToggleGroup(result);
		radionotransgression.setToggleGroup(result);
		radiotransgression.setSelected(false);
		radionotransgression.setSelected(false);

		//Togglegroup handling for: Additional steps
		radioadditionalstepsyes.setToggleGroup(additionalsteps);
		radioadditionalstepsno.setToggleGroup(additionalsteps);
		radioadditionalstepsyes.setSelected(false);
		radioadditionalstepsno.setSelected(false);

		ClientInternRMI feukora;
		try {
			feukora = new ClientInternRMI();
			ObservableList<String> customerNames = FXCollections.observableArrayList();
			ObservableList<Customer> customers = feukora.getCustomers();
			int i = 0;
			while (i < customers.size()) {
				String lastname = customers.get(i).getLastname();
				String firstname = customers.get(i).getFirstname();
				String name = lastname + " " + firstname;
				customerNames.add(name);			
				i++;
			}

			ObservableList<String> heaterNames = FXCollections.observableArrayList();
			ObservableList<Heater> heaters = feukora.getHeaters();
			int j = 0;
			while (j < heaters.size()) {
				String name = heaters.get(j).toString();
				heaterNames.add(name);			
				j++;
			}

			ObservableList<String> blowerNames = FXCollections.observableArrayList();
			ObservableList<Blower> blowers = feukora.getBlowers();
			int k = 0;
			while (k < blowers.size()) {
				String name = blowers.get(k).toString();
				blowerNames.add(name);			
				k++;
			}

			comboboxOwnerAdministration.setItems(customerNames);
			comboboxheatertype.setItems(heaterNames);
			comboboxblowertype.setItems(blowerNames);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if(Context.getRapportid() != null){
			Update();
		}else {
		}

	}

	/**
	 * method to save a rapport
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void ActionRapportSave(ActionEvent event) throws IOException {

		String canton = textfieldCanton.getText();
		String adress = textfieldaddress.getText();
		String customer = comboboxOwnerAdministration.getValue();
		String facilitymanager = textfieldfacilitymanager.getText();

		// Tab 2
		String manufactureyearheater = textfieldheateryear.getText();
		Integer heateryear = Integer.parseInt(manufactureyearheater);
		String heatertype = comboboxheatertype.getSelectionModel().getSelectedItem().toString();
		String ctype = null;
		if(radioroutinecontrol.isSelected() == true){
			ctype = "Routinekontrolle"; 
		}else if(radioacceptanceinspection.isSelected() == true){
			ctype = "Abnahmekontrolle";
		}

		String manufactureyearblower = textfieldbloweryear.getText();
		Integer bloweryear = Integer.parseInt(manufactureyearblower);
		String blowertype = comboboxblowertype.getSelectionModel().getSelectedItem().toString();
		String performance = textfieldheatinput.getText();

		//Tab 3
		LocalDate date = measuringdate.getValue();
		Date utilDate = Date.from( date.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		GregorianCalendar gdate = new GregorianCalendar();
		gdate.setTime(utilDate);

		String smokenumber1 = textfieldsmokenumber1.getText();
		String smokenumber2 = textfieldsmokenumber1.getText();
		String smokenumber3 = textfieldsmokenumber1.getText();
		String smokenumber4 = textfieldsmokenumber1.getText();

		String carbonmonoxide1 = textfielcarbonmonoxide1.getText();
		String carbonmonoxide2 = textfielcarbonmonoxide2.getText();
		String carbonmonoxide3 = textfielcarbonmonoxide3.getText();
		String carbonmonoxide4 = textfielcarbonmonoxide4.getText();

		String nitrogendioxide1 = textfieldnitrogendioxide1.getText();
		String nitrogendioxide2 = textfieldnitrogendioxide2.getText();
		String nitrogendioxide3 = textfieldnitrogendioxide3.getText();
		String nitrogendioxide4 = textfieldnitrogendioxide4.getText();

		String exhaustgastemp1 = textfieldexhaustgastemp1.getText();
		String exhaustgastemp2 = textfieldexhaustgastemp2.getText();
		String exhaustgastemp3 = textfieldexhaustgastemp3.getText();
		String exhaustgastemp4 = textfieldexhaustgastemp4.getText();

		String heatertemp1 = textfieldheatertemp1.getText();
		String heatertemp2 = textfieldheatertemp2.getText();
		String heatertemp3 = textfieldheatertemp3.getText();
		String heatertemp4 = textfieldheatertemp4.getText();

		String blowertemp1 = textfieldblowertemp1.getText();
		String blowertemp2 = textfieldblowertemp2.getText();
		String blowertemp3 = textfieldblowertemp3.getText();
		String blowertemp4 = textfieldblowertemp4.getText();

		String oxygen1 = textfieldoxygen1.getText();
		String oxygen2 = textfieldoxygen2.getText();
		String oxygen3 = textfieldoxygen3.getText();
		String oxygen4 = textfieldoxygen4.getText();

		String exhaustgaslost1 = textfieldexhaustgasloss1.getText();
		String exhaustgaslost2 = textfieldexhaustgasloss2.getText();
		String exhaustgaslost3 = textfieldexhaustgasloss3.getText();
		String exhaustgaslost4 = textfieldexhaustgasloss4.getText();

		Boolean oilpart1 = false;
		Boolean oilpart2 = false;
		Boolean oilpart3 = false;
		Boolean oilpart4 = false;

		if(radiooilpartyes1.isSelected()){
			oilpart1 = true;
		} else if(radiooilpartno1.isSelected()){
			oilpart1 = false;
		}

		if(radiooilpartyes2.isSelected()){
			oilpart2 = true;
		} else if(radiooilpartno2.isSelected()){
			oilpart2 = false;
		}

		if(radiooilpartyes3.isSelected()){
			oilpart3 = true;
		} else if(radiooilpartno3.isSelected()){
			oilpart3 = false;
		}

		if(radiooilpartyes4.isSelected()){
			oilpart4 = true;
		} else if(radiooilpartno4.isSelected()){
			oilpart4 = false;
		}

		//Tab 4
		Boolean result = false;
		if(radionotransgression.isSelected()){
			result = true;
		} else if(radiotransgression.isSelected()){
			result = false;
		}

		Boolean smokenumber = false;
		Boolean oilpart = false;
		Boolean carbonmonoxide = false;
		Boolean nitrogendioxide = false;
		Boolean exhaustgaslost = false;

		if(checkboxsmokenumbertransgression.isSelected()){
			smokenumber = true;
		} else{
			smokenumber = false;
		}
		if(checkbockoilparttransgression.isSelected()){
			oilpart = true;
		} else{
			oilpart = false;
		}
		if(checkboxcarbonmonoxidetransgression.isSelected()){
			carbonmonoxide = true;
		} else{
			carbonmonoxide = false;
		}
		if(checkboxnitrogendioxidetransgression.isSelected()){
			nitrogendioxide = true;
		} else{
			nitrogendioxide = false;
		}
		if(checkboxexhaustlosstransgression.isSelected()){
			exhaustgaslost = true;
		} else{
			exhaustgaslost = false;
		}

		Boolean additionalsteps = false;
		if(radioadditionalstepsyes.isSelected()){
			additionalsteps = true;
		}else if (radioadditionalstepsno.isSelected()){
			additionalsteps = false;
		}

		String comment = textareacomments.getText();

		String persNumber = textfieldpersonalcode.getText();

		try {
			ClientInternRMI feukora = new ClientInternRMI();

			if(canton.isEmpty() == false && adress.isEmpty() == false && facilitymanager.isEmpty() == false && heateryear != null && ctype.isEmpty() == false &&
					bloweryear != null && performance.isEmpty() == false && gdate.getTime() != null && smokenumber1.isEmpty() == false && smokenumber2.isEmpty() == false && smokenumber3.isEmpty() == false && smokenumber4.isEmpty() == false &&
					carbonmonoxide1.isEmpty() == false && carbonmonoxide2.isEmpty() == false && carbonmonoxide3.isEmpty() == false && carbonmonoxide4.isEmpty() == false &&
					nitrogendioxide1.isEmpty() == false && nitrogendioxide2.isEmpty() == false && nitrogendioxide3.isEmpty() == false && nitrogendioxide4.isEmpty() == false &&
					exhaustgastemp1.isEmpty() == false && exhaustgastemp2.isEmpty() == false && exhaustgastemp3.isEmpty() == false && exhaustgastemp4.isEmpty() == false &&
					heatertemp1.isEmpty() == false && heatertemp2.isEmpty() == false && heatertemp4.isEmpty()  == false && heatertemp4.isEmpty() == false &&
					blowertemp1.isEmpty() == false && blowertemp2.isEmpty() == false && blowertemp3.isEmpty() == false && blowertemp4.isEmpty() == false &&
					oxygen1.isEmpty() == false && oxygen2.isEmpty() == false && oxygen3.isEmpty() == false && oxygen4.isEmpty() == false &&
					exhaustgaslost1.isEmpty() == false && exhaustgaslost2.isEmpty() == false && exhaustgaslost3.isEmpty() == false && exhaustgaslost4.isEmpty() == false &&
					radiooilpartyes1.isSelected() == false || radiooilpartno1.isSelected() == false && radiooilpartyes2.isSelected() == false || radiooilpartno2.isSelected() == false && radiooilpartyes3.isSelected() == false || radiooilpartno3.isSelected() == false && radiooilpartyes4.isSelected() == false || radiooilpartno4.isSelected() == false &&
					radionotransgression.isSelected() == false || radiotransgression.isSelected() == false && checkboxsmokenumbertransgression.isSelected() == false || checkbockoilparttransgression.isSelected() == false || checkboxcarbonmonoxidetransgression.isSelected() == false || checkboxnitrogendioxidetransgression.isSelected() == false || checkboxexhaustlosstransgression.isSelected() == false && radioadditionalstepsyes.isSelected() == false || radioadditionalstepsno.isSelected() == false && comment.isEmpty() == false && persNumber.isEmpty() == false) {

				if(rapport == null){

					feukora.saveRapport(canton, adress, customer, facilitymanager, heateryear, heatertype, ctype, bloweryear, blowertype, performance, gdate,
							smokenumber1, smokenumber2, smokenumber3, smokenumber4,
							carbonmonoxide1, carbonmonoxide2, carbonmonoxide3, carbonmonoxide4,
							nitrogendioxide1, nitrogendioxide2, nitrogendioxide3, nitrogendioxide4,
							exhaustgastemp1, exhaustgastemp2, exhaustgastemp3, exhaustgastemp4, 
							heatertemp1, heatertemp2, heatertemp3, heatertemp4,
							blowertemp1, blowertemp2, blowertemp3, blowertemp4, 
							oxygen1, oxygen2, oxygen3, oxygen4, 
							exhaustgaslost1, exhaustgaslost2, exhaustgaslost3, exhaustgaslost4,
							oilpart1, oilpart2, oilpart3, oilpart4, 
							result, smokenumber, oilpart, carbonmonoxide, nitrogendioxide, exhaustgaslost, additionalsteps, comment, persNumber);
				} else {
					//feukora.updateRapport();
				}

				//Tab 1
				textfieldCanton.clear();
				textfieldaddress.clear();
				textfieldfacilitymanager.clear();

				//Tab 2
				textfieldheateryear.clear();
				textfieldheateryear.clear();
				textfieldaddress.clear();
				textfieldaddress.clear();
				radioroutinecontrol.setSelected(false);
				radioacceptanceinspection.setSelected(false);
				textfieldbloweryear.clear();
				textfieldbloweryear.clear();
				textfieldheatinput.clear();

				//Tab 3

				textfieldsmokenumber1.clear();
				textfieldsmokenumber2.clear();
				textfieldsmokenumber3.clear();
				textfieldsmokenumber4.clear();

				textfielcarbonmonoxide1.clear();
				textfielcarbonmonoxide2.clear();
				textfielcarbonmonoxide3.clear();
				textfielcarbonmonoxide4.clear();

				textfieldnitrogendioxide1.clear();
				textfieldnitrogendioxide2.clear();
				textfieldnitrogendioxide3.clear();
				textfieldnitrogendioxide4.clear();

				textfieldexhaustgastemp1.clear();
				textfieldexhaustgastemp2.clear();
				textfieldexhaustgastemp3.clear();
				textfieldexhaustgastemp4.clear();

				textfieldheatertemp1.clear();
				textfieldheatertemp2.clear();
				textfieldheatertemp3.clear();
				textfieldheatertemp4.clear();

				textfieldoxygen1.clear();
				textfieldoxygen2.clear();
				textfieldoxygen3.clear();
				textfieldoxygen4.clear();

				textfieldexhaustgasloss1.clear();
				textfieldexhaustgasloss2.clear();
				textfieldexhaustgasloss3.clear();
				textfieldexhaustgasloss4.clear();

				radiooilpartyes1.setSelected(false);
				radiooilpartno1.setSelected(false);
				radiooilpartyes2.setSelected(false);
				radiooilpartno2.setSelected(false);
				radiooilpartyes3.setSelected(false);
				radiooilpartno3.setSelected(false);
				radiooilpartyes4.setSelected(false);
				radiooilpartno4.setSelected(false);

				// Tab 4

				radionotransgression.setSelected(false);
				radiotransgression.setSelected(false);
				checkboxsmokenumbertransgression.setSelected(false);
				checkbockoilparttransgression.setSelected(false);
				checkboxcarbonmonoxidetransgression.setSelected(false);
				checkboxnitrogendioxidetransgression.setSelected(false);
				checkboxexhaustlosstransgression.setSelected(false);
				radioadditionalstepsyes.setSelected(false);
				radioadditionalstepsno.setSelected(false);
				textareacomments.clear();
				textfieldpersonalcode.clear();		
			} else {
				errorInfoNeu();
			}	

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}

		AnchorPane pane = new AnchorPane();

		if(Context.getRole().equals("Administrator")) {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));
		} else if (Context.getRole().equals("Feuerungskontrolleur")) {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewInspector.fxml"));
		} else if (Context.getRole().equals("Sachbearbeiter")) {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAssistant.fxml"));
		}

	}

	/**
	 * method to get the data of the chosen record
	 */
	public void Update(){

		customer = Context.getCustomer();

		textfieldCanton.setText(rapport.getCanton());
		comboboxOwnerAdministration.setValue(customer.getLastname() + " " + customer.getFirstname());
		textfieldfacilitymanager.setText(facilitymanager.getlastname());

		if(rapport.getResults() == true){
			radiotransgression.setSelected(true);
		}else{
			radionotransgression.setSelected(true);
			if(rapport.getTransgression_smokenumber() == true){
				checkboxsmokenumbertransgression.setSelected(true);
			}
			if(rapport.getTransgression_oilpart() == true){
				checkbockoilparttransgression.setSelected(true);
			}
			if(rapport.getCarbonmonoxide() == true){
				checkboxcarbonmonoxidetransgression.setSelected(true);
			}
			if(rapport.getNitrogendioxide() == true){
				checkboxnitrogendioxidetransgression.setSelected(true);
			}
			if(rapport.getExhaustgaslost() == true){
				checkboxexhaustlosstransgression.setSelected(true);
			}
		}
		if(rapport.getAdditionalsteps() == true){
			radioadditionalstepsyes.setSelected(true);
		}else{
			radioadditionalstepsno.setSelected(true);
		}
		textareacomments.setText(rapport.getComments());

	}

	public void errorInfoNeu(){
		String titleBar = "Achtung";
		String headerMessage = "Bitte alle Daten eingeben";
		String infoMessage = "Eingabe nicht vollständig";
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}

	@FXML
	void ChoseOwnerAdministration(ActionEvent event) {

	}

	@FXML
	void SetAcceptanceinspection(ActionEvent event) {

	}

	@FXML
	void SetAdditionalstepsYes(ActionEvent event) {

	}

	@FXML
	void SetAdress(ActionEvent event) {

	}

	@FXML
	void SetBlowerType(ActionEvent event) {

	}

	@FXML
	void SetBlowerYear(ActionEvent event) {

	}

	@FXML
	void SetBlowertemp1(ActionEvent event) {

	}

	@FXML
	void SetBlowertemp2(ActionEvent event) {

	}

	@FXML
	void SetBlowertemp3(ActionEvent event) {

	}

	@FXML
	void SetBlowertemp4(ActionEvent event) {

	}

	@FXML
	void SetCarbonmonoxide1(ActionEvent event) {

	}

	@FXML
	void SetCarbonmonoxide2(ActionEvent event) {

	}

	@FXML
	void SetCarbonmonoxide3(ActionEvent event) {

	}

	@FXML
	void SetCarbonmonoxide4(ActionEvent event) {

	}

	@FXML
	void SetCarbonmonoxideTransgression(ActionEvent event) {

	}

	@FXML
	void SetExhaustgasloss1(ActionEvent event) {

	}

	@FXML
	void SetExhaustgasloss2(ActionEvent event) {

	}

	@FXML
	void SetExhaustgasloss3(ActionEvent event) {

	}

	@FXML
	void SetExhaustgasloss4(ActionEvent event) {

	}

	@FXML
	void SetExhaustgaslossTransgression(ActionEvent event) {

	}

	@FXML
	void SetExhaustgastemp1(ActionEvent event) {

	}

	@FXML
	void SetExhaustgastemp2(ActionEvent event) {

	}

	@FXML
	void SetExhaustgastemp3(ActionEvent event) {

	}

	@FXML
	void SetExhaustgastemp4(ActionEvent event) {

	}

	@FXML
	void SetFacilitymanager(ActionEvent event) {

	}

	@FXML
	void SetHeaterYear(ActionEvent event) {

	}

	@FXML
	void SetHeatertemp1(ActionEvent event) {

	}

	@FXML
	void SetHeatertemp2(ActionEvent event) {

	}

	@FXML
	void SetHeatertemp3(ActionEvent event) {

	}

	@FXML
	void SetHeatertemp4(ActionEvent event) {

	}

	@FXML
	void SetHeatinput(ActionEvent event) {

	}

	@FXML
	void SetMeasuringDate(ActionEvent event) {

	}

	@FXML
	void SetNitrogendioxide1(ActionEvent event) {

	}

	@FXML
	void SetNitrogendioxide2(ActionEvent event) {

	}

	@FXML
	void SetNitrogendioxide3(ActionEvent event) {

	}

	@FXML
	void SetNitrogendioxide4(ActionEvent event) {

	}

	@FXML
	void SetNitrogendioxideTransgression(ActionEvent event) {

	}

	@FXML
	void SetNoTransgression(ActionEvent event) {

	}

	@FXML
	void SetOilpartNo1(ActionEvent event) {

	}

	@FXML
	void SetOilpartNo2(ActionEvent event) {

	}

	@FXML
	void SetOilpartNo3(ActionEvent event) {

	}

	@FXML
	void SetOilpartNo4(ActionEvent event) {

	}

	@FXML
	void SetOilpartTransgression(ActionEvent event) {

	}

	@FXML
	void SetOilpartYes1(ActionEvent event) {

	}

	@FXML
	void SetOilpartYes2(ActionEvent event) {

	}

	@FXML
	void SetOilpartYes3(ActionEvent event) {

	}

	@FXML
	void SetOilpartYes4(ActionEvent event) {

	}

	@FXML
	void SetOxygen1(ActionEvent event) {

	}

	@FXML
	void SetOxygen2(ActionEvent event) {

	}

	@FXML
	void SetOxygen3(ActionEvent event) {

	}

	@FXML
	void SetOxygen4(ActionEvent event) {

	}

	@FXML
	void SetPersonalcode(ActionEvent event) {

	}

	@FXML
	void SetRoutinecontrol(ActionEvent event) {

	}

	@FXML
	void SetSmokenumber1(ActionEvent event) {

	}

	@FXML
	void SetSmokenumber2(ActionEvent event) {

	}

	@FXML
	void SetSmokenumber3(ActionEvent event) {

	}

	@FXML
	void SetSmokenumber4(ActionEvent event) {

	}

	@FXML
	void SetSmokenumberTransgression(ActionEvent event) {

	}

	@FXML
	void SetTransgression(ActionEvent event) {

	}

	@FXML
	void setAdditionalstepsNo(ActionEvent event) {

	}

	@FXML
	void setCanton(ActionEvent event) {

	}

	@FXML
	void setHeaterType(ActionEvent event) {

	}
}  