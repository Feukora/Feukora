package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Customerfunction;

/**
 * Interface to handle Customerfunction entities.
 * 
 * @author Patrick
 * @version 1.0
 *
 */
public interface CustomerfunctionManager {
	
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveCustomerfunction(Customerfunction entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Customerfunction
	 * @throws Exception
	 */
	Customerfunction updateCustomerfunction(Customerfunction entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteCustomerfunction(Customerfunction entity) throws Exception;

	/**
	 * Delete the customerfunction entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) throws Exception;

	/**
	 * Return the customerfunction entity with this id
	 * 
	 * @param id
	 * @return Customerfunction
	 */
	Customerfunction findCustomerfunctionByCustomerfunctionid(Integer customerfunctionid);

	/**
	 * Return all entities
	 * 
	 * @return List with all Customerfunctions
	 */
	List<Customerfunction> findAllCustomerfunction();

	/**
	 * Return the entity with this name
	 * 
	 * @param name
	 * @return Customerfunction
	 */
	Customerfunction findCustomerfunctionByName(String name);
}
