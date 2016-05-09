package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Deficit;

public interface DeficitPersister {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveDeficit(Deficit entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Deficit updateDeficit(Deficit entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteDeficit(Deficit entity) throws Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteDeficitByDeficitid(Integer Deficitid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Deficit findDeficitByDeficitid(Integer Deficitid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Deficit> findAllDeficits();

	/**
	 * Return a list with cusomerts with this lastname
	 * 
	 * @param name
	 * @return
	 */

}