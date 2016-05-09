package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Customer;

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
	 * Save the entity with this id
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
	List<Controltype> findAllControltypes();

	/**
	 * Return a list with cusomerts with this name
	 * 
	 * @param name
	 * @return
	 */
	public List<Controltype> findControltypeByName(String name);


}
