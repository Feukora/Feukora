package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projekt.feukora.server.model.Company;

/**
 * This class implements the interface CompanyPersister
 * 
 * @version 1.5
 * @author Robin
 */
public class CompanyPersisterImpl implements CompanyPersister {

	@Override
	public void saveCompany(Company entity) throws Exception {
		new GenericPersisterImpl<Company>(Company.class).save(entity);	
	}

	@Override
	public Company updateCompany(Company entity) throws Exception {
		return new GenericPersisterImpl<Company>(Company.class).update(entity);
	}

	@Override
	public void deleteCompany(Company entity) throws Exception {
		new GenericPersisterImpl<Company>(Company.class).delete(entity);
	}

	@Override
	public void deleteCompanyByCompanyid(Integer companyid) throws Exception {
		new GenericPersisterImpl<Company>(Company.class).deleteById(companyid);
	}

	@Override
	public Company findByCompanyid(Integer companyid) {
		return new GenericPersisterImpl<Company>(Company.class).findById(companyid);
	}

	@Override
	public List<Company> findAllCompanies() {
		return new GenericPersisterImpl<Company>(Company.class).findAll();
	}

	@Override
	public List<Company> findCompanyByName(String name) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Company> tQuery = em.createNamedQuery("Company.findByName",
				Company.class);

		tQuery.setParameter("name", name);

		List<Company> companylist = tQuery.getResultList();

		em.close();

		return companylist != null ? companylist : new ArrayList<Company>();
	}
}