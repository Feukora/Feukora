package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.User;

/**
 * Interface to handle user entities.
 * 
 * @author Tamara
 * @version 1.0
 *
 */
public interface UserManager {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveUsers(User entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	User updateUsers(User entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteUsers(User entity) throws Exception;

	/**
	 * Delete the user entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteUsersByUsersid(Integer usersid) throws Exception;

	/**
	 * Return the user entity with this id
	 * 
	 * @param id
	 * @return
	 */
	User findUsersByUsersid(Integer usersid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<User> findAllUsers();

	/**
	 * Return a list with users with this lastname
	 * 
	 * @param name
	 * @return
	 */
	public List<User> findUsersByLastname(String lastname);

	/**
	 * Return a list with users with this firstname
	 * 
	 * @param vorname
	 * @return
	 */
	public List<User> findUsersByFirstname(String firstname);

	/**
	 * Return a list with users with this lastname and firstname
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<User> findUsersByLastnameAndFirstname(String lastname, String firstname);

	/**
	 * Return a list with users with this username
	 * 
	 * @param ort
	 * @return
	 */
	public User findUserByUsername(String username);
	
//	/**
//	 * Return a list with users with this usergroup
//	 * 
//	 * @param ort
//	 * @return
//	 */
//	public List<User> findUserByUsergroup(String usergroup);
	
}
