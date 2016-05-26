package projekt.feukora.server.persister;

import java.util.List;
import projekt.feukora.server.model.Facilitymanager;

/**
 * This interface refers to a Facilitymanager
 * 
 * @version 1.5
 * @author Pascal
 *
 */
public interface FacilitymanagerPersister {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveFacilitymanager(Facilitymanager entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Facilitymanager
	 * @throws Exception
	 */
	Facilitymanager updateFacilitymanager(Facilitymanager entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteFacilitymanager(Facilitymanager entity) throws Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteFacilitymanagerByFacilitymanagerid(Integer Facilitymanagerid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id 
	 * @return Facilitymanager
	 */
	Facilitymanager findFacilitymanagerByFacilitymanagerid(Integer Facilitymanagerid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Facilitymanager> findAllFacilitymanagers();

	/**
	 * Return a list with Facilitymanager with this lastname
	 * 
	 * @param name
	 * @return List with Facilitymanager
	 */
	List<Facilitymanager> findFacilitymanagerByLastname(String lastname);
}