package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Blower;

/**
 * Interface to handle blower entities.
 * 
 * @author Robin
 * @version 1.0
 *
 */
public interface BlowerManager {
	
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
	 * Delete the blower entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteBlowerByBlowerid(Integer blowerid) throws Exception;

	/**
	 * Return the blower entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Blower findBlowerByBlowerid(Integer blowerid);

	/**
	 * Return all entities
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
