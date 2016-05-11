package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Town;

/**
 * This interface refers to a TownPersister
 * 
 * @version 1.1
 * @author Robin
 *
 */
public interface TownPersister {
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveTown(Town entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Town
	 * @throws Exception
	 */
	Town updateTown(Town entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteTown(Town entity) throws Exception;

	/**
	 * Delete the entity with this zip number
	 * 
	 * @param id
	 * @throws Exception
	 */
	
	void deleteTownByTownzip(Integer zip) throws Exception;

	/**
	 * Return the entity with this zip number
	 * 
	 * @param id
	 * @return List of Towns
	 */
	List<Town> findbyTownzip(Integer zip);

	/**
	 * Return a list with all entities
	 * 
	 * @return List of Towns
	 */
	List<Town> findAllTowns();

	/**
	 * Return a list with entities with this name
	 * 
	 * @param name
	 * @return List of Towns
	 */
	public List<Town> findTownByName(String name);
	
	/**
	 * Return a list with entities with this canton
	 * 
	 * @param name
	 * @return List of Towns
	 */
	public List<Town> findTownByCanton(String canton);
}
