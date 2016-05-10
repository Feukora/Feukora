package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Blower;

/**
 * This interface refers to a BlowerPersister
 * 
 * @version 1.1
 * @author Robin
 * 
 */
public interface BlowerPersister {
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveBlower(Blower entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Blower
	 * @throws Exception
	 */
	Blower updateBlower(Blower entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteBlower(Blower entity) throws Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteBlowerByBlowerid(Integer blowerid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return Blower
	 */
	Blower findByBlowerid(Integer blowerid);

	/**
	 * Return a list with all entities
	 * 
	 * @return List with Blowers
	 */
	List<Blower> findAllBlowers();

	/**
	 * Return a list with entities with this name
	 * 
	 * @param name
	 * @return
	 */
	public List<Blower> findBlowerByName(String name);
}