package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerheater;

/**
 * RMI interface for handling Customerheaters.
 * 
 * @author Pascal
 * @version 1.1
 */
public interface CustomerheaterRMI extends Remote {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveCustomerheater(Customerheater entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Customerheater
	 * @throws Exception
	 */
	Customerheater updateCustomerheater(Customerheater entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteCustomerheater(Customerheater entity) throws Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCustomerheaterByCustomerheaterid(Integer customerheaterid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return Customerheater
	 * @throws RemoteException 
	 */
	Customerheater findCustomerheaterByCustomerheaterid(Integer customerheaterid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return List with all Customerheaters
	 * @throws RemoteException 
	 */
	List<Customerheater> findAllCustomerheaters() throws RemoteException;

	/**
	 * 
	 * Return the entity with this performance
	 * 
	 * @param performance
	 * @return List with Customerheaters
	 * @throws RemoteException 
	 */
	List<Customerheater> findCustomerheaterByPerformance(Integer performance) throws RemoteException;

	/**
	 * This method returns a {@link List<Customerheater>} with all heaters for the given customer
	 * 
	 * @param customer
	 * @return {@link List<Customerheater>} with all {@link Customerheater} for the given customer
	 */
	List<Customerheater> findCustomerHeaterForCustomer( Customer customer ) throws RemoteException;
}
