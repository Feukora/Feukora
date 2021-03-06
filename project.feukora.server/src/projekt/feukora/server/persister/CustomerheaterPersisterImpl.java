package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerheater;

/**
 * This class implements the interface CustomerheaterPersister
 * 
 * @version 1.6
 * @author Pascal
 *
 */
public class CustomerheaterPersisterImpl implements CustomerheaterPersister {

	@Override
	public void saveCustomerheater(Customerheater entity) throws Exception {
		new GenericPersisterImpl<Customerheater>(Customerheater.class).save(entity);	
	}

	@Override
	public Customerheater updateCustomerheater(Customerheater entity) throws Exception {
		return new GenericPersisterImpl<Customerheater>(Customerheater.class).update(entity);
	}

	@Override
	public void deleteCustomerheater(Customerheater entity) throws Exception {
		new GenericPersisterImpl<Customerheater>(Customerheater.class).delete(entity);
	}

	@Override
	public void deleteCustomerheaterByCustomerheaterid(Integer customerheaterid) throws Exception {
		new GenericPersisterImpl<Customerheater>(Customerheater.class).deleteById(customerheaterid);	
	}

	@Override
	public Customerheater findCustomerheaterByCustomerheaterid(Integer customerheaterid) {
		return new GenericPersisterImpl<Customerheater>(Customerheater.class).findById(customerheaterid);
	}

	@Override
	public List<Customerheater> findAllCustomerheaters() {
		return new GenericPersisterImpl<Customerheater>(Customerheater.class).findAll();
	}

	@Override
	public List<Customerheater> findCustomerheaterByPerformance(Integer performance) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Customerheater> tQuery = em.createNamedQuery("Customerheater.findByPerformance",
				Customerheater.class);

		tQuery.setParameter("performance", performance);

		List<Customerheater> customerheaterlist = tQuery.getResultList();

		em.close();

		return customerheaterlist != null ? customerheaterlist : new ArrayList<Customerheater>();
	}

	@Override
	public List<Customerheater> findCustomerHeaterForCustomer(Customer customer) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Customerheater> tQuery = em.createNamedQuery("Customerheater.findByCustomerId", Customerheater.class);

		tQuery.setParameter("customerid", customer);

		List<Customerheater> customerHeaterList = tQuery.getResultList();

		em.close();

		return customerHeaterList != null ? customerHeaterList : new ArrayList<Customerheater>();
	}
}