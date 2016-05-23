package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Heater;

/**
 * RMI interface for handling heater entities
 * 
 * @author Patrick 
 * @version 1.1
 */

public interface HeaterRMI extends Remote{
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveHeater(Heater entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Heater updateHeater(Heater entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteHeater(Heater entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteHeaterByHeaterid(Integer heaterid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Heater findHeaterByheaterid(Integer heaterid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Heater> findAllHeaters() throws RemoteException;

	/**
	 * Return a list with heaters with this name
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public List<Heater> findHeaterByName(String name) throws RemoteException;

}
