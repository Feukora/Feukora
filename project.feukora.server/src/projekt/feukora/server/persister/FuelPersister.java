package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Fuel;

/**
 * This is the interface for the class FuelPersisterImpl
 * @author Tamara
 * @version
 */
public interface FuelPersister {
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveFuel(Fuel entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Fuel updateFuel(Fuel entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteFuel(Fuel entity) throws Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteFuelByFuelid(Integer fuelid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Fuel findFuelByFuelid(Integer fuelid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Fuel> findAllFuel();

}
