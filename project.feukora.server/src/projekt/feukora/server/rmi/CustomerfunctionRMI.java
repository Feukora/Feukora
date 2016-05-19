package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Customerfunction;

/**
 * RMI interface for handling customerfunction entities
 * @author Patrick
 * @version 1.0
 */

public interface CustomerfunctionRMI extends Remote {
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveCustomerfunction(Customerfunction entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Customerfunction
	 * @throws Exception
	 */
	Customerfunction updateCustomerfunction(Customerfunction entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteCustomerfunction(Customerfunction entity) throws RemoteException, Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return Customerfunction
	 * @throws RemoteException 
	 */
	Customerfunction findCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return List with all Customerfunctions
	 */
	List<Customerfunction> findAllCustomerfunction() throws RemoteException;

	/**
	 * Return the entity with this name
	 * 
	 * @param name
	 * @return Customerfunction
	 * @throws RemoteException 
	 */
	Customerfunction findCustomerfunctionByName(String name) throws RemoteException;

}
