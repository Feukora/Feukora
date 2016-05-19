package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Fuel;

public interface ControltypeManager {
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveControltype(Controltype entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Controltype updateControltype(Controltype entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteControltype(Controltype entity) throws Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteControltypeByControltypeid(Integer controltypeid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Controltype findControltypeByControltypeid(Integer controltypeid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Controltype> findAllControltype();

	/**
	 * Return a list with controltypes with this name
	 * 
	 * @param name
	 * @return
	 */
	public Controltype findControltypeByName(String name);

}
