package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Heater;

/**
 * Interface to handle heater entities.
 * 
 * @author Patrick
 * @version 1.0
 *
 */

public interface HeaterManager {
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveHeater(Heater entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Heater
	 * @throws Exception
	 */
	Heater updateHeater(Heater entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteHeater(Heater entity) throws Exception;

	/**
	 * Delete the heater entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteHeaterByHeaterid(Integer heaterid) throws Exception;

	/**
	 * Return the heater entity with this id
	 * 
	 * @param id
	 * @return Heater
	 */
	Heater findHeaterByHeaterid(Integer heaterid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Heater> findAllHeaters();

	/**
	 * Return a list with heaters with this name
	 * 
	 * @param name
	 * @return List of Heaters
	 */
	public List<Heater> findHeaterByName(String name);

}
