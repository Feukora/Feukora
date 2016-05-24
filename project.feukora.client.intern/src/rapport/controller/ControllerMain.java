package rapport.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Context;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.model.Town;

public class ControllerMain {

	private Rapport rapport;
	private Customerheater customerheater;
	private Customer customer;
	private Facilitymanager facilitymanager;
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

			comboboxOwnerAdministration.setItems(customerNames);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(Context.getRapportid() != null){
			Update();
		}else{

		}


	}

	public void Update(){

		rapport = Context.getRapport();
		customer = Context.getCustomer();
		facilitymanager = Context.getFacilitymanager();
		
		//1. Tab
		//Beide Methoden müssen in die Model Klasse noch hinzugefügt werden
		textfieldCanton.setText(rapport.getCanton());
		textfieldaddress.setText(rapport.getRapportAddress());
		comboboxOwnerAdministration.setValue(customer.getLastname() + " " + customer.getFirstname());
		textfieldfacilitymanager.setText(facilitymanager.getLastname() + " " + facilitymanager.getFirstname());

		// 2. Tab
		

	}

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
	private ComboBox<?> comboboxheatertype;

	@FXML
	private RadioButton radioroutinecontrol;

	@FXML
	private RadioButton radioacceptanceinspection;

	@FXML
	private ComboBox<?> comboboxblowertype;

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

	@FXML
	void ActionRapportSave(ActionEvent event) {

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