package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Users;
/**
 * 
 * @author Tamara
 * version 1.0
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
	 * @return
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
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteUserByUserid(Integer userid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Users findUserByUserid(Integer userid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Users> findAllUsers();

	/**
	 * Return a list of users with this lastname
	 * 
	 * @param name
	 * @return
	 */
	public List<Users> findUserByLastname(String lastname);

	/**
	 * Return a list of users with this firstname
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Users> findUserByFirstname(String firstname);

	/**
	 * Return a list of users with this lastname and firstname
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 */
	public List<Users> findUserByLastnameAndFirstname(String lastname, String firstname);
	
	/**
	 * Return a list of users with this username
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Users> findUserByUsername(String username);

	
}
