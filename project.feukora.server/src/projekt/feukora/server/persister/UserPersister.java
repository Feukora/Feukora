package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Users;

/**
 * This interface refers to a UserPersister
 * 
 * @version 1.1
 * @author Tamara
 *
 */
public interface UserPersister {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveUser(Users entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Users
	 * @throws Exception
	 */
	Users updateUser(Users entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteUser(Users entity) throws Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteUserByUserid(Integer userid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return Useres
	 */
	Users findUserByUserid(Integer userid);

	/**
	 * Return all entities
	 * 
	 * @return List with Users
	 */
	List<Users> findAllUsers();

	/**
	 * Return a list of users with this lastname
	 * 
	 * @param name
	 * @return List with Users
	 */
	public List<Users> findUserByLastname(String lastname);

	/**
	 * Return a list of users with this firstname
	 * 
	 * @param vorname
	 * @return List with Users
	 */
	public List<Users> findUserByFirstname(String firstname);

	/**
	 * Return a list of users with this lastname and firstname
	 * 
	 * @param lastname
	 * @param firstname
	 * @return List with users
	 */
	public List<Users> findUserByLastnameAndFirstname(String lastname, String firstname);
	
	/**
	 * Return a list of users with this username
	 * 
	 * @param username
	 * @return List with users
	 */
	public List<Users> findUserByUsername(String username);
}
