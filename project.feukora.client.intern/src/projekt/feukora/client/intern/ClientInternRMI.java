package projekt.feukora.client.intern;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import org.apache.log4j.Logger;
import org.omg.CORBA.INITIALIZE;

//import org.apache.log4j.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import login.controller.ControllerLogin;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Company;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.model.Heater;
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
 * This Class implements the rmi connection 
 * 
 * @version 1.2
 * @author Sandro Fasser
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
	


	
	public static void main(String[] args) {
		System.out
				.println("======================================================================");
		try {
			// Init Application over RMI
			ClientInternRMI feukora = new ClientInternRMI();
		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}
	
	/**
	 * Instantiates a new modulverwaltung client rmi.
	 *
	 * @throws Exception
	 */
	public ClientInternRMI() throws Exception {

		System.setProperty("java.security.policy", "feukora.policy");
		// SecurityManager installieren
		System.setSecurityManager(new SecurityManager());
		// init rmi connection
		String url = "rmi://localhost:9009/";
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
	 * 
	 *
	 * @throws Exception
	 */
	public boolean login(String username, String password) throws Exception {

		User user = userRMI.findUsersByUsername(username);
		
		return user.login( password );
	}

	/**
	 * 
	 *
	 * @throws Exception
	 */
	public void saveCustomer(String companyname, String lastname, String adress, String phone, Integer zip, String firstname, String email, Boolean isOwner) throws Exception {
		Customerfunction function;
		if(isOwner == true) {
			function = customerfunctionRMI.findCustomerfunctionByName("Eigentümer");
		} else {
			function = customerfunctionRMI.findCustomerfunctionByName("Verwaltung");
		}
		Town town1 = townRMI.findTownByZip(zip);
		
		Customer c1 = new Customer(companyname, firstname, lastname, adress, phone, email, function, town1);
		customerRMI.saveCustomer(c1);	
	}
	
	public void updateCustomer(Customer entity, String companyname, String lastname, String adress, String phone, Integer zip, String firstname, String email, Boolean isOwner) throws Exception {
		Customerfunction function;
		if(isOwner == true) {
			function = customerfunctionRMI.findCustomerfunctionByName("Eigentümer");
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
	
	
	public void deleteCustomer(Customer entity) {
		try {
			customerRMI.deleteCustomer(entity);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}
	
	/**
	 * 
	 *
	 * @throws Exception
	 */
	public void saveBlower(String name, Boolean oil, Boolean gas, Boolean liquidGas, Boolean blower, Boolean atmospheric, Boolean evaporator) throws Exception {
		Blowertype type;
		Fuel fuel;
		if(oil == true) {
			fuel = fuelRMI.findFuelByName("Öl");
		} else if (gas == true) {
			fuel = fuelRMI.findFuelByName("Erdgas");
		} else  if (liquidGas){
			fuel = fuelRMI.findFuelByName("Flüssiggas");
		} else {
			fuel = null;
		}
		
		if(blower == true) {
			type = blowertypeRMI.findBlowertypeByName("Gebläse");
		} else if(atmospheric == true) {
			type = blowertypeRMI.findBlowertypeByName("Athmosphärisch");
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

	
	public void updateBlower(Blower entity, String name, Boolean oil, Boolean gas, Boolean liquidGas, Boolean bblower, Boolean atmospheric, Boolean evaporator) throws Exception {
		Blowertype type;
		Fuel fuel;
		entity.setName(name);
		if(oil == true) {
			fuel = fuelRMI.findFuelByName("Öl");
		} else if (gas == true) {
			fuel = fuelRMI.findFuelByName("Erdgas");
		} else  if (liquidGas){
			fuel = fuelRMI.findFuelByName("Flüssiggas");
		} else {
			fuel = null;
		}
		entity.setFuelid(fuel);
		
		if(bblower == true) {
			type = blowertypeRMI.findBlowertypeByName("Gebläse");
		} else if(atmospheric == true) {
			type = blowertypeRMI.findBlowertypeByName("Athmosphärisch");
		} else if(evaporator == true) {
			type = blowertypeRMI.findBlowertypeByName("Verdampfer");
		} else {
			type = null;
		}
		entity.setBlowertypeid(type);
		
		blowerRMI.updateBlower(entity);
	}
	
	
	public void deleteBlower(Blower entity) {
		try {
			blowerRMI.deleteBlower(entity);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}
	
	
	
	/**
	 * 
	 *
	 * @throws Exception
	 */
	public ObservableList<Customer> getCustomers() throws Exception {
		
		ObservableList<Customer> customerlist = FXCollections.observableArrayList();
		customerlist.addAll(customerRMI.findAllCustomers());
		return customerlist;
		
	}
	
	public void saveUser(User entity){
		try {
			userRMI.saveUsers(entity);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveUser(Integer zip, String companyname, String firstname, String lastname, String adress, String phone, String email, String username, String password){
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(User entity) {
		try {
			userRMI.deleteUsers(entity);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgeführt werden\'",
					e);
		}
	}
	
	public void updateUser(User entity, Integer zip, String companyname, String firstname, String lastname, String adress, String phone, String email, String username, String password) throws Exception {
		
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
	 * 
	 *
	 * @throws Exception
	 */
	public ObservableList<Heater> getHeaters() throws Exception {

		ObservableList<Heater> heaterlist = FXCollections.observableArrayList();
		heaterlist.addAll(heaterRMI.findAllHeaters());
		return heaterlist;

	}

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

	public void updateHeater(Heater entity) throws Exception {
		heaterRMI.updateHeater(entity);
	}

	public void deleteHeater(Heater entity) {
		try {
			heaterRMI.deleteHeater(entity);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//			logger.error("Aktion konnte nicht durchgeführt werden\'",
			//					e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//			logger.error("Aktion konnte nicht durchgeführt werden\'",
			//					e);
		}
		
		
	}

	
	/**
	 * 
	 *
	 * @throws Exception
	 */
	public ObservableList<Blower> getBlowers() throws Exception {
		
		ObservableList<Blower> blowerlist = FXCollections.observableArrayList();
		blowerlist.addAll(blowerRMI.findAllBlowers());
		return blowerlist;
		
	}
	
	/**
	 * 
	 *
	 * @throws Exception
	 */
	public ObservableList<User> getUsers() throws Exception {
		
		ObservableList<User> userlist = FXCollections.observableArrayList();
		userlist.addAll(userRMI.findAllUsers());
		return userlist;
		
	}
	
	
	/**
	 * 
	 *
	 * @throws Exception
	 */
	public ObservableList<Company> getCompanies() throws Exception {
		
		ObservableList<Company> companylist = FXCollections.observableArrayList();
		companylist.addAll(companyRMI.findAllCompanies());
		return companylist;
		
	}
	/**
	 * 
	 *
	 * @throws Exception
	 */
	// Do muass no d uslesig vu allna Calendardata wo 
	public ObservableList<Customer> getCalendarData(String username) throws Exception {
		
		ObservableList<Customer> customerlist = FXCollections.observableArrayList();
		customerlist.addAll(customerRMI.findAllCustomers());
		return customerlist;
		
	}
	

	public String getTown(Integer zip) throws RemoteException {
		Town town1 = townRMI.findTownByZip(zip);
		return town1.getName();
		
	}	
	

}
