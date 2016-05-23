package projekt.feukora.client.intern;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

//import org.apache.log4j.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import login.controller.ControllerLogin;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Fuel;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.Users;
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
	
//	private static final Logger logger = Logger
//			.getLogger(ClientInternRMI.class);
//	
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
//			logger.error("Aktion konnte nicht durchgeführt werden\'",
//					e);
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
	public Boolean login(String username, String password) throws Exception {

		Users user = userRMI.findUsersByUsername(username).get(0);
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
			return true;
		}else{
			return false;
		}
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
	
	public void updateCustomer(String companyname, String lastname, String adress, String phone, Integer zip, String firstname, String email, Boolean isOwner) throws Exception {
		Customerfunction function;
		if(isOwner == true) {
			function = customerfunctionRMI.findCustomerfunctionByName("Eigentümer");
		} else {
			function = customerfunctionRMI.findCustomerfunctionByName("Verwaltung");
		}
		Town town1 = townRMI.findTownByZip(zip);
		
		Customer c1 = new Customer(companyname, firstname, lastname, adress, phone, email, function, town1);
		customerRMI.updateCustomer(c1);
	}
	
	
	public void deleteCustomer(Customer entity) {
		try {
			customerRMI.deleteCustomer(entity);
		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
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
	public void saveBlower(String name, Boolean oil, Boolean gas, Boolean liquidGas, Boolean blower, Boolean atmospheric, Boolean evaporator) throws Exception {
		Blowertype type;
		Fuel fuel;
		if(oil == true) {
			fuel = fuelRMI.findFuelByName("Öl");
		} else if (gas == true) {
			fuel = fuelRMI.findFuelByName("Erdgas");
		} else {
			fuel = fuelRMI.findFuelByName("Flüssiggas");
		}
		
		if(blower == true) {
			type = blowertypeRMI.findBlowertypeByName("Gebläse");
		} else if(atmospheric == true) {
			type = blowertypeRMI.findBlowertypeByName("Athmosphärisch");
		} else {
			type = blowertypeRMI.findBlowertypeByName("Verdampfer");
		}
//		Context.se
//		Blower b1 = new Blower(type, fuel, name);
//		blowerRMI.saveBlower(b1);
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

	
	public void updateBlower(Blower blower1, String name, Boolean oil, Boolean gas, Boolean liquidGas, Boolean blower, Boolean atmospheric, Boolean evaporator) throws Exception {
		Blowertype type;
		Fuel fuel;
		if(oil == true) {
			fuel = fuelRMI.findFuelByName("Öl");
		} else if (gas == true) {
			fuel = fuelRMI.findFuelByName("Gas");
		} else {
			fuel = fuelRMI.findFuelByName("Flüssig Gas");
		}
		
		if(blower == true) {
			type = blowertypeRMI.findBlowertypeByName("Gebläse");
		} else if(atmospheric == true) {
			type = blowertypeRMI.findBlowertypeByName("atmosphärisch");
		} else {
			type = blowertypeRMI.findBlowertypeByName("Verdampfer");
		}
		
		blowerRMI.updateBlower(blower1);
	}
	
	
	public void deleteBlower(Blower entity) {
		try {
			blowerRMI.deleteBlower(entity);
		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
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
	public ObservableList<Customer> getCustomers() throws Exception {
		
		ObservableList<Customer> customerlist = FXCollections.observableArrayList();
		customerlist.addAll(customerRMI.findAllCustomers());
		return customerlist;
		
	}
	
	
	public void saveUser(Users entity){
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
	
	public void deleteUser(Users entity) {
		try {
			userRMI.deleteUsers(entity);
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
	
	public void updateUser(Users entity) throws Exception {
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
	public ObservableList<Users> getUsers() throws Exception {
		
		ObservableList<Users> userlist = FXCollections.observableArrayList();
		userlist.addAll(userRMI.findAllUsers());
		return userlist;
		
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
