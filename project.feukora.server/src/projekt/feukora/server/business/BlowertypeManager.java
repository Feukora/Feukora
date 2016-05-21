package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Blowertype;

/**
 * Interface to handle blowertype entities.
 * 
 * @author Patrick
 * @version 1.0
 *
 */

public interface BlowertypeManager {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveBlowertype(Blowertype entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Blowertype
	 * @throws Exception
	 */
	Blowertype updateBlowertype(Blowertype entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteBlowertype(Blowertype entity) throws Exception;

	/**
	 * Delete the blowertype entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteBlowertypeByBlowertypeid(Integer blowertypeid) throws Exception;

	/**
	 * Return the blowertype entity with this id
	 * 
	 * @param id
	 * @return Blowertye
	 */
	Blowertype findBlowertypeByBlowertypeid(Integer blowertypeid);

	/**
	 * Return all entities
	 * 
	 * @return List with Blowertypes
	 */
	List<Blowertype> findAllBlowertypes();

	/**
	 * Return blowertype-objects with this name
	 * 
	 * @param name
	 * @return List with Blowertypes
	 */
	public Blowertype findBlowertypeByName(String name);
	
}
