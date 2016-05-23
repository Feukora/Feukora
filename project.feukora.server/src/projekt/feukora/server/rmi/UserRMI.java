package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Users;

/**
 * RMI interface for handling User entities
 * 
 * @author Tamara 
 * @version 1.1
 *
 */
public interface UserRMI extends Remote{
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveUsers(Users entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Users updateUsers(Users entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteUsers(Users entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteUserByUserid(Integer usersid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Users findUsersByUserid(Integer usersid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Users> findAllUsers() throws RemoteException;

	/**
	 * Return a list with users with this lastname
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public List<Users> findUsersByLastname(String lastname) throws RemoteException;

	/**
	 * Return a list with users with this firstname
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Users> findUsersByFirstname(String firstname) throws RemoteException ;

	/**
	 * Return a list with users with this lastname and firstname
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Users> findUsersByLastnameAndFirstname(String lastname, String firstname) throws RemoteException ;

	/**
	 * Return a list with users with this username
	 * 
	 * @param ort
	 * @return
	 */
	public List<Users> findUsersByUsername(String username) throws RemoteException ;
}
