package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import projekt.feukora.server.model.Company;

/**
 * RMI interface for handling customer entities
 * @author Sandro Fasser
 * @version 1.0
 */
/**
 * @author Robin Purtschert
 * @version 1.1
 */
public interface CompanyRMI extends Remote{
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveCompany(Company entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	Company updateCompany(Company entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteCompany(Company entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteCompanyByCompanyid(Integer companyid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Company findCompanyByCompanyid(Integer customerid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Company> findAllCompanies() throws RemoteException;

	/**
	 * Return a list with companies with this name
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	public List<Company> findCompanyByName(String name) throws RemoteException;

}
