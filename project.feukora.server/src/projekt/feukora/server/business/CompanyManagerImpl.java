package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Company;
import projekt.feukora.server.persister.CompanyPersister;
import projekt.feukora.server.persister.CompanyPersisterImpl;

/**
 * This Class implements the methods of the interface CompanyManager.
 * 
 * @author Robin
 * @version 1.0
 */
public class CompanyManagerImpl implements CompanyManager {
	private CompanyPersister companyPersister = new CompanyPersisterImpl();

	@Override
	public void saveCompany(Company entity) throws Exception {
		if( entity.getCompanyid() == 0 ){
			companyPersister.saveCompany(entity);
		}else{
			throw new Exception("Die Firma (id = "+ entity.getCompanyid() + ") ist bereits vorhanden");
		}
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
