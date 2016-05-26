package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.persister.CustomerheaterPersister;
import projekt.feukora.server.persister.CustomerheaterPersisterImpl;

/**
 * This Class implements the methods of the interface CustomerheaterManager.
 * 
 * @author Robin
 * @version 1.5
 * 
 */
public class CustomerheaterManagerImpl implements CustomerheaterManager {

	private CustomerheaterPersister customerheaterPersister = new CustomerheaterPersisterImpl();
	
	@Override
	public void saveCustomerheater(Customerheater entity) throws Exception {
			customerheaterPersister.saveCustomerheater(entity);
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
		return customerheaterPersister.findCustomerheaterByPerformance(performance);
	}

	@Override
	public List<Customerheater> findCustomerHeaterForCustomer(Customer customer) {
		return customerheaterPersister.findCustomerHeaterForCustomer( customer );
	}
}