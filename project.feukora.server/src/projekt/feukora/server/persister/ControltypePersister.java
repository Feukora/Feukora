package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Controltype;

/**
 * This interface refers to a ControltypePersister
 * 
 * @version 1.1
 * @author Allan
 *
 */
public interface ControltypePersister {
	
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
	 * @return Controltype
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
	 * @return Controltype
	 */
	Controltype findControltypeByControltypeid(Integer controltypeid);

	/**
	 * Return all entities
	 * 
	 * @return List with all Controltypes
	 */
	List<Controltype> findAllControltypes();

	/**
	 * Return the entity with this name
	 * 
	 * @param name
	 * @return Controltype
	 */
	Controltype findControltypeByName(String name);
}
