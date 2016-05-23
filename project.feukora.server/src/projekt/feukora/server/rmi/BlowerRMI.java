package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Blower;

/**
 * RMI interface for handling blower entities
 * 
 * @author Robin 
 * @version 1.1
 */

public interface BlowerRMI extends Remote{
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveBlower(Blower entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Blower updateBlower(Blower entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteBlower(Blower entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteBlowerByBlowerid(Integer blowerid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Blower findBlowerByBlowerid(Integer blowerid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Blower> findAllBlowers() throws RemoteException;

	/**
	 * Return a list with blowers with this name
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public List<Blower> findBlowerByName(String name) throws RemoteException, Exception;

}
