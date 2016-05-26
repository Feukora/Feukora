package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Customer;

/**
 * Interface to handle customer entities.
 * 
 * @author Sandro Fasser
 * @version 1.1
 *
 */
public interface CustomerManager {
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveCustomer(Customer entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Customer updateCustomer(Customer entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteCustomer(Customer entity) throws Exception;

	/**
	 * Delete the customer entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCustomerByCustomerid(Integer customerid) throws Exception;

	/**
	 * Return the customer entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Customer findCustomerByCustomerid(Integer customerid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Customer> findAllCustomers();

	/**
	 * Return a list with customers with this lastname
	 * 
	 * @param name
	 * @return
	 */
	public List<Customer> findCustomerByLastname(String lastname);

	/**
	 * Return a list with customers with this firstname
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Customer> findCustomerByFirstname(String firstname);

	/**
	 * Return a list with customers with this lastname and firstname
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Customer> findCustomerByLastnameAndFirstname(String lastname, String firstname);

	/**
	 * Return a list with customers with this adress
	 * 
	 * @param ort
	 * @return
	 */
	public List<Customer> findCustomerByCompanyname(String companyname);
}