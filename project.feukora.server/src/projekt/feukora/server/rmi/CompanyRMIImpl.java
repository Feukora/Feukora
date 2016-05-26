package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import projekt.feukora.server.business.CompanyManager;
import projekt.feukora.server.business.CompanyManagerImpl;
import projekt.feukora.server.model.Company;

/**
 *  This Class implements the methods of the interface CompanyRMI
 *  
 * @author Robin 
 * @version 1.1
 */
public class CompanyRMIImpl extends UnicastRemoteObject implements CompanyRMI {

	private static final long serialVersionUID = 5688064118469483727L;

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
		return companyManager.findCompanyByName(name);	
	}
}
