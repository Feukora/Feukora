package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Customerfunction;

/**
 * This interface refers to a CustomerfunctionPersister
 * 
 * @version 1.1
 * @author Allan
 *
 */
public interface CustomerfunctionPersister {

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
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) throws Exception;

	/**
	 * Return the entity with this id
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

