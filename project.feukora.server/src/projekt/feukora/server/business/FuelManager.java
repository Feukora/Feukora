package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Fuel;

/**
 * Interface for handling fuel entities.
 * 
 * @author Tamara
 * @version 1.0
 *
 */
public interface FuelManager {
	
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
	 * Delete the fuel entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteFuelByFuelid(Integer fuelid) throws Exception;

	/**
	 * Return the fuel entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Fuel findFuelByfuelid(Integer fuelid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Fuel> findAllFuel();

	/**
	 * Return fuel-objects with this name
	 * 
	 * @param name
	 * @return
	 */
	public Fuel findFuelByName(String name);
}
