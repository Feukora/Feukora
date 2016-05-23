package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Town;

/**
 * RMI interface for handling town entities.
 * 
 * @author Pascal
 * @version 1.0
 */
public interface TownRMI extends Remote{
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveTown(Town entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Town updateTown(Town entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteTown(Town entity) throws RemoteException, Exception;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Town> findAllTowns() throws RemoteException;

	/**
	 * Return a list with towns with this zip
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public Town findTownByZip(Integer zip) throws RemoteException;
}