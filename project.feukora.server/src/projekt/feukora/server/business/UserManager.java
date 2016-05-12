package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Users;

/**
 * 
 * @author Tamara
 *
 */
public interface UserManager {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveUsers(Users entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Users updateUsers(Users entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteUsers(Users entity) throws Exception;

	/**
	 * Delete the customer entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteUsersByUsersid(Integer usersid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Users findUsersByusersid(Integer usersid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Users> findAllUsers();

	/**
	 * Return a list with users with this lastname
	 * 
	 * @param name
	 * @return
	 */
	public List<Users> findUsersByLastname(String lastname);

	/**
	 * Return a list with users with this firstname
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Users> findUsersByFirstname(String firstname);

	/**
	 * Return a list with users with this lastname and firstname
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Users> findUsersByLastnameAndFirstname(String lastname, String firstname);

	/**
	 * Return a list with users with this username
	 * 
	 * @param ort
	 * @return
	 */
	public List<Users> findUserByUsername(String username);
	
}
