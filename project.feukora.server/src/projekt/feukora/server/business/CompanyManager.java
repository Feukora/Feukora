package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Company;

/**
 * Interface to handle company entities.
 * 
 * @author Robin
 * @version 1.1
 *
 */
public interface CompanyManager {

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
	 * Delete the company entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteCompanyByCompanyid(Integer companyid) throws Exception;

	/**
	 * Return the company entity with this id
	 * 
	 * @param id
	 * @return
	 */
	Company findCompanyByCompanyid(Integer companyid);

	/**
	 * Return all entities
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
