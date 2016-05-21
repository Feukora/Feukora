package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Facilitymanager;

/**
 * Interface to handle facillitymanager entities.
 * 
 * @author Pascal
 * @version 1.0
 *
 */

public interface FacilitymanagerManager {
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
	 * Delete the facilitymanager entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteFacilitymanagerByFacilitymanagerid(Integer Facilitymanagerid) throws Exception;

	/**
	 * Return the facilitymanager entity with this id
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
	public List<Facilitymanager> findFacilitymanagerByLastname(String lastname);

	/**
	 * Return a list with Facilitymanager with this firstname
	 * 
	 * @param firstname
	 * @return List with Facilitymanagers
	 */
	public List<Facilitymanager> findFacilitymanagerByFirstname(String firstname);
}
