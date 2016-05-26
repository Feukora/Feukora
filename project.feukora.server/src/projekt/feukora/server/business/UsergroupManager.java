package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Usergroup;

/**
 * Interface to handle usergroup entities.
 * 
 * @author Tamara
 * @version 1.4
 *
 */
public interface UsergroupManager {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveUsergroup(Usergroup entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Usergroup updateFuel(Usergroup entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteUsergroup(Usergroup entity) throws Exception;

	/**
	 * Delete the customer entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteUsergroupByUsergroupid(Integer usergroupid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Usergroup findUsergroupByUsergroupid(Integer usergroupid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Usergroup> findAllUsergroup();

	/**
	 * Return usergroup-objects with this name
	 * 
	 * @param name
	 * @return
	 */
	public Usergroup findFuelByName(String name);
}