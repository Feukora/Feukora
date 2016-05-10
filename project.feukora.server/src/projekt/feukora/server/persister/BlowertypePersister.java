package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Blowertype;

public interface BlowertypePersister {
	
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
	 * @return
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
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteBlowertypeByBlowertypeid(Integer blowertypeid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Blowertype findBlowertypeByBlowertypeid(Integer blowertypeid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Blowertype> findAllBlowertypes();

	/**
	 * Return a list with blowertype with this name
	 * 
	 * @param name
	 * @return
	 */
	public List<Blowertype> findBlowertypeByName(String name);


}
