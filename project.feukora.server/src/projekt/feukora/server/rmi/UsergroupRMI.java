package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Usergroup;

/**
 * RMI interface for handling usergroup entities.
 * 
 * @author Tamara
 * @version 1.0
 */
public interface UsergroupRMI extends Remote {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveUsergroup(Usergroup entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Usergroup updateUsergroup(Usergroup entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteUsergroup(Usergroup entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteUsergroupByUsergroupid(Integer usergroupid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Usergroup findUsergroupByUsergroupid(Integer usergroupid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Usergroup> findAllUsergroup() throws RemoteException;

	/**
	 * Return a list with usergroup with this name
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	Usergroup findUsergroupByName(String name) throws RemoteException, Exception;
}
