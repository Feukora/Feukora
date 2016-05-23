package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Fuel;

/**
 * RMI interface for handling fuel entities.
 * 
 * @author Tamara
 * @version 1.0
 */
public interface FuelRMI extends Remote {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveFuel(Fuel entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Fuel updateFuel(Fuel entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteFuel(Fuel entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteFuelByFuelid(Integer fuelid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Fuel findFuelByFuelid(Integer fuelid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Fuel> findAllFuel() throws RemoteException;

	/**
	 * Return a list with blowers with this name
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public Fuel findFuelByName(String name) throws RemoteException, Exception;
}
