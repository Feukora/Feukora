package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.User;
import projekt.feukora.server.model.Usergroup;

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
	void saveUsers(User entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	User updateUsers(User entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteUsers(User entity) throws RemoteException, Exception;

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
	User findUsersByUserid(Integer usersid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<User> findAllUsers() throws RemoteException;

	/**
	 * Return a list with users with this lastname
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	List<User> findUsersByLastname(String lastname) throws RemoteException;

	/**
	 * Return a list with users with this firstname
	 * 
	 * @param vorname
	 * @return
	 */
	List<User> findUsersByFirstname(String firstname) throws RemoteException ;

	/**
	 * Return a list with users with this lastname and firstname
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	List<User> findUsersByLastnameAndFirstname(String lastname, String firstname) throws RemoteException ;

	/**
	 * Return a list with users with this username
	 * 
	 * @param ort
	 * @return
	 */
	User findUsersByUsername(String username) throws RemoteException ;

	/**
	 * Return a list with users with this usergroup
	 * 
	 * @param usergroup
	 * @return
	 */
	List<User> findUserByUsergroup(Usergroup usergroup) throws RemoteException ;
}
