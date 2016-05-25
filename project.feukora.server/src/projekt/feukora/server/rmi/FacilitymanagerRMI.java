package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Facilitymanager;

/**
 * RMI interface for handling Facilitymanagers
 * 
 * @author Pascal
 * @version 1.0
 */

public interface FacilitymanagerRMI extends Remote {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveFacilitymanager(Facilitymanager entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Facilitymanager updateFacilitymanager(Facilitymanager entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteFacilitymanager(Facilitymanager entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteFacilitymanagerByFacilitymanagerid(Integer facilitymanagerid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Facilitymanager findFacilitymanagerByFacilitymanagerid(Integer facilitymanagerid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Facilitymanager> findAllFacilitymanagers() throws RemoteException;

	/**
	 * Return a list with facilitymanagers with this lastname
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public List<Facilitymanager> findFacilitymanagerByLastname(String lastname) throws RemoteException;

}
