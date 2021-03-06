package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Measuringresult;

/**
 * Interface to handle measuringresult entities.
 * 
 * @author Patrick
 * @version 1.4
 *
 */
public interface MeasuringresultManager {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveMeasuringresult(Measuringresult entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Heater
	 * @throws Exception
	 */
	Measuringresult updateMeasuringresult(Measuringresult entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteMeasuringresult(Measuringresult entity) throws Exception;

	/**
	 * Delete the measuringresult entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteMeasuringresultByMeasuringresultid(Integer measuringresultid) throws Exception;

	/**
	 * Return the measuringresult entity with this id
	 * 
	 * @param id
	 * @return Heater
	 */
	Measuringresult findMeasuringresultByMeasuringresultid(Integer measuringresultid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Measuringresult> findAllMeasuringresults();
}