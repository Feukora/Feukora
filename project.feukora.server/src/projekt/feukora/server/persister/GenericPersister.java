package projekt.feukora.server.persister;

import java.util.List;

/**
 * Interface for basic operations
 * 
 * @version 1.5
 * @author Pascal
 *
 * @param <T>
 */
public interface GenericPersister<T> {

	/**
	 * Save the entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void save(T entity) throws Exception;

	/**
	 * Update the entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	T update(T entity) throws Exception;

	/**
	 * Delete the entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void delete(T entity) throws Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteById(Integer id) throws Exception;

	/**
	 * Returns the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	T findById(Integer id);

	/**
	 * Returns all entities
	 * 
	 * @return
	 */
	List<T> findAll();
}