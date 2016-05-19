package projekt.feukora.server.business;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.persister.CustomerheaterPersister;
import projekt.feukora.server.persister.CustomerheaterPersisterImpl;
import projekt.feukora.server.persister.JpaUtil;

public class CustomerheaterManagerImpl implements CustomerheaterManager {

	private CustomerheaterPersister customerheaterPersister = new CustomerheaterPersisterImpl();
	
	@Override
	public void saveCustomerheater(Customerheater entity) throws Exception {
		if((Integer) entity.getCustomerheaterid() == null){
			customerheaterPersister.saveCustomerheater(entity);
		}else{
			throw new Exception("Die Kundenheizung (id = "+ entity.getCustomerheaterid() + ") ist bereits vorhanden");
		}
		
	}

	@Override
	public Customerheater updateCustomerheater(Customerheater entity) throws Exception {
		return customerheaterPersister.updateCustomerheater(entity);
	}

	@Override
	public void deleteCustomerheater(Customerheater entity) throws Exception {
		customerheaterPersister.deleteCustomerheater(entity);
		
	}

	@Override
	public void deleteCustomerheaterByCustomerheaterid(Integer customerheaterid) throws Exception {
		customerheaterPersister.deleteCustomerheaterByCustomerheaterid(customerheaterid);
		
	}

	@Override
	public Customerheater findCustomerheaterByCustomerheaterid(Integer customerheaterid) {
		return customerheaterPersister.findCustomerheaterByCustomerheaterid(customerheaterid);
	}

	@Override
	public List<Customerheater> findAllCustomerheaters() {
		return customerheaterPersister.findAllCustomerheaters();
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

}
