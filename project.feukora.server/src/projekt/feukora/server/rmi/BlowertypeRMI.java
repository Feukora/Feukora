package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Blowertype;

/**
 * RMI interface for handling blowertype entities
 * 
 * @author Patrick
 * @version 1.0
 */
public interface BlowertypeRMI extends Remote {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveBlowertype(Blowertype entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Blowertype updateBlowertype(Blowertype entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteBlowertype(Blowertype entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteBlowertypeByBlowertypeid(Integer blowertypeid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Blowertype findBlowertypeByBlowertypeid(Integer blowertypeid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Blowertype> findAllBlowertypes() throws RemoteException;

	/**
	 * Return a list with blowertypes with this name
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	Blowertype findBlowertypeByName(String name) throws RemoteException, Exception;
}
