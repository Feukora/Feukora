package projekt.feukora.server.business;

import java.util.GregorianCalendar;
import java.util.List;
import projekt.feukora.server.model.Rapport;

/**
 * Interface for handling rapport entities.
 * 
 * @author Sandro
 * @version 1.4
 *
 */
public interface RapportManager {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveRapport(Rapport entity) throws  Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Rapport
	 * @throws Exception
	 */
	Rapport updateRapport(Rapport entity) throws  Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteRapport(Rapport entity) throws  Exception;

	/**
	 * Delete the rapport entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteRapportByRapportid(Integer rapportid) throws  Exception;

	/**
	 * Return the rapport entity with this id
	 * 
	 * @param id
	 * @return Rapport
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
	 * @return List with Rapports
	 */
	List<Rapport> findRapportByResults(Boolean results);

	/**
	 * Return a list with rapports with this measuringdate
	 * 
	 * @param name
	 * @return List with Rapports
	 */
	List<Rapport> findRapportByMeasuringdate(GregorianCalendar measuringdate);
}