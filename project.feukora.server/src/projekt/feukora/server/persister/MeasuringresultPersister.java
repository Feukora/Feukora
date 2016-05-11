package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Measuringresult;

/**
 * This interface refers to a MeasuringresultPersiser
 * 
 * @version 1.1
 * @author Patrick
 *
 */
public interface MeasuringresultPersister {

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
	 * @return Measuringresult
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
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteMeasuringresultByMeasuringresultid(Integer measuringresultid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Measuringresult findMeasuringresultByMeasuringresultid(Integer measuringresultid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Measuringresult> findAllMeasuringresult();
}
