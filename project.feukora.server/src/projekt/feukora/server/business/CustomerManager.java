package projekt.feukora.server.business;

import java.rmi.Remote;
import java.util.List;

import projekt.feukora.server.model.Customer;

public interface CustomerManager extends Remote{
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
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCustomerByCustomerid(Integer customerid) throws Exception;

	/**
	 * Return the entity with this id
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
	 * Return a list with cusomerts with this lastname
	 * 
	 * @param name
	 * @return
	 */
	public List<Customer> findCustomerByLastname(String lastname);

	/**
	 * Return a list with cusomerts with this firstname
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Customer> findCustomerByFirstname(String firstname);

	/**
	 * Return a list with cusomerts with this lastname and firstname
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Customer> findCustomerByLastnameAndFirstname(String lastname, String firstname);

	/**
	 * Return a list with cusomerts with this adress
	 * 
	 * @param ort
	 * @return
	 */
	public List<Customer> findCustomerByCompanyname(String companyname);
}
