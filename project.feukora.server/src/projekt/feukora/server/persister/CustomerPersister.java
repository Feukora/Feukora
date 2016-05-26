package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Customer;

/**
 * This interface refers to a CustomerPersister
 * 
 * @version 1.5
 * @author Pascal
 *
 */
public interface CustomerPersister {

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
	 * @return Customer
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
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCustomerByCustomerid(Integer customerid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return Customer
	 */
	Customer findCustomerByCustomerid(Integer customerid);

	/**
	 * Return all entities
	 * 
	 * @return List with Customers
	 */
	List<Customer> findAllCustomers();

	/**
	 * Return a list with customers with this lastname
	 * 
	 * @param lastname
	 * @return List with Customers
	 */
	public List<Customer> findCustomerByLastname(String lastname);

	/**
	 * Return a list with customers with this firstname
	 * 
	 * @param firstname
	 * @return List with Customers
	 */
	public List<Customer> findCustomerByFirstname(String firstname);

	/**
	 * Return a list with customers with this lastname and firstname
	 * 
	 * @param lastname
	 * @param firstname
	 * @return List with Customers
	 */
	public List<Customer> findCustomerByLastnameAndFirstname(String lastname, String firstname);

	/**
	 * Return a list with customers with this Companyname
	 * 
	 * @param companyname
	 * @return List with Customers
	 */
	public List<Customer> findCustomerByCompanyname(String companyname);
}