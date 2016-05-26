package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Controltype;

/**
 * Interface to handle controltype entities.
 * 
 * @author Tamara
 * @version 1.4
 * 
 */
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
	 * Delete the controltype entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteControltypeByControltypeid(Integer controltypeid) throws Exception;

	/**
	 * Return the controltype entity with this id
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
	 * Return controltype-objects with this name
	 * 
	 * @param name
	 * @return
	 */
	public Controltype findControltypeByName(String name);
}