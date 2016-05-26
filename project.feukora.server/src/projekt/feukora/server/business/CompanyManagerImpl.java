package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Company;
import projekt.feukora.server.persister.CompanyPersister;
import projekt.feukora.server.persister.CompanyPersisterImpl;

/**
 * This Class implements the methods of the interface CompanyManager.
 * 
 * @author Robin
 * @version 1.4
 */
public class CompanyManagerImpl implements CompanyManager {
	private CompanyPersister companyPersister = new CompanyPersisterImpl();

	@Override
	public void saveCompany(Company entity) throws Exception {
		companyPersister.saveCompany(entity);
	}

	@Override
	public Company updateCompany(Company entity) throws Exception {
		return companyPersister.updateCompany(entity);	
	}

	@Override
	public void deleteCompany(Company entity) throws Exception {
		companyPersister.deleteCompany(entity);
	}

	@Override
	public void deleteCompanyByCompanyid(Integer companyid) throws Exception {
		companyPersister.deleteCompanyByCompanyid(companyid);	
	}

	@Override
	public Company findCompanyByCompanyid(Integer companyid) {
		return companyPersister.findByCompanyid(companyid);
	}

	@Override
	public List<Company> findAllCompanies() {
		return companyPersister.findAllCompanies();
	}

	@Override
	public List<Company> findCompanyByName(String name) {
		return companyPersister.findCompanyByName(name);
	}
}