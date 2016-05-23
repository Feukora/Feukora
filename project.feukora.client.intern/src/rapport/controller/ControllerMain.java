package rapport.controller;

import java.net.URL;
import java.util.ResourceBundle;

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

public class ControllerMain implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
    @FXML
    private TextField textfieldCanton;

    @FXML
    private TextField textfieldaddress;

    @FXML
    private RadioButton radioowner;

    @FXML
    private RadioButton radioadministration;

    @FXML
    private TextField textfieldfacilitymanager;

    @FXML
    private ComboBox<?> comboboxOwnerAdministration;

    @FXML
    private Button rapportstartforward;

    @FXML
    private TextField textfieldheateryear;

    @FXML
    private TextField textfieldbloweryear;

    @FXML
    private TextField textfieldheatinput;

    @FXML
    private Button heaterback;

    @FXML
    private ComboBox<?> comboboxheatertype;

    @FXML
    private RadioButton radiofueloil;

    @FXML
    private RadioButton radiofuelliquidgas;

    @FXML
    private RadioButton radiofuelnaturalgas;

    @FXML
    private RadioButton radioroutinecontrol;

    @FXML
    private RadioButton radioacceptanceinspection;

    @FXML
    private ComboBox<?> comboboxblowertype;

    @FXML
    private RadioButton radioblowerfan;

    @FXML
    private RadioButton radioverdampfer;

    @FXML
    private RadioButton radioathmosphaere;

    @FXML
    private Button heaterforward;

    @FXML
    private CheckBox checkboxoilpartyes1;

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
    private CheckBox checkboxoilpartno4;

    @FXML
    private CheckBox checkboxoilpartno3;

    @FXML
    private CheckBox checkboxoilpartno2;

    @FXML
    private CheckBox checkboxoilpartno1;

    @FXML
    private CheckBox checkboxoilpartyes2;

    @FXML
    private CheckBox checkboxoilpartyes3;

    @FXML
    private CheckBox checkboxoilpartyes4;

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
    private Button measuringresultback;

    @FXML
    private Button measuringresultforward;

    @FXML
    private CheckBox checkboxnotransgression;

    @FXML
    private CheckBox checkboxtransgression;

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
    private CheckBox checkboxadditionalstepsno;

    @FXML
    private CheckBox checkboxadditionalstepsyes;

    @FXML
    private TextField textfieldpersonalcode;

    @FXML
    private Button resultback;

    @FXML
    private TextArea textareacomments;

    @FXML
    private Button rapportsave;

    @FXML
    void ActionHeaterBack(ActionEvent event) {

    }

    @FXML
    void ActionHeaterForward(ActionEvent event) {

    }

    @FXML
    void ActionMeasuringresultBack(ActionEvent event) {

    }

    @FXML
    void ActionMeasuringresultForward(ActionEvent event) {

    }

    @FXML
    void ActionRapportSave(ActionEvent event) {

    }

    @FXML
    void ActionRapportStartForward(ActionEvent event) {

    }

    @FXML
    void ActionResultBack(ActionEvent event) {

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
    void SetAdministration(ActionEvent event) {

    }

    @FXML
    void SetAdress(ActionEvent event) {

    }

    @FXML
    void SetBlowerAtmosphere(ActionEvent event) {

    }

    @FXML
    void SetBlowerFan(ActionEvent event) {

    }

    @FXML
    void SetBlowerType(ActionEvent event) {

    }

    @FXML
    void SetBlowerVaporizer(ActionEvent event) {

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
    void SetFuelLiquidGas(ActionEvent event) {

    }

    @FXML
    void SetFuelNaturalGas(ActionEvent event) {

    }

    @FXML
    void SetFuelOil(ActionEvent event) {

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
    void SetOwner(ActionEvent event) {

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