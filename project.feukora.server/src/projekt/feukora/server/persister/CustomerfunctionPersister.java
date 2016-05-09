package projekt.feukora.server.persister;

	import java.util.List;
	import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;

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
		 * @return
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
		 * Save the entity with this id
		 * 
		 * @param id
		 * @throws Exception
		 */
		void deleteCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) throws Exception;

		/**
		 * Return the entity with this id
		 * 
		 * @param id
		 * @return
		 */
		Customerfunction findCustomerfunctionByCustomerfunctionid(Integer customerfunctionid);

		/**
		 * Return all entities
		 * 
		 * @return
		 */
		List<Customerfunction> findAllCustomerfunction();
		
		/**
		 * Return a list with cusomerts with this firstname
		 * 
		 * @param vorname
		 * @return
		 */
		public List<Customerfunction> findCustomerfunctionByFirstname(String firstname);

	}

