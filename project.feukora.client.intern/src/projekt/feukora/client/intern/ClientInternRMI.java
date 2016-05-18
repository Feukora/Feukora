package projekt.feukora.client.intern;

import java.rmi.Naming;

import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.rmi.AppointmentRMI;
import projekt.feukora.server.rmi.BlowerRMI;
import projekt.feukora.server.rmi.CompanyRMI;
import projekt.feukora.server.rmi.CustomerRMI;
import projekt.feukora.server.rmi.HeaterRMI;
import projekt.feukora.server.rmi.MeasuringresultRMI;
import projekt.feukora.server.rmi.RapportRMI;
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
		this.customerRMI = (CustomerRMI) Naming.lookup(url + customerRMIName);
		this.companyRMI = (CompanyRMI) Naming.lookup(url + companyRMIName);
		this.appointmentRMI = (AppointmentRMI) Naming.lookup(url + appointmentRMIName);
		this.blowerRMI = (BlowerRMI) Naming.lookup(url + blowerRMIName);
		this.heaterRMI = (HeaterRMI) Naming.lookup(url + heaterRMIName);
		this.measuringresultRMI = (MeasuringresultRMI) Naming.lookup(url + measuringresultRMIName);
		this.rapportRMI = (RapportRMI) Naming.lookup(url + rapportRMIName);
		this.userRMI = (UserRMI) Naming.lookup(url + userRMIName);
		
	}
	
	/**
	 * Instantiates a new modulverwaltung client rmi.
	 *
	 * @throws Exception
	 */
	public void saveCustomer(String lastname, String adress, String phone, Integer zip, String firstname, String email) throws Exception {
		Customer c1 = new Customer(null, firstname, lastname, adress, phone, email, null, null);
		customerRMI.saveCustomer(c1);
		
		
	}

	
}