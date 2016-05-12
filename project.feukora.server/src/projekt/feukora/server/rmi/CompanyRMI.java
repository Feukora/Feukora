package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Customer;

/**
 * RMI interface for handling customer entities
 * @author Sandro Fasser
 * @version 1.0
 */
/**
 * @author Sandro Fasser
 *
 */
public interface CompanyRMI extends Remote{
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveCustomer(Customer entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Customer updateCustomer(Customer entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteCustomer(Customer entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteCustomerByCustomerid(Integer customerid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Customer findCustomerByCustomerid(Integer customerid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Customer> findAllCustomers() throws RemoteException;

	/**
	 * Return a list with customers with this lastname
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public List<Customer> findCustomerByLastname(String lastname) throws RemoteException;

	/**
	 * Return a list with customers with this firstname
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Customer> findCustomerByFirstname(String firstname) throws RemoteException ;

	/**
	 * Return a list with customers with this lastname and firstname
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Customer> findCustomerByLastnameAndFirstname(String lastname, String firstname) throws RemoteException ;

	/**
	 * Return a list with customers with this adress
	 * 
	 * @param ort
	 * @return
	 */
	public List<Customer> findCustomerByCompanyname(String companyname) throws RemoteException ;
}
