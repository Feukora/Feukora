package projekt.feukora.client.intern;

import java.io.InputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.eclipse.persistence.sessions.server.ClientSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.model.Measuringresult;
import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.Usergroup;
import projekt.feukora.server.model.User;
import projekt.feukora.server.rmi.AppointmentRMI;
import projekt.feukora.server.rmi.BlowerRMI;
import projekt.feukora.server.rmi.BlowertypeRMI;
import projekt.feukora.server.rmi.CompanyRMI;
import projekt.feukora.server.rmi.ControltypeRMI;
import projekt.feukora.server.rmi.CustomerRMI;
import projekt.feukora.server.rmi.CustomerfunctionRMI;
import projekt.feukora.server.rmi.CustomerheaterRMI;
import projekt.feukora.server.rmi.FacilitymanagerRMI;
import projekt.feukora.server.rmi.FuelRMI;
import projekt.feukora.server.rmi.HeaterRMI;
import projekt.feukora.server.rmi.MeasuringresultRMI;
import projekt.feukora.server.rmi.RapportRMI;
import projekt.feukora.server.rmi.TownRMI;
import projekt.feukora.server.rmi.UserRMI;
import projekt.feukora.server.rmi.UsergroupRMI;

/**
 * This Class that implements the rmi connection.
 * @author Sandro and Pascal
 * @version 1.7
 *
 */
public class ClientInternRMI {

	private static final Logger logger = Logger
			.getLogger(ClientInternRMI.class);

	CustomerRMI customerRMI;
	CompanyRMI companyRMI;
	AppointmentRMI appointmentRMI;
	BlowerRMI blowerRMI;
	HeaterRMI heaterRMI;
	MeasuringresultRMI measuringresultRMI;
	RapportRMI rapportRMI;
	UserRMI userRMI;
	TownRMI townRMI;
	BlowertypeRMI blowertypeRMI;
	ControltypeRMI controltypeRMI;
	CustomerfunctionRMI customerfunctionRMI;
	CustomerheaterRMI customerheaterRMI;
	FacilitymanagerRMI facilitymanagerRMI;
	FuelRMI fuelRMI;
	UsergroupRMI usergroupRMI;

	public static User currLoggedInUser;

	public static void main(String[] args) {
		try {
			ClientInternRMI feukora = new ClientInternRMI();
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
	}

	/**
	 * Instantiates a new modulverwaltung client rmi.
	 *
	 * @throws Exception
	 */
	public ClientInternRMI() throws Exception {

		Properties props = new Properties();
		InputStream is = ClientSession.class.getClassLoader().getResourceAsStream("./rmiclient.properties");
		try {
			props.load(is);
		} catch (Exception e) {
			logger.error("Konfigurationsdaten konnten nicht eingelesen werden\'",
					e);
		}

		int port = Integer.parseInt(props.getProperty("server_port"));
		String hostIP = props.getProperty("server_ip");
		String url = "rmi://" + hostIP + ":" + port + "/";
		String customerRMIName = "customerRMI";
		String companyRMIName = "companyRMI";
		String appointmentRMIName = "appointmentRMI";
		String blowerRMIName = "blowerRMI";
		String heaterRMIName = "heaterRMI";
		String measuringresultRMIName = "measuringresultRMI";
		String rapportRMIName = "rapportRMI";
		String userRMIName = "userRMI";
		String townRMIName = "townRMI";
		String blowertypeRMIName = "blowertypeRMI";
		String controltypeRMIName = "controltypeRMI";
		String customerfunctionRMIName = "customerfunctionRMI";
		String customerheaterRMIName = "customerheaterRMI";
		String facilitymanagerRMIName = "facilitymanagerRMI";
		String fuelRMIName = "fuelRMI";
		String usergroupRMIName = "usergroupRMI";

		this.customerRMI = (CustomerRMI) Naming.lookup(url + customerRMIName);
		this.companyRMI = (CompanyRMI) Naming.lookup(url + companyRMIName);
		this.appointmentRMI = (AppointmentRMI) Naming.lookup(url + appointmentRMIName);
		this.blowerRMI = (BlowerRMI) Naming.lookup(url + blowerRMIName);
		this.heaterRMI = (HeaterRMI) Naming.lookup(url + heaterRMIName);
		this.measuringresultRMI = (MeasuringresultRMI) Naming.lookup(url + measuringresultRMIName);
		this.rapportRMI = (RapportRMI) Naming.lookup(url + rapportRMIName);
		this.userRMI = (UserRMI) Naming.lookup(url + userRMIName);	
		this.townRMI = (TownRMI) Naming.lookup(url + townRMIName);
		this.blowertypeRMI = (BlowertypeRMI) Naming.lookup(url + blowertypeRMIName);
		this.controltypeRMI = (ControltypeRMI) Naming.lookup(url + controltypeRMIName);
		this.customerfunctionRMI = (CustomerfunctionRMI) Naming.lookup(url + customerfunctionRMIName);
		this.customerheaterRMI = (CustomerheaterRMI) Naming.lookup(url + customerheaterRMIName);
		this.facilitymanagerRMI = (FacilitymanagerRMI) Naming.lookup(url + facilitymanagerRMIName);
		this.fuelRMI = (FuelRMI) Naming.lookup(url + fuelRMIName);
		this.usergroupRMI = (UsergroupRMI) Naming.lookup(url + usergroupRMIName);
	}

	/**
	 * method that gets the view depending on the user
	 *
	 * @throws Exception
	 */
	public boolean login(String username, String password) throws Exception {

		User user = userRMI.findUsersByUsername(username);
		currLoggedInUser = user.login(password);

		return currLoggedInUser != null;
	}

	/**
	 * method that does the authentification of the username and the password
	 * @param username
	 * @return
	 * @throws RemoteException
	 */
	public String authentication(String username) throws RemoteException {
		User user = userRMI.findUsersByUsername(username);
		String role = user.getUsergroupid().toString();
		return role;
	}

	/**
	 * method to save a customer
	 *
	 * @throws Exception
	 */
	public void saveCustomer(String companyname, String lastname, String adress, String phone, Integer zip, String firstname, String email, Boolean isOwner) throws Exception {
		Customerfunction function;
		if(isOwner == true) {
			function = customerfunctionRMI.findCustomerfunctionByName("Eigent�mer");
		} else {
			function = customerfunctionRMI.findCustomerfunctionByName("Verwaltung");
		}
		Town town1 = townRMI.findTownByZip(zip);

		Customer c1 = new Customer(companyname, firstname, lastname, adress, phone, email, function, town1);
		customerRMI.saveCustomer(c1);	
	}

	/**
	 * method to update a customer
	 * @param entity
	 * @param companyname
	 * @param lastname
	 * @param adress
	 * @param phone
	 * @param zip
	 * @param firstname
	 * @param email
	 * @param isOwner
	 * @throws Exception
	 */
	public void updateCustomer(Customer entity, String companyname, String lastname, String adress, String phone, Integer zip, String firstname, String email, Boolean isOwner) throws Exception {
		Customerfunction function;
		if(isOwner == true) {
			function = customerfunctionRMI.findCustomerfunctionByName("Eigent�mer");
		} else {
			function = customerfunctionRMI.findCustomerfunctionByName("Verwaltung");
		}
		entity.setCustomerfunction(function);
		Town town = townRMI.findTownByZip(zip);
		entity.setTown(town);
		entity.setCompanyname(companyname);
		entity.setLastname(lastname);
		entity.setAdress(adress);
		entity.setPhone(phone);
		entity.setFirstname(firstname);
		entity.setEmail(email);

		customerRMI.updateCustomer(entity);
	}

	/**
	 * method to delete a customer
	 * @param entity
	 */
	public void deleteCustomer(Customer entity) {
		try {
			customerRMI.deleteCustomer(entity);
		} catch (RemoteException e) {
			String titleBar = "Achtung";
			String headerMessage = "Benutzer kann nicht gel�scht werden";
			String infoMessage = "Es bestehen noch Verbindungen dieses Benutzer";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titleBar);
			alert.setHeaderText(headerMessage);
			alert.setContentText(infoMessage);
			alert.showAndWait();
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		} catch (Exception e) {
			String titleBar = "Achtung";
			String headerMessage = "Benutzer kann nicht gel�scht werden";
			String infoMessage = "Es bestehen noch Verbindungen dieses Benutzer";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titleBar);
			alert.setHeaderText(headerMessage);
			alert.setContentText(infoMessage);
			alert.showAndWait();
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
	}

	/**
	 * an list with customer
	 *
	 * @throws Exception
	 */
	public ObservableList<Customer> getCustomers() throws Exception {

		ObservableList<Customer> customerlist = FXCollections.observableArrayList();
		customerlist.addAll(customerRMI.findAllCustomers());
		return customerlist;
	}

	/**
	 * method to save a blower
	 *
	 * @throws Exception
	 */
	public void saveBlower(String name, Boolean oil, Boolean gas, Boolean liquidGas, Boolean blower, Boolean atmospheric, Boolean evaporator) throws Exception {
		Blowertype type;
		Fuel fuel;
		if(oil == true) {
			fuel = fuelRMI.findFuelByName("�l");
		} else if (gas == true) {
			fuel = fuelRMI.findFuelByName("Erdgas");
		} else  if (liquidGas){
			fuel = fuelRMI.findFuelByName("Fl�ssiggas");
		} else {
			fuel = null;
		}
		if(blower == true) {
			type = blowertypeRMI.findBlowertypeByName("Gebl�se");
		} else if(atmospheric == true) {
			type = blowertypeRMI.findBlowertypeByName("Athmosph�risch");
		} else if(evaporator == true) {
			type = blowertypeRMI.findBlowertypeByName("Verdampfer");
		} else {
			type = null;
		}
		Blower b1 = new Blower(type, fuel, name);
		blowerRMI.saveBlower(b1);
	}

	public void saveBlower(Blower entity) throws Exception {
		try {
			blowerRMI.saveBlower(entity);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * method to update a blower
	 * @param entity
	 * @param name
	 * @param oil
	 * @param gas
	 * @param liquidGas
	 * @param bblower
	 * @param atmospheric
	 * @param evaporator
	 * @throws Exception
	 */
	public void updateBlower(Blower entity, String name, Boolean oil, Boolean gas, Boolean liquidGas, Boolean bblower, Boolean atmospheric, Boolean evaporator) throws Exception {
		Blowertype type;
		Fuel fuel;
		entity.setName(name);
		if(oil == true) {
			fuel = fuelRMI.findFuelByName("�l");
		} else if (gas == true) {
			fuel = fuelRMI.findFuelByName("Erdgas");
		} else  if (liquidGas){
			fuel = fuelRMI.findFuelByName("Fl�ssiggas");
		} else {
			fuel = null;
		}
		entity.setFuelid(fuel);
		if(bblower == true) {
			type = blowertypeRMI.findBlowertypeByName("Gebl�se");
		} else if(atmospheric == true) {
			type = blowertypeRMI.findBlowertypeByName("Athmosph�risch");
		} else if(evaporator == true) {
			type = blowertypeRMI.findBlowertypeByName("Verdampfer");
		} else {
			type = null;
		}
		entity.setBlowertypeid(type);

		blowerRMI.updateBlower(entity);
	}

	/** 
	 * method to delete a blower
	 * @param entity
	 */
	public void deleteBlower(Blower entity) {
		try {
			blowerRMI.deleteBlower(entity);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
	}

	/**
	 * method to get a list with blowers
	 *
	 * @throws Exception
	 */
	public ObservableList<Blower> getBlowers() throws Exception {

		ObservableList<Blower> blowerlist = FXCollections.observableArrayList();
		blowerlist.addAll(blowerRMI.findAllBlowers());
		return blowerlist;
	}

	/**
	 * method to save users
	 * @param entity
	 */
	public void saveUser(User entity){
		try {
			userRMI.saveUsers(entity);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to save inspector users
	 * @param entity
	 */
	public void saveInspectorUser(Integer zip, String companyname, String firstname, String lastname, String adress, String phone, String email, String username, String password){
		try{
			Company company;
			Town city;
			Usergroup usergroup;

			usergroup = usergroupRMI.findUsergroupByName("Feuerungskontrolleur");
			city = townRMI.findTownByZip(zip);
			company = companyRMI.findCompanyByName(companyname).get(0);		

			User u1 = new User(usergroup, lastname, firstname, adress, city, company, username, password, phone, email);
			userRMI.saveUsers(u1);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to save assistant users
	 * @param entity
	 */
	public void saveAssistantUser(Integer zip, String companyname, String firstname, String lastname, String adress, String phone, String email, String username, String password){
		try{
			Company company;
			Town city;
			Usergroup usergroup;

			usergroup = usergroupRMI.findUsergroupByName("Sachbearbeiter");
			city = townRMI.findTownByZip(zip);
			company = companyRMI.findCompanyByName(companyname).get(0);		

			User u1 = new User(usergroup, lastname, firstname, adress, city, company, username, password, phone, email);
			userRMI.saveUsers(u1);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to update inspector users
	 * @param entity
	 */
	public void updateInspectorUser(User entity, Integer zip, String companyname, String firstname, String lastname, String adress, String phone, String email, String username, String password) throws Exception {

		Company company;
		Town city;
		Usergroup usergroup;

		usergroup = usergroupRMI.findUsergroupByName("Feuerungskontrolleur");
		city = townRMI.findTownByZip(zip);
		company = companyRMI.findCompanyByName(companyname).get(0);

		entity.setUsergroupid(usergroup);
		entity.setZip(city);
		entity.setFirstname(firstname);
		entity.setLastname(lastname);
		entity.setAdress(adress);
		entity.setPhone(phone);
		entity.setUsername(username);
		entity.setPassword(password);
		entity.setCompanyid(company);	
		userRMI.updateUsers(entity);
	}

	/**
	 * method to update assistant users
	 * @param entity
	 */
	public void updateAssistantUser(User entity, Integer zip, String companyname, String firstname, String lastname, String adress, String phone, String email, String username, String password) throws Exception {

		Company company;
		Town city;
		Usergroup usergroup;

		usergroup = usergroupRMI.findUsergroupByName("Sachbearbeiter");
		city = townRMI.findTownByZip(zip);
		company = companyRMI.findCompanyByName(companyname).get(0);

		entity.setUsergroupid(usergroup);
		entity.setZip(city);
		entity.setFirstname(firstname);
		entity.setLastname(lastname);
		entity.setAdress(adress);
		entity.setPhone(phone);
		entity.setUsername(username);
		entity.setPassword(password);
		entity.setCompanyid(company);	
		userRMI.updateUsers(entity);
	}

	/**
	 * method to delete users
	 * @param entity
	 */
	public void deleteUser(User entity) {
		try {
			userRMI.deleteUsers(entity);
		} catch (RemoteException e) {
			String titleBar = "Achtung";
			String headerMessage = "Feuerungskkontrolleur kann nicht gel�scht werden";
			String infoMessage = "Es bestehen noch Verbindungen diesem Feuerungskontrolleur";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titleBar);
			alert.setHeaderText(headerMessage);
			alert.setContentText(infoMessage);
			alert.showAndWait();

			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		} catch (Exception e) {
			String titleBar = "Achtung";
			String headerMessage = "Feuerungskkontrolleur kann nicht gel�scht werden";
			String infoMessage = "Es bestehen noch Verbindungen diesem Feuerungskontrolleur";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titleBar);
			alert.setHeaderText(headerMessage);
			alert.setContentText(infoMessage);
			alert.showAndWait();

			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
	}

	/**
	 * method to get a list with users
	 *
	 * @throws Exception
	 */
	public ObservableList<User> getUsers() throws Exception {

		ObservableList<User> userlist = FXCollections.observableArrayList();
		userlist.addAll(userRMI.findAllUsers());

		return userlist;
	}

	/**
	 * method to get a list with inspector users
	 * @return
	 * @throws Exception
	 */
	public ObservableList<User> getInspectors() throws Exception {

		ObservableList<User> userlist = FXCollections.observableArrayList();
		userlist.addAll(userRMI.findUserByUsergroup(usergroupRMI.findUsergroupByName("Feuerungskontrolleur")));
		return userlist;
	}


	/**
	 * method to get a list with assistant users
	 *
	 * @throws Exception
	 */
	public ObservableList<User> getAssistentUsers() throws Exception {

		ObservableList<User> userlist = FXCollections.observableArrayList();
		userlist.addAll(userRMI.findAllUsers());

		ObservableList<User> assistentlist = FXCollections.observableArrayList();
		for (User user : userlist) {
			if (user.getUsergroupid().equals("Sachbearbeiter")) {
				assistentlist.add(user);
			}
		}
		return assistentlist;
	}

	/**
	 * method to get a list with assistants
	 * @return
	 * @throws Exception
	 */
	public ObservableList<User> getAssistants() throws Exception {

		ObservableList<User> userlist = FXCollections.observableArrayList();
		userlist.addAll(userRMI.findUserByUsergroup(usergroupRMI.findUsergroupByName("Sachbearbeiter")));
		return userlist;
	}

	/**
	 * method to save heaters
	 * @param entity
	 */
	public void saveHeater(Heater entity){
		try {
			heaterRMI.saveHeater(entity);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * method to update heaters
	 * @param entity
	 */
	public void updateHeater(Heater entity) throws Exception {
		heaterRMI.updateHeater(entity);
	}

	/**
	 * method to delete heaters
	 * @param entity
	 */
	public void deleteHeater(Heater entity) {
		try {
			heaterRMI.deleteHeater(entity);
		} catch (RemoteException e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
	}

	/**
	 * 
	 *
	 * @throws Exception
	 */
	public ObservableList<Heater> getHeaters() throws Exception {

		ObservableList<Heater> heaterlist = FXCollections.observableArrayList();
		heaterlist.addAll(heaterRMI.findAllHeaters());
		return heaterlist;
	}

	/**
	 * method to get a list with companies
	 *
	 * @throws Exception
	 */
	public ObservableList<Company> getCompanies() throws Exception {

		ObservableList<Company> companylist = FXCollections.observableArrayList();
		companylist.addAll(companyRMI.findAllCompanies());
		return companylist;
	}

	/**
	 * This Method returns all {@link Customerheater} for a given customer
	 *
	 * @param customer - the user to get all customerheaters for
	 *
	 * @return returnValue - the list with all customerheaters for the given customer or an empty list if he doesn't have any
	 */
	public List<Customerheater> getCustomerHeaters( Customer customer )
	{
		List<Customerheater> returnValue = new ArrayList<Customerheater>();
		try {
			returnValue = customerheaterRMI.findCustomerHeaterForCustomer(customer);
		} catch (RemoteException e) {
			logger.error("Fehler beim Auslesen der W�rmeerzeuger f�r Kunden", e);
		}

		return returnValue;
	}

	/**
	 * method to get a town
	 * @param zip
	 * @return
	 * @throws RemoteException
	 */
	public String getTown(Integer zip) throws RemoteException {
		Town town1 = townRMI.findTownByZip(zip);
		return town1.getName();
	}

	/**
	 * method to save a rapport
	 * @param canton
	 * @param adress
	 * @param customer
	 * @param facilitymanager
	 * @param heateryear
	 * @param heatertype
	 * @param ctype
	 * @param bloweryear
	 * @param blowertype
	 * @param performance
	 * @param gdate
	 * @param smokenumber1
	 * @param smokenumber2
	 * @param smokenumber3
	 * @param smokenumber4
	 * @param carbonmonoxide1
	 * @param carbonmonoxide2
	 * @param carbonmonoxide3
	 * @param carbonmonoxide4
	 * @param nitrogendioxide1
	 * @param nitrogendioxide2
	 * @param nitrogendioxide3
	 * @param nitrogendioxide4
	 * @param exhaustgastemp1
	 * @param exhaustgastemp2
	 * @param exhaustgastemp3
	 * @param exhaustgastemp4
	 * @param heatertemp1
	 * @param heatertemp2
	 * @param heatertemp3
	 * @param heatertemp4
	 * @param blowertemp1
	 * @param blowertemp2
	 * @param blowertemp3
	 * @param blowertemp4
	 * @param oxygen1
	 * @param oxygen2
	 * @param oxygen3
	 * @param oxygen4
	 * @param exhaustgaslost1
	 * @param exhaustgaslost2
	 * @param exhaustgaslost3
	 * @param exhaustgaslost4
	 * @param oilpart1
	 * @param oilpart2
	 * @param oilpart3
	 * @param oilpart4
	 * @param result
	 * @param smokenumber
	 * @param oilpart
	 * @param carbonmonoxide
	 * @param nitrogendioxide
	 * @param exhaustgaslost
	 * @param additionalsteps
	 * @param comment
	 * @param persNumber
	 * @throws Exception
	 */
	public void saveRapport(String canton, String adress, String customer, String facilitymanager, Integer heateryear,
			String heatertype, String ctype, Integer bloweryear, String blowertype, String performance,
			GregorianCalendar gdate, String smokenumber1, String smokenumber2, String smokenumber3, String smokenumber4,
			String carbonmonoxide1, String carbonmonoxide2, String carbonmonoxide3, String carbonmonoxide4,
			String nitrogendioxide1, String nitrogendioxide2, String nitrogendioxide3, String nitrogendioxide4,
			String exhaustgastemp1, String exhaustgastemp2, String exhaustgastemp3, String exhaustgastemp4,
			String heatertemp1, String heatertemp2, String heatertemp3, String heatertemp4, String blowertemp1,
			String blowertemp2, String blowertemp3, String blowertemp4, String oxygen1, String oxygen2, String oxygen3,
			String oxygen4, String exhaustgaslost1, String exhaustgaslost2, String exhaustgaslost3,
			String exhaustgaslost4, Boolean oilpart1, Boolean oilpart2, Boolean oilpart3, Boolean oilpart4,
			Boolean result, Boolean smokenumber, Boolean oilpart, Boolean carbonmonoxide, Boolean nitrogendioxide,
			Boolean exhaustgaslost, Boolean additionalsteps, String comment, String persNumber) throws Exception {

		Rapport rapRapport;
		Customerheater rapCustomerheater;
		Customer rapCustomer;
		Facilitymanager rapFacilitymanager;
		Controltype rapType;
		Measuringresult rapMeasuringresult;
		Heater rapHeater;
		Blower rapBlower;
		User rapUser;

		Integer rapPerformance = Integer.parseInt(performance);

		Integer rapSmokenumber1 = Integer.parseInt(smokenumber1);
		Integer rapSmokenumber2 = Integer.parseInt(smokenumber2);
		Integer rapSmokenumber3;
		if(smokenumber3.isEmpty() == false) {
			rapSmokenumber3 = Integer.parseInt(smokenumber3);
		} else {
			rapSmokenumber3 = 0;
		}
		
		Integer rapSmokenumber4;
		if(smokenumber4.isEmpty() == false) {
			rapSmokenumber4 = Integer.parseInt(smokenumber4);
		} else {
			rapSmokenumber4 = 0;
		}

		Integer rapCarbonmonoxide1 = Integer.parseInt(carbonmonoxide1);
		Integer rapCarbonmonoxide2 = Integer.parseInt(carbonmonoxide2);
		Integer rapCarbonmonoxide3;
		if(carbonmonoxide3.isEmpty() == false) {
			rapCarbonmonoxide3 = Integer.parseInt(carbonmonoxide3);
		} else {
			rapCarbonmonoxide3 = 0;
		}
		
		Integer rapCarbonmonoxide4;
		if(carbonmonoxide4.isEmpty() == false) {
			rapCarbonmonoxide4 = Integer.parseInt(carbonmonoxide4);
		} else {
			rapCarbonmonoxide4 = 0;
		}

		Integer rapNitrogendioxide1 = Integer.parseInt(nitrogendioxide1);
		Integer rapNitrogendioxide2 = Integer.parseInt(nitrogendioxide2);
		Integer rapNitrogendioxide3;
		if(nitrogendioxide3.isEmpty() == false) {
			rapNitrogendioxide3 = Integer.parseInt(nitrogendioxide3);
		} else {
			rapNitrogendioxide3 = 0;
		}
		
		Integer rapNitrogendioxide4;
		if(nitrogendioxide4.isEmpty() == false) {
			rapNitrogendioxide4 = Integer.parseInt(nitrogendioxide4);
		} else {
			rapNitrogendioxide4 = 0;
		}

		Integer rapExhaustgastemp1 = Integer.parseInt(exhaustgastemp1);
		Integer rapExhaustgastemp2 = Integer.parseInt(exhaustgastemp2);
		Integer rapExhaustgastemp3;
		if(exhaustgastemp3.isEmpty() == false) {
			rapExhaustgastemp3 = Integer.parseInt(exhaustgastemp3);
		} else {
			rapExhaustgastemp3 = 0;
		}
		
		Integer rapExhaustgastemp4;
		if(exhaustgastemp4.isEmpty() == false) {
			rapExhaustgastemp4 = Integer.parseInt(exhaustgastemp4);
		} else {
			rapExhaustgastemp4 = 0;
		}

		Integer rapHeatertemp1 = Integer.parseInt(heatertemp1);
		Integer rapHeatertemp2 = Integer.parseInt(heatertemp2);
		Integer rapHeatertemp3;
		if(heatertemp3.isEmpty() == false) {
			rapHeatertemp3 = Integer.parseInt(heatertemp3);
		} else {
			rapHeatertemp3 = 0;
		}
		
		Integer rapHeatertemp4;
		if(heatertemp4.isEmpty() == false) {
			rapHeatertemp4 = Integer.parseInt(heatertemp4);
		} else {
			rapHeatertemp4 = 0;
		}

		Integer rapBlowertemp1 = Integer.parseInt(blowertemp1);
		Integer rapBlowertemp2 = Integer.parseInt(blowertemp2);
		Integer rapBlowertemp3;
		if(blowertemp3.isEmpty() == false) {
			rapBlowertemp3 = Integer.parseInt(blowertemp3);
		} else {
			rapBlowertemp3 = 0;
		}
		
		Integer rapBlowertemp4;
		if(blowertemp4.isEmpty() == false) {
			rapBlowertemp4 = Integer.parseInt(blowertemp4);
		} else {
			rapBlowertemp4 = 0;
		}

		Double rapOxygen1 = Double.parseDouble(oxygen1);
		Double rapOxygen2 = Double.parseDouble(oxygen2);
		Double rapOxygen3;
		if(oxygen3.isEmpty() == false) {
			rapOxygen3 = Double.parseDouble(oxygen3);
		} else {
			rapOxygen3 = 0.0;
		}
		
		Double rapOxygen4;
		if(oxygen4.isEmpty() == false) {
			rapOxygen4 = Double.parseDouble(oxygen4);
		} else {
			rapOxygen4 = 0.0;
		}

		Double rapExhaustgaslost1 = Double.parseDouble(exhaustgaslost1);
		Double rapExhaustgaslost2 = Double.parseDouble(exhaustgaslost2);
		Double rapExhaustgaslost3;
		if(exhaustgaslost3.isEmpty() == false) {
			rapExhaustgaslost3 = Double.parseDouble(exhaustgaslost3);
		} else {
			rapExhaustgaslost3 = 0.0;
		}
		
		Double rapExhaustgaslost4;
		if(exhaustgaslost4.isEmpty() == false) {
			rapExhaustgaslost4 = Double.parseDouble(exhaustgaslost4);
		} else {
			rapExhaustgaslost4 = 0.0;
		}

		Integer rapPersNumber = Integer.parseInt(persNumber);
		rapUser = userRMI.findUsersByUserid(rapPersNumber);

		String lastname;
		String[] names = customer.split("\\s+");
		lastname = names[0];

		rapCustomer = customerRMI.findCustomerByLastname(lastname).get(0);

		rapHeater = heaterRMI.findHeaterByName(heatertype).get(0);

		rapType = controltypeRMI.findControltypeByName(ctype);

		rapBlower = blowerRMI.findBlowerByName(blowertype).get(0);

		Appointment a1 = appointmentRMI.findAllAppointments().get(0);
		Facilitymanager fm1 = new Facilitymanager(facilitymanager);
		facilitymanagerRMI.saveFacilitymanager(fm1);
		fm1 = facilitymanagerRMI.findFacilitymanagerByLastname(facilitymanager).get(0);
		Customerheater ch1 = new Customerheater(rapCustomer, rapHeater, rapBlower, fm1, bloweryear, heateryear, rapPerformance);
		customerheaterRMI.saveCustomerheater(ch1);
		List<Customerheater> listch1 = customerheaterRMI.findAllCustomerheaters();
		int i = 0;
		while(i < listch1.size()){
			ch1 = listch1.get(i);
			i++;
		}
		Rapport r1 = new Rapport(canton, adress, rapType, ch1, rapUser, a1, gdate, result, additionalsteps, comment, smokenumber, oilpart, exhaustgaslost, nitrogendioxide, carbonmonoxide);
		rapportRMI.saveRapport(r1);
		r1 = rapportRMI.findRapportByRapportid(r1.getRapportid());
		Measuringresult mr1 = new Measuringresult(r1, 1, 1, rapSmokenumber1, rapCarbonmonoxide1, oilpart1, rapNitrogendioxide1,
				rapExhaustgastemp1, rapHeatertemp1, rapBlowertemp1, rapOxygen1, rapExhaustgaslost1);
		Measuringresult mr2 = new Measuringresult(r1, 1, 2, rapSmokenumber2, rapCarbonmonoxide2, oilpart2, rapNitrogendioxide2,
				rapExhaustgastemp2, rapHeatertemp2, rapBlowertemp2, rapOxygen2, rapExhaustgaslost2);
		Measuringresult mr3 = new Measuringresult(r1, 2, 1, rapSmokenumber3, rapCarbonmonoxide3, oilpart3, rapNitrogendioxide3,
				rapExhaustgastemp3, rapHeatertemp3, rapBlowertemp3, rapOxygen3, rapExhaustgaslost3);
		Measuringresult mr4 = new Measuringresult(r1, 2, 2, rapSmokenumber4, rapCarbonmonoxide4, oilpart4, rapNitrogendioxide4,
				rapExhaustgastemp4, rapHeatertemp4, rapBlowertemp4, rapOxygen4, rapExhaustgaslost4);

		measuringresultRMI.saveMeasuringresult(mr1);
		measuringresultRMI.saveMeasuringresult(mr2);
		measuringresultRMI.saveMeasuringresult(mr3);
		measuringresultRMI.saveMeasuringresult(mr4);
	}

	/**
	 * method to update a rapport
	 * @param rapport
	 * @param canton
	 * @param adress
	 * @param customer
	 * @param facilitymanager
	 * @param heateryear
	 * @param bloweryear
	 * @param performance
	 * @param date
	 * @param result
	 * @param smokenumber
	 * @param oilpart
	 * @param carbonmonoxide
	 * @param nitrogendioxide
	 * @param exhaustgaslost
	 * @param additionalsteps
	 * @param comment
	 */
	public void updateRapport(Rapport rapport, String canton, String adress, String customer, String facilitymanager,
			Integer heateryear, Integer bloweryear, String performance, LocalDate date, Boolean result,
			Boolean smokenumber, Boolean oilpart, Boolean carbonmonoxide, Boolean nitrogendioxide,
			Boolean exhaustgaslost, Boolean additionalsteps, String comment) {		
	}

	/**
	 * method to delete a rapport
	 * @param entity
	 */
	public void deleteRapport(Rapport entity) {
		try {
			rapportRMI.deleteRapport(entity);
		} catch (RemoteException e) {
			String titleBar = "Achtung";
			String headerMessage = "Benutzer kann nicht gel�scht werden";
			String infoMessage = "Es bestehen noch Verbindungen dieses Benutzer";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titleBar);
			alert.setHeaderText(headerMessage);
			alert.setContentText(infoMessage);
			alert.showAndWait();
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		} catch (Exception e) {
			String titleBar = "Achtung";
			String headerMessage = "Benutzer kann nicht gel�scht werden";
			String infoMessage = "Es bestehen noch Verbindungen dieses Benutzer";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titleBar);
			alert.setHeaderText(headerMessage);
			alert.setContentText(infoMessage);
			alert.showAndWait();
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
	}

	/**
	 * a list with rapports
	 *
	 * @throws Exception
	 */
	public ObservableList<Rapport> getRapports() throws Exception {

		ObservableList<Rapport> rapportlist1 = FXCollections.observableArrayList();
		rapportlist1.addAll(rapportRMI.findAllRapports());

		ObservableList<Rapport> rapportlist = FXCollections.observableArrayList();
		for (Rapport rapport : rapportlist1) {
			rapport.getMeasuringdate().toString(); 
		}
		//R�ckgabe von Measuringdate als String muss noch gemacht werden
		return rapportlist1;
	}

	/**
	 * method to save a appointment
	 * @param app
	 * @param newApp
	 */
	public void saveAppointment( Appointment app, boolean newApp )
	{
		try {
			if ( newApp )
			{
				appointmentRMI.saveAppointment( app );
			}
			else
			{
				appointmentRMI.updateAppointment(app);
			}
		} catch (Exception e) {
			logger.error( "Fehler beim speichern eines neuen Termines", e );
		}
	}

	/**
	 * method to delete a appointment
	 * @param app
	 */
	public void deleteAppointment( Appointment app )
	{
		try {
			appointmentRMI.deleteAppointment( app );
		} catch (Exception e) {
			logger.error("Fehler beim l�schen des Termins (appointmentid = " + app.getAppointmentid(), e);
		}
	}

	/**
	 * This Method returns all Appointments for a given inspector
	 *
	 * @param inspector - the user to get all appointments for
	 *
	 * @return returnValue - the list with all appointments for the given user or an empty list if he doesn't have any
	 */
	public List<Appointment> getAppointments(User inspector) 
	{
		List<Appointment> returnValue = new ArrayList<Appointment>();
		try {
			returnValue = appointmentRMI.findAppointmentsForInspector(inspector);
		} catch (RemoteException e) {
			logger.error( "Fehler beim Auslesen der Termine", e );
		}

		return returnValue;
	}
}
