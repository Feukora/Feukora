package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Blowertype;

/**
 * Interface to handle blowertype entities.
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
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteBlowertypeByBlowertypeid(Integer blowertypeid) throws Exception;

	/**
	 * Return the entity with this id
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
	 * Return a list with blowertype with this name
	 * 
	 * @param name
	 * @return List with Blowertypes
	 */
	public Blowertype findBlowertypeByName(String name);
	
}
