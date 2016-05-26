package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Town;

/**
 * Interface to handle town entities.
 * 
 * @author Pascal
 * @version 1.0
 *
 */
public interface TownManager {
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
	 * Return all entities
	 * 
	 * @return
	 */
	List<Town> findAllTowns();

	/**
	 * Return town-objects with this zip
	 * 
	 * @param name
	 * @return
	 */
	Town findTownByZip(Integer zip);
}