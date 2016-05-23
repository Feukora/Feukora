package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Fuel;

/**
 * RMI interface for handling controltype entities.
 * 
 * @author Tamara
 *
 */
public interface ControltypeRMI extends Remote{
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveControltype(Controltype entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Controltype updateControltype(Controltype entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteControltype(Controltype entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteControltypeByControltypeid(Integer controltypeid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Controltype findControltypeByControltypeid(Integer controltypeid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Controltype> findAllControltype() throws RemoteException;

	/**
	 * Return a list with controltypes with this name
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public Controltype findControltypeByName(String name) throws RemoteException, Exception;

}
