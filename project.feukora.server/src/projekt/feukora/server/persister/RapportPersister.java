package projekt.feukora.server.persister;

import java.util.GregorianCalendar;
import java.util.List;
import projekt.feukora.server.model.Rapport;

public interface RapportPersister {
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveRapport(Rapport entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Rapport updateRapport(Rapport entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteRapport(Rapport entity) throws Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteRapportByRapportid(Integer rapportid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Rapport findRapportByRapportid(Integer rapportid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Rapport> findAllRapports();

	/**
	 * Return a list with rapports with this results
	 * 
	 * @param name
	 * @return
	 */
	public List<Rapport> findRapportByResults(Boolean results);
	
	/**
	 * Return a list with rapports with this measuringdate
	 * 
	 * @param name
	 * @return
	 */
	public List<Rapport> findRapportByMeasuringdate(GregorianCalendar measuringdate);


	
}
