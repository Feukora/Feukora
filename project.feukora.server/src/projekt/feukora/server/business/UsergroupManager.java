package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Usergroup;

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
	 * Return a list with usergroup with this name
	 * 
	 * @param name
	 * @return
	 */
	public Usergroup findFuelByName(String name);
}
