package projekt.feukora.server.persister;

import java.util.List;
import projekt.feukora.server.model.User;
import projekt.feukora.server.model.Usergroup;

/**
 * This interface refers to a UserPersister
 * 
 * @version 1.4
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
	void saveUser(User entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Users
	 * @throws Exception
	 */
	User updateUser(User entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteUser(User entity) throws Exception;

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
	User findUserByUserid(Integer userid);

	/**
	 * Return all entities
	 * 
	 * @return List with Users
	 */
	List<User> findAllUsers();

	/**
	 * Return a list of users with this lastname
	 * 
	 * @param name
	 * @return List with Users
	 */
	List<User> findUserByLastname(String lastname);

	/**
	 * Return a list of users with this firstname
	 * 
	 * @param vorname
	 * @return List with Users
	 */
	List<User> findUserByFirstname(String firstname);

	/**
	 * Return a list of users with this lastname and firstname
	 * 
	 * @param lastname
	 * @param firstname
	 * @return List with users
	 */
	List<User> findUserByLastnameAndFirstname(String lastname, String firstname);

	/**
	 * Return a list of users with this username
	 * 
	 * @param username
	 * @return user corresponding to the username
	 */
	User findUserByUsername(String username);

	/**
	 * Return a list of users with this usergroup
	 * 
	 * @param username
	 * @return user corresponding to the usergroup
	 */
	List<User> findUserByUsergroup(Usergroup usergroup);
}