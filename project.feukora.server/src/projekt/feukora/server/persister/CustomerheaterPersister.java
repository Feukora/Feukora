package projekt.feukora.server.persister;

import java.util.List;
import projekt.feukora.server.model.Customerheater;

/**
 * This interface refers to a CustomerheaterPersister
 * 
 * @version 1.5
 * @author Pascal
 *
 */
public interface CustomerheaterPersister {
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
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCustomerheaterByCustomerheaterid(Integer customerheaterid) throws Exception;

	/**
	 * Return the entity with this id
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
	 * @return List with Customereaters
	 */
	public List<Customerheater> findCustomerheaterByPerformance(Integer performance);
}