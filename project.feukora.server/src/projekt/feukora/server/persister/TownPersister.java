package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Town;

/**
 * This class refers to a Town
 * @author Robin
 * @version 1.0
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
	 * @return
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
	
	void deleteTownByTownzip(Town zip) throws Exception;

	/**
	 * Return the entity with this zip number
	 * 
	 * @param id
	 * @return
	 */
	List<Town> findbyTownzip(Integer zip);

	/**
	 * Return a list with all entities
	 * 
	 * @return
	 */
	List<Town> findAllTowns();

	/**
	 * Return a list with entities with this name
	 * 
	 * @param name
	 * @return
	 */
	public List<Town> findTownByName(String name);
	
	/**
	 * Return a list with entities with this canton
	 * 
	 * @param name
	 * @return
	 */
	public List<Town> findTownByCanton(String canton);
	
	/**
	 * Return a list with entities with this municipality
	 * 
	 * @param name
	 * @return
	 */
	public List<Town> findTownByMunicipality (String municipality);



	
	

}
