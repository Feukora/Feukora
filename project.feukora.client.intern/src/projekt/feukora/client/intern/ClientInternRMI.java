package projekt.feukora.client.intern;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import javafx.collections.ObservableList;
import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;
import projekt.feukora.server.model.Town;
import projekt.feukora.server.model.Users;
import projekt.feukora.server.rmi.AppointmentRMI;
import projekt.feukora.server.rmi.BlowerRMI;
import projekt.feukora.server.rmi.CompanyRMI;
import projekt.feukora.server.rmi.CustomerRMI;
import projekt.feukora.server.rmi.HeaterRMI;
import projekt.feukora.server.rmi.MeasuringresultRMI;
import projekt.feukora.server.rmi.RapportRMI;
import projekt.feukora.server.rmi.TownRMI;
import projekt.feukora.server.rmi.UserRMI;


/**
 * This Class implements the rmi connection 
 * 
 * @version 1.1
 * @author Sandro Fasser
 *
 */
public class ClientInternRMI {
	
	CustomerRMI customerRMI;
	CompanyRMI companyRMI;
	AppointmentRMI appointmentRMI;
	BlowerRMI blowerRMI;
	HeaterRMI heaterRMI;
	MeasuringresultRMI measuringresultRMI;
	RapportRMI rapportRMI;
	UserRMI userRMI;
	TownRMI townRMI;


	
	public static void main(String[] args) {
		System.out
				.println("======================================================================");
		try {
			// Init Application over RMI
			ClientInternRMI feukora = new ClientInternRMI();
		} catch (Exception e) {
			e.printStackTrace();
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
		this.customerRMI = (CustomerRMI) Naming.lookup(url + customerRMIName);
		this.companyRMI = (CompanyRMI) Naming.lookup(url + companyRMIName);
		this.appointmentRMI = (AppointmentRMI) Naming.lookup(url + appointmentRMIName);
		this.blowerRMI = (BlowerRMI) Naming.lookup(url + blowerRMIName);
		this.heaterRMI = (HeaterRMI) Naming.lookup(url + heaterRMIName);
		this.measuringresultRMI = (MeasuringresultRMI) Naming.lookup(url + measuringresultRMIName);
		this.rapportRMI = (RapportRMI) Naming.lookup(url + rapportRMIName);
		this.userRMI = (UserRMI) Naming.lookup(url + userRMIName);	
		this.townRMI = (TownRMI) Naming.lookup(url + townRMIName);
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
	public void saveCustomer(String lastname, String adress, String phone, Integer zip, String firstname, String email) throws Exception {
		Customerfunction function = new Customerfunction();
		function.setName("Verwaltung");
		String companyname = "Firma";
		Town town1 = townRMI.findTownByZip(zip);
		
		Customer c1 = new Customer(companyname, firstname, lastname, adress, phone, email, null, town1);
		customerRMI.saveCustomer(c1);	
	}
	
	public void deleteCustomer(Customer entity) {
		
	}

	public String getTown(Integer zip) throws RemoteException {
		Town town1 = townRMI.findTownByZip(zip);
		return town1.getName();
		
	}	
	
	/**
	 * 
	 *
	 * @throws Exception
	 */
	public ObservableList<Customer> showCustomer() throws Exception {
		
		ObservableList<Customer> customerlist = (ObservableList<Customer>) customerRMI.findAllCustomers();
		return customerlist;
		
	}
}
