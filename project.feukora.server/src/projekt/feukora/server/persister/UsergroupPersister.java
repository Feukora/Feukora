package projekt.feukora.server.persister;

import java.util.List;
import projekt.feukora.server.model.Usergroup;

/**
 * This interface refers to a UsergroupPersister
 * 
 * @version 1.4
 * @author Tamara
 *
 */
public interface UsergroupPersister {
	
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
	 * @return Usergroup
	 * @throws Exception
	 */
	Usergroup updateUsergroup(Usergroup entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteUsergroup(Usergroup entity) throws Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteUsergroupByUsergroupid(Integer usergroupid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return Usergroup
	 */
	Usergroup findUsergroupByUsergroupid(Integer usergroupid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Usergroup> findAllUsergroup();
	
	/**
	 * Return a list with entities with this name
	 * 
	 * @param name
	 * @return Usergroup
	 */
	public Usergroup findUsergroupByName(String name);
}
