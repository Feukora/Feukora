package projekt.feukora.server.persister;
import java.util.List;

import projekt.feukora.server.model.Company;
 /**
  * This class refers to a Company.
  * @author Robin
  * @version 1.0
  */
public interface CompanyPersister {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveCompany(Company entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Company updateCompany(Company entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteCompany(Company entity) throws Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCompanyByCompanyid(Integer companyid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Company findByCompanyid(Integer companyid);

	/**
	 * Return a list with all entities
	 * 
	 * @return
	 */
	List<Company> findAllCompanies();

	/**
	 * Return a list with entities with this name
	 * 
	 * @param name
	 * @return
	 */
	public List<Company> findCompanyByName(String name);
	
}