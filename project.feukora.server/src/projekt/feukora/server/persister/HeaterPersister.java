package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Heater;

public interface HeaterPersister {
	
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
	 * @return
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
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteHeaterByHeaterid(Integer heaterid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
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
	 * @return
	 */
	public List<Heater> findHeaterByName(String name);

	
}

