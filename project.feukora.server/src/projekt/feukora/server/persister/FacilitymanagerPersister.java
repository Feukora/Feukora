package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Facilitymanager;

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
	 * @return
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
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteFacilitymanagerByFacilitymanagerid(Integer Facilitymanager) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Facilitymanager findFacilitymanagerByFacilitymanagerid(Integer Facilitymanagerid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Facilitymanager> findAllFacilitymanagers();
}