package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Usergroup;


/**
 * This is the interface for the class UsergroupPersisterImpl.
 * @author Tamara
 * @version 1.0
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
	 * @return
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
	 * Save the entity with this id
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
	
	

}
