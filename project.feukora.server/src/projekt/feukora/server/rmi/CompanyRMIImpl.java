package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.business.CompanyManager;
import projekt.feukora.server.business.CompanyManagerImpl;
import projekt.feukora.server.model.Company;
import projekt.feukora.server.persister.JpaUtil;

/**
 *  This Class implements the methods of the interface CompanyRMI
 * @author Robin Purtschert
 * @version 1.0
 */
public class CompanyRMIImpl extends UnicastRemoteObject implements CompanyRMI {

	private static final long serialVersionUID = 724994631535546964L;
	
	private CompanyManager companyManager;

	public CompanyRMIImpl() throws RemoteException {
		companyManager = new CompanyManagerImpl();
	}

	@Override
	public void saveCompany(Company entity) throws RemoteException, Exception {
		companyManager.saveCompany(entity);	
	}

	@Override
	public Company updateCompany(Company entity) throws RemoteException, Exception {
		return companyManager.updateCompany(entity);
	}

	@Override
	public void deleteCompany(Company entity) throws RemoteException, Exception {
		companyManager.deleteCompany(entity);
	}

	@Override
	public void deleteCompanyByCompanyid(Integer companyid) throws RemoteException, Exception {
		companyManager.deleteCompanyByCompanyid(companyid);	
	}

	@Override
	public Company findCompanyByCompanyid(Integer companyid) throws RemoteException {
		return companyManager.findCompanyByCompanyid(companyid);
	}

	@Override
	public List<Company> findAllCompanies() throws RemoteException {
		return companyManager.findAllCompanies();
	}

	@Override
	public List<Company> findCompanyByName(String name)throws RemoteException {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Company> tQuery = em.createNamedQuery("Company.findByName",
				Company.class);

		tQuery.setParameter("name", name);

		List<Company> companylist = tQuery.getResultList();

		em.close();

		return companylist != null ? companylist : new ArrayList<Company>();
	}

}
