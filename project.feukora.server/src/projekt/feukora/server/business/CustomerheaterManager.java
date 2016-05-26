package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Customerheater;

/**
 * Interface to handle customerheater entities.
 * 
 * @author Pascal
 * @version 1.4
 *
 */
public interface CustomerheaterManager {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveCustomerheater(Customerheater entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Customerheater
	 * @throws Exception
	 */
	Customerheater updateCustomerheater(Customerheater entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteCustomerheater(Customerheater entity) throws Exception;

	/**
	 * Delete the customerheater entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCustomerheaterByCustomerheaterid(Integer customerheaterid) throws Exception;

	/**
	 * Return the customerheater entity with this id
	 * 
	 * @param id
	 * @return Customerheater
	 */
	Customerheater findCustomerheaterByCustomerheaterid(Integer customerheaterid);

	/**
	 * Return all entities
	 * 
	 * @return List with all Customerheaters
	 */
	List<Customerheater> findAllCustomerheaters();
	
	/**
	 * 
	 * Return the entity with this performance
	 * 
	 * @param performance
	 * @return List with Customerheaters
	 */
	public List<Customerheater> findCustomerheaterByPerformance(Integer performance);
}