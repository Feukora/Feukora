package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import projekt.feukora.server.business.CustomerManager;
import projekt.feukora.server.business.CustomerManagerImpl;
import projekt.feukora.server.model.Customer;

/**
 * This Class implements the methods of the interface CustomerRMI
 * 
 * @author Sandro
 * @version 1.1
 */
public class CustomerRMIImpl extends UnicastRemoteObject implements CustomerRMI {

	private static final long serialVersionUID = 724994631535546964L;

	private CustomerManager customerManager;

	public CustomerRMIImpl() throws RemoteException {
		customerManager = new CustomerManagerImpl();
	}

	@Override
	public void saveCustomer(Customer entity) throws RemoteException, Exception {
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
