package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerfunction;

public class CustomerfunctionPersisterImpl implements CustomerfunctionPersister {

	@Override
	public void saveCustomerfunction(Customerfunction entity) throws Exception {
		new GenericPersisterImpl<Customerfunction>(Customerfunction.class).save(entity);
		
	}

	@Override
	public Customerfunction updateCustomerfunction(Customerfunction entity) throws Exception {
		return new GenericPersisterImpl<Customerfunction>(Customerfunction.class).update(entity);
	}

	@Override
	public void deleteCustomerfunction(Customerfunction entity) throws Exception {
		new GenericPersisterImpl<Customerfunction>(Customerfunction.class).delete(entity);
		
	}

	@Override
	public void deleteCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) throws Exception {
		new GenericPersisterImpl<Customerfunction>(Customerfunction.class).deleteById(customerfunctionid);
		
	}

	@Override
	public Customerfunction findCustomerfunctionByCustomerfunctionid(Integer customerfunctionid) {
		return new GenericPersisterImpl<Customerfunction>(Customerfunction.class).findById(customerfunctionid);
	}

	@Override
	public List<Customerfunction> findAllCustomerfunction() {
		return new GenericPersisterImpl<Customerfunction>(Customerfunction.class).findAll();
		
	}

	@Override
	public List<Customerfunction> findCustomerfunctionByFirstname(String firstname) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Customerfunction> tQuery = em.createNamedQuery("Customerfunction.findByFirstname",
				Customerfunction.class);

		tQuery.setParameter("firstname", firstname);

		List<Customerfunction> customerfunctionlist = tQuery.getResultList();

		em.close();

		return customerfunctionlist != null ? customerfunctionlist : new ArrayList<Customerfunction>();
	}

	// die fünf Grundmethoden 
	
	

}
