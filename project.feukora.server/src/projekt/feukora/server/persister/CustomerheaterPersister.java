package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Customerheater;

/**
 * This interface refers to a CustomerheaterPersister
 * 
 * @version 1.1
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
	void saveCustomer(Customerheater entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Customerheater
	 * @throws Exception
	 */
	Customerheater updateCustomer(Customerheater entity) throws Exception;

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
}