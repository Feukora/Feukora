package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Blower;

/**
 * This class refers to a Blower
 * @author Robin
 * @version 1.0
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
	 * @return
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
	 * @return
	 */
	Blower findByBlowerid(Integer blowerid);

	/**
	 * Return a list with all entities
	 * 
	 * @return
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