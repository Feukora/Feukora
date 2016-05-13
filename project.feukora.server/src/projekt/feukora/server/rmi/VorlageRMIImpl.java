package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.business.CustomerManager;
import projekt.feukora.server.business.CustomerManagerImpl;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.persister.GenericPersisterImpl;
import projekt.feukora.server.persister.JpaUtil;

/**
 *  This Class implements the methods of the interface CustomerRMI
 * @author Sandro Fasser
 * @version 1.0
 */

//Muss UnicastRemoteObject extenden -> fürs RMI und CustomerRMI implementieren
//Es müssen alle Methden RemoteException throwen (dieselben wie bei VorlageRMI
//Zuerst VorlageRMI erstellen dann hier mit Rechtsklick auf Source -> Override/Implement Methods
//damit alle sicher vorhanden sind

public class VorlageRMIImpl extends UnicastRemoteObject implements CustomerRMI {

	// ACHTUNG: Für jede neue Implementation muss diese Zeile hier unten gelöscht, dann gespeichert und 
	// dann "Add generated serial version ID" klicken, Meldung bei public class VorlageRMIImpl.........

	private static final long serialVersionUID = -5699727667136274431L;
	
	private CustomerManager customerManager;

	public VorlageRMIImpl() throws RemoteException {
		customerManager = new CustomerManagerImpl();
	}
	
	// HIER unten müssen mindestens alle Methoden die in VorlageRMI.java implementiert sind auch
	// vorhanden sind
	@Override
	public void saveCustomer(Customer entity) throws RemoteException, Exception {
		//customerManager der oben mit new instanziert wird hier die richtige Methode mit . hinzufügen
		customerManager.saveCustomer(entity);	
	}

	@Override
	public Customer updateCustomer(Customer entity) throws RemoteException, Exception {
		return customerManager.updateCustomer(entity);
	}

	@Override
	public void deleteCustomer(Customer entity) throws RemoteException, Exception {
		customerManager.deleteCustomer(entity);
	}

	@Override
	public void deleteCustomerByCustomerid(Integer customerid) throws RemoteException, Exception {
		customerManager.deleteCustomerByCustomerid(customerid);	
	}

	@Override
	public Customer findCustomerByCustomerid(Integer customerid) throws RemoteException {
		return customerManager.findCustomerByCustomerid(customerid);
	}

	@Override
	public List<Customer> findAllCustomers() throws RemoteException {
		return customerManager.findAllCustomers();
	}

	@Override
	public List<Customer> findCustomerByLastname(String lastname) throws RemoteException  {
		return customerManager.findCustomerByLastname(lastname);
	}

	@Override
	public List<Customer> findCustomerByFirstname(String firstname) throws RemoteException {
		return customerManager.findCustomerByFirstname(firstname);	
	}

	@Override
	public List<Customer> findCustomerByLastnameAndFirstname(String lastname, String firstname) throws RemoteException  {
		return customerManager.findCustomerByLastnameAndFirstname(lastname, firstname);
	}

	@Override
	public List<Customer> findCustomerByCompanyname(String companyname) throws RemoteException  {
		return customerManager.findCustomerByCompanyname(companyname);
	} 


}
